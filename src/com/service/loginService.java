package com.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import com.dao.TAdminDAO;
import com.dao.TYuangongDAO;
import com.model.TAdmin;
import com.model.TYuangong;

public class loginService
{
	private TAdminDAO adminDAO;
	private TYuangongDAO yuangongDAO;
	
	public TAdminDAO getAdminDAO()
	{
		return adminDAO;
	}
	public void setAdminDAO(TAdminDAO adminDAO)
	{
		this.adminDAO = adminDAO;
	}
	public TYuangongDAO getYuangongDAO()
	{
		return yuangongDAO;
	}
	public void setYuangongDAO(TYuangongDAO yuangongDAO)
	{
		this.yuangongDAO = yuangongDAO;
	}
	
	
	
	public String login(String userName,String userPw,int userType)
	{
		System.out.println("userType"+userType);
		try
		{
			Thread.sleep(700);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String result="no";
		
		if(userType==0)//系统管理员登陆
		{
			String sql="from TAdmin where userName=? and userPw=?";
			Object[] con={userName,userPw};
			List adminList=adminDAO.getHibernateTemplate().find(sql,con);
			if(adminList.size()==0)
			{
				 result="no";
			}
			else
			{
				 WebContext ctx = WebContextFactory.get(); 
				 HttpSession session=ctx.getSession(); 
				 TAdmin admin=(TAdmin)adminList.get(0);
				 session.setAttribute("userType", 0);
	             session.setAttribute("admin", admin);
	             result="yes";
			}
		}
		if(userType==1)
		{
			
		}
		
		if(userType==2)//员工
		{
			String sql="from TYuangong where yuangongDel='no' and yuangongGonghao=? and yuangongMima=?";
			Object[] con={userName,userPw};
			List yuangongList=yuangongDAO.getHibernateTemplate().find(sql,con);
			if(yuangongList.size()==0)
			{
				 result="no";
			}
			else
			{
				 WebContext ctx = WebContextFactory.get(); 
				 HttpSession session=ctx.getSession(); 
				 TYuangong yuangong=(TYuangong)yuangongList.get(0);
				 session.setAttribute("userType", 2);
	             session.setAttribute("yuangong", yuangong);
	             result="yes";
			}
		}
		
		return result;
	}

    public String adminPwEdit(String userPwNew)
    {
		System.out.println("DDDD");
    	try 
		{
			Thread.sleep(700);
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebContext ctx = WebContextFactory.get(); 
		HttpSession session=ctx.getSession(); 
		 
		TAdmin admin=(TAdmin)session.getAttribute("admin");
		admin.setUserPw(userPwNew);
		
		adminDAO.getHibernateTemplate().update(admin);
		session.setAttribute("admin", admin);
		
		return "yes";
    }
    
    
    
    
    public List yuangongSelect()
    {
    	String sql="from TYuangong where yuangongDel='no'";
		List yuangongList=yuangongDAO.getHibernateTemplate().find(sql);
		return yuangongList;
    }
}

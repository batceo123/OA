package com.action;

import java.util.List;
import java.util.Map;


import com.dao.TOrgDAO;
import com.dao.TYuangongDAO;
import com.model.TYuangong;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class yuangongAction extends ActionSupport
{
	private Integer yuangongId;
	private int yuangongOrgId;
	private String yuangongName;
	private String yuangongSex;

	private String yuangongAge;
	private String yuangongXueli;
	private String yuangongAddress;

	private String yuangongTel;
	private String yuangongEmail;
	private String yuangongGonghao;
	private String yuangongMima;
	
	private String quanxian;
	private String yuangongDel;
	
	private TYuangongDAO yuangongDAO;
	private TOrgDAO orgDAO;
	
	
	public String yuangongAdd()//添加员工
	{
		String sql="from TYuangong where yuangongDel='no' and yuangongGonghao=?";
		Object[] c={yuangongGonghao.trim()};
		List yuangongList=yuangongDAO.getHibernateTemplate().find(sql,c); 
		if(yuangongList.size()>0)
		{
			Map request=(Map)ActionContext.getContext().get("request");
			request.put("msg", "工号重复");
			return "msg";
		}
		TYuangong yuangong=new TYuangong();
		yuangong.setYuangongOrgId(yuangongOrgId);
		yuangong.setYuangongName(yuangongName);
		yuangong.setYuangongSex(yuangongSex);
		yuangong.setYuangongAge(yuangongAge);
		yuangong.setYuangongXueli(yuangongXueli);
		yuangong.setYuangongAddress(yuangongAddress);
		yuangong.setYuangongTel(yuangongTel);
		yuangong.setYuangongEmail(yuangongEmail);
		yuangong.setYuangongGonghao(yuangongGonghao.trim());
		yuangong.setYuangongMima(yuangongMima);
		yuangong.setQuanxian(quanxian);
		System.out.println(yuangongName);

		yuangongDAO.save(yuangong);
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("msg", "信息添加成功");
		return "msg";
	}
	
	
	public String yuangongMana()//
	{
		String sql="from TYuangong where yuangongDel='no'";
		List yuangongList=yuangongDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<yuangongList.size();i++)
		{
			TYuangong yuangong=(TYuangong)yuangongList.get(i);
		    yuangong.setOrg(orgDAO.findById(yuangong.getYuangongOrgId()));
		}
		
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("yuangongList", yuangongList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String yuangongDel()//删除员工
	{
		TYuangong yuangong=yuangongDAO.findById(yuangongId);
		yuangong.setYuangongDel("yes");
		
		yuangongDAO.attachDirty(yuangong);
		
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("msg", "信息删除成功");
		return "msg";
	}
	
	
	public String yuangongPre()
	{
		TYuangong yuangong=yuangongDAO.findById(yuangongId);
		
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("yuangong", yuangong);
		return ActionSupport.SUCCESS;
	}
	
	
	public String yuangongEdit()//编辑员工
	{
		TYuangong yuangong=yuangongDAO.findById(yuangongId);
		
		//yuangong.setYuangongId(yuangongId);
		yuangong.setYuangongOrgId(yuangongOrgId);
		yuangong.setYuangongName(yuangongName);
		yuangong.setYuangongSex(yuangongSex);
		
		yuangong.setYuangongAge(yuangongAge);
		yuangong.setYuangongXueli(yuangongXueli);
		yuangong.setYuangongAddress(yuangongAddress);
		
		yuangong.setYuangongTel(yuangongTel);
		yuangong.setYuangongEmail(yuangongEmail);
		yuangong.setYuangongGonghao(yuangongGonghao);
		yuangong.setYuangongMima(yuangongMima);
		
		
		
		yuangong.setQuanxian(quanxian);
		yuangong.setYuangongDel("no");
		
		yuangongDAO.attachDirty(yuangong);
		
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("msg", "信息修改成功");
		return "msg";
	}

	
	public String yuangongRes()
	{
		StringBuffer sql=new StringBuffer("from TYuangong where yuangongDel='no'");
		if(yuangongOrgId !=0)
		{
			sql.append(" and yuangongOrgId="+yuangongOrgId);
		}
		
		sql.append(" and yuangongGonghao like '%"+yuangongGonghao.trim()+"%'");
		sql.append(" and yuangongName like '%"+yuangongName.trim()+"%'");
		
		List yuangongList=yuangongDAO.getHibernateTemplate().find(sql.toString());
		for(int i=0;i<yuangongList.size();i++)
		{
			TYuangong yuangong=(TYuangong)yuangongList.get(i);
		    yuangong.setOrg(orgDAO.findById(yuangong.getYuangongOrgId()));
		}
		
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("yuangongList", yuangongList);
		return ActionSupport.SUCCESS;
	}
	
	public String yuangongSuoyou()
	{
		String sql="from TYuangong where yuangongDel='no'";
		List yuangongList=yuangongDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<yuangongList.size();i++)
		{
			TYuangong yuangong=(TYuangong)yuangongList.get(i);
		    yuangong.setOrg(orgDAO.findById(yuangong.getYuangongOrgId()));
		}
		
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("yuangongList", yuangongList);
		return ActionSupport.SUCCESS;
	}

	
	
	public String yuangongEditMe()
	{
		TYuangong yuangong=yuangongDAO.findById(yuangongId);
		
		//yuangong.setYuangongId(yuangongId);
		//yuangong.setYuangongOrgId(yuangongOrgId);
		yuangong.setYuangongName(yuangongName);
		yuangong.setYuangongSex(yuangongSex);
		
		yuangong.setYuangongAge(yuangongAge);
		yuangong.setYuangongXueli(yuangongXueli);
		yuangong.setYuangongAddress(yuangongAddress);
		
		yuangong.setYuangongTel(yuangongTel);
		yuangong.setYuangongEmail(yuangongEmail);
		yuangong.setYuangongGonghao(yuangongGonghao);
		yuangong.setYuangongMima(yuangongMima);
		
		yuangong.setYuangongDel("no");
		
		yuangongDAO.attachDirty(yuangong);
		
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("msg", "信息修改成功，重新登陆后生效");
		return "msg";
	}
	
	public Integer getYuangongId()
	{
		return yuangongId;
	}


	public void setYuangongId(Integer yuangongId)
	{
		this.yuangongId = yuangongId;
	}


	public int getYuangongOrgId()
	{
		return yuangongOrgId;
	}


	public void setYuangongOrgId(int yuangongOrgId)
	{
		this.yuangongOrgId = yuangongOrgId;
	}


	public String getYuangongDel()
	{
		return yuangongDel;
	}


	public String getYuangongGonghao()
	{
		return yuangongGonghao;
	}


	public String getQuanxian() {
		return quanxian;
	}


	public void setQuanxian(String quanxian) {
		this.quanxian = quanxian;
	}


	public void setYuangongGonghao(String yuangongGonghao)
	{
		this.yuangongGonghao = yuangongGonghao;
	}


	public String getYuangongMima()
	{
		return yuangongMima;
	}


	public void setYuangongMima(String yuangongMima)
	{
		this.yuangongMima = yuangongMima;
	}


	public void setYuangongDel(String yuangongDel)
	{
		this.yuangongDel = yuangongDel;
	}


	public String getYuangongName()
	{
		return yuangongName;
	}


	public void setYuangongName(String yuangongName)
	{
		this.yuangongName = yuangongName;
	}


	public String getYuangongSex()
	{
		return yuangongSex;
	}


	public void setYuangongSex(String yuangongSex)
	{
		this.yuangongSex = yuangongSex;
	}




	public String getYuangongAge() {
		return yuangongAge;
	}


	public void setYuangongAge(String yuangongAge) {
		this.yuangongAge = yuangongAge;
	}


	public String getYuangongXueli()
	{
		return yuangongXueli;
	}


	public void setYuangongXueli(String yuangongXueli)
	{
		this.yuangongXueli = yuangongXueli;
	}




	public String getYuangongAddress()
	{
		return yuangongAddress;
	}


	public void setYuangongAddress(String yuangongAddress)
	{
		this.yuangongAddress = yuangongAddress;
	}


	public String getYuangongTel()
	{
		return yuangongTel;
	}


	public void setYuangongTel(String yuangongTel)
	{
		this.yuangongTel = yuangongTel;
	}


	public String getYuangongEmail()
	{
		return yuangongEmail;
	}


	public void setYuangongEmail(String yuangongEmail)
	{
		this.yuangongEmail = yuangongEmail;
	}


	public TYuangongDAO getYuangongDAO()
	{
		return yuangongDAO;
	}


	public void setYuangongDAO(TYuangongDAO yuangongDAO)
	{
		this.yuangongDAO = yuangongDAO;
	}


	public TOrgDAO getOrgDAO() {
		return orgDAO;
	}


	public void setOrgDAO(TOrgDAO orgDAO) {
		this.orgDAO = orgDAO;
	}

	
}

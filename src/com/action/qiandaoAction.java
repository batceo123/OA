package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TQiandaoDAO;
import com.dao.TYuangongDAO;
import com.model.TQiandao;
import com.model.TYuangong;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.liuService;

public class qiandaoAction extends ActionSupport
{
	private Integer id;
	private Integer yuangongId;
	private String riqi;
	private String shijian;
	
	private TQiandaoDAO qiandaoDAO;
	private TYuangongDAO yuangongDAO;
	
	
	public String qiandaoAdd()
	{
		Map session=ActionContext.getContext().getSession();
		TYuangong yuangong=(TYuangong)session.get("yuangong");
		Map request=(Map)ServletActionContext.getContext().get("request");
		String s=panduan_shifou_qiandao(yuangong.getYuangongId(), riqi);
		if(s.endsWith("yiqiandao"))
		{
			request.put("msg", "今日您已经签到，请不要重复签到");
		}
		else
		{
			TQiandao qiandao=new TQiandao();
			
			qiandao.setYuangongId(yuangong.getYuangongId());
			qiandao.setRiqi(riqi);
			qiandao.setShijian(shijian);
			System.out.println(riqi+" "+shijian);
			qiandao.setShuxing(liuService.shifouchidao(riqi+" "+shijian, riqi+" "+"08:30:00"));
			qiandaoDAO.save(qiandao);
			request.put("msg", "签到完毕");
		}
		
		return "msg";
	}
	
	
	
	
	
	
	public String panduan_shifou_qiandao(int yuangongId,String riqi)
	{
		String s="";
		
		String sql="from TQiandao where yuangongId=? and riqi=?";
		Object[] c={yuangongId,riqi};
		List qiandaoList=qiandaoDAO.getHibernateTemplate().find(sql,c);
		if(qiandaoList.size()>0)
		{
			s="yiqiandao";
		}
		else
		{
			s="weiqiandao";
		}
	    return s;
	}


	public Integer getId()
	{
		return id;
	}



	public void setId(Integer id)
	{
		this.id = id;
	}



	public TQiandaoDAO getQiandaoDAO()
	{
		return qiandaoDAO;
	}



	public void setQiandaoDAO(TQiandaoDAO qiandaoDAO)
	{
		this.qiandaoDAO = qiandaoDAO;
	}



	public String getRiqi()
	{
		return riqi;
	}



	public void setRiqi(String riqi)
	{
		this.riqi = riqi;
	}



	public String getShijian()
	{
		return shijian;
	}



	public void setShijian(String shijian)
	{
		this.shijian = shijian;
	}



	public TYuangongDAO getYuangongDAO()
	{
		return yuangongDAO;
	}



	public void setYuangongDAO(TYuangongDAO yuangongDAO)
	{
		this.yuangongDAO = yuangongDAO;
	}



	public Integer getYuangongId()
	{
		return yuangongId;
	}



	public void setYuangongId(Integer yuangongId)
	{
		this.yuangongId = yuangongId;
	}

}

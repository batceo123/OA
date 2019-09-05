package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TQingjiaDAO;
import com.dao.TYuangongDAO;
import com.model.TQingjia;
import com.model.TYuangong;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class qingjiaAction extends ActionSupport
{
	private Integer id;
	private Integer yuangongId;
	private String kaishishijian;
	private String jieshushijian;
	
	private String shiyou;
	private String zt;//µÈ´ýÉóºË===ÉóºËÍ¨¹ý===ÉóºËÎ´¹ý
	private String shenheshijian;
	private String huifuxinxi;
	
	
	private TYuangongDAO yuangongDAO;
	private TQingjiaDAO qingjiaDAO;
	
	public String qingjiaAdd()
	{
		Map session=ActionContext.getContext().getSession();
		TYuangong yuangong=(TYuangong)session.get("yuangong");
		
		TQingjia qingjia=new TQingjia();
		
		qingjia.setYuangongId(yuangong.getYuangongId());
		qingjia.setKaishishijian(kaishishijian);
		qingjia.setJieshushijian(jieshushijian);
		qingjia.setShiyou(shiyou);
		
		qingjia.setZt("µÈ´ýÉóºË");
		qingjia.setShenheshijian("");
		qingjia.setHuifuxinxi("");
		
		qingjiaDAO.save(qingjia);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "Çë¼ÙÌîÐ´Íê±Ï£¬µÈ´ýÉóºË");
		return "msg";
	}
	
	
	
	public String qingjiaMine()
	{
		Map session=ActionContext.getContext().getSession();
		TYuangong yuangong=(TYuangong)session.get("yuangong");
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		String sql="from TQingjia where yuangongId="+yuangong.getYuangongId();
		List qingjiaList=qingjiaDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<qingjiaList.size();i++)
		{
			TQingjia qingjia=(TQingjia)qingjiaList.get(i);
			qingjia.setYuangong(yuangongDAO.findById(qingjia.getYuangongId()));
		}
		
		request.put("qingjiaList", qingjiaList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String qingjiaDel()
	{
		TQingjia qingjia=qingjiaDAO.findById(id);
		qingjiaDAO.delete(qingjia);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "ÐÅÏ¢É¾³ýÍê±Ï");
		return "msg";
	}
	
	
	public String qingjiaMana()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		String sql="from TQingjia";
		List qingjiaList=qingjiaDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<qingjiaList.size();i++)
		{
			TQingjia qingjia=(TQingjia)qingjiaList.get(i);
			qingjia.setYuangong(yuangongDAO.findById(qingjia.getYuangongId()));
		}
		request.put("qingjiaList", qingjiaList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String qingjiaShenhe()
	{
		TQingjia qingjia=qingjiaDAO.findById(id);
		
		qingjia.setZt(zt);
		qingjia.setShenheshijian(shenheshijian);
		qingjia.setHuifuxinxi(huifuxinxi);
		
		qingjiaDAO.attachDirty(qingjia);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "Çë¼ÙÐÅÏ¢ÉóºËÍê±Ï");
		return "msg";
	}



	public String getHuifuxinxi()
	{
		return huifuxinxi;
	}



	public void setHuifuxinxi(String huifuxinxi)
	{
		this.huifuxinxi = huifuxinxi;
	}



	public Integer getId()
	{
		return id;
	}



	public void setId(Integer id)
	{
		this.id = id;
	}



	public TQingjiaDAO getQingjiaDAO()
	{
		return qingjiaDAO;
	}



	public void setQingjiaDAO(TQingjiaDAO qingjiaDAO)
	{
		this.qingjiaDAO = qingjiaDAO;
	}



	public String getJieshushijian()
	{
		return jieshushijian;
	}



	public void setJieshushijian(String jieshushijian)
	{
		this.jieshushijian = jieshushijian;
	}



	public String getKaishishijian()
	{
		return kaishishijian;
	}



	public void setKaishishijian(String kaishishijian)
	{
		this.kaishishijian = kaishishijian;
	}



	public String getShenheshijian()
	{
		return shenheshijian;
	}



	public void setShenheshijian(String shenheshijian)
	{
		this.shenheshijian = shenheshijian;
	}



	public String getShiyou()
	{
		return shiyou;
	}



	public void setShiyou(String shiyou)
	{
		this.shiyou = shiyou;
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



	public String getZt()
	{
		return zt;
	}



	public void setZt(String zt)
	{
		this.zt = zt;
	}
	
}

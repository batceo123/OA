package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TGongziDAO;
import com.dao.TYuangongDAO;
import com.model.TGongzi;
import com.model.TYuangong;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class gongziAction extends ActionSupport
{
	private Integer id;
	private Integer yuangongId;
	private String yuefen;
	private Integer jibengongzi;

	private Integer jiabanfei;
	private Integer jiangjin;
	private Integer qingjiafei;
	private Integer shifagongzi;
    
    private String message;
	private String path;
	
	private TGongziDAO gongziDAO;
	private TYuangongDAO yuangongDAO;
	
	
	
	public String gongziAdd()
	{
		
		TGongzi gongzi=new TGongzi();
		gongzi.setYuangongId(yuangongId);
		gongzi.setYuefen(yuefen);
		gongzi.setJibengongzi(jibengongzi);
		gongzi.setJiabanfei(jiabanfei);
		
		gongzi.setJiangjin(jiangjin);
		gongzi.setQingjiafei(qingjiafei);
		gongzi.setShifagongzi(jibengongzi+jiabanfei+jiangjin-qingjiafei);
		
		gongziDAO.save(gongzi);
		
		this.setMessage("操作成功");
		this.setPath("gongziMana.action");
		return "succeed";
	}
	
	
	
	public String gongziMana()
	{
		String sql="from TGongzi";
		List gongziList=gongziDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<gongziList.size();i++)
		{
			TGongzi gongzi=(TGongzi)gongziList.get(i);
			gongzi.setYuangong(yuangongDAO.findById(gongzi.getYuangongId()));
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("gongziList", gongziList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String gongziDel()
	{
		TGongzi gongzi=gongziDAO.findById(id);
		gongziDAO.getHibernateTemplate().delete(gongzi);
		
		this.setMessage("操作成功");
		this.setPath("gongziMana.action");
		return "succeed";
	}
	
	
	public String gongziPre()
	{
		TGongzi gongzi=gongziDAO.findById(id);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("gongzi", gongzi);
		return ActionSupport.SUCCESS;
	}
	
	public String gongziEdit()
	{
		TGongzi gongzi=gongziDAO.findById(id);
		
		gongzi.setYuangongId(yuangongId);
		gongzi.setYuefen(yuefen);
		gongzi.setJibengongzi(jibengongzi);
		gongzi.setJiabanfei(jiabanfei);
		
		gongzi.setJiangjin(jiangjin);
		gongzi.setQingjiafei(qingjiafei);
		gongzi.setShifagongzi(jibengongzi+jiabanfei+jiangjin+qingjiafei);
		
		gongziDAO.attachDirty(gongzi);
		
		this.setMessage("操作成功");
		this.setPath("gongziMana.action");
		return "succeed";
		
	}

	
	
	public String gongziMine()
	{
		Map session=ActionContext.getContext().getSession();
		TYuangong yuangong=(TYuangong)session.get("yuangong");
		
		String sql="from TGongzi where yuangongId="+yuangong.getYuangongId();
		List gongziList=gongziDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<gongziList.size();i++)
		{
			TGongzi gongzi=(TGongzi)gongziList.get(i);
			gongzi.setYuangong(yuangongDAO.findById(gongzi.getYuangongId()));
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("gongziList", gongziList);
		return ActionSupport.SUCCESS;
	}


	public TGongziDAO getGongziDAO()
	{
		return gongziDAO;
	}



	public void setGongziDAO(TGongziDAO gongziDAO)
	{
		this.gongziDAO = gongziDAO;
	}



	public Integer getId()
	{
		return id;
	}



	public void setId(Integer id)
	{
		this.id = id;
	}



	public Integer getJiabanfei()
	{
		return jiabanfei;
	}



	public void setJiabanfei(Integer jiabanfei)
	{
		this.jiabanfei = jiabanfei;
	}



	public Integer getJiangjin()
	{
		return jiangjin;
	}



	public void setJiangjin(Integer jiangjin)
	{
		this.jiangjin = jiangjin;
	}



	public Integer getJibengongzi()
	{
		return jibengongzi;
	}



	public void setJibengongzi(Integer jibengongzi)
	{
		this.jibengongzi = jibengongzi;
	}



	public String getMessage()
	{
		return message;
	}



	public void setMessage(String message)
	{
		this.message = message;
	}



	public String getPath()
	{
		return path;
	}



	public void setPath(String path)
	{
		this.path = path;
	}



	public Integer getQingjiafei()
	{
		return qingjiafei;
	}



	public void setQingjiafei(Integer qingjiafei)
	{
		this.qingjiafei = qingjiafei;
	}



	public Integer getShifagongzi()
	{
		return shifagongzi;
	}



	public void setShifagongzi(Integer shifagongzi)
	{
		this.shifagongzi = shifagongzi;
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



	public String getYuefen()
	{
		return yuefen;
	}



	public void setYuefen(String yuefen)
	{
		this.yuefen = yuefen;
	}
	
}

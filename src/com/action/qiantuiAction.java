package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TQiandaoDAO;
import com.dao.TQiantuiDAO;
import com.dao.TYuangongDAO;
import com.model.TQiantui;
import com.model.TYuangong;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.liuService;

public class qiantuiAction extends ActionSupport
{
	private Integer id;
	private Integer yuangongId;
	private String riqi;
	private String shijian;
	
	private TQiantuiDAO qiantuiDAO;
	private TQiandaoDAO qiandaoDAO;
	private TYuangongDAO yuangongDAO;
	
	
	public String qiantuiAdd()
	{
		Map session=ActionContext.getContext().getSession();
		TYuangong yuangong=(TYuangong)session.get("yuangong");
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		String s=panduan_shifou_qiantui(yuangong.getYuangongId(), riqi);
		if(s.endsWith("yiqiantui"))
		{
			request.put("msg", "今日您已经签退，请不要重复签退");
			return "msg";
		}
		
		String y=panduan_shifou_qianDao(yuangong.getYuangongId(), riqi);
		System.out.println(y+"&&&"+qiandaoDAO);
		if(y.endsWith("weiqiandao"))
		{
			request.put("msg", "今日您还没有签到，不能签退");
			return "msg";
		}
		
		
		
		TQiantui qiantui=new TQiantui();
		
		qiantui.setYuangongId(yuangong.getYuangongId());
		qiantui.setRiqi(riqi);
		qiantui.setShijian(shijian);
		qiantui.setShuxing(liuService.shifouzaotui(riqi+" "+shijian, riqi+" "+"17:30:00"));
		qiantuiDAO.save(qiantui);
		request.put("msg", "签退完毕");
		return "msg";
	}
	
	
	
	public String panduan_shifou_qiantui(int yuangongId,String riqi)
	{
		String s="";
		
		String sql="from TQiantui where yuangongId=? and riqi=?";
		Object[] c={yuangongId,riqi};
		List qiantuiList=qiantuiDAO.getHibernateTemplate().find(sql,c);
		if(qiantuiList.size()>0)
		{
			s="yiqiantui";
		}
		else
		{
			s="weiqiantui";
		}
	    return s;
	}
	
	
	public String panduan_shifou_qianDao(int yuangongId,String riqi)//判断今天是否签到，如果今天没签到的话。不能签退
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



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public TQiandaoDAO getQiandaoDAO() {
		return qiandaoDAO;
	}



	public void setQiandaoDAO(TQiandaoDAO qiandaoDAO) {
		this.qiandaoDAO = qiandaoDAO;
	}



	public Integer getYuangongId() {
		return yuangongId;
	}



	public void setYuangongId(Integer yuangongId) {
		this.yuangongId = yuangongId;
	}



	public String getRiqi() {
		return riqi;
	}



	public void setRiqi(String riqi) {
		this.riqi = riqi;
	}



	public String getShijian() {
		return shijian;
	}



	public void setShijian(String shijian) {
		this.shijian = shijian;
	}



	public TQiantuiDAO getQiantuiDAO() {
		return qiantuiDAO;
	}



	public void setQiantuiDAO(TQiantuiDAO qiantuiDAO) {
		this.qiantuiDAO = qiantuiDAO;
	}



	public TYuangongDAO getYuangongDAO() {
		return yuangongDAO;
	}



	public void setYuangongDAO(TYuangongDAO yuangongDAO) {
		this.yuangongDAO = yuangongDAO;
	}

}

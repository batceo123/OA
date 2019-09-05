package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.TQiandaoDAO;
import com.dao.TQiantuiDAO;
import com.dao.TYuangongDAO;
import com.model.TQiandao;
import com.model.TQiantui;
import com.model.TYuangong;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.liuService;

public class chuqinAction extends ActionSupport
{
	private TQiandaoDAO qiandaoDAO;
	private TQiantuiDAO qiantuiDAO;
	private TYuangongDAO yuangongDAO;
	
	
	public String chuqinTongji()//显示出勤列表
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		String sql="from TQiandao order by riqi desc";
		List qiandaoList=qiandaoDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<qiandaoList.size();i++)
		{
			TQiandao qiandao=(TQiandao)qiandaoList.get(i);
			qiandao.setYuangong(yuangongDAO.findById(qiandao.getYuangongId()));
			String riqi=qiandao.getRiqi();
			TQiantui qiantui=get_qiantui(riqi);
			qiandao.setQiantuishi(qiantui.getShijian());
			qiandao.setQiantuishuxing(qiantui.getShuxing());
		}
		request.put("qiandaoList", qiandaoList);
		return ActionSupport.SUCCESS;
	}
	
	public String chuqinRes()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		String yuefen=request.getParameter("yuefen");
		if(yuefen==null)
		{
			yuefen=new SimpleDateFormat("yyyy-MM").format(new Date());
		}
		
		String sql="from TYuangong where yuangongDel='no'";
		List yuangongList=yuangongDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<yuangongList.size();i++)
		{
			TYuangong yuangong=(TYuangong)yuangongList.get(i);
			int yuangongId=yuangong.getYuangongId();
			yuangong.setQiandaocishu(get_qiandaoCishu(yuefen, yuangongId));
			yuangong.setChidaocishu(get_chidaoCishu(yuefen, yuangongId));
			yuangong.setZaotuicishu(get_zaotuiCishu(yuefen, yuangongId));
			
		}
		
		request.setAttribute("yuangongList", yuangongList);
		request.setAttribute("yuefen", yuefen);
		return ActionSupport.SUCCESS;
	}
	
	
	public String chuqinMine()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		TYuangong yuangong=(TYuangong)session.getAttribute("yuangong");
		
		String sql="from TQiandao where yuangongId="+yuangong.getYuangongId()+" order by riqi desc";
		List qiandaoList=qiandaoDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<qiandaoList.size();i++)
		{
			TQiandao qiandao=(TQiandao)qiandaoList.get(i);
			qiandao.setYuangong(yuangongDAO.findById(qiandao.getYuangongId()));
			String riqi=qiandao.getRiqi();
			TQiantui qiantui=get_qiantui(riqi);
			qiandao.setQiantuishi(qiantui.getShijian());
			qiandao.setQiantuishuxing(qiantui.getShuxing());
			
			
		}
		request.setAttribute("qiandaoList", qiandaoList);
		return ActionSupport.SUCCESS;
	}
	
	public TQiantui get_qiantui(String riqi)//签退
	{
		String sql="from TQiantui where riqi=?";
		Object[] c={riqi};
		List qiantuiList=qiantuiDAO.getHibernateTemplate().find(sql,c);
		if(qiantuiList.size()==0)
		{
			TQiantui qiantui=new TQiantui();
			qiantui.setShijian("");
			qiantui.setShuxing("");
			return qiantui;
		}
		else
		{
			TQiantui qiantui=(TQiantui)qiantuiList.get(0);
			return qiantui;
		}
	}
	
	
	public int get_qiandaoCishu(String yuefen,int yuangongId)
	{
		String sql="from TQiandao where yuangongId="+yuangongId+" and riqi like '%"+yuefen+"%'";
		List qiandaoList=qiandaoDAO.getHibernateTemplate().find(sql);
		return qiandaoList.size();
	}
	
	
	public int get_chidaoCishu(String yuefen,int yuangongId)
	{
		String sql="from TQiandao where yuangongId="+yuangongId+" and riqi like '%"+yuefen+"%'"+" and shuxing='迟到'";
		List qiandaoList=qiandaoDAO.getHibernateTemplate().find(sql);
		return qiandaoList.size();
	}
	
	public int get_zaotuiCishu(String yuefen,int yuangongId)
	{
		String sql="from TQiantui where yuangongId="+yuangongId+" and riqi like '%"+yuefen+"%'"+" and shuxing='早退'";
		List qiantuiList=qiantuiDAO.getHibernateTemplate().find(sql);
		return qiantuiList.size();
	}


	public TQiandaoDAO getQiandaoDAO() {
		return qiandaoDAO;
	}


	public void setQiandaoDAO(TQiandaoDAO qiandaoDAO) {
		this.qiandaoDAO = qiandaoDAO;
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

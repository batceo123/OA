package com.model;

import java.util.Date;

/**
 * TYuangong generated by MyEclipse Persistence Tools
 */

public class TYuangong implements java.io.Serializable
{

	// Fields

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
	
	
	private TOrg org;
	
	private int qiandaocishu;
	private int chidaocishu;
	private int zaotuicishu;
	
	
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
	public String getYuangongName()
	{
		return yuangongName;
	}
	public void setYuangongName(String yuangongName)
	{
		this.yuangongName = yuangongName;
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
	public String getYuangongDel()
	{
		return yuangongDel;
	}
	
	public TOrg getOrg() {
		return org;
	}
	public void setOrg(TOrg org) {
		this.org = org;
	}
	public int getQiandaocishu() {
		return qiandaocishu;
	}
	public void setQiandaocishu(int qiandaocishu) {
		this.qiandaocishu = qiandaocishu;
	}
	public int getChidaocishu() {
		return chidaocishu;
	}
	public void setChidaocishu(int chidaocishu) {
		this.chidaocishu = chidaocishu;
	}
	public int getZaotuicishu() {
		return zaotuicishu;
	}
	public void setZaotuicishu(int zaotuicishu) {
		this.zaotuicishu = zaotuicishu;
	}
	public void setYuangongDel(String yuangongDel)
	{
		this.yuangongDel = yuangongDel;
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

}
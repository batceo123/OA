package com.model;

/**
 * TLiuyan generated by MyEclipse Persistence Tools
 */

public class TLiuyan implements java.io.Serializable
{

	private Integer id;
	private String neirong;
	private String liuyanshi;
	private Integer yuangongId;

	private String huifu;
	private String huifushi;
	
	private TYuangong yuangong;
	
	public String getHuifu()
	{
		return huifu;
	}
	public void setHuifu(String huifu)
	{
		this.huifu = huifu;
	}
	public String getHuifushi()
	{
		return huifushi;
	}
	public void setHuifushi(String huifushi)
	{
		this.huifushi = huifushi;
	}
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public Integer getYuangongId() {
		return yuangongId;
	}
	public void setYuangongId(Integer yuangongId) {
		this.yuangongId = yuangongId;
	}
	public TYuangong getYuangong() {
		return yuangong;
	}
	public void setYuangong(TYuangong yuangong) {
		this.yuangong = yuangong;
	}
	public String getLiuyanshi()
	{
		return liuyanshi;
	}
	public void setLiuyanshi(String liuyanshi)
	{
		this.liuyanshi = liuyanshi;
	}
	public String getNeirong()
	{
		return neirong;
	}
	public void setNeirong(String neirong)
	{
		this.neirong = neirong;
	}
	
	
	
}
package com.model;

/**
 * TQiantui entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TQiantui implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer yuangongId;
	private String riqi;
	private String shijian;
	
	private String shuxing;
	
	private TYuangong yuangong;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getShuxing() {
		return shuxing;
	}

	public void setShuxing(String shuxing) {
		this.shuxing = shuxing;
	}

	public TYuangong getYuangong() {
		return yuangong;
	}

	public void setYuangong(TYuangong yuangong) {
		this.yuangong = yuangong;
	}

}
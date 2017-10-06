package com.iii.eeit9703.activity;

import java.sql.Date;

public class activityVO implements java.io.Serializable {
	
	private Integer member_ID;   //會員編號
	private Integer actID;      //行程編號
	private Date    BDate;     //開始日期
	private Date    EDate;    //結束日期
	private Integer PerNum;  //參加人數
	private Integer attactionID; //景點 住宿 商家ID
	private Integer name;       //地點名稱
	private Integer county;    //所在地區
	
	
	public Integer getMember_ID() {
		return member_ID;
	}
	public void setMember_ID(Integer member_ID) {
		this.member_ID = member_ID;
	}
	public Integer getActID() {
		return actID;
	}
	public void setActID(Integer actID) {
		this.actID = actID;
	}
	public Date getBDate() {
		return BDate;
	}
	public void setBDate(Date bDate) {
		BDate = bDate;
	}
	public Date getEDate() {
		return EDate;
	}
	public void setEDate(Date eDate) {
		EDate = eDate;
	}
	public Integer getPerNum() {
		return PerNum;
	}
	public void setPerNum(Integer perNum) {
		PerNum = perNum;
	}
	public Integer getAttactionID() {
		return attactionID;
	}
	public void setAttactionID(Integer attactionID) {
		this.attactionID = attactionID;
	}
	public Integer getName() {
		return name;
	}
	public void setName(Integer name) {
		this.name = name;
	}
	public Integer getCounty() {
		return county;
	}
	public void setCounty(Integer county) {
		this.county = county;
	}

	

}

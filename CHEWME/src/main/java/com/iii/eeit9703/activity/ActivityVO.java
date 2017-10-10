package com.iii.eeit9703.activity;

import java.sql.Date;

public class ActivityVO implements java.io.Serializable {
	
	private Integer actID;       //行程編號
	private Integer member_ID;  //會員編號
	private Date    BDate;     //開始日期
	private Date    EDate;    //結束日期
	private Integer PerNum;  //參加人數
	private Integer activity_state; //建立活動目前狀態
	private Integer sheduleID; //
	private Date Day;     //編輯行程的天數
	private Date period; //編輯行程的時段
	private String Desc;  //編輯行程的備註
	private Integer attactionID; //景點 住宿 商家ID
	private String name;       //地點名稱
	private String county;    //所在地區
	private Integer collectID;  //收藏表
	private String uniqueld; //活動參與者名單
	
	
	public Integer getActivity_state() {
		return activity_state;
	}
	public void setActivity_state(Integer activity_state) {
		this.activity_state = activity_state;
	}
	public Integer getSheduleID() {
		return sheduleID;
	}
	public void setSheduleID(Integer sheduleID) {
		this.sheduleID = sheduleID;
	}
	public Date getDay() {
		return Day;
	}
	public void setDay(Date day) {
		Day = day;
	}
	public Date getPeriod() {
		return period;
	}
	public void setPeriod(Date period) {
		this.period = period;
	}
	public String getDesc() {
		return Desc;
	}
	public void setDesc(String desc) {
		Desc = desc;
	}
	public Integer getCollectID() {
		return collectID;
	}
	public void setCollectID(Integer collectID) {
		this.collectID = collectID;
	}
	public String getUniqueld() {
		return uniqueld;
	}
	public void setUniqueld(String uniqueld) {
		this.uniqueld = uniqueld;
	}
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}

	

}

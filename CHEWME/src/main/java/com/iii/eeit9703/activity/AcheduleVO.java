package com.iii.eeit9703.activity;

import java.sql.Date;

public class AcheduleVO implements java.io.Serializable {

	//編輯行程
	
	private Integer schedule;  //行程編號
	private String Day;       //行程天數(天)
	private Date period;     //行程時段(HH:MM)
	private String Desc;    //備註說明
	
	//商家 景點 餐廳
	
	private Integer attractionID; //景點ID

	public Integer getSchedule() {
		return schedule;
	}

	public void setSchedule(Integer schedule) {
		this.schedule = schedule;
	}

	public String getDay() {
		return Day;
	}

	public void setDay(String day) {
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

	public Integer getAttractionID() {
		return attractionID;
	}

	public void setAttractionID(Integer attractionID) {
		this.attractionID = attractionID;
	}
	
	
}

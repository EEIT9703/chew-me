package com.iii.eeit9703.activity.model;

import java.sql.Date;
import java.sql.Time;

public class ActivityVO implements java.io.Serializable {
	
	//活動表
	private Integer actID;       //行程編號(完成編輯)
	private Integer member_ID;  //會員編號

	private String  act_name;  //活動名稱
	private Integer act_groups; //成團人數
	private Integer act_current;//當前人數
	private Time BDate;        //開始日期
	private Time EDate;       //結束日期
	private Integer activity_state; //活動型態  0 = 建構中, 1 = 上架  ,  2 = 被檢舉  , 3 = 下架 
	private Integer ReportID;    //檢舉
	private Integer collectID;  //收藏表
	private String uniqueld; //活動參與者名單
	
	public Integer getActID() {
		return actID;
	}
	public void setActID(Integer actID) {
		this.actID = actID;
	}
	public Integer getMember_ID() {
		return member_ID;
	}
	public void setMember_ID(Integer member_ID) {
		this.member_ID = member_ID;
	}
	public String getAct_name() {
		return act_name;
	}
	public void setAct_name(String act_name) {
		this.act_name = act_name;
	}
	public Integer getAct_groups() {
		return act_groups;
	}
	public void setAct_groups(Integer act_groups) {
		this.act_groups = act_groups;
	}
	public Integer getAct_current() {
		return act_current;
	}
	public void setAct_current(Integer act_current) {
		this.act_current = act_current;
	}
	public Time getBDate() {
		return BDate;
	}
	public void setBDate(Time bDate) {
		BDate = bDate;
	}
	public Time getEDate() {
		return EDate;
	}
	public void setEDate(Time eDate) {
		EDate = eDate;
	}
	public Integer getActivity_state() {
		return activity_state;
	}
	public void setActivity_state(Integer activity_state) {
		this.activity_state = activity_state;
	}
	public Integer getReportID() {
		return ReportID;
	}
	public void setReportID(Integer reportID) {
		ReportID = reportID;
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


	//存與取

	

}

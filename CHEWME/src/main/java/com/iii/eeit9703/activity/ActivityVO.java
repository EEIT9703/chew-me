package com.iii.eeit9703.activity;

import java.sql.Date;

public class ActivityVO implements java.io.Serializable {
	
	//行程表
	
	private Integer actID;       //行程編號(完成編輯)
	private Integer member_ID;  //會員編號
	private Integer activity_state; //活動型態  0 = 建構中, 1 = 上架  ,  2 = 被檢舉  , 3 = 下架 

	private Integer ReportID;    //檢舉
	private Integer collectID;  //收藏表
	
	//private String uniqueld; //活動參與者名單
	
	
	
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
	

	
	

	

}

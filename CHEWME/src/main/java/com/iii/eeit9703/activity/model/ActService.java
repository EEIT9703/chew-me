package com.iii.eeit9703.activity.model;

import java.sql.Time;

public class ActService {

	private ActivityDAO_interface dao;
	
	public ActService(){
		dao = new ActivityDAO();
	}
	
	//新增活動
	public ActivityVO addAct(String act_name,Integer act_groups,Integer act_current,Time BDate,Time EDate,Integer activity_state){
		
		ActivityVO activityVO = new ActivityVO();
		
		activityVO.setAct_name(act_name);
		activityVO.setAct_groups(act_groups);
		activityVO.setAct_current(act_current);
		activityVO.setBDate(BDate);
		activityVO.setEDate(EDate);
		activityVO.setActivity_state(activity_state);
		
		dao.insert(activityVO);
		return activityVO;
	}

}

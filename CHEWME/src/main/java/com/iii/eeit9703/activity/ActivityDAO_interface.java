package com.iii.eeit9703.activity;

import java.util.*;

public interface ActivityDAO_interface {
	
	//新增
	public void insert (ActivityVO activityVO);
    //修改
	public void update (ActivityVO activityVO);
	//刪除
	public void delete (Integer actID);
	//主鍵
	public ActivityVO findByPrimaryKey(Integer actID);
	//查詢
	public List<ActivityVO>getAll();
	
}

package com.iii.eeit9703.actEditor;

public class AreaVO implements java.io.Serializable{

	private Integer areaID;		//區域代碼(EX.100)
	private String conty;		//區鄉鎮(EX.中正區)
	private String city;		//市(EX.台北市)
	private String cityID;		//市縮寫(EX.TPE)
	public Integer getAreaID() {
		return areaID;
	}
	public void setAreaID(Integer areaID) {
		this.areaID = areaID;
	}
	public String getConty() {
		return conty;
	}
	public void setConty(String conty) {
		this.conty = conty;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCityID() {
		return cityID;
	}
	public void setCityID(String cityID) {
		this.cityID = cityID;
	}
	

}

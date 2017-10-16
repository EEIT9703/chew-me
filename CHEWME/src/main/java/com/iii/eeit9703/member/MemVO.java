package com.iii.eeit9703.member;

public class MemVO implements java.io.Serializable{
	private String memberId;
	private String mname;
	private String mnickn;
	private String mpwd;
	private java.sql.Date mbirthday;
	private String mmail;
	private String maddr;
	private String mphone;
	private String mintr;
	private byte[] mphoto;
	private String mstatus;
	private String mrole;
	public String getmemberId() {
		return memberId;
	}
	public void setmemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getmname() {
		return mname;
	}
	public void setmname(String mname) {
		this.mname = mname;
	}
	public String getmnickn() {
		return mnickn;
	}
	public void setmnickn(String mnickn) {
		this.mnickn = mnickn;
	}
	public String getmpwd() {
		return mpwd;
	}
	public void setmpwd(String mpwd) {
		this.mpwd = mpwd;
	}
	public java.sql.Date getmbirthday() {
		return mbirthday;
	}
	public void setmbirthday(java.sql.Date mbirthday) {
		this.mbirthday = mbirthday;
	}
	public String getmmail() {
		return mmail;
	}
	public void setmmail(String mmail) {
		this.mmail = mmail;
	}
	public String getmaddr() {
		return maddr;
	}
	public void setmaddr(String maddr) {
		this.maddr = maddr;
	}
	public String getmphone() {
		return mphone;
	}
	public void setmphone(String mphone) {
		this.mphone = mphone;
	}
	public String getmintr() {
		return mintr;
	}
	public void setmintr(String mintr) {
		this.mintr = mintr;
	}
	public byte[] getmphoto() {
		return mphoto;
	}
	public void setmphoto(byte[] mphoto) {
		this.mphoto = mphoto;
	}
	public MemVO(String memberId,String mname,String mnickn,String mpwd,java.sql.Date mbirthday,String mmail,String maddr,String mphone,String mintr,String mstatus,String mrole){
		super();
		this.memberId=memberId;
		this.mname=mname;
		this.mnickn=mnickn;
		this.mpwd=mpwd;
		this.mbirthday=mbirthday;
		this.mmail=mmail;
		this.maddr=maddr;
		this.mphone=mphone;
		this.mintr=mintr;
		this.mstatus=mstatus;
		this.mrole=mrole;
	}
	public MemVO() {
		
	}
	public String getMstatus() {
		return mstatus;
	}
	public void setMstatus(String mstatus) {
		this.mstatus = mstatus;
	}
	public String getMrole() {
		return mrole;
	}
	public void setMrole(String mrole) {
		this.mrole = mrole;
	}


	
}

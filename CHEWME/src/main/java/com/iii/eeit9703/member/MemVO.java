package com.iii.eeit9703.member;

public class MemVO implements java.io.Serializable{
	private String memberId;
	private String mname;
	private String mnickn;
	private String mpwd;
	private String mbirthday;
	private String mmail;
	private String maddr;
	private String mphone;
	private String mintr;
	private byte[] mphoto;
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
	public String getmbirthday() {
		return mbirthday;
	}
	public void setmbirthday(String mbirthday) {
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


	
}

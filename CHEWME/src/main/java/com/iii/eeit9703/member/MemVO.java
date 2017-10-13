package com.iii.eeit9703.member;

public class MemVO implements java.io.Serializable{
	private String member_Id;
	private String m_name;
	private String m_nickn;
	private String m_pwd;
	private Integer m_age;
	private String m_mail;
	private String m_addr;
	private String m_phone;
	private String m_intr;
	private byte[] m_photo;
	public String getMember_Id() {
		return member_Id;
	}
	public void setMember_Id(String member_Id) {
		this.member_Id = member_Id;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_nickn() {
		return m_nickn;
	}
	public void setM_nickn(String m_nickn) {
		this.m_nickn = m_nickn;
	}
	public String getM_pwd() {
		return m_pwd;
	}
	public void setM_pwd(String m_pwd) {
		this.m_pwd = m_pwd;
	}
	public Integer getM_age() {
		return m_age;
	}
	public void setM_age(Integer m_age) {
		this.m_age = m_age;
	}
	public String getM_mail() {
		return m_mail;
	}
	public void setM_mail(String m_mail) {
		this.m_mail = m_mail;
	}
	public String getM_addr() {
		return m_addr;
	}
	public void setM_addr(String m_addr) {
		this.m_addr = m_addr;
	}
	public String getM_phone() {
		return m_phone;
	}
	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}
	public String getM_intr() {
		return m_intr;
	}
	public void setM_intr(String m_intr) {
		this.m_intr = m_intr;
	}
	public byte[] getM_photo() {
		return m_photo;
	}
	public void setM_photo(byte[] m_photo) {
		this.m_photo = m_photo;
	}


	
}

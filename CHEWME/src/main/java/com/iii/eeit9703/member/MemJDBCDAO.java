package com.iii.eeit9703.member;

public class MemJDBCDAO {
    String driver="com.nicrosoft.sqlserver.jdbc.SQLSerberDriver";
    String url = "jdbc:sqlserver://localhost:1433;DatabaseName=EEIT9707test";
	String userid = "sa";
	String passwd = "P@ssw0rd";
	
	private static final String INSERT_STMT=
			"INSERT INTO member (m_name,m_nickn,m_pwd,m_age,m_mail,m_addr,m_phone,m_intr) VALUES(?,?,?,?,?,?,?,?)";
	private static final String GET_ALL_STMT =
		      "SELECT  member_Id,m_name,m_nickn,m_pwd,m_age,m_mail,m_addr,m_phone,m_intr FROM member order by member_Id";
	private static final String GET_ONE_STMT =
		      "SELECT  member_Id,m_name,m_nickn,m_pwd,m_age,m_mail,m_addr,m_phone,m_intr FROM member WHERE member_Id=?";
	private static final String DELETE =
		      "DELETE FROM member WHERE member_Id=?";
	private static final String UPDATE =
		      "UPDATE member set m_name=?,m_nickn=?, m_pwd=?, m_age=?, m_mail=?, m_addr=?, m_phone=?,m_intr=?  WHERE member_Id=?";

}

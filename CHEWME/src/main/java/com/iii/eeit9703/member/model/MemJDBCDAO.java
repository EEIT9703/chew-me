package com.iii.eeit9703.member.model;

import java.sql.*;
import java.util.*;



public class MemJDBCDAO {
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url = "jdbc:sqlserver://localhost:1433;DatabaseName=CMDB";
	String userid = "sa";
	String passwd = "P@ssw0rd";

	private static final String INSERT_STMT = "INSERT INTO members (memberId,mname,mnickn,mpwd,mbirthday,mmail,maddr,mphone,mintr,mphoto,mstatus,mrole) VALUES(?,?,?,?,?,?,?,?,?,?,'正常','一般會員')";
	private static final String GET_ALL_STMT = "SELECT  memberId,mname,mnickn,mpwd,mbirthday,mmail,maddr,mphone,mintr,mphoto,mstatus,mrole FROM members order by memberId";
	private static final String GET_ONE_STMT = "SELECT  memberId,mname,mnickn,mpwd,mbirthday,mmail,maddr,mphone,mintr,mphoto,mstatus,mrole FROM members WHERE memberId=?";
	private static final String DELETE = "DELETE FROM members WHERE memberId=?";
	private static final String UPDATE = "UPDATE members set mname=?,mnickn=?, mpwd=?, mbirthday=?, mmail=?, maddr=?, mphone=?,mintr=?,mphoto=?,mstatus=?,mrole=?  WHERE memberId=?";

	public void insert(MemVO memVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, memVO.getmemberId());
			pstmt.setString(2, memVO.getmname());
			pstmt.setString(3, memVO.getmnickn());
			pstmt.setString(4, memVO.getmpwd());
			pstmt.setDate(5, memVO.getmbirthday());
			pstmt.setString(6, memVO.getmmail());
			pstmt.setString(7, memVO.getmaddr());
			pstmt.setString(8, memVO.getmphone());
			pstmt.setString(9, memVO.getmintr());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	public void update(MemVO memVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, memVO.getmname());
			pstmt.setString(2, memVO.getmnickn());
			pstmt.setString(3, memVO.getmpwd());
			pstmt.setDate(4, memVO.getmbirthday());
			pstmt.setString(5, memVO.getmmail());
			pstmt.setString(6, memVO.getmaddr());
			pstmt.setString(7, memVO.getmphone());
			pstmt.setString(8, memVO.getmintr());
			pstmt.setString(9, memVO.getmemberId());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	public void delete(String memberId) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, memberId);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	public MemVO findByPrimaryKey(String memberId) {

		MemVO memVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, memberId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				memVO = new MemVO();
				memVO.setmemberId(rs.getString("memberId"));
				memVO.setmname(rs.getString("mname"));
				memVO.setmnickn(rs.getString("mnickn"));
				memVO.setmpwd(rs.getString("mpwd"));
				memVO.setmbirthday(rs.getDate("mbirthday"));
				memVO.setmmail(rs.getString("mmail"));
				memVO.setmaddr(rs.getString("maddr"));
				memVO.setmphone(rs.getString("mphone"));
				memVO.setmintr(rs.getString("mintr"));

			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return memVO;

	}

	public List<MemVO> getAll() {
		List<MemVO> list = new ArrayList<MemVO>();
		MemVO memVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// memVO 也稱為 Domain objects
				memVO = new MemVO();
				memVO.setmemberId(rs.getString("memberId"));
				memVO.setmname(rs.getString("mname"));
				memVO.setmnickn(rs.getString("mnickn"));
				memVO.setmpwd(rs.getString("mpwd"));
				memVO.setmbirthday(rs.getDate("mbirthday"));
				memVO.setmmail(rs.getString("mmail"));
				memVO.setmaddr(rs.getString("maddr"));
				memVO.setmphone(rs.getString("mphone"));
				memVO.setmintr(rs.getString("mintr"));
				list.add(memVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {

		MemJDBCDAO dao = new MemJDBCDAO();

		 MemVO memVO1=new MemVO();
		 memVO1.setmemberId("eeit970307");
		 memVO1.setmname("王立藍");
		 memVO1.setmnickn("職業哈星");
		 memVO1.setmpwd("eeit97032017");
		 memVO1.setmbirthday(java.sql.Date.valueOf("1978-05-22"));
		 memVO1.setmmail("eeit9703@gmail.com");
		 memVO1.setmaddr("你家");
		 memVO1.setmphone("0912-345-678");
		 memVO1.setmintr("我超猛");
		 
		 
		 dao.insert(memVO1);

//		 MemVO memVO2=new MemVO();
//		 memVO2.setmemberId("eeit970301");
//		 memVO2.setmname("王立綠");
//		 memVO2.setmnickn("業餘哈星");
//		 memVO2.setmpwd("eeit9703022017");
//		 memVO2.setmbirthday(java.sql.Date.valueOf("1990-11-22"));
//		 memVO2.setmmail("eeit970302@gmail.com");
//		 memVO2.setmaddr("我家");
//		 memVO2.setmphone("0987-654-321");
//		 memVO2.setmintr("我超爛");
//		 dao.update(memVO2);
//
//		dao.delete("eeit970301");
//
//		MemVO memVO3 = dao.findByPrimaryKey("eeit970301");
//		System.out.print(memVO3.getmemberId() + ",");
//		System.out.print(memVO3.getmname() + ",");
//		System.out.print(memVO3.getmnickn() + ",");
//		System.out.print(memVO3.getmpwd() + ",");
//		System.out.print(memVO3.getmbirthday() + ",");
//		System.out.print(memVO3.getmmail() + ",");
//		System.out.print(memVO3.getmaddr() + ",");
//		System.out.print(memVO3.getmphone() + ",");
//		System.out.print(memVO3.getmintr());
//		System.out.println("---------------------");
//
//		List<MemVO> list = dao.getAll();
//		for (MemVO aMem : list) {
//			System.out.print(aMem.getmemberId() + ",");
//			System.out.print(aMem.getmname() + ",");
//			System.out.print(aMem.getmnickn() + ",");
//			System.out.print(aMem.getmpwd()+",");
//			System.out.print(aMem.getmbirthday() + ",");
//			System.out.print(aMem.getmmail() + ",");
//			System.out.print(aMem.getmaddr() + ",");
//			System.out.print(aMem.getmphone() + ",");
//			System.out.print(aMem.getmintr());
//			System.out.println();
//
//		}
	}
}

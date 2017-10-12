package com.iii.eeit9703.member;

import java.sql.*;
import java.util.*;



public class MemJDBCDAO {
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url = "jdbc:sqlserver://localhost:1433;DatabaseName=EEIT9703test";
	String userid = "sa";
	String passwd = "P@ssw0rd";

	private static final String INSERT_STMT = "INSERT INTO member (member_Id,m_name,m_nickn,m_pwd,m_age,m_mail,m_addr,m_phone,m_intr) VALUES(?,?,?,?,?,?,?,?,?)";
	private static final String GET_ALL_STMT = "SELECT  member_Id,m_name,m_nickn,m_pwd,m_age,m_mail,m_addr,m_phone,m_intr FROM member order by member_Id";
	private static final String GET_ONE_STMT = "SELECT  member_Id,m_name,m_nickn,m_pwd,m_age,m_mail,m_addr,m_phone,m_intr FROM member WHERE member_Id=?";
	private static final String DELETE = "DELETE FROM member WHERE member_Id=?";
	private static final String UPDATE = "UPDATE member set m_name=?,m_nickn=?, m_pwd=?, m_age=?, m_mail=?, m_addr=?, m_phone=?,m_intr=?  WHERE member_Id=?";

	public void insert(MemVO memVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, memVO.getMember_Id());
			pstmt.setString(2, memVO.getM_name());
			pstmt.setString(3, memVO.getM_nickn());
			pstmt.setString(4, memVO.getM_pwd());
			pstmt.setInt(5, memVO.getM_age());
			pstmt.setString(6, memVO.getM_mail());
			pstmt.setString(7, memVO.getM_addr());
			pstmt.setString(8, memVO.getM_phone());
			pstmt.setString(9, memVO.getM_intr());

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

			pstmt.setString(1, memVO.getM_name());
			pstmt.setString(2, memVO.getM_nickn());
			pstmt.setString(3, memVO.getM_pwd());
			pstmt.setInt(4, memVO.getM_age());
			pstmt.setString(5, memVO.getM_mail());
			pstmt.setString(6, memVO.getM_addr());
			pstmt.setString(7, memVO.getM_phone());
			pstmt.setString(8, memVO.getM_intr());
			pstmt.setString(9, memVO.getMember_Id());

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

	public void delete(String member_Id) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, member_Id);

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

	public MemVO findByPrimaryKey(String member_Id) {

		MemVO memVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, member_Id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				memVO = new MemVO();
				memVO.setMember_Id(rs.getString("member_Id"));
				memVO.setM_name(rs.getString("m_name"));
				memVO.setM_nickn(rs.getString("m_nickn"));
				memVO.setM_pwd(rs.getString("m_pwd"));
				memVO.setM_age(rs.getInt("m_age"));
				memVO.setM_mail(rs.getString("m_mail"));
				memVO.setM_addr(rs.getString("m_addr"));
				memVO.setM_phone(rs.getString("m_phone"));
				memVO.setM_intr(rs.getString("m_intr"));

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
				memVO.setMember_Id(rs.getString("member_Id"));
				memVO.setM_name(rs.getString("m_name"));
				memVO.setM_nickn(rs.getString("m_nickn"));
				memVO.setM_pwd(rs.getString("m_pwd"));
				memVO.setM_age(rs.getInt("m_age"));
				memVO.setM_mail(rs.getString("m_mail"));
				memVO.setM_addr(rs.getString("m_addr"));
				memVO.setM_phone(rs.getString("m_phone"));
				memVO.setM_intr(rs.getString("m_intr"));
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
		 memVO1.setMember_Id("eeit970302");
		 memVO1.setM_name("王立藍");
		 memVO1.setM_nickn("職業哈星");
		 memVO1.setM_pwd("eeit97032017");
		 memVO1.setM_age(38);
		 memVO1.setM_mail("eeit9703@gmail.com");
		 memVO1.setM_addr("你家");
		 memVO1.setM_phone("0912-345-678");
		 memVO1.setM_intr("我超猛");
		 dao.insert(memVO1);

		 MemVO memVO2=new MemVO();
		 memVO2.setMember_Id("eeit970301");
		 memVO2.setM_name("王立綠");
		 memVO2.setM_nickn("業餘哈星");
		 memVO2.setM_pwd("eeit9703022017");
		 memVO2.setM_age(28);
		 memVO2.setM_mail("eeit970302@gmail.com");
		 memVO2.setM_addr("我家");
		 memVO2.setM_phone("0987-654-321");
		 memVO2.setM_intr("我超爛");
		 dao.update(memVO2);

		dao.delete("eeit970301");

		MemVO memVO3 = dao.findByPrimaryKey("eeit970301");
		System.out.print(memVO3.getMember_Id() + ",");
		System.out.print(memVO3.getM_name() + ",");
		System.out.print(memVO3.getM_nickn() + ",");
		System.out.print(memVO3.getM_pwd() + ",");
		System.out.print(memVO3.getM_age() + ",");
		System.out.print(memVO3.getM_mail() + ",");
		System.out.print(memVO3.getM_addr() + ",");
		System.out.print(memVO3.getM_phone() + ",");
		System.out.print(memVO3.getM_intr());
		System.out.println("---------------------");

		List<MemVO> list = dao.getAll();
		for (MemVO aMem : list) {
			System.out.print(aMem.getMember_Id() + ",");
			System.out.print(aMem.getM_name() + ",");
			System.out.print(aMem.getM_nickn() + ",");
			System.out.print(aMem.getM_pwd()+",");
			System.out.print(aMem.getM_age() + ",");
			System.out.print(aMem.getM_mail() + ",");
			System.out.print(aMem.getM_addr() + ",");
			System.out.print(aMem.getM_phone() + ",");
			System.out.print(aMem.getM_intr());
			System.out.println();

		}
	}
}

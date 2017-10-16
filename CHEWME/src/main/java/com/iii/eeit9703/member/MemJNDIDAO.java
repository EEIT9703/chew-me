package com.iii.eeit9703.member;

import java.util.*;
import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemJNDIDAO implements Mem_interface {
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/CMDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	private static final String INSERT_STMT = "INSERT INTO member (memberId,mname,mnickn,mpwd,mbirthday,mmail,maddr,mphone,mintr,mphoto,mstatus,mrole) VALUES(?,?,?,?,?,?,?,?,?,?,'正常','一般會員')";
	private static final String GET_ALL_STMT = "SELECT  memberId,mname,mnickn,mpwd,mbirthday,mmail,maddr,mphone,mintr,mphoto,mstatus,mrole FROM member order by memberId";
	private static final String GET_ONE_STMT = "SELECT  memberId,mname,mnickn,mpwd,mbirthday,mmail,maddr,mphone,mintr,mphoto,mstatus,mrole FROM member WHERE memberId=?";
	private static final String DELETE = "DELETE FROM member WHERE memberId=?";
	private static final String UPDATE = "UPDATE member set mname=?,mnickn=?, mpwd=?, mbirthday=?, mmail=?, maddr=?, mphone=?,mintr=?,mphoto=?,mstatus=?,mrole=?  WHERE memberId=?";

	@Override
	public void insert(MemVO memVO) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, memVO.getmemberId());
			pstmt.setString(2, memVO.getmname());
			pstmt.setString(3, memVO.getmnickn());
			pstmt.setString(4, memVO.getmpwd());
			pstmt.setString(5, memVO.getmbirthday());
			pstmt.setString(6, memVO.getmmail());
			pstmt.setString(7, memVO.getmaddr());
			pstmt.setString(8, memVO.getmphone());
			pstmt.setString(9, memVO.getmintr());

			pstmt.executeUpdate();

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

	@Override
	public void update(MemVO memVO) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, memVO.getmname());
			pstmt.setString(2, memVO.getmnickn());
			pstmt.setString(3, memVO.getmpwd());
			pstmt.setString(4, memVO.getmbirthday());
			pstmt.setString(5, memVO.getmmail());
			pstmt.setString(6, memVO.getmaddr());
			pstmt.setString(7, memVO.getmphone());
			pstmt.setString(8, memVO.getmintr());
			pstmt.setString(9, memVO.getmemberId());

			pstmt.executeUpdate();

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

	@Override
	public void delete(String memberId) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, memberId);

			pstmt.executeUpdate();

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

	@Override
	public MemVO findByPrimaryKey(String memberId) {
		MemVO memVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
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
				memVO.setmbirthday(rs.getString("mbirthday"));
				memVO.setmmail(rs.getString("mmail"));
				memVO.setmaddr(rs.getString("maddr"));
				memVO.setmphone(rs.getString("mphone"));
				memVO.setmintr(rs.getString("mintr"));

			}

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

	@Override
	public List<MemVO> getAll() {
		List<MemVO> list = new ArrayList<MemVO>();
		MemVO memVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// memVO 也稱為 Domain objects
				memVO = new MemVO();
				memVO.setmemberId(rs.getString("memberId"));
				memVO.setmname(rs.getString("mname"));
				memVO.setmnickn(rs.getString("mnickn"));
				memVO.setmpwd(rs.getString("mpwd"));
				memVO.setmbirthday(rs.getString("mbirthday"));
				memVO.setmmail(rs.getString("mmail"));
				memVO.setmaddr(rs.getString("maddr"));
				memVO.setmphone(rs.getString("mphone"));
				memVO.setmintr(rs.getString("mintr"));
				list.add(memVO); // Store the row in the list
			}

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		}finally {
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

}

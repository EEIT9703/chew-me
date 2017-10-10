package com.iii.eeit9703.activity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ActivityJDBCDAO implements ActivityDAO_interface {
	
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url = "jdbc:sqlserver://localhost:1433;DatabaseName=DB01";
	String userid = "sa";
	String passwd = "P@ssw0rd";

	//新增
	private static final String INSERT_STMT =
			"INSERT INTO activity (attractionID,name,county,Day,period,Desc) VALUES (?,?,?,?,?,?) ";
	//修改
	private static final String UPDATE_STMT =
			"UPDATE activity set attractionID=?, name=?, county=? ,Day=?, period=?, Desc=? where actID = ? ";
	//刪除
	private static final String DELETE_STMT =
			"DELETE FROM activity actID = ?";
	//查詢
	private static final String GET_ALL_STMT =
		      "SELECT actID,attractionID,name,county,Day,period,Desc FROM acvitity order by actID";
	private static final String GET_ONE_STMT =
		      "SELECT actID,attractionID,name,county,Day,period,Desc FROM acvitity where actID = ?";

	
	//新增
	@Override
	public void insert(ActivityVO activityVO) {
        
		Connection con = null;
		PreparedStatement pstmt =null;
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setInt(1, activityVO.getAttactionID());
			pstmt.setString(2, activityVO.getName());
			pstmt.setString(3, activityVO.getCounty());
			pstmt.setDate(4, activityVO.getDay());
			pstmt.setDate(5, activityVO.getPeriod());
			pstmt.setString(6, activityVO.getDesc());
			
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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

	
	//修改
	@Override
	public void update(ActivityVO activityVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE_STMT);
			
			pstmt.setInt(1, activityVO.getAttactionID());
			pstmt.setString(2, activityVO.getName());
			pstmt.setString(3, activityVO.getCounty());
			pstmt.setDate(4, activityVO.getDay());
			pstmt.setDate(5, activityVO.getPeriod());
			pstmt.setString(6, activityVO.getDesc());
			
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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

	
	//刪除
	@Override
	public void delete(Integer actID) {
		
		Connection con = null;
		PreparedStatement pstmt =null;
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE_STMT);
			
			pstmt.setInt(1, actID);
			
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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

	
	//
	@Override
	public ActivityVO findByPrimaryKey(Integer actID) {

		ActivityVO activityVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			
			pstmt.setInt(1, actID);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()){
				
				activityVO = new ActivityVO();
				
				activityVO.setActID(rs.getInt("actID"));
				activityVO.setName(rs.getNString("Name"));
				activityVO.setCounty(rs.getString("County"));
				activityVO.setDay(rs.getDate("Day"));
				activityVO.setPeriod(rs.getDate("period"));
				activityVO.setDesc(rs.getString("Desc"));
				
				
			}
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
		
		return activityVO;
	}

	@Override
	public List<ActivityVO> getAll() {
		
		List<ActivityVO> list = new ArrayList<ActivityVO>();
		ActivityVO activityVO = null;

		Connection con =null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			
			while(rs.next()){
				
                activityVO = new ActivityVO();
				
				activityVO.setActID(rs.getInt("actID"));
				activityVO.setName(rs.getNString("Name"));
				activityVO.setCounty(rs.getString("County"));
				activityVO.setDay(rs.getDate("Day"));
				activityVO.setPeriod(rs.getDate("period"));
				activityVO.setDesc(rs.getString("Desc"));
				
				list.add(activityVO);
				
			}
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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

		ActivityJDBCDAO dao = new ActivityJDBCDAO();
		
		//新增
		ActivityVO actVO1 = new ActivityVO();
		
		actVO1.setName("九份");
		actVO1.setCounty("北部");
		actVO1.setDay(java.sql.Date.valueOf("2017-10-10"));
		actVO1.setPeriod(java.sql.Date.valueOf("2017-10-10"));
		actVO1.setDesc("無");
		dao.insert(actVO1);
		
		//修改
        ActivityVO actVO2 = new ActivityVO();
		
		actVO2.setActID(1);
		actVO2.setName("八份");
		actVO2.setCounty("中部");
		actVO2.setDay(java.sql.Date.valueOf("2017-10-10"));
		actVO2.setPeriod(java.sql.Date.valueOf("2017-10-10"));
		actVO2.setDesc("無");
		dao.insert(actVO2);
		
		//刪除
		dao.delete(1);
		
		// 查詢
		ActivityVO actVO3 = dao.findByPrimaryKey(1);
		System.out.print(actVO3.getActID() + ",");
		System.out.print(actVO3.getName() + ",");
		System.out.print(actVO3.getCounty() + ",");
		System.out.print(actVO3.getDay() + ",");
		System.out.print(actVO3.getPeriod() + ",");
		System.out.print(actVO3.getDesc() + ",");
		System.out.println("---------------------");
		
		// 查詢
		List<ActivityVO> list = dao.getAll();
		for (ActivityVO aAct : list) {
			System.out.print(aAct.getActID() + ",");
			System.out.print(aAct.getName() + ",");
			System.out.print(aAct.getCounty() + ",");
			System.out.print(aAct.getDay() + ",");
			System.out.print(aAct.getPeriod() + ",");
			System.out.print(aAct.getDesc() + ",");
			System.out.println();
		}
		

	}

}

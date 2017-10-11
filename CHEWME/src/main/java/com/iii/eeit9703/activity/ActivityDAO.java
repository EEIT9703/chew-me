package com.iii.eeit9703.activity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ActivityDAO implements ActivityDAO_interface {

	
	private static DataSource ds = null;
	static{
		try {
			Context ctx = new InitialContext(); //初始化
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/TestDB"); //連結資料庫
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
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
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setInt(1, activityVO.getAttactionID());
			pstmt.setString(2, activityVO.getName());
			pstmt.setString(3, activityVO.getCounty());
			pstmt.setInt(4, activityVO.getDay());
			pstmt.setDate(5, activityVO.getPeriod());
			pstmt.setString(6, activityVO.getDesc());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException("資料庫新增錯誤" + e.getMessage());
			
		}finally{
			if(pstmt != null){	
				try {
					pstmt.close();
				} catch (SQLException e1) {
					e1.printStackTrace(System.err);
				}
			}
		}
		if(con !=null){
			try {
				con.close();
			} catch (SQLException e1) {
				e1.printStackTrace(System.err);
			}
		}
		
	}

	
	//修改
	@Override
	public void update(ActivityVO activityVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE_STMT);
			
			pstmt.setInt(1, activityVO.getAttactionID());
			pstmt.setString(2, activityVO.getName());
			pstmt.setString(3, activityVO.getCounty());
			pstmt.setInt(4, activityVO.getDay());
			pstmt.setDate(5, activityVO.getPeriod());
			pstmt.setString(6, activityVO.getDesc());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException("資料庫更新錯誤" + e.getMessage());
			
		}finally{
			if(pstmt != null){	
				try {
					pstmt.close();
				} catch (SQLException e1) {
					e1.printStackTrace(System.err);
				}
			}
		}
		if(con !=null){
			try {
				con.close();
			} catch (SQLException e1) {
				e1.printStackTrace(System.err);
			}
		}
		
	}

	
	//刪除
	@Override
	public void delete(Integer actID) {
		
		Connection con = null;
		PreparedStatement pstmt =null;
		
		try {
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE_STMT);
			
			pstmt.setInt(1, actID);
			
			pstmt.executeUpdate();
			
		} catch (SQLException se) {
			throw new RuntimeException("資料庫刪除錯誤"
					+ se.getMessage());
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
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
			
			pstmt.setInt(1, actID);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()){
				
				activityVO = new ActivityVO();
				
				activityVO.setActID(rs.getInt("actID"));
				activityVO.setName(rs.getNString("Name"));
				activityVO.setCounty(rs.getString("County"));
				activityVO.setDay(rs.getInt("Day"));
				activityVO.setPeriod(rs.getDate("period"));
				activityVO.setDesc(rs.getString("Desc"));
				
				
			}
			
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
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
                activityVO = new ActivityVO();
				
				activityVO.setActID(rs.getInt("actID"));
				activityVO.setName(rs.getNString("Name"));
				activityVO.setCounty(rs.getString("County"));
				activityVO.setDay(rs.getInt("Day"));
				activityVO.setPeriod(rs.getDate("period"));
				activityVO.setDesc(rs.getString("Desc"));
				
				list.add(activityVO);
				
			}
			
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

}

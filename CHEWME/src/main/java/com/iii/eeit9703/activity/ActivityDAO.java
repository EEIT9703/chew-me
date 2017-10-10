package com.iii.eeit9703.activity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
			pstmt.setDate(4, activityVO.getDay());
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

	@Override
	public void update(ActivityVO activityVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer actID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ActivityVO findByPrimaryKey(Integer actID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ActivityVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

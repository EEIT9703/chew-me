package com.iii.eeit9703.actEditor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AreaDAO {

	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url = "jdbc:sqlserver://localhost:1433;DatabaseName=CMDB";
	String userid = "sa";
	String passwd = "P@ssw0rd";
	
	private static final String SELECT = "SELECT conty where cityID = ?";
	
	public AreaVO findConty(String cityID){
		
		AreaVO areaVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(SELECT);
			
			pstmt.setString(1, cityID);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				areaVO = new AreaVO();
				areaVO.setAreaID(rs.getInt("areaID"));
				areaVO.setConty(rs.getString("conty"));
				areaVO.setCity(rs.getString("city"));
				areaVO.setCityID(rs.getString("cityID"));
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(rs != null){
				try {rs.close();} 
				catch (SQLException e) {e.printStackTrace();}
			}
			if(pstmt != null){
				try {pstmt.close();} 
				catch (SQLException e) {e.printStackTrace();}
			}
			if(con != null){
				try {con.close();} 
				catch (SQLException e) {e.printStackTrace();}
			}
		}
		return areaVO;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

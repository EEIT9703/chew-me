package com.iii.eeit9703.member;

import java.io.*;
import java.util.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@MultipartConfig(location="",
fileSizeThreshold=1024*1024,//檔案大小
maxFileSize=1024*1024*500,//檔案長度
maxRequestSize=1024*1024*500*5)//所有檔案總長度
public class RegisterServlet extends HttpServlet{
	private static final long serialVersionUID=1L;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("UTF-8");//文字資料轉碼
		Map<String,String>errorMsg=new HashMap<String,String>();//準備存放錯誤訊息的Map物件
		Map<String,String>msgOK=new HashMap<String,String>();//準備存放成功註冊訊息的Map物件
		HttpSession session=request.getSession();//
		request.setAttribute("MsgMap", errorMsg);//顯示錯誤訊息
		request.setAttribute("MsgOK", msgOK);//顯示成功訊息
		
	}

}

package com.iii.eeit9703.member;

import java.io.*;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@MultipartConfig(location = "", fileSizeThreshold = 1024 * 1024, // 檔案大小
		maxFileSize = 1024 * 1024 * 500, // 檔案長度
		maxRequestSize = 1024 * 1024 * 500 * 5) // 所有檔案總長度
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("UTF-8");//文字資料轉碼
		Map<String,String>errorMsg=new HashMap<String,String>();//準備存放錯誤訊息的Map物件
		Map<String,String>msgOK=new HashMap<String,String>();//準備存放成功註冊訊息的Map物件
		HttpSession session=request.getSession();//
		request.setAttribute("MsgMap", errorMsg);//顯示錯誤訊息
		request.setAttribute("MsgOK", msgOK);//顯示成功訊息
		
		String memberId="";
		String mname="";
		String mnickn="";
		String mpwd="";
		String mpwdchk="";
		String mbirthday="";
		String mmail="";
		String maddr="";
		String mphone="";
		String mintr="";
		String mphoto="";
		long sizeInBytes=0;
		InputStream is=null;
		String mstatus="正常";
		String mrole="一般會員";
		
		Collection<Part> parts=request.getParts();//取出multipart request內所有的parts
		GlobalService.exploreParts(parts,request);
		if(parts!=null){
			for(Part p:parts){
				String fldName=p.getName();
				String value=request.getParameter(fldName);
				if(p.getContentType()==null){
					if(fldName.equals("memberId")){
						memberId=value;
					}else if(fldName.equalsIgnoreCase("mname")){
						mname=value;
					}else if(fldName.equalsIgnoreCase("mnickn")){
						mnickn=value;
					}else if(fldName.equals("mpwd")){
						mpwd=value;
					}else if(fldName.equals("mpwdchk")){
						mpwdchk=value;
					}else if(fldName.equals("mbirthday")){
						mbirthday=value;
					}else if(fldName.equalsIgnoreCase("mmail")){
						mmail=value;
					}else if(fldName.equalsIgnoreCase("maddr")){
						maddr=value;
					}else if(fldName.equals("mphone")){
						mphone=value;
					}else if(fldName.equals("mintr")){
						mintr=value;
					}
					}else{
						mphoto=GlobalService.getFileName(p);
						if(mphoto!=null&&mphoto.trim().length()>0){
							sizeInBytes=p.getSize();
							is=p.getInputStream();
						}else{
							errorMsg.put("errPicture", "必須挑選圖片檔");
						}
					}
				}
				if(memberId==null&&memberId.trim().length()==0){
					errorMsg.put("errorIDEmpty", "帳號欄位必須輸入");
				}
				if(mname==null&&mname.trim().length()==0){
					errorMsg.put("errorNameEmpty", "姓名欄位必須輸入");
				}
				if(mnickn==null&&mnickn.trim().length()==0){
					errorMsg.put("errorNickEmpty", "暱稱欄位必須輸入");
				}
				if(mpwd==null&&mpwd.trim().length()==0){
					errorMsg.put("errorPwdEmpty", "密碼欄位必須輸入");
				}
				if(mpwdchk==null&&mpwdchk.trim().length()==0){
					errorMsg.put("errorPwdChkEmpty", "密碼確認欄位必須輸入");
				}
				if(mpwd.trim().length()>0&&mpwdchk.trim().length()>0){
					if(!mpwd.trim().equals(mpwdchk.trim())){
						errorMsg.put("errorPwdChkEmpty", "密碼欄位與確認欄位必須一致");
						errorMsg.put("errorPwdEmpty", "*");
					}
				}
				if(mbirthday==null&&mbirthday.trim().length()==0){
					errorMsg.put("errorBDEmpty", "生日欄位必須輸入");
				}
				if(mmail==null&&mmail.trim().length()==0){
					errorMsg.put("errorMailEmpty", "信箱欄位必須輸入");
				}
				if(maddr==null&&maddr.trim().length()==0){
					errorMsg.put("errorAddrEmpty", "地址欄位必須輸入");
				}
				if(mphone==null&&mphone.trim().length()==0){
					errorMsg.put("errorPhoneEmpty", "電話欄位必須輸入");
				}
				if(mintr==null&&mintr.trim().length()==0){
					errorMsg.put("errorIntrEmpty", "自我介紹欄位必須輸入");
				}
				if(maddr==null&&maddr.trim().length()==0){
					errorMsg.put("errorAddrEmpty", "地址欄位必須輸入");
				}
			}else{
				errorMsg.put("errTitle", "此表單不是上傳檔案的表單");//errTitle待確認
			}
		//如果有錯誤
		if(!errorMsg.isEmpty()){
			//導回註冊畫面,並顯示錯誤訊息
			RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
			rd.forward(request, response);
			return;
		}
		try{
			RegisterServiceDB rs=new RegisterServiceDB();//RegisterServiceDB待建立
			if(rs.idExists(memberId)){
				errorMsg.put("errorIDDup", "帳號已存在")
			}else{//MemberBean待建立
				MemberBean mem=new MemberBean(memberId,mname,mnickn,mpwd,mbirthday,mmail,maddr,mphone,mintr,mstatus,mrole);
				//將MemberBean mem寫入DB
				int n=rs.saveMember(mem,is,sizeInBytes,mphoto);
				if(n==1){
					msgOK.put("InsertOK", "Insert Success");
					response.sendRedirect("../index.jsp");
					return;
				}else{
					errorMsg.put("errorIDDup","註冊失敗");
				}
			}
			if(!errorMsg.isEmpty()){
				//導回註冊畫面,並顯示錯誤訊息
				RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
				rd.forward(request, response);
				return;
			}
		}catch(Exception e){
			e.printStackTrace();
			errorMsg.put("errorIDDup", e.getMessage());
			RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
			rd.forward(request, response);
		}
		}
}

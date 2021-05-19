package com.veranda.member.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veranda.common.controller.NextPage;
import com.veranda.common.controller.SuperClass;
import com.veranda.member.dao.MemberDao;
import com.veranda.member.vo.Member;

public class MemberInsertController extends SuperClass{
	Member bean = null;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		String gotopage = "/members/memberInsertForm.jsp";
		super.GotoPage(gotopage);
		
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
		bean = new Member();
		
		bean.setUser_id(request.getParameter("id"));
		bean.setUser_pwd(request.getParameter("pwd"));
		bean.setUser_name(request.getParameter("name"));
		bean.setUser_nickname(request.getParameter("nickname"));
		bean.setUser_email(request.getParameter("mail"));
		bean.setUser_phone(request.getParameter("phone"));
		bean.setUser_address(request.getParameter("address"));
		bean.setUser_birth(request.getParameter("birth"));
		bean.setUser_gender(request.getParameter("sex"));
		bean.setUser_remark(request.getParameter("remark"));
		bean.setUser_address(request.getParameter("sample2_address"));
		bean.setUser_address1(request.getParameter("sample2_extraAddress"));
		bean.setUser_address2(request.getParameter("ample2_detailAddress"));
		
		
		if (request.getParameter("sample2_postcode") == null || request.getParameter("sample2_postcode").equals("")) {
			bean.setUser_postcode(0);
		} else {
			bean.setUser_postcode(Integer.parseInt(request.getParameter("sample2_postcode")));
		}
		
		System.out.println("postcode 유효성 검사 진입");
		
//		if ( request.getParameter("postcode") == null || request.getParameter("postcode").equals("")) {
//			bean.setUser_postcode(0);
//			
//			System.out.println("postcode 공백에 대한 내용 처리 완료");
//			
//		} else {
//			bean.setUser_postcode(Integer.parseInt(request.getParameter("postcode")));
//			
//			System.out.println("postcode 공백아 아닐 경우에 대한 내용 처리 완료");
//		}
		
		MemberDao mdao = new MemberDao();
		
		if (this.validate(request) == true) {
			System.out.println("회원가입 유효성 검사 성공(MemberInsertController 68줄)");
			
			int cnt = - 1;
			
			cnt = mdao.InsertData(bean);
			
			new MemberLoginController().doGet(request, response);
		
		} else {
			System.out.println("회원가입 유효성 검사 실패(MemberInsertController 77줄)");

			super.doPost(request, response);
			String gotopage = "members/memberInsertForm.jsp";
			super.GotoPage(gotopage);
		} // if - else문 끝
		
		}	// doPost 끝

	}  // Class 끝



//String token = 
//
//if (access_token != null) { /* access token 받아왔는지 확인 */
//		try {
//			String apiurl = "https://openapi.naver.com/v1/nid/me";
//			
//			URL url = new URL(apiurl);
//			
//			HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
//			
//			con.setRequestMethod("GET");
//			con.setRequestProperty("Authorization", header);
//			
//			int responseCode = con.getResponseCode();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}

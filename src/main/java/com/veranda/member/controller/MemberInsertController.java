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
		bean.setUser_email(request.getParameter("email"));
		bean.setUser_phone(request.getParameter("phone"));
		bean.setUser_birth(request.getParameter("birth"));
		bean.setUser_gender(request.getParameter("sex"));
		bean.setUser_address(request.getParameter("sample2_address"));
		bean.setUser_address1(request.getParameter("sample2_extraAddress"));
		bean.setUser_address2(request.getParameter("sample2_detailAddress"));
		bean.setUser_phone1(request.getParameter("phone1"));
		bean.setUser_phone2(request.getParameter("phone2"));
		
		System.out.println("postcode 유효성 검사 진입");
		
		if (request.getParameter("sample2_postcode") == null || request.getParameter("sample2_postcode").equals("")) {
			bean.setUser_postcode(0);
			
			System.out.println("postcode 공백에 대한 내용 처리 완료");
			
		} else {
			bean.setUser_postcode(Integer.parseInt(request.getParameter("sample2_postcode")));
		
			System.out.println("postcode 공백 아닐 경우에 대한 내용 처리 완료");
		}
		
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
	
	@Override
	public boolean validate(HttpServletRequest request) {
		boolean joinCheck = true;
		
		System.out.println("MemberInsertController validate() 진입 하였습니다");
		
		if (bean.getUser_id().length() < 5 || bean.getUser_id().length() > 15) {
			request.setAttribute(super.PREFIX + "id", "아이디는 5자리 이상 15자리 이하로 입력 해 주시기 바랍니다!");
			joinCheck = false;
			
			System.out.println("MemberInsertController validate() 아이디 유효성 검사 실패 하였습니다!");
		}
		
		if (bean.getUser_pwd().length() < 10 || bean.getUser_pwd().length() > 20) {
			request.setAttribute(super.PREFIX + "pwd", "비밀번호는 10자리 이상 20자리 이하로 입력 해 주시기 바랍니다!");
			joinCheck = false;
			
			System.out.println("MemberInsertController validate() 비밀번호 유효성 검사 실패 하였습니다!");
		}
		
		if (bean.getUser_nickname().length() < 3 || bean.getUser_nickname().length() > 8) {
			request.setAttribute(super.PREFIX + "nickname", "닉네임은 3자리 이상 8자리 이하로 입력 해 주시기 바랍니다!");
			joinCheck = false;
			
			System.out.println("MemberInsertController validate() 닉네임 유효성 검사 실패 하였습니다!");
		}
		
		if(bean.getUser_name().length() < 2 || bean.getUser_name().length() > 8) {
			request.setAttribute(super.PREFIX + "name", "이름은 2자리 이상 8자리 이하로 입력 해 주시기 바랍니다!");
			joinCheck = false;
			
			System.out.println("MemberInsertController validate() 이름 유효성 검사 실패 하였습니다!");
		}
		
		if (bean.getUser_email() == null || bean.getUser_nickname() == "") {
			request.setAttribute(super.PREFIX + "email", "이메일을 입력 해 주세요!");
			joinCheck = false;
			
			System.out.println("MemberInsertController validate() 이메일 유효성 검사 실패 하였습니다!");
		}
		
		String regex = "\\d{4}[-/]\\d{2}[-/]\\d{2}";
		
		if (bean.getUser_birth() == null) {
			bean.setUser_birth("");
			
		}
		
		// pattern.matches는 앞에 매개변수 값을 토대로 쉼표 뒤에 매개변수 값을 검사하는 메서드
					boolean result = java.util.regex.Pattern.matches(regex, bean.getUser_birth());
					
		if (result == false) {
			request.setAttribute(super.PREFIX + "birth", "생일을 입력 해 주시기 바랍니다!");
			joinCheck = false;
			
			System.out.println("MemberInsertController validate() 생일 유효성 검사 실패 하였습니다!");
		}
		
		if (bean.getUser_address2() == null || bean.getUser_address2() == "") {
			request.setAttribute(super.PREFIX + "sample2_detailAddress", "상세 주소는 필수 입력 사항 입니다.");
			joinCheck = false;
			
			System.out.println("MemberInsertController validate() 상세 주소 유효성 검사 실패 하였습니다!");
		}
	
		System.out.println("MemberInsertController validate() 유효성 검사 결과" + joinCheck + " 입니다!");
		return joinCheck;
	} // validate 끝

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

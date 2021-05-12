package com.veranda.member.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		bean.setId(request.getParameter("id"));
		bean.setPwd(request.getParameter("pwd"));
		
		MemberDao dao = new MemberDao();
		
		if ( this.validate(request) == true) { /* log용 txt 파일 만들기 */
			
		     String txt = "회원 가입 유효성 검사가 정상적으로 실행 되었습니다." ;
	         
		        String fileName = "../../../../../../src/main/webapp/log" ;
		         
		        try{
		                         
		            // BufferedWriter 와 FileWriter를 조합하여 사용 (속도 향상)
		            BufferedWriter fw = new BufferedWriter(new FileWriter(fileName, true));
		             
		            // 파일안에 문자열 쓰기
		            fw.write(txt);
		            fw.flush();
		 
		            fw.close();  // 객체 닫기
		             
		             
		        }catch(Exception e){ /* 파일 읽는데 문제가 생기면 excetion 발생 */
		            e.printStackTrace();
		        } // try-catch 끝
			
		} // log 생성용 if문 끝

	} // doPost 끝

} // class 끝

package com.veranda.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veranda.common.controller.SuperClass;
import com.veranda.member.dao.MemberDao;
import com.veranda.member.vo.Member;

public class MemberIdcheckController extends SuperClass{
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		String user_id = request.getParameter("id");
		
		MemberDao dao = new MemberDao();
		
		Member bean = dao.SelectDataByPk(user_id);
		
		if ( bean == null ) { /* DB에 동일한 아이디가 없다면 */
			request.setAttribute("message",  user_id + "<font color='blue')은(는) <b> 사용 가능 </b>합니다!</font>");
			request.setAttribute("isCheck", true);
			
		} else {
			
			if (bean.getUser_id().equals("admin")) { /* 관리자 아이디 중복 검사 */ 
				request.setAttribute("message", "<font color='red')은(는) <b> 사용 불가 </b>합니다!</font>");
				request.setAttribute("isCheck", false);
				
			} else {
				request.setAttribute("message", "<font color='red')은(는) 이미 <b> 사용 중 </b>입니다!</font>");
				request.setAttribute("isCheck", false);
			}
		}
		
		String gotopage = "members/idCheck.jsp";
		super.GotoPage(gotopage);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
	}

}

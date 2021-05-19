package com.veranda.community.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veranda.common.controller.SuperClass;
import com.veranda.community.dao.CommunityDao;
import com.veranda.community.vo.Community;

public class CommunityHateController extends SuperClass{
	
	private Community bean = null;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		bean = new Community();
		
//		bean.setUser_no(Integer.parseInt(request.getParameter("user_no")));
		bean.setNo(Integer.parseInt(request.getParameter("no")));
		bean.setHate(Integer.parseInt(request.getParameter("hate")));
//		bean.setTitle(request.getParameter("title"));
//		bean.setContent(request.getParameter("content"));
		
		System.out.println( "bean 정보 확인" );
		System.out.println( bean.toString () );
		
		CommunityDao dao = new CommunityDao();
		int cnt = - 1;
		cnt = dao.UpdateHate(bean);
		
		new CommunityDetailViewController().doGet(request, response);

	}
		
	
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		

	}	
}


//int no = Integer.parseInt(request.getParameter("no")) ;
//CommunityDao dao = new CommunityDao();		
//
//Community bean = dao.SelectDataByPk(no);
//
//request.setAttribute("bean", bean);
//
//String gotopage = "/community/communityDetailView.jsp" ;
//super.GotoPage(gotopage);

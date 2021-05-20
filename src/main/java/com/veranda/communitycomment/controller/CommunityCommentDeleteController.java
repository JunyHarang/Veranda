package com.veranda.communitycomment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veranda.common.controller.SuperClass;
import com.veranda.community.controller.CommunityDetailViewController;
import com.veranda.communitycomment.dao.CommunityCommentDao;

public class CommunityCommentDeleteController extends SuperClass{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		int com_no = Integer.parseInt(request.getParameter("com_no"));
		System.out.println(com_no);
//		int no = Integer.parseInt(request.getParameter("no"));
//		System.out.println(no);
		CommunityCommentDao dao = new CommunityCommentDao();
		int cnt = -1;
		cnt = dao.DeleteData(com_no);
		
		new CommunityDetailViewController().doGet(request, response);
		
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}
}

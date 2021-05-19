package com.veranda.community.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.veranda.common.controller.SuperClass;
import com.veranda.community.dao.CommunityDao;

public class CommunityDeleteController extends SuperClass{
	
	/* Copyright 2021. JunyHarang all rights reserved. */
	/* JunyHarang E-mail: junyharang8592@gmail.com */
	/* JunyHarang Blog: https://junyharang.tistory.com */
	/* JunyHarang GitHug: https:github.com/JunyHarang */
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		System.out.println("Copyright 2021. JunyHarang all rights reserved.");
		System.out.println("JunyHarang E-mail: junyharang8592@gmail.com");
		System.out.println("Blog: https://junyharang.tistory.com");
		System.out.println("GitHug: https:github.com/JunyHarang");
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		CommunityDao dao = new CommunityDao();
		
		int cnt = - 1;
		
		cnt = dao.DeleteData(no);
		
		System.out.println("CommunityDeleteController의 doGet()에 cnt 값은 " + cnt + "입니다.");
		
		new CommunityListController().doGet(request, response);
		
	} // doGet 끝
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
	} // doPost 끝
	
} // Class 끝

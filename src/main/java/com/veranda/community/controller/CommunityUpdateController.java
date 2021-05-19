package com.veranda.community.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.veranda.common.controller.SuperClass;
import com.veranda.community.dao.CommunityDao;
import com.veranda.community.vo.Community;
import com.veranda.member.vo.Member;

public class CommunityUpdateController extends SuperClass{
	
	/* Copyright 2021. JunyHarang all rights reserved. */
	/* JunyHarang E-mail: junyharang8592@gmail.com */
	/* JunyHarang Blog: https://junyharang.tistory.com */
	/* JunyHarang GitHug: https:github.com/JunyHarang */
	
	Community bean = null;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		System.out.println("Copyright 2021. JunyHarang all rights reserved.");
		System.out.println("JunyHarang E-mail: junyharang8592@gmail.com");
		System.out.println("Blog: https://junyharang.tistory.com");
		System.out.println("GitHug: https:github.com/JunyHarang");
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		CommunityDao dao = new CommunityDao();
		
		bean = dao.SelectDataByPk(no);
		
		request.setAttribute("bean", bean);
		
		
		String gotopage = "community/communityUpdate.jsp";
		super.GotoPage(gotopage);
		
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
		System.out.println("Copyright 2021. JunyHarang all rights reserved.");
		System.out.println("JunyHarang E-mail: junyharang8592@gmail.com");
		System.out.println("Blog: https://junyharang.tistory.com");
		System.out.println("GitHug: https:github.com/JunyHarang");
		
		MultipartRequest multi = (MultipartRequest)request.getAttribute("multi");	
		
	bean = new Community();
	
	bean.setCategory(multi.getParameter("category"));
	bean.setTitle(multi.getParameter("title"));
	bean.setContent(multi.getParameter("content"));
	
	// 사진 업로드 객체 처리
	
	bean.setImage1(multi.getFilesystemName("image1"));
	bean.setImage2(multi.getFilesystemName("image2"));
	bean.setImage3(multi.getFilesystemName("image3"));
	bean.setImage4(multi.getFilesystemName("image4"));
	bean.setImage5(multi.getFilesystemName("image5"));
	bean.setImage6(multi.getFilesystemName("image6"));
	bean.setImage7(multi.getFilesystemName("image7"));
	bean.setImage8(multi.getFilesystemName("image8"));
	bean.setImage9(multi.getFilesystemName("image9"));
	bean.setImage10(multi.getFilesystemName("image10"));
	
	// int에 대한 처리
	
	if (multi.getParameter("com_no") != null && multi.getParameter("com_no").equals("") == false) {
		bean.setNo(Integer.parseInt(multi.getParameter("com_no")));
	}
	
	
	System.out.println("CommunityUpdateController에 dopost()에 bean에는 다음과 같은 내용이 담겼습니다." + bean.toString());
	
		if ( this.validate(request) == true) { /* 게시글 유효성 검사 */
			System.out.println("CommunityUpdateController에 dopost()에 게시글 유효성 검사가 성공하였습니다.");
			
			CommunityDao dao = new CommunityDao();
			
			int cnt = -1;
			
			cnt = dao.UpdateData(bean);	
			
			new CommunityListController().doGet(request, response);
			
			System.out.println("CommunityUpdateController에 게시글이 정상적으로 업로드 되었습니다");
		
		} else {
			
			System.out.println("CommunityUpdateController에 게시글 유효성 검사가 실패 하였습니다.");
			
			request.setAttribute("bean", bean);
			
			String gotopage = "/community/communityUpdate.jsp";
			super.GotoPage(gotopage);
			
		} // if-else 문 끝
	
	} // doPost 끝
	
	@Override
	public boolean validate(HttpServletRequest request) {
		boolean comUpdateCheck = true;
		
		// 유효성 검사 수행
		// PREFIX는 접두사로 err이 첨부
		
		if (bean.getTitle().length() < 2 || bean.getTitle().length() > 12) {
			request.setAttribute(super.PREFIX + "title", "제목은 2자리 이상 12자리 이하로 작성하실 수 있습니다!");
			
			comUpdateCheck = false;
		}
		
		if (bean.getContent().length() < 5 || bean.getContent().length() > 800) {
			request.setAttribute(super.PREFIX + "content", "게시글 내용은 5글자 이상 800글자 이하로 작성하실 수 있습니다!");
			
			comUpdateCheck = false;
		}
		
		if (bean.getCategory().equals("-") || bean.getCategory().equals(null) ){
			request.setAttribute(super.PREFIX + "category", "카테고리를 선택 해 주세요!!");
			
			comUpdateCheck = false;
		}
		
		return comUpdateCheck;
		
	} // valiDate 끝
	
} // Class 끝

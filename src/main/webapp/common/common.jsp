<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	int twelve = 12 ;
%>
<!DOCTYPE>
<html>
<head>
<title>Stellar by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
	  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
   		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   		<style type="text/css">
      		/* for form validation check */
      		.err{font-size:10pt; color:red; font-weight: bolder;}
   		</style>
</head>
<body>
<%	
	String contextPath = request.getContextPath();
	String mappingName = "/veranda";
	
	String FormYes = contextPath + mappingName;
	String FormNo = contextPath + mappingName + "?command=";
%>
	common.jsp 파일의 내용입니다.
	<div align="center">
		<ul>
			<li><a href="<%=FormNo%>meLogin">로그인</a>&nbsp;/&nbsp;<a href="<%=FormNo%>meInsert">회원가입</a></li>
		</ul>
	</div>	
	<div align="center">
		<!-- Nav -->
		<nav>
			<ul >
				<li>
					<a href="<%=FormNo%>noList" class="active">공지사항</a>&nbsp;&nbsp;
					<a href="<%=FormNo%>prList" class="active">상품 게시판</a>&nbsp;&nbsp;
					<a href="<%=FormNo%>coList" class="active">커뮤니티</a>&nbsp;&nbsp;
					<a href="<%=FormNo%>qnaList" class="active">Q&A</a>&nbsp;&nbsp;
				</li>
			</ul>
		</nav>
		
		</div>
	<br>
</body>
</html>
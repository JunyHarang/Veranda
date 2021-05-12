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
    <meta charset="UTF-8">
    <meta name="description" content="Cake Template">
    <meta name="keywords" content="Cake, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Cake | Template</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@400;500;600;700;800;900&display=swap"
    rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500;600;700;800;900&display=swap"
    rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/flaticon.css" type="text/css">
    <link rel="stylesheet" href="css/barfiller.css" type="text/css">
    <link rel="stylesheet" href="css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
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
	<header class="header">
		<div class="container">
	            <div class="row">
	                <div class="col-lg-12">
	                    <nav class="header__menu mobile-menu">
	                        <ul>
	                            <li class="active">
	                            	<a href="<%=FormNo%>main">
	                            		home
	                            	</a>
	                            </li>
	                            <li>
	                            	<a href="<%=FormNo%>noList">
	                            		공지사항
	                            	</a>
	                            </li>
	                            <li>
	                            	<a href="<%=FormNo%>prList">
	                            		상품 게시판
	                            	</a>
	                            </li>
	                            <li>
	                            	<a href="<%=FormNo%>coList">
	                            		커뮤니티
	                            	</a>
	                            </li>
	                            <li>
	                            	<a href="<%=FormNo%>qnaList">
	                            		Q&A
	                            	</a>
	                            </li>
	                        </ul>
	                    </nav>
	                </div>
	            </div>
	        </div>
        </header>
	<br>
</body>
</html>
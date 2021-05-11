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
</head>
<body>
<%	
	String contextPath = request.getContextPath();
	String mappingName = "/veranda";
	
	String FormYes = contextPath + mappingName;
	String FormNo = contextPath + mappingName + "?command=";
%>
	common.jsp 파일의 내용입니다.
	<div id="wrapper">
	
		<!-- Nav -->
		<nav id="nav" >
			<ul >
				<li><a href="#intro" class="active">Introduction</a></li>
				<li><a href="#first">First Section</a></li>
				<li><a href="#second">Second Section</a></li>
				<li><a href="#cta">Get Started</a></li>
			</ul>
		</nav>
		
		<header id="header" class="alt">
				<span class="logo"><img src="images/파프리카.png" alt="" /></span>
				<h1>Stellar</h1>
				<p>Just another free, fully responsive site template<br />
				built by <a href="https://twitter.com/ajlkn">@ajlkn</a> for <a href="https://html5up.net">HTML5 UP</a>.</p>
		</header>
					
		</div>
	<br>
</body>
</html>
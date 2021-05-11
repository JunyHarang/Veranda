<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<%
	/* position for grid system */	
	int offset = 2 ;
	int mywidth = twelve - 2 * offset ;
	int formleft = 3 ;
	int formright = twelve - formleft ;
	int rightButton = 2 ;
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 회원 가입 창 위치 설정 왼쪽 2, 오른쪽 2 여백 회원 가입창 8 -->
	<div class="container col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">

		<!-- 회원 가입 창 상단 색상 지정 -->
		<div class="panel-warning">
		
		<!-- 회원 가입 창 머리 만들기 -->
			<div class="panel-heading">
			
			<!-- 제목 만들기 두꺼운 글씨체 -->
				<h2>
					<strong>회원가입</strong>
				</h2>
			</div>
				
			<!-- 회원 가입창 몸통 만들기 -->
			<div class="panel-body">
			
				<!-- Form 설정 -->
				<form name="joinform" class="form-horizontal" action="" method="post">
					
					<!-- form grouping -->
					<div class="form-group">
					
					<!--  -->
					</div>
				</form>
			
			</div>
			<form action=""></form>
			
		</div>
	</div>
</body>
</html>
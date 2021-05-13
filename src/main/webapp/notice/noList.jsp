<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="./../common/common.jsp" %>

<%
	
	int offset = 2;
	int mywidth = twelve - 2 * offset ;
	int formleft = 3 ;
	int formright = twelve - formleft ;
	int rightButton = 2 ;		

%>
    
<!DOCTYPE html>
<html>
<head>
<script>

/* 필드 검색 상태 보존 */
$('#mode option').each(function(){
	if($(this).val() == '${pageInfo.mode}'){
		$(this).attr('selected', 'selected');
	}
});

$('#keyword').val('${pageInfo.keyword}');

function search(){
	/* alert('검색');  */	
	var mode = $('#mode').val() ;
	var keyword = $('#keyword').val() ;
	location.href='<%=FormNo%>noList' + '&mode=' + mode + '&keyword=' + keyword ;
}
function searchAll(){
	/* alert('전체 목록 보기'); */
	location.href='<%=FormNo%>noList';
}
function writeForm(){
	/* alert('글 작성'); */
	location.href='<%=FormNo%>noInsert';
}

$(document).ready(function(){
	
});



</script>
</head>

<body>

	<div class="container col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">
		<div class="panel panel-primary">
			<div class="panel-heading" >			
				<h4>공지사항 전체 보기</h4>
			</div>
			<div class="panel-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>글번호</th>												
							<th>글제목</th>							
							<th>작성 일자</th>							
						</tr>
					</thead>
					<%-- 테스트
						<tr>
							<td>1</td>
							<td>안녕하세요</td>
							<td>2021-05-12</td>
						</tr>
					--%>
					<tbody>
					<tr>
							<td align="center" colspan="11">
								<form action="" class="form-inline" role="form" name="myform" method="get"> 
									<div class="form-group">
										<select id="mode" name="mode" class="form-control">
											<option value="select" selected="selected">-선택하세요-
											<option value="subject" >제목
											<option value="all">제목+내용
										
										</select>
									</div>									
									<div class="form-group">
										<input type="text" class="form-control" name="keyword" id="keyword"> 
									</div>									
									&nbsp;&nbsp;
									<button class="btn btn-default" type="button" onclick="search();">검색</button>
									&nbsp;&nbsp;	
									<button class="btn btn-default" type="button" onclick="searchAll();">전체 목록</button>																
								${pageInfo.pagingStatus}	
								<%-- 테스트 위해 임시로 글쓰기 권한 열어둠 --%>
								<%-- 	<c:if test="${whologin == 2}">--%>
										&nbsp;&nbsp;
										<button class="btn btn-default" type="button" onclick="writeForm();">글쓰기</button>
								<%--	</c:if> --%>
									
									&nbsp;&nbsp;
																
								</form>
							</td>							
						</tr>
						
			<c:forEach var="bean" items="${requestScope.lists}">		
			<tr>
				<td>${bean.no}</td>
				<td>${bean.title}</td>
				<td>${bean.content}</td>
				<td>${bean.date}</td>					
				<td>${bean.user_no}</td>
				
				<td>
					<c:if test="${whologin == 2}">
							<a href="<%=FormNo%>prDelete&num=${bean.num}&${requestScope.parameters}">
								삭제
							</a>
						</c:if>
						<c:if test="${whologin != 2}">
							삭제
						</c:if>				
					</td>
					<td>
						<c:if test="${whologin == 2}">
							<a href="<%=FormNo%>prUpdate&num=${bean.num}&${requestScope.parameters}">
								수정
							</a>
						</c:if>
						<c:if test="${whologin != 2}">
							수정
						</c:if>										
				</td>
			</tr>
			</c:forEach>					
					</tbody>
					</table>					
					</div>
				<div align="center">
					<footer>${pageInfo.pagingHtml}</footer>
				</div>
					
					</div>
					
					</div>
					
					


</body>
</html>

<jsp:include page="/common/footer.jsp"></jsp:include>
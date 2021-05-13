<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="./../common/common.jsp" %>
<%
	/* position for grid system */	
	int offset = 2 ;
	int mywidth = twelve - 2 * offset ;
	int formleft = 3 ;
	int formright = twelve - formleft ;
	int rightButton = 2 ;
%> 
<!DOCTYPE html><html>
<head>
	<script>	
		function search(){
			var mode = $('#mode').val() ;
			var keyword = $('#keyword').val() ;
			location.href='<%=FormNo%>prList' + '&mode=' + mode + '&keyword=' + keyword ;
		}
		function searchAll(){
			location.href='<%=FormNo%>prList';
		}
		function writeForm(){
			location.href='<%=FormNo%>prInsert';
		}
		
		$(document).ready(function(){
			
		});
</script> 
</head>

<body>
	<div class="container col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4>상품 게시판</h4>
			</div>
			<div class="panel-body">
				<table class="table table-hover">
					<thead>
					<tr>
						<th>번호</th>
						<th>카테고리</th>
						<th>글 제목</th>
						<th>날짜</th>
						<th>조회수</th>
					</tr>
				</thead>
					<tbody>
						<tr>
							<td align="center" colspan="12">
								<form action="" class="form-inline" role="form" name="myform" method="get"> 
									<div class="form-group">
										<select id="mode" name="mode" class="form-control">
											<option value="all" selected="selected">-- 선택하세요.
										
											<option value="sellcomplete">판매완료
											<option value="selling">판매중
										</select>
									</div>									
									<div class="form-group">
										<input type="text" class="form-control" name="keyword" id="keyword"> 
									</div>									
									&nbsp;&nbsp;
									<button class="btn btn-default" type="button" onclick="search();">검색</button>
									&nbsp;&nbsp;
									
									&nbsp;&nbsp;
									${pageInfo.pagingStatus}																	
								</form>
							</td>
						</tr>
						
						
						<tr>
							<td>
								<form action="" align="right" >
									<button  class="btn btn-default" type="button" onclick="writeForm();">글쓰기</button>
									&nbsp;&nbsp;
									${pageInfo.pagingStatus}																	
								</form>
							</td>
						</tr>
				<c:forEach var="bean" items="${requestScope.lists}">
				<tr>
					<td>${bean.no}</td>
					<td>${bean.state}</td>
					<td>${bean.title}</td>
					<td>${bean.content}</td>
					<td>${bean.date}</td>
					<td>${bean.readhit}</td>
					
				
					<td>
						<a href="<%=FormNo%>prDetailView&num=${bean.num}&${requestScope.parameters}">
							${bean.title}
						</a>
					</td>
					<td>${bean.inputdate}</td>
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
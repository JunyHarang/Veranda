<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	qnaList 테스트입니당
	<div class="container col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4>Q&A 게시판</h4>
			</div>
			<div class="panel-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<td>
								<button>
									최신순
								</button>
							</td>
							<td>
								<button>
									댓글순
								</button>
							</td>
							<td>
								<button>
									조회순
								</button>
							</td>
						</tr>
					</thead>
					<thead>
						<tr>
							<th>글번호</th>
							<th>카테고리</th>
							<th>글 제목</th>
							<th>날짜</th>
							<th>조회수</th>						
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td>불만사항</td>
							<td>불만임</td>
							<td>2021-05-11</td>
							<td>2</td>
						</tr>
						<tr>
							<td>2</td>
							<td>불만사항</td>
							<td>불만임</td>
							<td>2021-05-11</td>
							<td>2</td>
						</tr>
						<tr>
							<td>3</td>
							<td>불만사항</td>
							<td>불만임</td>
							<td>2021-05-11</td>
							<td>2</td>
						</tr>
						<tr>
							<td>4</td>
							<td>불만사항</td>
							<td>불만임</td>
							<td>2021-05-11</td>
							<td>2</td>
						</tr>
						<tr>
							<td>5</td>
							<td>불만사항</td>
							<td>불만임</td>
							<td>2021-05-11</td>
							<td>2</td>
						</tr>
						<tr>
							<td>6</td>
							<td>불만사항</td>
							<td>불만임</td>
							<td>2021-05-11</td>
							<td>2</td>
						</tr>
						<tr>
							<td>7</td>
							<td>불만사항</td>
							<td>불만임</td>
							<td>2021-05-11</td>
							<td>2</td>
						</tr>
						<tr>
							<td>8</td>
							<td>불만사항</td>
							<td>불만임</td>
							<td>2021-05-11</td>
							<td>2</td>
						</tr>
						<tr>
							<td>9</td>
							<td>불만사항</td>
							<td>불만임</td>
							<td>2021-05-11</td>
							<td>2</td>
						</tr>
						<tr>
							<td>10</td>
							<td>불만사항</td>
							<td>불만임</td>
							<td>2021-05-11</td>
							<td>2</td>
						</tr>
						<tr>
							<td>11</td>
							<td>불만사항</td>
							<td>불만임</td>
							<td>2021-05-11</td>
							<td>2</td>
						</tr>
						<tr>
							<td align="center" colspan="4">
								<form action="" class="form-inline" role="form" name="myform" method="get"> 
									<div class="form-group">
										<select id="mode" name="mode" class="form-control">
											<option value="all" selected="selected">선택하세요.
											<option >제목
											<option >제목+내용
											<option >작성자
											<option >불편사항
											<option >이용문의
										</select>
									</div>
									&nbsp;&nbsp;
									<div class="form-group">
										<input type="text" class="form-control" name="keyword" id="keyword"> 
									</div>
									&nbsp;&nbsp;
									<button class="btn btn-default" type="button" onclick="search();">검색</button>
									&nbsp;&nbsp;
									${pageInfo.pagingStatus}
								</form>
							</td>
							<td>
								<button >등록</button>
							</td>
						</tr>	
					</tbody>
				</table>
				<div align="center">
					<footer>${pageInfo.pagingHtml}</footer>
				</div>
			</div>
		</div>
	</div>
	<br><br><br><br>
	<script type="text/javascript">
		/* 필드 검색 상태 보존 */
		$('#mode option').each(function(){
			if($(this).val() == '${pageInfo.mode}'){
				$(this).attr('selected', 'selected');
			}
		});
		
		$('#keyword').val('${pageInfo.keyword}');
	</script>
	<br>
</body>
</html>
<jsp:include page="/common/footer.jsp"></jsp:include>
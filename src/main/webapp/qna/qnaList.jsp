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
	<script>
		function search(){
			var mode = $('#mode').val() ;
			var keyword = $('#keyword').val() ;
			location.href='<%=FormNo%>qnaList' + '&mode=' + mode + '&keyword=' + keyword ;
		}
		function searchAll(){
			location.href='<%=FormNo%>qnaList';
		}
		function writeForm(){
			location.href='<%=FormNo%>prInsert';
		}
		
		$(document).ready(function(){
			
		});
		
		
		
		
		
		function checkForm() {
			/* 제목 길이 체크 */
			var title = document.insertform.title.value;
			if (title.length < 2) {
				alert('제목은 최소 2자리 이상이어야 합니다.');
				document.insertform.title.focus();
				return false;
			} else if (title.length > 20) {
				alert('제목은 최소 20자리 이하이어야 합니다.');
				document.insertform.title.focus();
				return false;
			}
			

			/* 내용 길이 체크 */
			var content = document.insertform.content.value;
			if (content.length < 5) {
				alert('내용은 최소 5자리 이상이어야 합니다.');
				document.insertform.content.focus();
				return false;
			} else if (content.length > 1333) {
				alert('내용은 최대 1333자리 이하이어야 합니다.');
				document.insertform.content.focus();
				return false;
			}

			/* 카테고리 선택 체크 */
			var category = document.insertform.category.value;
			if (category == "-") {
				alert('카테고리를 선택해주세요.');
				document.insertform.category.focus();
				return false;

			}
		}
	</script>
<style type="text/css">
	.checkout__input_2 input{
		height: 350px;
		width: 100%;
		border: 1px solid #e1e1e1;
		font-size: 14px;
		color: #666666;
		padding-left: 20px;
		margin-bottom: 20px;
	}
	.checkout__input_2 p span {
 		 color: #f08632;
	}
</style>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min2.css" type="text/css">
</head>
<body>
	<!-- 게시판 리스트 시작 -->
	<div class="container col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4>Q&A 게시판</h4>
			</div>
			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">글 번호</th>
						<th scope="col">카테고리</th>
						<th scope="col" colspan="2">글 제목</th>
						<th scope="col">날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="bean" items="${requestScope.lists}">	
						<tr class="table-active">
							<th scope="row">${bean.no}</th>
							<td>${bean.category}</td>
							<td colspan="2">${bean.title}</td>
							<td>${bean.date}</td>
						</tr>
					</c:forEach>
					<tr class="table-active">
						<th scope="row">Active</th>
						<td>Column content</td>
						<td colspan="2">Column content</td>
						<td>Column content</td>
					</tr>
					<tr>
						<th scope="row">Default</th>
						<td>Column content</td>
						<td colspan="2">Column content</td>
						<td>Column content</td>
					</tr>
					<tr class="table-primary">
						<th scope="row">Primary</th>
						<td>Column content</td>
						<td colspan="2">Column content</td>
						<td>Column content</td>
					</tr>
					<tr class="table-secondary">
						<th scope="row">Secondary</th>
						<td>Column content</td>
						<td colspan="2">Column content</td>
						<td>Column content</td>
					</tr>
					<tr class="table-success">
						<th scope="row">Success</th>
						<td>Column content</td>
						<td colspan="2">Column content</td>
						<td>Column content</td>
					</tr>
					<tr class="table-danger">
						<th scope="row">Danger</th>
						<td>Column content</td>
						<td colspan="2">Column content</td>
						<td>Column content</td>
					</tr>
					<tr class="table-warning">
						<th scope="row">Warning</th>
						<td>Column content</td>
						<td colspan="2">Column content</td>
						<td>Column content</td>
					</tr>
					<tr class="table-info">
						<th scope="row">Info</th>
						<td>Column content</td>
						<td colspan="2">Column content</td>
						<td>Column content</td>
					</tr>
					<tr class="table-light">
						<th scope="row">Light</th>
						<td>Column content</td>
						<td colspan="2">Column content</td>
						<td>Column content</td>
					</tr>
					<tr class="table-dark">
						<th scope="row">Dark</th>
						<td>Column content</td>
						<td colspan="2">Column content</td>
						<td>Column content</td>
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
							<button class="btn btn-default" type="button" onclick="writeForm();">
								글 등록
							</button>
						</td>
					</tr>
				</tbody>
			</table>
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
	<!-- 게시판 리스트 끝 -->





	<!-- 게시판 입력 폼 시작 -->

    <!-- Breadcrumb Begin -->
    <div class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="breadcrumb__text">
                        <h2>Q&A</h2>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="breadcrumb__links">
                        <a href="<%=FormNo%>main">Home</a>
                        <span>Q&A</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->

    <!-- Checkout Section Begin -->
    <section class="checkout spad">
        <div class="container">
            <div class="checkout__form">
                <form name="insertform" action="<%=FormYes%>" method="post">
                	<input type="hidden" name="command" value="qnaInsert">
                	<input type="hidden" name="writer" value="${sessionScope.loginfo.id}">
                    <div class="row">
                        <div class="col-lg-12 col-md-6">
                            <h6 class="coupon__code">
                            	<span class="icon_tag_alt">
                            	</span> Q&A 게시판 글 작성
                        	</h6>
                            <div class="row">
                                <div class="col-lg-8">
                                    <div class="checkout__input">
                                        <p>제목<span>*</span></p>
                                        <input type="text" name="title" id="title">
                                    </div>
                                </div>
                                <div class="col-lg-4">
									<div class="checkout__input">
                                        <p>카테고리<span>*</span></p>
                                        <div>
                                			<select id="category" name="category" class="form">
                                				<option value="-" selected="selected">선택하세요
                                				<option value="">불편사항
                                				<option value="">이용문의
                                			</select>
                                		</div>
                                    </div>
                                </div>
                            </div>
                            <div class="checkout__input_2">
                                <p>글 내용<span>*</span></p>
                                <input type="text" name="content" id="content">
                            </div>
                            <button type="submit" class="site-btn" onclick="return checkForm();">
                            	등록
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </section>
    <!-- Checkout Section End -->

	<!-- 게시판 입력 폼 끝 -->
</body>
</html>
<jsp:include page="/common/footer.jsp"></jsp:include>
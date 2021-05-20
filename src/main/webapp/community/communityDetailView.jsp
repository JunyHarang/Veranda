<%@page import="java.text.Normalizer.Form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="./../common/common.jsp"%>
<%
/* position for grid system */
int offset = 2;
int mywidth = twelve - 2 * offset;
int formleft = 3;
int formright = twelve - formleft;
int rightButton = 2;
%>

<html>
<head>

	<script type="text/javascript">
	
		function emotion(type) {
			
			const resultlike = document.getElementById('like');
			
			const resulthate = document.getElementById('hate');
			
			const no = document.getElementById('com_no').value;;
			
			// 현재 화면에 표시된 값
			
			let likeplus = resultlike.innerText;
			
			let hateplus = resulthate.innerText;
			
			// 더하기 / 빼기
			
			if ( type == 'like' ) {
				likeplus = ${bean.like} + 1;
				
				location.href='<%=FormNo%>coLike&no=' + no + '&like=' + likeplus;
				
			} else if (type == 'hate') {
				hateplus = ${bean.hate} + 1;
				
				location.href='<%=FormNo%>coHate&no=' + no + '&hate=' + hateplus;
			}
			
			
			
			//결과 출력
			resultlike.innerText = likeplus;
			
			resulthate.innerText = hateplus;
			
		}
		
		function checkForm() {

			/* 내용 길이 체크 */
			var content = document.insertform.content.value;
			if (content.length < 2) {
				alert('내용은 최소 2자리 이상이어야 합니다.');
				document.insertform.content.focus();
				return false;
			} else if (content.length > 300) {
				alert('내용은 최대 300자리 이하이어야 합니다.');
				document.insertform.content.focus();
				return false;
			}
		}
		
		$(document).ready(function() {
			
		});
	
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
	   .upImg{
	         height: 350px;
	         width: 350px;
	   }
	   
	   .box{
	   			paddint:40px;
	   			border:4px;
	   			solid #000;
	   }
	   
	   .box label {
				display: block;
				position: relative;
				height: 38px;
				border-bottom: 1px;
				solid #ccc;
		}
		
		.box input[type="text"] {
				padding: 0 10px;
				width: 200px;
				height: 38px;
				color: #444;
				font-size: 16px;
				border: 0;
		
		}
	</style>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min2.css" type="text/css">
</head>
<body>
   <div class="container col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">
      <div class="panel panel-primary">
         <div class="card mb-3">
            <table class="table table-hover">
               <tr>
                  <th scope="row">${bean.no}</th>
                  <td colspan="2">${bean.title}</td>
                  <td>${bean.date}</td>
                  <td>${bean.category}</td>
                  <td>${writer}</td>
                  <c:if test="${bean.user_no == sessionScope.loginfo.no}">
							<th><a href="<%=FormNo%>myPage">${writer}</a></th>
						</c:if>
						
						<c:if test="${bean.user_no != sessionScope.loginfo.no}">
							<th><a href="<%=FormNo%>neighborPage&writer=${writer}">${writer}</a></th>
						</c:if>
						
						<th>${bean.date}</th>
						
						<td>
                  
                  		<button type="button" id="like" name="like" class="btn btn-primary btn-like" onclick='emotion("like");'> ${bean.like}
                  			<i class="fa fa-thumbs-o-up"></i>
                  		</button>
                  </td>
                  
                  <td>
							<button type="button" id="hate" name="hate"  class="btn btn-danger btn-hate" onclick='emotion("hate");'> ${bean.hate}
								<i class="fa fa-thumbs-o-down"></i>
							 </button>
                  </td>
		               <c:forEach var="bean" items="${requestScope.lists}"> 
		           	   
		           	     <c:if test="${sessionScope.loginfo.no == bean.user_id}"> 	
		           	                  	     	
				              <td>
				                <a href="<%=FormNo%>coUpdate&no=${bean.no}&${requestScope.parameters}"> 수정 </a>
				              </td>
		                  
		                    <td>
		                       <a href="<%=FormNo%>coDelete&no=${bean.no}&${requestScope.parameters}"> 삭제 </a>
   		                    </td>
                  		</c:if> 	
                  			
              	   </c:forEach> 
               </tr>
            </table>
            <div class="card-body">
               <h5 class="card-title">${bean.content}</h5>
            </div>
            <div align="center">
            
               <img class="upImg" src="upload/${bean.image1}">
               <img class="upImg" src="upload/${bean.image2}">
               <br>
               <img class="upImg" src="upload/${bean.image3}">
               <img class="upImg" src="upload/${bean.image4}">
               <br>
               <img class="upImg" src="upload/${bean.image5}">
               <img class="upImg" src="upload/${bean.image6}">
               <br>
               <img class="upImg" src="upload/${bean.image7}">
               <img class="upImg" src="upload/${bean.image8}">
               <br>
               <img class="upImg" src="upload/${bean.image9}">
               <img class="upImg" src="upload/${bean.image10}">
            </div>
            	<br><br>
            	
            	<ul class="list-group list-group-flush">
					<li class="list-group-item">
						<c:if test="${whologin != 0}">
							<form name="insertform" action="<%=FormYes%>" method="post">
								<input type="hidden" name="no" value="${bean.no}">
								<input type="hidden" name="command" value="ccoInsert">
								<input type="hidden" name="writer" value="${sessionScope.loginfo.no}">
								작성자 : <input type="text" disabled="disabled" value="${sessionScope.loginfo.user_nickname}">
								<textarea name="content" rows="3" cols="110" style="resize: none;" placeholder="댓글을 입력하세요."></textarea>
								<button type="submit" onclick="return checkForm();">
									댓글 등록
								</button>
							</form>
						</c:if>
					</li>
            	
            		<c:forEach var="comment" items="${requestScope.commlists}">
	    				<li class="list-group-item">
	    					<c:if test="${comment.user_no == sessionScope.loginfo.no}">
								<th>작성자 : <a href="<%=FormNo%>myPage">${comment.writer}</a></th>
							</c:if>
							<c:if test="${comment.user_no != sessionScope.loginfo.no}">
								<th>작성자 : <a href="<%=FormNo%>neighborPage&writer=${comment.writer}">${comment.writer}</a></th>
							</c:if>
	    					- 등록일자 ${comment.date}
	    					<c:if test="${comment.user_no == sessionScope.loginfo.no}">
								<td>
									<a href="<%=FormNo%>ccoUpdate&com_no=${comment.com_no}&${requestScope.parameters}">
										수정
									</a>
								</td>
								<td>
									<a href="<%=FormNo%>ccoDelete&com_no=${comment.com_no}&no=${bean.no}">
										삭제
									</a>
								</td>
							</c:if> 
	    					<br> 
	    					내용 : ${comment.content}
	    				</li>
            		</c:forEach>
            		</ul>
	            		<input type="hidden" name="command" value="coDetailView">
	            		<input type="hidden" name="user_no" value="${sessionScope.loginfo.no}">
						<input type="hidden" id="com_no" name="com_no" value="${bean.no}">
         </div>
      </div>
   </div>
</body>
</html>

<jsp:include page="/common/footer.jsp"></jsp:include>
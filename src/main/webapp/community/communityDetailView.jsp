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
                  <td>
                  
                  			<a href="<%=FormNo%>coLike&no=${bean.no}&like=${bean.like}&${requestScope.parameters}"> like </a>
                  			
                  		<button type="button" id="like" name="like" class="btn btn-primary btn-like" onclick='emotion("like");'> like </button>
                  </td>
                  
                  <td>
                  			
                  				
                  				<a href="<%=FormNo%>coHate&no=${bean.no}&hate=${bean.like}&${requestScope.parameters}"> like </a>
							<button type="button" id="hate" name="hate"  class="btn btn-danger btn-hate" onclick='emotion("hate");'> hate </button>
                  </td>
		                  
				                  <td>
				                     <a href="<%=FormNo%>coUpdate&no=${bean.no}&${requestScope.parameters}"> 수정 </a>
		
				                  </td>
		                  
		                  <td>
		                     <a href="<%=FormNo%>coDelete&no=${bean.no}&${requestScope.parameters}"> 삭제 </a>
		                     
		                  </td>
                  	
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
            		<div align="center" class="commentBox">
               		<textarea id="cmt" name="cmt" placeholder="소중한 댓글을 남겨 주세요!"></textarea>>
               	</div>
               		
               	<div class="commnet-button">
               			<button id="cmt-btn">댓글등록</button>
            		</div>
            		
	            		<input type="hidden" name="command" value="coDetailView">
	            		<input type="hidden" name="user_no" value="${sessionScope.loginfo.no}">
						<input type="hidden" id="com_no" name="com_no" value="${bean.no}">
         </div>
      </div>
   </div>
</body>
</html>

<jsp:include page="/common/footer.jsp"></jsp:include>
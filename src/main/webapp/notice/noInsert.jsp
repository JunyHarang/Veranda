<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %>
<%
	/* position for grid system */	
	int offset = 2 ;
	int mywidth = twelve - 2 * offset ;
	int formleft = 3 ;
	int formright = twelve - formleft ;
%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script>
		$(document).ready(function(){
		});
		
	</script>
</head>
<body>
<div class="container col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4>공지사항 등록</h4>
			</div>
			<div class="panel-body">
				<form class="form-horizontal" action="<%=FormYes%>" method="post">
					<input type="hidden" name="command" value="noInsert">									    
					<div class="form-group">
				      	<label class="control-label col-sm-<%=formleft%>" for="writer">작성자</label>
				      	<div class="col-sm-<%=formright%>">
				        	<input type="text" class="form-control" disabled="disabled" 
				        		id="fakewriter" name="fakewriter" value="작성자"
				        		<%-- value="${sessionScope.loginfo.name}(${sessionScope.loginfo.id})" --%> >				        		
				        	<input type="hidden" name="writer" <%-- value="${sessionScope.loginfo.id}" --%>>
				      	</div>
				    </div>
					<div class="form-group">
				      	<label class="control-label col-sm-<%=formleft%>" for="title">글 제목</label>
				      	<div class="col-sm-<%=formright%>">
				        	<input type="text" class="form-control" id="title" 
				        		name="title" value="${bean.title}">
				        	<span class="err">${errtitle}</span>
				      	</div>
				    </div>
					<div class="form-group">
				      	<label class="control-label col-sm-<%=formleft%>" for="content">글 내용</label>
				      	<div class="col-sm-<%=formright%>">
				        	<input type="text" class="form-control" id="content" 
				        		name="content" value="${bean.content}">
				        	<span class="err">${errcontent}</span>
				      	</div>
				    </div>					
				    <div class="form-group">        
				      	<div class="col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">
				        	<button type="submit" class="btn btn-default" onclick="searchAll();" >공지사항 등록</button>
				        	&nbsp;&nbsp;&nbsp;
				        		        	
				      	</div>
				    </div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
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
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>베란다에서 온 파프리카에 가입하기</title>
	<script type="text/javascript">
		
		function idCheck() { /* 아이디 유효성 검사 */
			var id = document.joinform.id.value;
				
			if (id.length < 5 || id.length > 15) { /* 아이디 길이 확인 */
				alert('아이디는 5글자 이상 15글자 이하로 입력 해 주세요!');
				document.joinform.id.focus();
				return false;
			} // 아이디 길이 확인 if문 끝
			
			if (!id.value) { /* 아이디 공란 여부 체크 */
				alert('아이디를 입력 해 주세요!');
				document.joinform.id.focus();
				return false;
			} // 아이디 공란 여부 체크 if문 끝
			
			if (id.isCheck.value != "idCheck") { /* 중복 체크 확인 */
				alert('중복 체크를 눌러 주세요!');
				document.joinform.id.focus();
				return false;
			} // 중복 체크 if문 끝
			
			var url = '<%=FormNo%>meIdcheck&id='+id;
			window.open(url,'mywin','height=150,width=300');
			
		} // 아이디 유효성 검사 끝
		
		function pwdCheck() { /* 패스워드 유효성 검사 */
			
			var id = document.joinform.id.value;
			
			var pwd = document.joinform.pwd.value;
			
			var checkpwd = document.joinform.checkpwd.value;
			
			function CheckPassword(id, pwd){ /* 영(대,소)문자 + 숫자 조합 시 길이 검사 */
			    if(!/^[a-zA-Z0-9]{10,20}$/.test(pwd)){
			        alert("비밀번호는 숫자와 영문자 조합으로 10~20자리를 사용해야 합니다.");
			        return false;
			    } // if문 끝
			    
			    var chk_num = pwd.search(/[0-9]/g);		// 숫자 비교 시 사용될 변수
			   
			    var chk_eng = pwd.search(/[a-z]/ig);	// 영어(소문자) 비교 시 사용될 변수
			    
			    if(chk_num < 0 || chk_eng < 0){ /* 영소문자 + 숫자 조합 여부 검사 */
			        alert("비밀번호는 숫자와 영문자를 혼용하여야 합니다.");
			        return false;
			    } // if문 끝
			    
			    if(/(\w)\1\1\1/.test(pwd)){
			        alert("비밀번호에 같은 문자를 4번 이상 사용하실 수 없습니다.");
			        return false;
			    }
			    if(pwd.search(id) > -1){
			        alert("ID가 포함된 비밀번호는 사용하실 수 없습니다.");
			        return false;
			    }
			    return true;
			}
			
			
			if (pwd.length < 10 || pwd.length > 20) { /* 패스워드 길이 검사 */
				
				window.alert('비밀번호는 최소 10자리 20자리 이하여야 합니다!');
	
				document.getElementById('pwd').value=document.getElementById('Checkpwd').value='';
				
				document.getElementById('same').innerHTML='';
				
				return false;
			} // 패스워드 길이 유효성 검사 if문 끝
			
			if (document.getElementById('pwd').value!='' && document.getElementById('checkpwd').value != '') { /* 패스워드 빈란 여부 검사 */
				
				if (document.getElementById('pwd').value==document.getElementById('checkpwd').value) { /* 패스워드가 같은지 검사 */
				
				document.getElementById('same').innerHTML='Check it!';
				
				document.getElementById('same').style.color='blue';
				
				} else {
					document.getElementById('same').innerHTML='Retry please!';
					
					document.getElementById('same').style.color='red';
					
					return false;
				} // if-else문 끝
				
			} // 패스워드 공백 검사 if문 끝
			
		} // 패스워드 유효성 검사 끝
	
	</script>
</head>
<body>

<!-- CSS Form 받아오기 -->
<link rel="stylesheet" href="css/joinForm.css">

<div class="container">
<br>
<hr>

<div class="card bg-light">
<article class="card-body mx-auto" style="max-width: 400px;">
	<h4 class="card-title mt-3 text-center">회원 가입</h4>
	<p class="text-center">베란다에서 온 파프리카에 오신 것을 환영 합니다!</p>
	
	<p>
		<a href="" class="btn btn-block btn-naver"> <i class="fab fa-naver"></i>   네이버 인증하기</a>
		<a href="" class="btn btn-block btn-facebook"> <i class="fab fa-facebook-f"></i>   페이스북 인증하기</a>
		<a href="" class="btn btn-block btn-google"> <i class="fab fa-google"></i>   구글 인증하기</a>
	</p>
	
	<p class="divider-text">
        <span class="bg-light">OR</span>
    </p>
    
	<form name="joinform">
	
	<%-- 아이디 입력란 --%>
	<div class="form-group input-group">
	
		<div class="input-group-prepend">
		
		    <span class="input-group-text"> 
		    	<i class="fa fa-user"></i> 
		    </span>
		 
		 </div>
        
        <input name="id" class="form-control" placeholder="아이디를 입력 해 주세요!" type="text">
        
        <input type="hidden" name="command" value="meInsert">
        <input type="hidden" name="isCheck" value="false">
        
    	<input type="button" name="${bean.id}" value="중복 확인" class="btn btn-idcheck" onclick="idCheck();">
    
    </div> 
    
    <%-- 비밀번호 입력란 --%>
    <div class="form-group input-group">
	
		<div class="input-group-prepend">
		
		    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
		 
		 </div>
        
        <input id="pwd" name="pwd" class="form-control" placeholder="비밀번호를 입력 해 주세요!" type="password" onchange="pwdCheck();">
        <br><br>
        <input id="checkpwd" name="checkpwd" class="form-control" placeholder="비밀번호를 한번 더 입력 해 주세요!" type="password" onchange="pwdCheck();">
        &nbsp;&nbsp;
        <span id="same"></span>
    
    </div> 
    
    <%-- 비밀번호 입력란 --%>
    <div class="form-group input-group">
    
    	<div class="input-group-prepend">
	
		    <span class="input-group-text"> 
		    	<i class="fa fa-envelope"></i> 
		    </span>
		 </div>
        
        <input name="" class="form-control" placeholder="Email address" type="email">
    </div> 
    
    <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-phone"></i> </span>
		</div>
		<select class="custom-select" style="max-width: 120px;">
		    <option selected="">+971</option>
		    <option value="1">+972</option>
		    <option value="2">+198</option>
		    <option value="3">+701</option>
		</select>
    	<input name="" class="form-control" placeholder="Phone number" type="text">
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-building"></i> </span>
		</div>
		<select class="form-control">
			<option selected=""> Select job type</option>
			<option>Designer</option>
			<option>Manager</option>
			<option>Accaunting</option>
		</select>
	</div> <!-- form-group end.// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
		</div>
        <input class="form-control" placeholder="Create password" type="password">
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
		</div>
        <input class="form-control" placeholder="Repeat password" type="password">
    </div> <!-- form-group// -->                                      
    <div class="form-group">
        <button type="submit" class="btn btn-primary btn-block"> Create Account  </button>
    </div> <!-- form-group// -->      
    <p class="text-center">Have an account? <a href="">Log In</a> </p>                                                                 
</form>
</article>
</div> <!-- card.// -->

</div> 
<!--container end.//-->

<br><br>
<article class="bg-secondary mb-3">  
<div class="card-body text-center">
    <h3 class="text-white mt-3">Bootstrap 4 UI KIT</h3>
<p class="h5 text-white">Components and templates  <br> for Ecommerce, marketplace, booking websites 
and product landing pages</p>   <br>
<p><a class="btn btn-warning" target="_blank" href="http://bootstrap-ecommerce.com/"> Bootstrap-ecommerce.com  
 <i class="fa fa-window-restore "></i></a></p>
</div>
<br><br>
</article>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
		<!DOCTYPE html>    
		<html>             
		<head>             
		<meta charset='UTF-8'>
		<title>회원관리</title>
		</head>             
		<jsp:include page="/WEB-INF/views/menu.jsp"/>     
		<body>             
		<h1> 로그인 </h1>
		<form action='${pageContext.request.contextPath}/member/login.do' method='post'>         
		아이디:<input type='text' name='memId' value='' placeholder="아이디를 입력해주세요" autofocus/><br>        
		비밀번호:<input type='password' name='memPass' value=''placeholder="비밀번호를 입력해주세요" autofocus/><br>
		<input type='submit' value="로그인"/>                                       
		</form>                                                                                   
		</body>    
		</html>    
		     
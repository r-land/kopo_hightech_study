<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
		<!DOCTYPE html>    
		<html>             
		<head>             
		<meta charset='UTF-8'>
		<jsp:include page="/WEB-INF/views/menu.jsp"/>     		
		<title>회원관리</title>
		</head>             
		<body>             
		<h1> 회원정보변경 </h1>
		<form action='${pageContext.request.contextPath}/member/edit.do' method='post'>  
		아이디 :<input type='text' name='memId' value='<c:out value="${mvo.memId}"/>' readonly/><br> 
		<%-- 아이디: <c:out value="${mvo.memId}"/><br>       
		<input type='hidden' name='memId' value='<c:out value="${mvo.memId}"/>' readonly="readonly"/><br>       --%>  
	<!-- 	비밀번호:<input type='password' name='memPass' value=''/><br> -->
		이름:<input type='text' name='memName' value='<c:out value="${mvo.memName}"/>'/><br>        
		포인트:<input type='number' name='memPoint' value='${mvo.memPoint}'/><br>  
		<input type='submit'/>                                       
		<input type='hidden' name='command' value='addMember'/>      
		</form>                                                      
                               
		</body>    
		</html>    
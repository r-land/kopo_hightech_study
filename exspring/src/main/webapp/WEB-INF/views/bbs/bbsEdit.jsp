<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

    
		<!DOCTYPE html>    
		<html>             
		<head>             
		<meta charset='UTF-8'>
		<jsp:include page="/WEB-INF/views/menu.jsp"/>     		
		<title>게시판</title>
		</head>             
		<body>             
		<h1> 게시글정보변경 </h1>
		<form action='${pageContext.request.contextPath}/bbs/edit.do' method='post'>  
		<input type="hidden" name='bbsNo' value="${bbsVo.bbsNo}"/><br> 
		제목:<input type='text' name='bbsTitle' value='<c:out value="${bbsVo.bbsTitle}"/>'/><br>        
		내용:<textarea name='bbsContent' cols="22" rows="5"><c:out value="${bbsVo.bbsContent}"/></textarea><br>        
		작성자:<c:out value="${bbsVo.bbsWriter}"/><br>        
		등록일:<fmt:formatDate value="${bbsVo.bbsRegDate}" pattern="yyyy-MM-dd HH:mm:ss"/><br>  
		<input type='submit' value="저장"/>                                       
	
		<a href='${pageContext.request.contextPath}/bbs/del.do?bbsNo=${bbsVo.bbsNo}'>
		<button type='button'>삭제</button></a>
		</form>    
		                                                  
                               
		</body>    
		</html>    
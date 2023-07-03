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
		<input type="hidden" name='bbsNo' value="${bbsMvo.bbsNo}"/><br> 
		제목:<input type='text' name='bbsTitle' value='<c:out value="${bbsMvo.bbsTitle}"/>'/><br>        
		내용:<textarea name='bbsContent' cols="22" rows="5"><c:out value="${bbsMvo.bbsContent}"/></textarea><br>        
		작성자:<c:out value="${bbsMvo.bbsWriter}"/><br>        
		등록일:<fmt:formatDate value="${bbsMvo.bbsRegDate}" pattern="yyyy-MM-dd HH:mm:ss"/><br>  
		
		<c:forEach var="vo" items="${bbsMvo.attachList}">
			첨부파일: <a href="${pageContext.request.contextPath}/bbs/down.do?attNo=${vo.attNo}"><c:out value= "${vo.attOrgName}"/></a><br>
		</c:forEach>
		<input type='submit' value="저장"/>                                       
	
		<a href='${pageContext.request.contextPath}/bbs/del.do?bbsNo=${bbsVo.bbsNo}'>
		<button type='button'>삭제</button></a>
		</form>    
		                                                  
                               
		</body>    
		</html>    
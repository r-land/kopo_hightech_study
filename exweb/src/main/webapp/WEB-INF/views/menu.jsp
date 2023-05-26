<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!-- 로그인이 된 경우 -->
<c:if test="${loginUser!=null}">
접속계정 :<c:out value="${loginUser.memName}"/>
<a href='<c:url value="/member/logout.do"/>' style="text-decoration:none">로그아웃[out] </a><br></c:if>

<!-- 로그인이 되지 않은 경우 -->
<c:if test="${loginUser==null}">
<a href='${pageContext.request.contextPath}/member/login.do' style="text-decoration:none">로그인[in] </a>
<a href='${pageContext.request.contextPath}/member/add.do' style="text-decoration:none">회원추가[o] </a></c:if>
	
<hr>
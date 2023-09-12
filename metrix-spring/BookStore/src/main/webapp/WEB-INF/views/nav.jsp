<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <div class="container">
		<c:if test="${sessionScope.member == null}">
			<div class="my-2">
				<a href="/login" class="btn btn-sm btn-secondary">로그인<i class="bi bi-box-arrow-in-right"></i></a>
				<a href="/signup" class="btn btn-sm btn-secondary">회원가입</a>
				<a href="/cart" class="btn btn-sm btn-secondary">장바구니</a>
			</div>
		</c:if>
		
		<c:if test="${sessionScope.member != null}">
			<div class="my-2">
				<a href="/logout" class="btn btn-sm btn-secondary">로그아웃<i class="bi bi-box-arrow-in-left"></i></a>
				<a href="/cart" class="btn btn-sm btn-secondary">장바구니</a>
			</div>
		</c:if>
		</div>
</body>
</html>
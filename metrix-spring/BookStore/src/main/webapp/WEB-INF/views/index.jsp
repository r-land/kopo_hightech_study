<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="header.jsp"></jsp:include>
<script>
	const msg = "${msg}";
	if(msg) 
		alert(msg);
</script>
</head>
<body>
	<div class="container">
		<div>
			<h1>폴리북스</h1>
		</div>
		<c:if test="${sessionScope.member == null}">
			<div>
				<a href="login">로그인<i class="bi bi-box-arrow-in-right"></i></a>
				<a href="signup">회원가입</a>
			</div>
		</c:if>
		
		<c:if test="${sessionScope.member != null}">
			<div>
				${sessionScope.member.name} 님 환영합니다!
			</div>
			<div>
				<a href="logout">로그아웃<i class="bi bi-box-arrow-in-left"></i></a>
			</div>
		</c:if>
		<div>
			<ul>
				<li><a href="book/list">도서관리</a></li>
				<li><a href="customer/list">고객관리</a></li>
				<li><a href="orders/list">주문관리</a></li>
			</ul>
		</div>
	</div>
</body>
</html>
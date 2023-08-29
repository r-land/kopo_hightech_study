<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<div>
		<div>
			<h1>폴리북스</h1>
		</div>
		<div>
			<a href="signup">회원가입</a>
		</div>
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
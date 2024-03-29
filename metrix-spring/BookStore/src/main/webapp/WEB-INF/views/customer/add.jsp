<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../header.jsp"></jsp:include>
<script src="/resources/js/password_check_jquery.js"></script>
</head>
<body>
	<div class="container">
		<div>
			<h3>고객등록</h3>
		</div>
		<form method="post">
		<div>
			<div class="form-group">
				<label>아이디:</label>
				<input type="text" name="custid">
			</div>
			<div>
				<label>비밀번호:</label>
				<input type="password" name="passwd">
				<button type="button" class="password_check" data-for="passwd">확인</button>
			</div>
			<div>
				<label>고객명:</label>
				<input type="text" name="name">
			</div>
			<div>
				<label>주소:</label>
				<input type="text" name="address">
			</div>
			
			<div>
				<label>전화번호:</label>
				<input type="text" name="phone">
			</div>
			
			<div>
				<button>등록</button>
				<a href="list"><button type ="button">목록</button></a>
			</div>
		</div>
		</form>
	</div>
</body>
</html>
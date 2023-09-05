<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="header.jsp"></jsp:include>
<script src="/resources/js/password_check.js"></script>
<script src="/resources/js/check_id.js"></script>
<script src="/resources/js/validate_form.js"></script>
</head>
<body>
	<div class="container">
		<div>
			<h3>회원가입</h3>
		</div>
		<form method="post" name="signup_form">
		<div>
			<div class="form-group">
				<label>아이디:</label>
				<input type="text" name="custid">
				<button type="button" id="check_id">[비동기]중복확인</button>
				<button type="button" id="check_id_sync">[동기]중복확인</button>
			</div>
			<div>
				<label>비밀번호:</label>
				<input type="password" name="passwd">
				<button type="button" class="password_check" data-msg="Hello1" data-for="passwd">확인</button>
			</div>
			<div>
				<label>비밀번호 확인:</label>
				<input type="password" name="passwd_confirm">
				<button type="button" class="password_check" data-msg="Hello2" data-for="passwd_confirm">확인</button>
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
				<button type="button" id="signup" >등록</button>
				<a href="/"><button type ="button">처음으로</button></a>
			</div>
		</div>
		</form>
	</div>
	<script>
		new ValidateForm(
		{ 
			selector:"#signup",
			tags:[
				  {tag: "custid", msg: "아이디는 필수 입니다"},
			      {tag: "custid", msg: "아이디 중복검사를 해 주세요.", condition: "checkId"},
			      {tag: "passwd", msg: "비밀번호를 입력해 주세요"},
			      {tag: "passwd_confirm", msg: "비밀번호를 확인해 주세요"},
			      {tag: "passwd_confirm", msg: "비밀번호가 일치하지 않습니다.확인해 주세요", eq: "passwd"},
			      {tag: "name", msg: "이름을 입력해 주세요"}
			]
		});
	</script>
</body>
</html>
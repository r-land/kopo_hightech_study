<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../header.jsp"></jsp:include>
</head>
<body>
		<div class="container">
		<div>
			<h1>폴리북스</h1>
		</div>
		<nav>
			<jsp:include page="../nav.jsp"></jsp:include>
		</nav>
		<div>
			<h3>도서정보변경</h3>
		</div>
		<form method="post">
		<div>
			<div>
				<label>도서번호:</label>
				<input type="number" name="bookid" value="${item.bookid}" readonly>
			</div> 
			
			<div>
				<label>도서명:</label>
				<input type="text" name="bookname" value="${item.bookname}">
			</div>
			
			<div>
				<label>출판사:</label>
				<input type="text" name="publisher" value="${item.publisher}">
			</div>
			
			<div>
				<label>가격:</label>
				<input type="number" name="price" value="${item.price}">
			</div>
			
			<div>
				<button>등록</button>
				<a href="../list"><button type ="button">목록</button></a>
			</div>
		</div>
		</form>
	</div>
</body>
</html>

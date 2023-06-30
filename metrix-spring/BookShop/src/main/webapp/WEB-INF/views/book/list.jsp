<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>마당서점</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<body>
	<div class="container">
		<div>
			<h3>도서 목록</h3>
		</div>
		<div>
			<table border="1" class="table table-striped table-hover">
				<thead class="table-dark">
					<tr>
						<th>도서번호</th>
						<th>도서명</th>
						<th>출판사</th>
						<th>가격</th>
						<th>관리</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${list}">
					<tr>
						<td>${item.bookid}</td>
						<td>${item.bookname}</td>
						<td>${item.publisher}</td>
						<td>${item.price}</td>
						<td><a href="delete/${item.bookid}" class="btn btn-danger btn-sm"><i class="bi bi-trash"></i></a> <a href="update/${item.bookid}" class="btn btn-warning btn-sm"><i class="bi bi-cart-plus"></i></a></td>
					</tr>
					</c:forEach>
					
					<c:if test="${list.size() < 1}">
						<tr>
							<td colspan = "5"> 검색 된 도서가 없습니다. </td>
						</tr>
					</c:if>
				</tbody>	
			</table>
		</div>
		<div class="mb-5">
			<a href="add" class="btn btn-primary btn-sm">등록</a>
			<a href="dummy" class="btn btn-warning btn-sm">대량등록</a>
			<a href="init" class="btn btn-danger btn-sm">초기화</a>
		</div>
	</div>
</body>
</html>

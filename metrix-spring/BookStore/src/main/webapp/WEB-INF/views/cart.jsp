<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="header.jsp"></jsp:include>
<script src="/resources/js/cart.js"></script>
</head>
<body>
<div class="container">
		<div>
			<h1>장바구니</h1>
		</div>
		<nav>
			<jsp:include page="nav.jsp"></jsp:include>
		</nav>
		<div>
			<table border="1" class="table table-sm table-striped">
				<thead class="table-dark">
					<tr>
						<td>도서관리</td>
						<td>수량</td>
						<td>관리</td>
					</tr>
				</thead>
				
				<tbody>
					<c:if test="${sessionScope.cart == null || sessionScope.cart.size() < 1}">
					<tr>
						<td colspan="3">등록 된 도서가 없습니다</td>
					</tr>
					</c:if>
					<c:forEach var="item" items="${sessionScope.cart}">
					<tr data-bookid="${item.key}">
						<td>${item.key}</td>
						<td><input type="number" value="${item.value}"></td>
						<td>
						  <button class="btn btn-primary me-sm-1 cart_update" >변경</button>
						  <button class="btn me-sm-1" style="background-color: pink;" >삭제</button>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		<div>
			<a href="/orders/order" class="btn btn-sm btn-primary">주문</a>
			<a href="/" class="btn btn-sm btn-secondary">처음으로</a>
		</div>
		</div>
		
</body>
</html>
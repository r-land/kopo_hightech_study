<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../header.jsp"></jsp:include>
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<div>
			<h3>주문 상세내역</h3>
		</div>
		
		<nav>
			<jsp:include page="../nav.jsp"></jsp:include>
		</nav>
		
		<div>
			<div>
				<label>주문번호:</label>${item.orderid}
			</div>
			<div>
				<label>고객번호:</label>${item.custid}
			</div>
			<div>
				<label>주문금액:</label>${item.saleprice}
			</div>
			<div>
				<label>주문일자:</label><fmt:formatDate value="${item.orderdate}" pattern="yyyy년 MM월 dd일"/>
			</div>
			<div>
				<table class="table table-sm table-striped">
				<thead class="table-dark">
					<tr>
						<th>상세번호</th>
						<th>도서번호</th>
						<th>도서이름</th>
						<th>출판사</th>
						<th>주문수량</th>
					</tr>
				</thead>
				
				<tbody>
					<c:if test="${list.size() < 1}">
						<tr>
							<td colspan="5">상세내역이 없습니다.</td>
						</tr>
					</c:if>
					
					<c:forEach var="detail" items="${item.details}">
						<tr>
							<td>${detail.code}</td>
							<td>${detail.bookid}</td>
							<td>${detail.bookname}</td>
							<td>${detail.publisher}</td>
							<td>${detail.amount}</td>
						</tr>	
					</c:forEach>				
				</tbody>
				
				</table>
			</div>
		<div>
			<a href="../list" class="btn btn-primary btn-sm">목록</a>
		</div>
		</div>
	</div>
</body>
</html>
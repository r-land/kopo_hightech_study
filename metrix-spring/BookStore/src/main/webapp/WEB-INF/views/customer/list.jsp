<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
<jsp:include page="../header.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<div>
			<h3>고객 목록</h3>
		</div>
		<div>
			<form>
				<div class="row mb-2">
					<div class="col-3"></div>
					<div class="col">
						<select name="search" class="form-select form-select-sm">
							<option value="0">검색항목을 선택하세요</option>
							<option value="1" ${pager.search == 1 ? "selected" : "" }>아이디</option>
							<option value="2" ${pager.search == 2 ? "selected" : "" }>고객명</option>
							<option value="3" ${pager.search == 3 ? "selected" : "" }>주소</option>						
							<option value="4" ${pager.search == 4 ? "selected" : "" }>전화번호</option>						
						</select>
					</div>
					<div class="col-5">
						<input type="text" name="keyword" class="form-control form-control-sm" value="${pager.keyword}">
					</div>
					<div class="col d-grid">
						<button class="btn btn-sm btn-primary">검색</button>
					</div>
				</div>
			</form>
		</div>
		<div>
			<table border="1" class="table table-striped table-hover">
				<thead class="table-dark">
					<tr>
						<th>아이디</th>
						<th>비밀번호</th>
						<th>고객명</th>
						<th>주소</th>
						<th>전화번호</th>
						<th>관리</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${list}">
					<tr>
						<td>${item.custid}</td>
						<td>${item.passwd}</td>
						<td>${item.name}</td>
						<td>${item.address}</td>
						<td>${item.phone}</td>
						<td><a href="delete/${item.custid}" class="btn btn-danger btn-sm"><i class="bi bi-trash"></i></a> <a href="update/${item.custid}" class="btn btn-warning btn-sm"><i class="bi bi-gear"></i></a></td>
					</tr>
					</c:forEach>
					
					<c:if test="${list.size() < 1}">
						<tr>
							<td colspan = "5"> 검색 된 고객정보가 없습니다. </td>
						</tr>
					</c:if>
				</tbody>
				
				<tfoot>
					<tr>
						<td colspan="5">
						  <ul class="pagination justify-content-center mt-3">
							    <li class="page-item"><a class="page-link" href="?page=1${pager.query}">처음</a></li>
							    <li class="page-item"><a class="page-link" href="?page=${pager.prev}${pager.query}">이전</a></li>
							    <c:forEach var="page" items="${pager.list}">
							    	<li class="page-item"><a class="page-link ${page == pager.page ? 'active' : ''}" href="?page=${page}${pager.query} ">${page}</a></li>
							    </c:forEach>
								<li class="page-item"><a class="page-link" href="?page=${pager.next}&${pager.query}">다음</a></li>
							    <li class="page-item"><a class="page-link" href="?page=${pager.last}&${pager.query}">마지막</a></li>
						 </ul>
					
						</td>
					</tr>
				</tfoot>	
			</table>
		</div>
		<div class="mb-5">
			<a href="add" class="btn btn-primary btn-sm">등록</a>
			<a href=".." class="btn btn-secondary btn-sm">홈</a>
		</div>
	</div>
</body>
</html>

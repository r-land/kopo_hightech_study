<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!-- <!DOCTYPE html>     
<html>              
<head>              
<meta charset='UTF-8'> 
<title>회원관리</title>
</head>            
<body> -->
<%-- <jsp:include page="/WEB-INF/views/menu.jsp"/>    --%>  
<h1>회원목록 </h1>
<div class="mb-3">
<a href='<c:url value="/member/add.do"/>' style="text-decoration:none" class="btn btn-outline-success btn-sm">회원추가[o] </a>
<a href='<%=request.getContextPath()%>/member/delform.do' style="text-decoration:none" class="btn btn-outline-danger btn-sm">회원삭제[x] </a>
</div>
<table border="1" class="table table-striped table-hover">
<thead class="table-dark">
		<tr><th>아이디</th><th>이름</th><th>포인트</th><th>관리</th></tr>
	</thead>
	<tbody>
<c:forEach var="vo" items='${memberList}'>
<tr>
	<p>
	<td><a href='${pageContext.request.contextPath}/member/edit.do?memId=<c:out value="${vo.memId}"/>' style="text-decoration:none"><c:out value="${vo.memId}"/></a></td>
	<td><c:out value="${vo.memName}"/></td>
	<td><c:out value="${vo.memPoint}"/></td>
	<td>
	<a href='${pageContext.request.contextPath}/member/del.do?memId=<c:out value="${vo.memId}"/>'><i class="bi bi-trash"></i></a>	
<!-- 	JSTL 태그의 scope와 var 속성을 사용하면 
	JSTL 태그 실행 결과를 현재 위치에 출력하지 않고,
	지정한 scope에 지정한 이름(var)의 속성을 저장한 후,
	EL에서 읽어서 사용 가능 -->
<%-- 	<c:url value="/member/del.do" var="delUrl">
	 <c:param name="memId">${vo.memId}</c:param>
	</c:url>
	<a href='${delUrl}'>
	<button type='button'>삭제</button></a> --%>
	</p>
	</tr>
</c:forEach>
</tbody>
</table>
<!-- </body>           
</html>   -->         

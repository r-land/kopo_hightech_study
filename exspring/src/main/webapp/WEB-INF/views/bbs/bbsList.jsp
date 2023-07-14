<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 


<!-- <!DOCTYPE html>     
<html>              
<head>              
<meta charset='UTF-8'> 
<title>게시판</title>
</head>            
<body> -->
<%-- <jsp:include page="/WEB-INF/views/menu.jsp"/>   --%>   
<h1>게시글목록 </h1>
<div style=" text-align: left;">
	
	<form action="${pageContext.request.contextPath}/bbs/list.do">
		<select name="searchType">
			<%-- <option value="title" ${searchInfo.searchType=='title'?'selected':''}>제목</option>
			<option value="content" ${searchInfo.searchType=='content'?'selected':''}>내용</option>
			<option value="total" ${searchInfo.searchType=='total'?'selected':''}>제목+내용</option> --%>
			<option value="title">제목</option>
			<option value="content" >내용</option>
			<option value="total" >제목+내용</option>
		</select>
		<script type="text/javascript">
		//	document.querySelector('[name="searchType"]').value = "${searchInfo.searchType}";
			$('[name="searchType"]').val('${searchInfo.searchType}');
		</script>
		<input type="text" name="searchWord" value="${searchInfo.searchWord}"/>
		<input type="submit" value="검색" />	
	</form>
	<div><a href="${pageContext.request.contextPath}/bbs/add.do" style="text-decoration:none"> 
	<button type='button'>글쓰기</button></a></div>
</div>
<table>
	<thead>
		<tr><th>번호</th><th>제목</th><th>작성자</th><th>등록일시</th></tr>
	</thead>
	<tbody>
		<c:forEach var="vo" items='${bbsList}'>
			<tr>
			<td>${vo.bbsNo}</td>
			<td>
				<a href="${pageContext.request.contextPath}/bbs/edit.do?bbsNo=${vo.bbsNo}" style="text-decoration:none">
				<c:out value="${vo.bbsTitle}"/>
				</a>
			</td>
			<td><c:out value="${vo.bbsWriter}"/></td>
			<td><fmt:formatDate value="${vo.bbsRegDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			<c:if test="{loginUser.memId == vo.bbsWriter}">
			<td><a href="${pageContext.request.contextPath}/bbs/edit.do?bbsNo=${vo.bbsNo}" >
				<button type='button'>변경</button></a>
			</td>
			</c:if>
<%-- 	${fn:escapeXml} or <c:out> 보안상 --%>

			</tr>
		</c:forEach>

	</tbody>
</table>



</body>           
</html>           

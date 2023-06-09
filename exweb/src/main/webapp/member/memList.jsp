<%@page import="java.util.List"%>
<%@page import="com.exweb.member.MemberVo"%>
<%@page import="com.exweb.member.MemberDaoBatis"%>
<%@page import="com.exweb.member.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%!
private MemberDao memberDao = new MemberDaoBatis();
%>
<%
List<MemberVo> list = memberDao.selectMemberList(); 
request.setAttribute("memberList", list);
%>


<html>              
<!DOCTYPE html>     
<head>              
<meta charset='UTF-8'> 
<title>회원관리</title>
</head>            
<body>             
<h1>회원목록 </h1>
<a href='<%=request.getContextPath()%>/member/memAddform.jsp' style="text-decoration:none">회원추가[o] </a>
<a href='${pageContext.request.contextPath}/member/memAddform.jsp' style="text-decoration:none">회원추가[o] </a>
<a href='<c:url value="/member/memAddform.jsp"/>' style="text-decoration:none">회원추가[o] </a><br>
<a href='<%=request.getContextPath()%>/member/delform.do' style="text-decoration:none">회원삭제[x] </a>


<c:forEach var="vo" items='${memberList}'>
	<p>
	<c:out value="${vo.memId}"/>:
	<c:out value="${vo.memName}"/>:
	${vo.memPoint}
	<a href='${pageContext.request.contextPath}/member/memDel.jsp?memId=<c:out value="${vo.memId}"/>'><button type='button'>삭제[x]</button></a>	
<!-- 	JSTL 태그의 scope와 var 속성을 사용하면 
	JSTL 태그 실행 결과를 현재 위치에 출력하지 않고,
	지정한 scope에 지정한 이름(var)의 속성을 저장한 후,
	EL에서 읽어서 사용 가능 -->
	<c:url value="/member/memDel.jsp" var="delUrl">
	 <c:param name="memId">${vo.memId}</c:param>
	</c:url>
	<a href='${delUrl}'>
	<button type='button'>삭제</button></a>
	</p>
</c:forEach>

</body>           
</html>           

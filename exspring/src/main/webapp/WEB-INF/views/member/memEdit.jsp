<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
		
		<%-- <jsp:include page="/WEB-INF/views/menu.jsp"/>    --%>  		
            
		<h1> 회원정보변경 </h1>
		<form action='${pageContext.request.contextPath}/member/edit.do' method='post'>  
		아이디 :<input type='text' name='memId' value='<c:out value="${mvo.memId}"/>' readonly/><br> 
		<%-- 아이디: <c:out value="${mvo.memId}"/><br>       
		<input type='hidden' name='memId' value='<c:out value="${mvo.memId}"/>' readonly="readonly"/><br>       --%>  
	<!-- 	비밀번호:<input type='password' name='memPass' value=''/><br> -->
		이름:<input type='text' name='memName' value='<c:out value="${mvo.memName}"/>'/><br>        
		포인트:<input type='number' name='memPoint' value='${mvo.memPoint}'/><br>  
		<input type='submit'/>                                       
		<input type='hidden' name='command' value='addMember'/>    
		<c:url value="/member/del.do" var="delUrl">
		<c:param name="memId">${mvo.memId}</c:param>
		</c:url>
		<a href='${delUrl}'>
		<button type='button'>삭제</button></a>

		</form>    
		                                                  
    
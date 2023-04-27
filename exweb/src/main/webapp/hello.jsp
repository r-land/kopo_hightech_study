<%@page import="com.exweb.member.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1> HEllo Jsp</h1>
	<%--JSP주석
	<!-- HTML 주석 -->
	JSP 구성요소
	-디렉티브 : PAGE(현재JSP파일전체에 대한 설정), INCLUDE(다른JSP파일포함), TAGLIB(태그라이브러리사용)
	 <%@ 디렉티브명 속성명="속성값" %>
	-스크립트요소 
		스크립트릿 <% 서블릿의 service메서드 내부에 들어갈 자바코드%>
		표현식 <%=현재위치에 결과값을 출력할 자바코드%>
		선언부 <!% 서블릿의 service메서드 외부에 들어갈 자바코드%>
		주석
	-액션태그 : 자주사용하는 자바코드를 대체할 수 있는 태그
	-EL  디자이너들도 이해하도록 자바코드 없애려는 노력
	-커스텀태그  --%>
	
	<% 
	//변수 선언없이 사용가능한 내장객체(기본객체):
	//	request(요청객체), reponse(응답객체), session(세션객체), application(서블릿컨텍스트객체)
	//out(응답출력스트림), config(서블릿설정), pageContext(현재jsp파일에 대한모든정보를 담은객체)
	//page(현재JSP서블릿객체), exception(발생한예외,에러페이지에서만사용가능) 
	out.println("출력할내용 지금은 jsp 실습중");
	out.println(session == request.getSession());
	out.println(application == getServletContext());
	out.println(config == getServletConfig());
//pageContext 객체에 현재 jsp 파일에서만 사용가능한 데이터를 속성으로 저장 가능
	pageContext.setAttribute("pa", "pv");
	out.println(pageContext.getAttribute("pa"));
/* 	pageContext 객체에는 다른 내장객체들이 모두 저장되어 있다. */
/* 	li태그는 직접접근이 안되서 이렇게 꺼내서 써야할 때가 있다. */
	out.println( request == pageContext.getRequest());
	out.println( response == pageContext.getResponse());
	out.println( session == pageContext.getSession());
	out.println( application == pageContext.getServletContext());
	%>
	<%! //JSP파일이 최초 실행될때 한번만 실행할 자바코드 
	int global = 0;
	%>
	
	<% //JSP파일이 실행될때마다 한번씩 반복 실행할 자바 코드
	int local = 0;
	out.println("local:"+ ++local );
	out.println("global:"+ ++global );
	%>
	<hr>
표현식 : <%out.print(local);%> <%=local%>
	<hr>
액션태그
<%	
	MemberVo v =(MemberVo)pageContext.getAttribute("m");
	if(v==null){
		v = new MemberVo();
		pageContext.setAttribute("m", v);
	}
	v.setMemId("A001");
	out.print(v.getMemId());
%>

<jsp:useBean id="m" class="com.exweb.member.MemberVo" scope="page"></jsp:useBean>
<jsp:setProperty name="m" property="memId" value="A001"/> 
<jsp:getProperty name="m" property="memId" />

<%
	/* request.getRequestDispatcher("/menu.jsp").forward(request,response); */
	request.getRequestDispatcher("/menu.jsp").include(request,response);

%>
<%-- <jsp:forward page="/menu.jsp"></jsp:forward> --%>
<jsp:include page="/menu.jsp"></jsp:include>
액션태그버전 하단
</body>
</html>


<!-- 실행시 톰캣이 서블릿으로 자동으로 바꿔줌 -->
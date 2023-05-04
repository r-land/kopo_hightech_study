<%@page import="java.util.HashMap"%>
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
	-EL(Expression Language):${자바코드} 표현으로 jsp표현식(<%=%>)유사한 역할 수행  디자이너들도 이해하도록 자바코드 없애려는 노력
	-커스텀태그  자바코드를 대체할 수 있는 태그를 정의하여 사용
	JSTL(JSP Standard tag libraries)라이브러리니깐 톰캣에서 다운  --%>
	
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
//	request.getRequestDispatcher("/menu.jsp").include(request,response);

%>
<%-- <jsp:forward page="/menu.jsp"></jsp:forward> --%>
<%--<jsp:include page="/menu.jsp"></jsp:include>
액션태그버전 하단 --%>

<h1>EL</h1>
${123} ${456.789}${"문자열1"}${'문자열2'}${true}${false}${null}<br>
${5+3}${5-3}${5*3}${5/3}<br>

<%
//EL에서 ${x}라고 쓰면, x는 변수 이름이 아니라,
//jsp 내장객체 저장소 4형제 scope- pageContext(jsp 파일내 하나),request(하나의 요청처리동안 공유하는 서블릿 jsp),session(사용자마다 브라우저별로)
//application(servletContext)(해당웹 종료전까지)에 저장한 속성 이름으로 해석
String s = "테스트";
pageContext.setAttribute("ps", s);
int[] arr = {3,4,5};
pageContext.setAttribute("pa", arr);
HashMap map = new HashMap();
map.put("k","v");
pageContext.setAttribute("pm", map);
MemberVo vo = new MemberVo();
vo.setMemId("a001");
pageContext.setAttribute("pv", vo);
%>
<%=s%>, ${ps} <br>
배열 1번칸의 값 :<%=arr[1] %>, ${pa[1]}<br>
맵에 k라는 이름으로 저장된 값 : <%=map.get("k") %>, ${pm.get("k")}, ${pm.k}, ${pm["k"]}<br>
객체의 memId 속성(변수)값: <%=vo.getMemId()%>, ${pv.getMemId()}, ${pv.memId}, ${pv["memId"]}<br>
<%--속성과 변수는 엄밀히 다름 get set하고 붙는게 속성 다를수있음 보통 똑같이하지만 ${aaa} 여기서 쓰는값 속성값으로 해석 --%>
<%
	pageContext.setAttribute("pa", 12);
	request.setAttribute("ra", 22);
	session.setAttribute("sa", 32);
	application.setAttribute("aa", 42);
	
	//EL 에서 xxxScope 을 생략 경우,
	//pageScope >requestScope> sessionScope> applicationScope을 순차적으로 찾아보고,
	//먼저 발견되는 속성값을 사용 
%>
<%=pageContext.getAttribute("pa") %>, ${pageScope.pa}, ${pageScope["pa"]}, ${pa}<br>
<%=request.getAttribute("ra") %>, ${requestScope.pa}, ${requestScope["ra"]}, ${ra}<br>
<%=session.getAttribute("sa") %>, ${sessionScope.pa}, ${sessionScope["sa"]}, ${sa}<br>
<%=application.getAttribute("aa") %>, ${applicationScope.pa}, ${applicationScope["aa"]}, ${aa}<br>
EL에서 별도의 선언없이 사용가능한 기본객체(JSP기본객체와 다른다)<br>
- pageScope, requestScope, sessionScope, applicationScope<br>
-파라미터값 : <%=request.getParameter("x")%>, ${param.x}, ${param["x"]}<br>
	파라미터값이 2개 이상인 경우, param 대신 paramValues 사용 
-요청헤더값 : <%=request.getHeader("User-Agent")%><br>${header["User-Agent"]}<br>
<%--user agent 헤더값 어떤 브라우저를 사용했는지 요청객체에 다 들어잇다 --%>
	헤더값이 2개 이상인 경우, header 대신 headerValues 사용 
-쿠키값 : <%=request.getCookies()[0].getName()%>, ${cookie.JSESSIONID.name} <br>
<%--첫번째 쿠키이름--%>
 <%=request.getCookies()[0].getValue()%>, ${cookie.JSESSIONID.value} <br>
<%--첫번째 쿠키값--%>
-컨텍스트초기화파라미터값:
	<%=application.getInitParameter("driver") %>, ${initParam.driver}<br>
-EL에서 JSP기본객체를 사용하고 싶은 경우, pageContext를 통해서 사용 가능<br>	
<%--web.xml에서 <context-param>값  --%>
- 컨텍스트패스(애플리케이션의 고유경로)
<%--http://localhost:8000/exweb/hello.jsp?x=abc 여기서 exweb --%>
	<%=request.getContextPath() %>, ${pageContext.request.contextPath}<br>
<%--EL에서는 기본객체 request 사용 불가  pageContext 안에 있음  --%>

파라미터x의 값이 "abc"인지 확인 : (EL에서 문자열비교는 ==,!=로 가능) <%=request.getParameter("x").equals("abc")%>, ${param.x=="abc"}<br> 
</body>
</html>

<!-- 실행시 톰캣이 서블릿으로 자동으로 바꿔줌 -->
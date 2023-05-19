<%@page import="java.util.Date"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.exweb.member.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  JSTL core 태그라이브러리에서 제공하는 태그를 c 접두어를 붙여서 사용 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
<h1>코어태그</h1>
-c:set : pageContext, request, session, servletContext에 속성 저장 
<%-- <% pageContext.setAttribute("score", 80); %> --%>
<c:set scope="page" var="score" value="${80}"></c:set>
${pageScope.score}<br>
-c:remove : pageContext, request, session, servletContext에 속성 삭제 아래주석풀기
<%-- <c:remove scope="page" var="score"/> --%>
${pageScope.score}<br>
-조건문<br>
<c:if test="${score>60}">통과</c:if>
<c:choose>
	<c:when test="${score>=90}">최우수</c:when>
	<c:when test="${score>=80}">우수</c:when>
	<c:otherwise>보통</c:otherwise>
</c:choose>
<br>
-반복문<br>
<% for(int num=1;num<=10;num+=2) out.print(num); %>
<c:forEach var="num" begin="1" end="10" step="2">${num}</c:forEach><br>
<%
/* String[] arr = {"A","B","C"}; */
/* pageContext.setAttribute("pa", arr);
for (String s : arr){
	out.print(s);
} */
%>
<c:forEach var="s" items="${pa}">${s}</c:forEach>
<ul>
<c:forEach var="s" items="${pa}" varStatus="stat">
<li>
${s}==${stat.current}현재값,
${stat.index}몇번째 반복인지 (0부터),
${stat.count}몇번째 반복인지 (1부터),
${stat.first}첫번째반복인지여부,
${stat.last}마지막반복인지여부,
<!--<c:forEach var="num" begin="1" end="10" step="2">${num}</c:forEach>-->
${stat.begin}태그의 begint 속성값,
${stat.end}태그의 end 속성값,
${stat.step}태그의 step 속성값,
</li>
</c:forEach>
</ul>
<c:forTokens var="tk" items="${'a,b:c,d'}" delims=",:">(${tk})</c:forTokens><br>
-출력
<% pageContext.setAttribute("str","제목"); %>
${str}
<c:out value="${str}"/>
<% pageContext.setAttribute("str","<h1>제목</h1>"); %>
${str}
<c:out value="${str}"/><br>
<%--c:out 문자열 내부의 태그문자를 변환하여 HTML 태그로 해석되지 않도록 출력 그대로 출력
스크립트상 삭제명령어 넣으면 그대로 실행되어 보안상 위험 c태그를 이용하자  --%>
-주소처리<br>
<a href="menu.jsp">메뉴로 이동</a> 
<a href="<%=request.getContextPath() %>/menu.jsp">메뉴로 이동</a> 
<a href="${pageContext.request.contextPath}/menu.jsp">메뉴로 이동</a> 
<c:set scope="page" var="cp" value="${pageContext.request.contextPath}"/>
<a href="${cp}/menu.jsp">메뉴로 이동</a>
<a href="<c:url value="/menu.jsp"/>">메뉴로 이동</a>
<!-- c:url은 경로가/로 시작하면 ,컨텍스트패스를 자동 추가 -->
<br><br>
-다른 JSP파일을 포함 <br>
다른 JSP파일의 소스코드를 현재 위치에 포함시켜서 하나의 JSP파일로서 실행
<%@ include file="/menu.jsp" %>
다른 JSP 또는 서블릿의 실행결과(출력내용)을 현재 JSP의 출력내용에 포함 (내것만)
<jsp:include page="/menu.jsp" />
jsp:include와 동일하지만, 다른 웹애플리케이션(사이트)도 포함 가능 
<c:import url="/menu.jsp"/>
<%-- <c:import url="http://google.com"/> --%>
-리다이렉트 : c:redirect 는 컨텍스트패스를 자동추가
<%-- <% response.sendRedirect( request.getContextPath()+ "/menu.jsp";)%> --%>
<%--<c:redirect url="/menu.jsp"><c/redirect> --%>
<br>
-주소생성시 파라미터 추가
<c:url value="/hello.jsp">
	<c:param name="x">abc</c:param>
	<c:param name="y">def</c:param>
</c:url>
<br>
-예외처리
<c:catch var="e">
	<% int a = 5/0; %>
</c:catch>
${e.message}

<h1>국제화/포맷팅 태그</h1>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%pageContext.setAttribute("d", new Date());%>
${d} <br>
자바Date 객체를 원하는 형태의 문자열로 변환 : 
<fmt:formatDate value="${d}" pattern="yyyy/MM/dd HH:mm:ss"/> <br>
날짜시간문자열을 자바 Date객체로 변환 :
<fmt:parseDate value="2022/01/20 12:34:56" pattern="yyyy/MM/dd HH:mm:ss" var="d2"/>
${d2}<br>

<%pageContext.setAttribute("n", 12345.67);%>
${n} <br>
숫자를 원하는 형태의 문자열로 변환 : 
<fmt:formatNumber value="${n}" pattern="###,###.###"/> <br>
<fmt:formatNumber value="${n}" pattern="000,000.000"/> <br>
<fmt:formatNumber value="${n}" pattern="#,###.#"/> <br>
<fmt:formatNumber value="${n}" pattern="0,000.0"/> <br>
숫자문자열을 숫자로 변환 :
<fmt:parseNumber value="12,345.67" pattern="###,###.###" var="n2"/> 
${n2}<br>


현재 Jsp파일에서 JSTL 국제화 태그가 사용할 로케일 강제 지정 
basename은  지정하지 않으면 Accept-Language 요청 헤더 값 사용 :
국가코드는 ISO 3166-1 alpha-2,언어코드는 ISO 639-1(java.util.Locale참조)
<fmt:setLocale value="en_US"/>
<fmt:formatDate value="${d}" type="both" dateStyle="full" timeStyle="full"/>
<fmt:formatNumber value="${n}" type="currency"/>
<br>
메시지를 저장한 프로퍼티파일이 "클래스패스/폴더명/번들명_언어_국가.properties" 일때
basename은 "폴더명.번들명" :
<fmt:setBundle basename="msg" var="mb"/>
<fmt:message bundle="${mb}" key="str"/>
<%--프로퍼티 파일은 기본으로 한글 지원 안함 \uC548\uB155 안녕이렇게 출력 브라우저체제(Accept-language)에 맞게 한글, 영어 골라서 출력해줌--%>

<fmt:message bundle="${mb}" key="str2">
<!--메시지내용중 {0},{1}...위치에 주입할 값을 fmt:param 태그로 순서대로 지정-->
	<fmt:param value="JSP"/>
	<fmt:param value="!!!"/>
</fmt:message>
<br>
<h1>JSTL functions</h1>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<br> ${fn:length("aBcD")} <%="aBcD".length()%> ${"aBcD".length()} 
<!-- 펑션태그 자바코드 el에서 요즘은 기능이 좋아져서 el로도 가능  -->
<br> ${fn:contains("aBcD","Bc")} <%="aBcD".contains("Bc")%> ${"aBcD".contains("Bc")}   
<br> ${fn:containsIgnoreCase("aBcD","bC")}  <%="aBcD".toLowerCase().contains("bC".toLowerCase())%> ${"aBcD".toLowerCase().contains("bC".toLowerCase())}
<!-- 대소문자 무시 -->
<br> ${fn:startsWith("aBcD","aB")} <%="aBcD".startsWith("aB")%> ${"aBcD".startsWith("aB")}
<!-- 첫번째 문자열이 aB로 시작하는지 참거짓 -->
<br> ${fn:endsWith("aBcD","cD")} <%="aBcD".endsWith("cD")%> ${"aBcD".endsWith("cD")}
<!-- 마지막 문자열이 cD로 시작하는지 참거짓 -->
<br> ${fn:escapeXml("<h1>제목</h1>")} <c:out value="<h1>제목</h1>" /> 
<!-- html 꺽쇠가 인식안되게 -->
<br> ${fn:indexOf("aBcD","Bc")} <%="aBcD".indexOf("Bc")%> ${"aBcD".indexOf("Bc")} 
<%
	String[] arr = {"A","B","C"}; 
	pageContext.setAttribute("pa", arr);
// 	EL에서 String.join() 사용시, Iterable 파라미터에 배열이 타입이 맞지 않는 오류 발생 (버그인듯) 
// 	배열이 아닌 ArrayList 객체를 사용하면 정상실행 
	pageContext.setAttribute("pl", new java.util.ArrayList<String>(java.util.Arrays.asList(arr))); 
%>
<br> ${fn:join(pa,"::")} <%=String.join("::", arr)%> ${String.join("::", pl)} ${String.join("::", ["A","B","C"])}       

<br> ${(fn:split("a,B:c,D",",:"))[2]} <%="a,B:c,D".split("[,:]")[2]%> ${"a,B:c,D".split("[,:]")[2]} 
<!-- 구분자를 배열로 -->
<br> ${fn:replace("aBcDBc","Bc","efg")} <%="aBcDBc".replace("Bc","efg") %> ${"aBcDBc".replace("Bc","efg")}
<!-- 문자열에서 두번쨰 문자열을 세번쨰문자열로 -->
<br> ${fn:substring("aBcD", 1, 2)} <%="aBcD".substring(1,2)%> ${"aBcD".substring(1,2)}

<br> ${fn:substringAfter("aBcD", "Bc")}  <%="aBcD".substring( "aBcD".indexOf("Bc") + "Bc".length() )%>  ${"aBcD".substring("aBcD".indexOf("Bc")+"Bc".length())} 
<br> ${fn:substringBefore("aBcD", "Bc")} <%="aBcD".substring(0, "aBcD".indexOf("Bc") )%> ${"aBcD".substring(0,"aBcD".indexOf("Bc"))}
<br> ${fn:toLowerCase("aBcD")} <%="aBcD".toLowerCase()%> ${"aBcD".toLowerCase()}
<br> ${fn:toUpperCase("aBcD")} <%="aBcD".toUpperCase()%> ${"aBcD".toUpperCase()}
<br> [${fn:trim("   aB cD  ")}] [<%="   aB cD  ".trim()%>] [${"   aB cD  ".trim()}]
<!-- 공백제거 -->
</body>
</html>
<%@page import="com.exweb.member.MemberDaoBatis"%>
<%@page import="com.exweb.member.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%! 
private MemberDao memberDao = new MemberDaoBatis(); 
%>  
<%

String memId = request.getParameter("memId");
//db삭제관련 메소드생성
int n = memberDao.deleteMember(memId);
System.out.println(n + "명의 회원 삭제 성공");

response.sendRedirect(request.getContextPath()+"/member/memList.jsp");

%>
		
		
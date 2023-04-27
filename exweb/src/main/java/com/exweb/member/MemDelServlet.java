package com.exweb.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//웹브라우저에서 del.do?memId=삭제할회원아이디 
//로 요청을 보내면, 지정한 회원 정보를 데이터베이스에서 삭제하고
// "명 회원 삭제 성공" 메세지와 " 회원목록 으로 이동" 링크 화면출력


@WebServlet("/member/del.do")
public class MemDelServlet extends HttpServlet{
	private MemberDao memberDao = new MemberDaoBatis();
	//memberdao로 간 메소드 새로운 객체로 만들어서 사용하기 
	//jdbc > batis로 수정 
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		req.setCharacterEncoding("UTF-8"); 필터로 이동
		
		
		String memId = req.getParameter("memId");
 //db삭제관련 메소드생성
		int n = memberDao.deleteMember(memId);
		System.out.println(n + "명의 회원 삭제 성공");
		
		resp.sendRedirect(req.getContextPath()+"/member/list.do");
		
		/*
		 * resp.setContentType("text/html; charset=utf-8"); //서버에서 문서를 해석하는 타입과 인코딩
		 * PrintWriter out = resp.getWriter();
		 * 
		 * out.println("<!DOCTYPE html>     "); out.println("<html>              ");
		 * out.println("<head>              "); out.println("<meta charset='UTF-8'>" );
		 * out.println("<title>회원삭제</title>"); out.println("</head>             ");
		 * out.println("<body>              "); out.println("<h2>"+ n +
		 * "명의 회원 삭제 </h2>"); out.println("<a href='" +req.getContextPath()+
		 * "/member/list.do'>회원목록 </a>"); out.println("</body>             ");
		 * out.println("</html>             ");
		 */
		
	}



}

//package com.exam.myapp.member;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
////1.브라우저 주소창에 http://localhost:8000/exweb/member/login.do (파라미터값, 디비조회, 객체저장 필요 없음) 입력하여 접속하면
////LoginServlet클래스와 login.jsp파일 순차실행 	되어 브라우저에 로그인 화면 출력되도록 구현
////2. 로그인 화면에 submit 버튼 클릭 하면 LoginServlet클래스의 dopost실행되도록 구현
//
//@WebServlet("/member/logout.do")
//public class LogoutServlet extends HttpServlet {
//	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//		HttpSession session =req.getSession();
////		session.setAttribute("loginUser", null); //세션에 지정한 이름의 속성값 null설정시 로그인 안한 상태
////		session.removeAttribute("loginUser"); //세션에서 지정한 이름의 속성 삭제
//		session.invalidate(); //세션객체를 제거(후 다시 생성), 모든 속성들도 함께삭제
//		
//		resp.sendRedirect(req.getContextPath()+"/member/login.do");
//	
//	}
//		
//}
//
//

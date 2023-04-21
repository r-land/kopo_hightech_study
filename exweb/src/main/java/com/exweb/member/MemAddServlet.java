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

//회원정보 추가 후 화면에 "회원목록으로 이동" 링크를 추가하고, 
//그 링크를 클릭하면, 회원정보화면으로 이동하도록
//MemAddServlet 클래식 변경

@WebServlet("/member/add.do")
public class MemAddServlet extends HttpServlet {
	private MemberDao memberDao = new MemberDaoJdbc();
//memberdao로 간 메소드 새로운 객체로 만들어서 사용하기 

//	// 클래스 초기화 블럭 최초 1번만 실행 왜 중복으로 생성했냐면 어디 페이지 먼저 실행될지 모르니깐  //Dao에 만들어줬으니깐 삭제가능
//	String url = "jdbc:oracle:thin:@localhost:1521:xe"; // DB 서버 주소
//	String user = "web"; // DB 접속 아이디
//	String password = "web01"; // db 접속 비밀번호

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");   // 필터로 이동

	MemberVo vo = new MemberVo();
	vo.setMemId(req.getParameter("memId"));
	vo.setMemPass(req.getParameter("memPass"));
	vo.setMemName(req.getParameter("memName"));
	vo.setMemPoint(Integer.parseInt(req.getParameter("memPoint")));
	

		// 이방법으로도 insert가능
		resp.setContentType("text/html; charset=utf-8"); // 서버에서 문서를 해석하는 타입과 인코딩
		PrintWriter out = resp.getWriter();

//		// 애플리케이션에 JDBC 사용 전에 최초 1번은 JDBC 드라이버 클래스를 메모리에 로드 필요 /web.xml로 이동
//		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//		} catch (ClassNotFoundException e) {
//			// 예외처리
//			e.printStackTrace();
//		}
		
		
		//디비 메소드생성 -  인서트 하고 몇명 반환됐는지 출력됨 
		
		int n = memberDao.insertMember(vo);
		System.out.println(n + "명의 회원 추가 성공");

		// 프로그램이 완벽해도 db server 이상하면 접속 안될수도 있어서 오류 뜨지만 예외처리 해주면됨

		// 회원목록 출력
		// MemListServlet 실행!
		// forward : 요청객체와 응답객체를 전달하면서 지정한 주소의 다른 서블릿을 실행 웹브라우저한테 안알려고 그냥 해서 주소창이 안변함 
		// 현재 서블릿에서는 더이상 응담을 출력하지 않는다
		/*
		 * req.getRequestDispatcher("/member/list.do").forward(req, resp);
		 */ // include : 요청객체와 응답객체를 전달하면서 지정한 주소의 다른 서블릿을 실행
		// 현재 서블릿의 출력 내용 중간에 지정한 서블릿의 출력 내용을 포함 , 메뉴바 같은 공통적인 부분에 쓰임 밑에 현 서블릿 같이 출력가능 웹브라우저한테 안알려고 그냥 해서 주소창이 안변함 
		/* req.getRequestDispatcher("/member/list.do").include(req, resp); */
		// redirect : 지정한 주소로 이동하라는 명령을 담은 응답을 웹브라우저에게 전송 웹브라우저가 알고 주소도 변함 리스트.do로
		resp.sendRedirect(req.getContextPath()+"/member/list.do");
		
		  out.println("<!DOCTYPE html>     "); out.println("<html>              ");
		  out.println("<head>              "); out.println("<meta charset='UTF-8'>" );
		  out.println("<title>회원정보추가</title>"); out.println("</head>             ");
		  out.println("<body>              "); out.println("<h2>"+ n +
		  "명의 회원 추가 </h2>"); out.println("<a href='" +req.getContextPath()+
		  "/member/list.do'>회원목록 </a>"); out.println("</body>             ");
		  out.println("</html>             ");
		 

	}


}

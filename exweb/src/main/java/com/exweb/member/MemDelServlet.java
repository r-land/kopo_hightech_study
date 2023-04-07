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
	
	{//애플리케이션에 JDBC 사용 전에 최초 1번은 JDBC 드라이버 클래스를 메모리에 로드 필요 
				try {
					Class.forName("oracle.jdbc.OracleDriver");
				} catch (ClassNotFoundException e) {
					// 예외처리
					e.printStackTrace();
				}
		
	}	
	//클래스 초기화 블럭 최초 1번만 실행  
	String url = "jdbc:oracle:thin:@localhost:1521:xe";  // DB 서버 주소
	String user = "web";  // DB 접속 아이디
	String password = "web01"; //db 접속 비밀번호	
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		
		String memId = req.getParameter("memId");
 
		String sql ="delete from member where mem_id = ?";
			
		//jdbc sql은 세미콜론 없고 뒤에 공백 하나씩  +변수+로 하면 해킹 위험 
		//이방법으로도 insert 가능 
		int n=0;
		try(//지정한 데이터베이스 접속하라는 명령문
				Connection conn = DriverManager.getConnection(url, user, password); 
				//해당 연결을 통해 실행할 sql문을 담은 명령문 객체 생성
				PreparedStatement pstmt = conn.prepareStatement(sql);		
				)//try(괄호)안은 try-catch블럭 실행 완료후 conn, pstmt 자동으로 종료 close()메서드 실행 이전에는 finally 에 if !=null 구문까지 했어야함
			{
			//pstmt 명령문 객체에 담겨 있는 sql문의 ?에 값 채워넣기 
			//채워넣는 값의 타입에 따라서 set타입명() 메서드 사용
			pstmt.setString(1, memId); //1번쨰 ?에 memId 값 넣기

			//sql문 실행  insert, update,delete문 실행은 executeUpdate()메서드 사용
			
			n = pstmt.executeUpdate(); //반환값은 sql문 실행으로 영향받은 레코드(row) 수
			System.out.println(n + "명의 회원 삭제 성공");
			
		
		} catch (SQLException e) {
			e.printStackTrace();

		}
		//프로그램이 완벽해도 db server 이상하면 접속 안될수도 있어서 오류 뜨지만 예외처리 해주면됨 
		
		
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

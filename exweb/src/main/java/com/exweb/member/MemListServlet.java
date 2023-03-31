package com.exweb.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/list.do")
public class MemListServlet extends HttpServlet{
	
	{//애플리케이션에 JDBC 사용 전에 최초 1번은 JDBC 드라이버 클래스를 메모리에 로드 필요 //addservlet과 어느게 먼저 실행될지 몰라서 둔다
				try {
					Class.forName("oracle.jdbc.OracleDriver");
				} catch (ClassNotFoundException e) {
					// 예외처리
					e.printStackTrace();
				}
	}	
	//클래스 초기화 블럭 최초 1번만 실행  
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//애플리케이션에 JDBC 사용 전에 최초 1번은 JDBC 드라이버 클래스를 메모리에 로드 필요 
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// 예외처리
			e.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@localhost:1521:xe";  // DB 서버 주소
		String user = "web";  // DB 접속 아이디
		String password = "web01"; //db 접속 비밀번호

		String sql ="SELECT mem_id, mem_pass, mem_name, mem_point FROM member" ; 
		//jdbc sql은 ;세미콜론 없고 뒤에 공백 하나씩  +변수+로 하면 해킹 위험 
		
		
		try(//지정한 데이터베이스 접속하라는 명령문
				Connection conn = DriverManager.getConnection(url, user, password); 
				//해당 연결을 통해 실행할 sql문을 담은 명령문 객체 생성
				PreparedStatement pstmt = conn.prepareStatement(sql);		
				)//try(괄호)안은 try-catch블럭 실행 완료후 conn, pstmt 자동으로 종료 close()메서드 실행 이전에는 finally 에 if !=null 구문까지 했어야함
			{	
			//sql문 실행  selet문 실행은 executeQuery()메서드 사용
			ResultSet rs = pstmt.executeQuery(); //반환값은 조회결과  레코드(row) 수
			
			//처음 resultset 객체는 첫 레코드(row) 이전을 가르키고 있음
			// .next() 메서드를 실행하면 다음 레코드를 가리키게 된다.
			//.next() 다음 레코드가 있으면 true를 반환하고 없으면 false를 반환한다.
			
			while (rs.next()) {
		
				//컬럼값의 데이터타입에 따라 get타입("컬럼명") 메소드를 사용하여 컬람값 읽기
				String memId = rs.getString("mem_id");//현재 가리키는 레코드(row)의 mem-id 컬럼값 읽기
				String memPass = rs.getString("mem_pass");//현재 가리키는 레코드(row)의 mem-pass 컬럼값 읽기
				String memName = rs.getString("mem_name");//현재 가리키는 레코드(row)의 mem-naem 컬럼값 읽기
				int memPoint = rs.getInt("mem_point");//현재 가리키는 레코드(row)의 mem-point 컬럼값 읽기
				System.out.println(memId + ":" + memPass + ":" + memName + ":" + memPoint);
			}
			
			
			
			} catch (SQLException e) {
			e.printStackTrace();

		}
		//프로그램이 완벽해도 db server 이상하면 접속 안될수도 있어서 오류 뜨지만 예외처리 해주면됨 
		
	}
}

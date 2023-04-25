package com.exweb.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//회원목록 화면에 "회원추가"링크를 추가하고,
//그 링크를 클릭하면, 회원정보를 입력하는 폼 화면으로 이동하도록
//MemListServlet 클래스 변경

//회원정보 추가 후 화면에 "회원목록으로 이동" 링크를 추가하고, 
//그 링크를 클릭하면, 회원정보화면으로 이동하도록
//MemAddServlet 클래스 변경

//회원목록의 각 회원정보 옆에 "삭제"링크를 출력하고 
//링크를 클릭하면 해당 회원이 삭제되도록
//MemlistServlet 클래스 변경

@WebServlet("/member/list.do")
public class MemListServlet extends HttpServlet{
	private MemberDao memberDao = new MemberDaoBatis();
	//처음 한번 만들어서 계속 사용 할수 있으까 서비스 메서드 안에서 위치 변동 시키고 여기서만 쓰니깐 프라이빗 붙이기
	//new DAOjdbc 였던걸 바티스로 바꿔줌 
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//db관련 메소드 	
		List<MemberVo> list = memberDao.selectMemberList();
		//memberDaojdbc로 간 selecMemberList()를 사용하려면 ? 객체 만들어서 실체를 만들어주면 클래스의 것을 가져다 쓸수 있음

//		req.setCharacterEncoding("UTF-8"); 필터로 이동
		resp.setContentType("text/html; charset=utf-8"); //서버에서 문서를 해석하는 타입과 인코딩 
		PrintWriter out = resp.getWriter();	
		
		out.println("<!DOCTYPE html>     ");
		out.println("<html>              ");
		out.println("<head>              ");
		out.println("<meta charset='UTF-8'>" );
		out.println("<title>회원관리</title>");
		out.println("</head>             ");
		out.println("<body>              ");
		out.println("<h1>회원목록 </h1>");
		out.println("<a href='" +req.getContextPath()+ "/member/addform.do'>회원추가[o] </a>");
		out.println("<a href='" +req.getContextPath()+ "/member/delform.do'>회원삭제[x] </a>");	
		
			
			for (MemberVo vo : list) {
			
//			System.out.println(memId + ":" + memPass + ":" + memName + ":" + memPoint); //콘솔출력
			
			out.println("<p>"+ vo.getMemId() + ":" + vo.getMemPass() + ":" + vo.getMemName() + ":" + vo.getMemPoint() );
			out.println("<a href='" +req.getContextPath()+ "/member/del.do?memId=" +vo.getMemId() + "'><button type='button'>삭제[x]</button></a>");	
			out.println("</p>");
			//웹브라우저출력
			out.println("</body>             ");
			out.println("</html>             ");	
		}
	}



	
}

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
import javax.servlet.http.HttpSession;

//회원목록 화면에 "회원추가"링크를 추가하고,
//그 링크를 클릭하면, 회원정보를 입력하는 폼 화면으로 이동하도록
//MemListServlet 클래스 변경

//회원정보 추가 후 화면에 "회원목록으로 이동" 링크를 추가하고, 
//그 링크를 클릭하면, 회원정보화면으로 이동하도록
//MemAddServlet 클래스 변경

//회원목록의 각 회원정보 옆에 "삭제"링크를 출력하고 
//링크를 클릭하면 해당 회원이 삭제되도록
//MemlistServlet 클래스 변경

//로그인하지 않은 상태에서 회원목록 페이지 접속하면 로그인화면으로 이동하도록 구현
//필터로 이동 시킴 loginfilter

@WebServlet("/member/list.do")
public class MemListServlet extends HttpServlet{
	private MemberDao memberDao = new MemberDaoBatis();
	//처음 한번 만들어서 계속 사용 할수 있으까 서비스 메서드 안에서 위치 변동 시키고 여기서만 쓰니깐 프라이빗 붙이기
	//new DAOjdbc 였던걸 바티스로 바꿔줌 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<MemberVo> list = memberDao.selectMemberList();

		req.setAttribute("memberList", list);
		
		req.getRequestDispatcher("/WEB-INF/views/member/memList.jsp").forward(req, resp);
		
		}
	}



	


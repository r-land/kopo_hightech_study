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

//회원목록에서 아이디 클릭하면 
//MemEditServlet memedit .jsp가 순차적으로 실행되어 회원정보변경 화면이 브라우저에 출력되도록 구현
//1.회원정보변경 화면에서 이름과 포인트를 변경하고 submit 버튼을 클릭하면, Memeditservlet 클래스의 dopost 메서드가 실행되도록 memEdit.jsp파일 변경

//2. 회원정보변경 화면에서 아이디는 키보드값을 입력(변경)할 수 없도록 memedit.jsp파일을 변경하세요.
//>c:out 하나 쓰고 (보여주는것) 아래 입력받아서 제출받는 기능 구현은 hidden 처리
//>입력방지속성 readonly(키보드막기 파라마티전송가능)/ disabled(키보드막고 파라미터삭제) (코드로 수정가능하니깐 보안측면위험)

//3.Memeditservlet 클래스의 dopost 메서드에서 사용자가 입력한 정보에 따라서 데이터베이스의 회원정보(이름,포인트가)변경되도록
//Memeditservlet.java+, memberDao.java+, mamberdaobatis.java+,  membaermapper.xml+ 파일변경

@WebServlet("/member/edit.do")
public class MemEditServlet extends HttpServlet {
	private MemberService memberService = MemberServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memId = req.getParameter("memId");
		MemberVo vo = memberService.selectMember(memId);
		req.setAttribute("mvo", vo);
		
		req.getRequestDispatcher("/WEB-INF/views/member/memEdit.jsp").forward(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	MemberVo vo = new MemberVo();
	vo.setMemId(req.getParameter("memId"));
	vo.setMemName(req.getParameter("memName"));
	vo.setMemPoint(Integer.parseInt(req.getParameter("memPoint")));
			
		int n = memberService.updateMember(vo);
		System.out.println(n + "명의 회원 변경 성공");

		resp.sendRedirect(req.getContextPath()+"/member/list.do");
		
	}


}

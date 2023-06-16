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
import javax.servlet.http.HttpSession;

//1.브라우저 주소창에 http://localhost:8000/exweb/member/login.do (파라미터값, 디비조회, 객체저장 필요 없음) 입력하여 접속하면
//LoginServlet클래스와 login.jsp파일 순차실행 	되어 브라우저에 로그인 화면 출력되도록 구현
//2. 로그인 화면에 submit 버튼 클릭 하면 LoginServlet클래스의 dopost실행되도록 구현

@WebServlet("/member/login.do")
public class LoginServlet extends HttpServlet {
	private MemberService memberService = MemberServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	MemberVo vo = new MemberVo();
	vo.setMemId(req.getParameter("memId"));
	vo.setMemPass(req.getParameter("memPass"));
	
	MemberVo mvo = memberService.selectLogin(vo);

	//Mapper에서 가져온 정보가 일치하는지 여부
	

	
	if(mvo==null) { 	//로그인 실패 로그인화면 이동 
		resp.setContentType("text/html; charset=UTF-8");
		 
		PrintWriter out = resp.getWriter();
		 
		out.println("<script>alert('로그인실패했어요'); history.back(); </script>");
		 
		out.flush();
		
		/*
		 * resp.sendRedirect(req.getContextPath()+"/member/login.do");
		 */		//로긴.두 강제이동  로긴.jsp 포워딩도 됨
	}else { //로그인 성공
		HttpSession session =req.getSession();
		session.setAttribute("loginUser", mvo);
		//가져온 정보 loginuser 이름으로 세션에 저장함 
		resp.sendRedirect(req.getContextPath()+"/member/list.do"); //회원목록화면 이동
	//	요청객체(하나 한번의 요청처리하는 애들),세션객체(사용자별로 요청시간까지 유지),서블릿 컨텍스트 객체(1개로 다른사람들 다 공유) (여러곳에서 사용하는 애들 모음)
		
	}
		
	}

}

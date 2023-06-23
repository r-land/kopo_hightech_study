package com.exam.myapp.comm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.exam.myapp.member.MemberVo;

//다수의 컨트롤러 실행 전후에 수행해야하는 공통작업들은
//핸들러인터셉터를 사용하여 구현 가능 

public class LoginFilter extends HandlerInterceptorAdapter {
	private List<String> whiteList = new ArrayList<String>();
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//필터가 처음 생성됐을떄 1번 실행
		whiteList.add("/member/login.do");
		whiteList.add("/member/add.do");
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//서블릿 리쿼스트가 http서블릿리쿼스트 보다 상위타입 강제형변환 시켜줌 
		//필터 경로에 맞는 요청이 올떄마다 한번씩 실행
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		System.out.println("URI: " + req.getRequestURI());
		System.out.println("URL " + req.getRequestURL());
		String reqPath = req.getRequestURI().substring(req.getContextPath().length());
		System.out.println("reqPath: " + reqPath);
		
		
		if(whiteList.contains(reqPath) == false) {
//			if(!whiteList.contains(req.getRequestURI())) {
			//요청보낸 사용자의 세션 가져와서
			HttpSession session =req.getSession();
			//세션에 로그인정보 꺼내와서
			MemberVo vo = (MemberVo) session.getAttribute("loginUser");
			
			if(vo==null) { 	//로그인 정보가 없다면,
				//로그인페이지로 이동
			resp.sendRedirect(req.getContextPath()+"/member/login.do");
			return;
			}
			
		}
		//로그인 안한사람은 어느 주소를 쓰든 로그인.do로 가게 구현함 
		//로그인 한사람은 통과
		//이후 실행될 필터 또는 서블릿들을 실행/  실제 실행 되는 시점 /  원하는 시점 전후로 코드 추가 
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}

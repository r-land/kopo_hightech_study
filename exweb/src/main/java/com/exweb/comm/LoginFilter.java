package com.exweb.comm;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exweb.member.MemberVo;

public class LoginFilter implements Filter{
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//서블릿 리쿼스트가 http서블릿리쿼스트 보다 상위타입 강제형변환 시켜줌 
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		if(!req.getRequestURI().equals(req.getContextPath() + "/member/login.do") ) {
			
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


	
}

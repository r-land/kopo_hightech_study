package com.exweb.comm;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//필터 : 서블릿의 실행 전후에 끼어들어가서 실행
// 다수의 서블릿들이 수행하는 공통작업을 실행할떄 사용
// Filter 인터페이스 구현하여 필터 클래스 정의
//web.xml에 <filter> 태그로 등록하거나, 클래스에 @webfilter 적용
//method 3개 

public class CharEncFilter implements Filter{
	//지역변수일때 에러 나므로  필드, 전역변수 선언해줘야 초기화 메소드에서 설정한게 필터 메소드에서 사용가능
	private String enc;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//필터가 처음 생성됐을떄 1번 실행
		System.out.println("CharEncFilter init() 실행");
		enc = filterConfig.getInitParameter("encoding");
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("CharEncFilter doFilter() 실행");
		
		request.setCharacterEncoding(enc);
		
		//인코딩이라면 이전 서블릿 응답 후 보답은 이후
		//이후 실행될 필터 또는 서블릿들을 실행/  실제 실행 되는 시점 /  원하는 시점 전후로 코드 추가 
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		//필터 객체가 소멸(삭제)되기 전에 1번 실행
		System.out.println("CharEncFilter destroy() 실행");

	}
	
}

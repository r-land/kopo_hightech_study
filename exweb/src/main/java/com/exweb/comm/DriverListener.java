package com.exweb.comm;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//리스너 : 특정 사건이 발생했을떄 자동으로 실행되는 객체
//감지하고 싶은 사건의 종류에 따라서 그에 맞는 리스너인터페이스 구현


public class DriverListener implements ServletContextListener  {

		@Override
		public void contextInitialized(ServletContextEvent sce) {
			//서블릿컨텍스트객체가 처음생성된 시점(서버(톰캣)시작시점)에 실행되는 메서드
			System.out.println("DriverListener contextInitialized()실행!");
			
			ServletContext context = sce.getServletContext(); // 생성된 서블릿컨텍스트 객체 가져오기 
			String cname = context.getInitParameter("driver");
			// 애플리케이션에 JDBC 사용 전에 최초 1번은 JDBC 드라이버 클래스를 메모리에 로드 필요
			//누가쓸지모르면 context parameter
			//특정서블릿은 init pairam web.xml에서 
			try {
				Class.forName(cname);
			} catch (ClassNotFoundException e) {
				// 예외처리
				e.printStackTrace();
			}
		}
		
		@Override
		public void contextDestroyed(ServletContextEvent sce) {
			//서블릿컨텍스트객체가 소멸되기 직전(서버(톰캣)종료시점)에 실행되는 메서드
			System.out.println("DriverListener contextDestroyed()실행!");

		}
	
}

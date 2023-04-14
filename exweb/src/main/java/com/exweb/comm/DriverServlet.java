package com.exweb.comm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

//공통작업을 한곳에 모으기 
//톰캣에 등록해주기 @WebServlet ,web.xml

public class DriverServlet extends HttpServlet {

@Override
public void init() throws ServletException {
	// 생성자 처음 만들어질때 한번만
	System.out.println("DriverServlet init() 실행!");
	String cname = getInitParameter("driver"); // 현 서블릿의 "driver" 초기화 파라미터 값 읽기
	// 애플리케이션에 JDBC 사용 전에 최초 1번은 JDBC 드라이버 클래스를 메모리에 로드 필요
		try {
			Class.forName(cname);
		} catch (ClassNotFoundException e) {
			// 예외처리
			e.printStackTrace();
		}

	
	}  
		
		
		
}



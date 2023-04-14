package com.exweb.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//다수의 서블릿들이 공유하는 데이터를 저장하는 공간
//1. 서버(톰캣)저장
//(1) 요청객체 req
//	-요청 1개 마다 1개의 요청객체 생성, 요청처리가 끝나면 소멸 /다른서블릿에서 포워딩 인클루딩일때 객체들을 꺼내서 쓰일수있다
//	-하나의 요청을 처리하기 위해 사용되는 서블릿들간의 데이터 공유(forward, include)
// forward : 요청객체와 응답객체를 전달하면서 지정한 주소의 다른 서블릿을 실행 웹브라우저한테 안알려고 그냥 해서 주소창이 안변함 
// 현재 서블릿에서는 더이상 응담을 출력하지 않는다
/*
 * req.getRequestDispatcher("/member/list.do").forward*******이런식 (req, resp);
 */ // include : 요청객체와 응답객체를 전달하면서 지정한 주소의 다른 서블릿을 실행
// 현재 서블릿의 출력 내용 중간에 지정한 서블릿의 출력 내용을 포함 , 메뉴바 같은 공통적인 부분에 쓰임 밑에 현 서블릿 같이 출력가능 웹브라우저한테 안알려고 그냥 해서 주소창이 안변함 
/* req.getRequestDispatcher("/member/list.do").include*****이런식 (req, resp); */

//(2) 세션객체
//	  -클라이언트(웹브라우저)마다 1개당 1 개의 세션 객체 생성	
//	  -클라이어트 종료시까지 서버 종료시 일정시간 동안 요청이 없을때 세션 객체 소멸 
//    -클라이언트(사용자,웹브라우저)별로 각각 유지해야하는 데이터 공유 (로그인정보....)
//(3) 서블릿컨텍스트 객체
//	  -웹 애플리케이션 전체에서 1개의 서블릿컨텍스트 객체만 생성
//	  -서버(톰캣)가 시작될떄 생성 서버 종료될때 소멸 
//	  -모든 사용자와 모든 서블릿들이 데이터 공유
// * 요청객체 세션객체 서블릿컨텍스트객체 모두 동일한 메서드로 데이터 저장 및 조회 가능 
//- 객체.setAttribute("속성명", 속성값) : 속성값 저장
//- 객체.getAttribute("속성명") : 속성값 읽기
//- 객체.removeAttribute("속성명") : 속성값 삭제
//2. 클라이언트 (웹브라우저)에 저장
//(1)쿠키
//	  -	웹브라우저에 데이터를 이름- 값 쌍으로 저장
//	  - 기본적으로 쿠키를 저장한 웹사이트(도메인)와 동일한 웹사이트로 요청을 보낼때 요청헤더에 쿠키를 자동으로 포함
//	  -만료기간을 설정하면, 웹브라우저 종료되더라도 쿠키 값 유지 가능 
//	  - 웹브라우저에서 접근하여 사용 가능하기 때문에 보안상 위험 존재 얼마든지 사용자가  개발자 도구 켜가지고 조작 가능 세션 서블릿은 못함 	
//    -쿠키 이름과 값은 쉽포 세미콜론 공백 등 특수문자와 한글 등 비영어권 문자 사용불가  값을 ;로 구분하는데 이름에 그게 들어가면 안됨 
//		일반적으로 쿠키이름은 영문자와 숫자만 사용하는게 좋지만 한글특수문자 쿠키값은 인코딩/디코딩하여 사용해서 그 값 받아서 사용
//(2)html5에서는 sessionStorage,localStorage,indexedDB도 사용 가능
@WebServlet("/save")
public class SaveServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



	req.setCharacterEncoding("UTF-8");

	String nval = req.getParameter("nn");
	String rval = req.getParameter("rem"); //기억하기 체크하면 rval 이 on 으로 저장
	
	//세션객체 받아오기 현재 요청 보낸 사용자의 세션객체 가져오기 없으면 생성
	HttpSession session = req.getSession();
	session.setAttribute("nick", nval); // 받아온 객체 저장 이름을 붙여야 나중에 꺼내쓸수잇다 . 변수명 처럼 설정  nick이라는 이름으로 nval 변수값
	
	//현재 웹 애플리케이션의 서블릿컨텍스트 서버 끄지않은한 계속 유지
	ServletContext context = getServletContext();
	context.setAttribute("nick", nval); //서블릿 컨텍스트객체에 "nick"이라는 이름으로 nval
	
	if("on".equals(rval)) { 		//java 비교는 ==부등호로 하지말고 메소드로 왜냐면 객체니깐 
			String enval = URLEncoder.encode(nval,"UTF-8"); // 인코딩 (하고싶은값 , 할떄 사용할문자툴) 한글 특수문자 포함시 필요 그 값을 주소창에 반영 했으면 읽으때도 디코딩 필요 
			Cookie c = new Cookie("nick",enval); //쿠키 객체 만들고 변수 C로 받기 import javax.servlet.http.Cookie; 임포트 해주세요
			c.setMaxAge(60*5); //쿠키 유효기간(초) 설정 (0 즉시 삭제, 음수는 웹브라우저 종료시 삭제) 60*5는 5분 유지 서버 브라우저 다 재실행해도 이것만 살아남음
//			c.setDomain("도메인"); //지정한 도메인과 하위 도메인으로 요청을 전송할 때만 쿠키 포함
//			c.setPath("경로");// 지정한 경로의 하위 경로로 요청을 전송할 때만 쿠키 포함 
//			c.setHttpOnly(true); //true 설정하면 자바스크립트로 쿠키 접근 불가
//			c.setSecure(true);  //true 설정하면  https://와 같은 보안프로토콜 로만 접근가능
//			c.setVersion(0); //0. 초창기 모델부터 1. 최근 쿠키로 설정  디폴트 0
			resp.addCookie(c); //응답객체 만들어서 쿠키객체가 받은걸 쿠키에 저장 / 웹브라우저가 쿠키를 저장하도록 응답에 포함 
	}
	//쿠키 확인하려면 개발자 도구 들어가서 네트워크 헤더 보면 set-cookie에 nick=R // save?nn=R&rem=on 로 나타남 
	//개발자도구 application  cookies 에서 이후 exweb 아래 어느 페이지든지 쿠키설정된걸 확인 가능하다 
	
	
	
	
resp.setContentType("text/html; charset=utf-8"); //utf-8 응답내용 쓸때 사용할 문자인코딩 방식 지정 , text/html 데이터 타입설정 
PrintWriter out = resp.getWriter(); //응답객체에 내용 쓸수잇는 writer 가져오기

out.println("<!DOCTYPE html>     ");
out.println("<html>              ");
out.println("<head>              ");
out.println("<meta charset='UTF-8'>" );
out.println("<title>HELLO</title>");
out.println("</head>             ");
out.println("<body>              ");
out.println("<h1>닉네임 세션에 저장완료</h1> ");

out.println("</body>             ");
out.println("</html>             ");

	
	}
}



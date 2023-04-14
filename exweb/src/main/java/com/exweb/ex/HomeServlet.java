package com.exweb.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

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
//(3) 서블릿컨텍스트 객체
//2. 클라이언트 (웹브라우저)에 저장
//(1)쿠기

//세이브서블릿 저장한 데이터 꺼내서 읽는거 테스트
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



	


	
	
resp.setContentType("text/html; charset=utf-8"); //utf-8 응답내용 쓸때 사용할 문자인코딩
PrintWriter out = resp.getWriter();

out.println("<!DOCTYPE html>     ");
out.println("<html>              ");
out.println("<head>              ");
out.println("<meta charset='UTF-8'>" );
out.println("<title>HOME</title>");
out.println("</head>             ");
out.println("<body>              ");
out.println("<h1>home</h1> ");
//세션객체를 가져와야 읽을수잇음 가져올떄get 집어넣을떄 set
HttpSession session = req.getSession(); //세션 가져월 세팅 
String nickName = (String) session.getAttribute("nick"); // 세션에서 닉네임 가져와 닉네임 어떤타입인지몰라서 오브젝트 저장한 사람들은 아니깐 스트링으로 강제 형변환
out.println("세션에 저장된 닉네임 :" + nickName + "<br>");

//컨텍스트객체를 가져와야 읽을수잇음 가져올떄get 집어넣을떄 set
ServletContext context = getServletContext();
String contextNick = (String) context.getAttribute("nick"); // 서블릿컨텍스트객체에서 가져와 닉네임 어떤타입인지몰라서 오브젝트 저장한 사람들은 아니깐 스트링으로 강제 형변환
out.println("서블릿컨텍스트 저장된 닉네임 :" + contextNick + "<br>");

//쿠키도 자기 브라우저만 저장함 세션, 쿠키는 브라우저별로 반영 서블릿컨텍스트는 공용
//요청헤더에 있으니깐 쿠키 헤더 가서 가져와라 그거 출력 하나의 헤더에 여러 쿠키 있어서 배열로 해서 원하는 쿠키만 꺼내는 명령어 
Cookie[] cookies = req.getCookies();
for (Cookie c : cookies) {
	if("nick".equals(c.getName()) ) { //쿠키이름이 "nick"인경우
		String v = URLDecoder.decode(c.getValue(), "UTF-8");
		out.println("쿠키에 저장된 닉네임 :" + v + "<br>"); //쿠키에 저장된 값을 출력하면 닉네임 확인가능 

	}
}

out.println("</body>             ");
out.println("</html>             ");

	
	}
}



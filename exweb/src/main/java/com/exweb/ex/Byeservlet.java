package com.exweb.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Byeservlet extends HttpServlet  {
		
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ByeServlet 실행!");

		String av = req.getParameter("user");

		
/* resp.setCharacterEncoding("utf-8"); resp.setContentType("text/html"); */
	resp.setContentType("text/html; charset=utf-8");
	PrintWriter out = resp.getWriter();
	/* out.println("Bye Bye"); */
	
out.println("<!DOCTYPE html>     ");
out.println("<html>              ");
out.println("<head>              ");
out.println("<meta charset='UTF-8'>" );
out.println("<title>HELLO</title>");
out.println("</head>             ");
out.println("<body>              ");
out.println("<h1>서블릿이 출력한 HTML</h1> ");
out.println("<h2>"+ av +"님 환영합니다 </h2>" );
/* out.println("<h2>b : "+bval+" </h2> "); */
out.println("</body>             ");
out.println("</html>             ");
	



	}

}



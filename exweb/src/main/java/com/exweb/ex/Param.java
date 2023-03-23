package com.exweb.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/param.do")
public class Param extends HttpServlet { 
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("paramServlet 실행!");

	
	req.setCharacterEncoding("UTF-8");
	String av = req.getParameter("x");
	String bv = req.getParameter("y");
	
	/* resp.setCharacterEncoding("utf-8"); resp.setContentType("text/html"); */
	resp.setContentType("text/html; charset=utf-8");
	
	

PrintWriter out = resp.getWriter();

out.println("<!DOCTYPE html>     ");
out.println("<html>              ");
out.println("<head>              ");
out.println("<meta charset='UTF-8'>" );
out.println("<title>HELLO</title>");
out.println("</head>             ");
out.println("<body>              ");
out.println("<h1>서블릿이 출력한 HTML</h1> ");
out.println("<h2>x 파라미터값 :"+ av +"</h2>" );
out.println("<h2>y 파라미터값 :"+ bv +"</h2>" );
out.println("</body>             ");
out.println("</html>             ");

	
	}
}

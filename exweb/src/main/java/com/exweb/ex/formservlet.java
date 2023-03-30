package com.exweb.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form.do")
public class formservlet extends HttpServlet{
@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("formservlet 실행!");
	

	req.setCharacterEncoding("UTF-8"); //전송요청 인코딩



String prod = req.getParameter("prod"); 
String fruit = req.getParameter("fruit");
String[] drink = req.getParameterValues("drink");





//op 파라미터값 맞는 사칙연산 수행
// 문자열 값을 동등비교하는 경우, ==연산자가 아닌 .equals() 메서드 사용 
// "문자열1" =="문자열2" (x)
// "문자열1".equals("문자열2") (o)

resp.setContentType("text/html; charset=UTF-8"); //서버에서 문서를 해석하는 타입과 인코딩 
PrintWriter out = resp.getWriter();

out.println("<!DOCTYPE html>     ");
out.println("<html>              ");
out.println("<head>              ");
out.println("<meta charset='UTF-8'>" );
out.println("<title>FoRm</title>");
out.println("</head>             ");
out.println("<body>              ");
out.println("<h1>요청주소 : "+ req.getRequestURL() + "</h1>");
out.println("<h1>요청주소 : "+ req.getRequestURI() + "</h1>");
out.println("<h1>애플리케이션 고유경로 : "+ req.getContextPath() + "</h1>");
out.println("<h1>요청방식 : "+ req.getMethod() + "</h1>");
out.println("<h1>User-Agent 요청헤더 : "+ req.getHeader("User-Agent") + "</h1>");
out.println("<h1>사용자IP주소 : "+ req.getRemoteAddr() + "</h1>");
out.println("<h1>상품 : "+ prod + "</h1>");
out.println("<img src='https://api.lorem.space/image/" +prod+ "?w=150&h=150'/>");
out.println("<h1>과일 : "+ fruit + "</h1>");
out.println("<h1>음료 :");
if(drink != null) {
for (int i = 0; i < drink.length; i++) {
	out.println("["+ drink[i] +"]");} }  //if 선택없음 실행x  for values값 배열처리
out.println("</h1>");
out.println("</body>             ");
out.println("</html>             ");

}
}

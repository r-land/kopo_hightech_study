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

@WebServlet("/calc.do")
public class CalServlet extends HttpServlet{
@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("CalServlet 실행!");
	

	req.setCharacterEncoding("UTF-8"); //전송요청 인코딩
PrintWriter out = resp.getWriter();


String aa = req.getParameter("x"); 
String bb = req.getParameter("y");
double aaa = Double.parseDouble(aa);  //실수문자열 실수 변환
double bbb = Double.parseDouble(bb);
Double result = aaa+bbb;
//op 파라미터값 맞는 사칙연산 수행
//문자열 값을 동등비교하는 경우, ==연산자가 아닌 .equals() 메서드 사용 
// "문자열1" =="문자열2" (x)
// "문자열1".equals("문자열2") (o)

resp.setContentType("text/html; charset=utf-8"); //서버에서 문서를 해석하는 타입과 인코딩 

out.println("<!DOCTYPE html>     ");
out.println("<html>              ");
out.println("<head>              ");
out.println("<meta charset='UTF-8'>" );
out.println("<title>HELLO</title>");
out.println("</head>             ");
out.println("<body>              ");
out.println("<h2>"+ aa + "+" + bb + "=" + result + "</h2>");
out.println("</body>             ");
out.println("</html>             ");

}
}

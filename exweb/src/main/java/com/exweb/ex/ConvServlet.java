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

@WebServlet("/dollar.do")
public class ConvServlet extends HttpServlet{
	
@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("ConvServlet 실행!");
	

	req.setCharacterEncoding("UTF-8"); //전송요청 인코딩



/*
 * String aa = req.getParameter("x"); 
 * String bb = req.getParameter("y");
 */
double a = Double.parseDouble(req.getParameter("x"));  //실수문자열 실수 변환
String unit = req.getParameter("unit");
double result = 0; //초기값 설정 op값 외 입력시 
String fromUnit = "";
String toUnit ="";
switch(unit) {
case "won" : result = a/1289; //원 >달러
			fromUnit = "원";
			toUnit = "달러"; break;
case "dol" :  result = a*1289; //달러>원
			  fromUnit = "달러";
			  toUnit = "원"; break;
}

/*
 * switch (unitval) { case "won" : result =fromMoney /1287; fromUnit ="원";
 * toUint = "달러"; break; case "dol" : result =fromMoney *1287;
 */



//op 파라미터값 맞는 사칙연산 수행
// 문자열 값을 동등비교하는 경우, ==연산자가 아닌 .equals() 메서드 사용 
// "문자열1" =="문자열2" (x)
// "문자열1".equals("문자열2") (o)

resp.setContentType("text/html; charset=utf-8"); //서버에서 문서를 해석하는 타입과 인코딩 
PrintWriter out = resp.getWriter();

out.println("<!DOCTYPE html>     ");
out.println("<html>              ");
out.println("<head>              ");
out.println("<meta charset='UTF-8'>" );
out.println("<title>HELLO</title>");
out.println("</head>             ");
out.println("<body>              ");
out.println("<h2>"+ a + fromUnit +" = "+ result + toUnit + "</h2>");
out.println("</body>             ");
out.println("</html>             ");

}
}

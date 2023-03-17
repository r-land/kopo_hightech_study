package com.exweb.ex;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hello.do")
public class HelloServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
System.out.println("HelloServlet 실행!");

/*  요청주소 뒤 "?파라미터명=파라미터값&파라미터명=파라미터값&...."*/
// 서블릿에는 요청객체.getparameter("파라미터명") 



service(req, resp);

}




	}



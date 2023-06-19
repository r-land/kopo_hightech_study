<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*" %>

<% 
	request.setCharacterEncoding("UTF-8");

	String bookid = request.getParameter("bookid");

	
	Class.forName("oracle.jdbc.OracleDriver"); 
	
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "madang", "madang");
	
	PreparedStatement stmt = conn.prepareStatement("DELETE FROM book WHERE bookid=?");
	
	stmt.setString(1, bookid);

	int result = stmt.executeUpdate();
	
	stmt.close();
	conn.close();
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div>
	 	<div>
	 		<h3><%= result %> 건이 삭제 되었습니다 </h3>
	 	</div>
	 	<div>
	 		<a href="list.jsp">목록</a>
	 	</div>
	</div>
</body>
</html>
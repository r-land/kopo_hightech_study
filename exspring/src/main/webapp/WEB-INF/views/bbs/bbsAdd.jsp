<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
		<!DOCTYPE html>    
		<html>             
		<head>             
		<meta charset='UTF-8'>
		<title>게시판</title>
		</head>             
		<body>        
		<jsp:include page="/WEB-INF/views/menu.jsp"/>     
		
		<!--파일을 포함하여 전송하는 form 엘리먼트는 enctype="multipart/form-data"-->
		<h1> 새글쓰기 </h1>
		<form action='${pageContext.request.contextPath}/bbs/add.do' method='post' enctype="multipart/form-data">         
		제목 : <input type='text' name='bbsTitle'  placeholder="입력하세요!" style="width:400px;height:20px;font-size:10px;" value=''/><br>        
		내용 : <textarea name="bbsContent" cols="55px" rows="5"></textarea><br>
		첨부파일1 : <input type="file" name="bbsFile"><br/>
		첨부파일2 : <input type="file" name="bbsFile"><br/>
		<input type="submit" value="업로드"/><br/>
   		                                
		</form>                                                      
                               
		</body>    
		</html>    
		
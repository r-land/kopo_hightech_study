<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
      
		<%-- <jsp:include page="/WEB-INF/views/menu.jsp"/>     --%> 
		
		<!--파일을 포함하여 전송하는 form 엘리먼트는 enctype="multipart/form-data"-->
		<h1> 새글쓰기 </h1>
		<form action='${pageContext.request.contextPath}/bbs/add.do' method='post' enctype="multipart/form-data">         
		<input type='text' name='bbsTitle'  placeholder="제목을 입력해주세요" class="form-control mt-4 mb-2" value='' required/><br>        
		
		<div class="form-group">
		<textarea class="form-control" rows="10" name="bbsContent"
			placeholder="내용을 입력해주세요" required></textarea></div>
		
		첨부파일1 : <input type="file" name="bbsFile"><br/>
		첨부파일2 : <input type="file" name="bbsFile"><br/>
		<button type="submit" class="btn btn-secondary mb-3">제출하기</button><br/>	                                
		</form>                                                      
                               

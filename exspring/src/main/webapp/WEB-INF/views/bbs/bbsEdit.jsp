<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

    
		<!DOCTYPE html>    
		<html>             
		<head>             
		<meta charset='UTF-8'>
		<jsp:include page="/WEB-INF/views/menu.jsp"/>     		
		<title>게시판</title>
		</head>             
		<body>             
		<h1> 게시글정보변경 </h1>
		<form action='${pageContext.request.contextPath}/bbs/edit.do' method='post'>  
		<input type="hidden" name='bbsNo' value="${bbsMvo.bbsNo}"/><br> 
		제목:<input type='text' name='bbsTitle' value='<c:out value="${bbsMvo.bbsTitle}"/>'/><br>        
		내용:<textarea name='bbsContent' cols="22" rows="5"><c:out value="${bbsMvo.bbsContent}"/></textarea><br>        
		작성자:<c:out value="${bbsMvo.bbsWriter}"/><br>        
		등록일:<fmt:formatDate value="${bbsMvo.bbsRegDate}" pattern="yyyy-MM-dd HH:mm:ss"/><br>  
		
		<div width: 100%, text-align: center, display:inline-block> 
		<c:forEach var="vo" items="${bbsMvo.attachList}">
			첨부파일: <a href="${pageContext.request.contextPath}/bbs/down.do?attNo=${vo.attNo}"><c:out value= "${vo.attOrgName}"/></a><br>
		</c:forEach>
		<input type='submit' value="저장"/>                                       
		<a href="${pageContext.request.contextPath}/bbs/del.do?bbsNo=${bbsMvo.bbsNo}">
		<button type='button'>삭제</button></a>
		</form>    
		<a href='${pageContext.request.contextPath}/bbs/list.do'>
		<button type='button'>목록</button></a>
		</form>  
		</div>       

		
		<div>
		<hr>
		<form action="${pageContext.request.contextPath}/reply/add.do" method="post">
			<input type="hidden" name="repBbsNo" value="${bbsMvo.bbsNo}"/><br>
			<textarea name='repContent' cols="30" rows="5"></textarea>
			<input id="repSavebtn" type="button" value="저장" />		
		</form>
		</div>               
		
		<div id="replyList"> </div>
		
		
		
		             
        <script src="${pageContext.request.contextPath}/resources/js/jquery-3.7.0.min.js"></script>        
        <script type="text/javascript">
        //"${pageContext.request.contextPath}/reply/list.do" 로 GET 방식 요청을 전송하여
        // 현재 글 에 대한 댓글들을 받아오도록 구현
function refreshReplyList(){
        	
        		$.ajax({
      			  url: "${pageContext.request.contextPath}/reply/list.do", // 요청주소
      			  method: "GET", //요청방식
      			  data: { repBbsNo : ${bbsMvo.bbsNo} }, //요청파라미터
      			  dataType: "json" //응답데이터타입
      			}).done(function( data ) { //요청 전송 후 성공적으로 응답을 받았을 때 실행
      				var listHtml = '';
      				for (var i=0; i<data.length;i++){
      					var repVo = data[i];
      					console.log( repVo.repContent, repVo.repWriter, repVo.repRegDate );
      					listHtml += '<div>' + repVo.repContent + '</div>' ;
      					listHtml += '<div>' + repVo.repWriter + '</div>' ;
      					listHtml += '<div>' + repVo.repRegDate + '</div>' ;
      					listHtml += '<div><input type="button" value="삭제"></div>' ;
      					listHtml += '<hr>';
      				}
      				console.log(listHtml);
      				$('#replyList').html(listHtml);
      			}).fail(function( jqXHR, textStatus ) { //요청 처리에 오류가 발생했을때 실행
      			  alert( "Request failed: " + textStatus );
      			});	  
		}
        
		refreshReplyList();

			$.ajax({
      			  url: "${pageContext.request.contextPath}/reply/list.do", // 요청주소
      			  method: "GET", //요청방식
      			  data: { repBbsNo : ${bbsMvo.bbsNo} }, //요청파라미터
      			  dataType: "json" //응답데이터타입
      			}).done(function( msg ) { //요청 전송 후 성공적으로 응답을 받았을 때 실행
      				console.log(msg);
   
      				
      			}).fail(function( jqXHR, textStatus ) { //요청 처리에 오류가 발생했을때 실행
      			  alert( "Request failed: " + textStatus );
      			});
		
        
        
/*         	document.getElementById('repSaveBtn').onclick = function(){}
        	document.getElementById('repSaveBtn').addEventListner('click', func) */
        	//AJAX 저장 요청 전송
        	//AJZX
        	//(1) XmlHttpRequest 객체사용
        	//(2) fetch() 함수
        	//(3) $.ajax() 메소드 
      		$('#repSavebtn').on('click', function () {
			$.ajax({
      			  url: "${pageContext.request.contextPath}/reply/add.do", // 요청주소
      			  method: "POST", //요청방식
      			  data: { repBbsNo : ${bbsMvo.bbsNo}, repContent : $('[name="repContent"]').val()}, //요청파라미터
      			  dataType: "json" //응답데이터타입
      			  //"json"으로 설정하면 ,응답으로 받은 JSON 문자열을 자바스크립트 객체로변환하여
      			  //응답처리함수(DONE())에게 인자로 전달
      			}).done(function( msg ) { //요청 전송 후 성공적으로 응답을 받았을 때 실행
      				
      				refreshReplyList()
      				//msg == '{"result":1,"ok":true}'
      				//var data = JSON.parse(msg); // json(문자열)을 자바스크립트 객체로 변환
      				//data == {result:1, ok:true}
      				alert(msg.result + "개의 댓글 저장");
      			}).fail(function( jqXHR, textStatus ) { //요청 처리에 오류가 발생했을때 실행
      			  alert( "Request failed: " + textStatus );
      			});
			});
        /* 	$('#repSaveBtn').click(function) {
			}); */
        	
        </script>               
		</body>    
		</html>    
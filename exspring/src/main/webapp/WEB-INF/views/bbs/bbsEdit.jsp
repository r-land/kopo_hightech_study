<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

    
	<!--<!DOCTYPE html>    
		<html>             
		<head>             
		<meta charset='UTF-8'> -->
		<%-- <jsp:include page="/WEB-INF/views/menu.jsp"/>  --%> 
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
		<title>게시판</title>
		</head>             
		<body>             
		<h1> 게시글정보변경 </h1>
		<form action='${pageContext.request.contextPath}/bbs/edit.do' method='post'>  
		<input type="hidden" name='bbsNo' value="${bbsMvo.bbsNo}"/><br> 
		<%-- <c:set value="${bbsMvo.bbsWriter==loginUser.memId}" var="isMine"/> --%>
		<%-- <c:set value="${pageContext.request.contextPath}" var="contextPath"/> --%>
		제목:<input <c:if test= "${bbsMvo.bbsWriter!=loginUser.memId}">readonly</c:if> type='text' name='bbsTitle' value='<c:out value="${bbsMvo.bbsTitle}"/>'/><br>        
		
		내용:<textarea ${bbsMvo.bbsWriter!=loginUser.memId?'readonly':''} name='bbsContent' cols="22" rows="5"><c:out value="${bbsMvo.bbsContent}" /></textarea><br>        
		
		작성자:<c:out value="${bbsMvo.bbsWriter}"/><br>        
		등록일:<fmt:formatDate value="${bbsMvo.bbsRegDate}" pattern="yyyy-MM-dd HH:mm:ss"/><br>  
		
		<div width: 100%, text-align: center, display:inline-block> 
		<c:forEach var="vo" items="${bbsMvo.attachList}">
			첨부파일: <a href="${pageContext.request.contextPath}/bbs/down.do?attNo=${vo.attNo}"><c:out value= "${vo.attOrgName}"/></a><br>
		</c:forEach>
		<c:if test= "${bbsMvo.bbsWriter == loginUser.memId}">
			<input class="btn btn-outline-succes" type='submit' value="저장"/>                                       
			<a id="delLink" href="${pageContext.request.contextPath}/bbs/del.do?bbsNo=${bbsMvo.bbsNo}">
			<button type='button' class="btn btn-outline-danger">삭제</button></a>    
		</c:if>
	
		
		<a href='${pageContext.request.contextPath}/bbs/list.do'>
		<button type='button'>목록</button></a>
		</form>  
		</div>       

		
		<div>
		<hr>
		<form id="replyForm" action="${pageContext.request.contextPath}/reply/add.do" method="post">
			<input type="hidden" name="repBbsNo" value="${bbsMvo.bbsNo}"/><br>
			<textarea name='repContent' cols="30" rows="5" placeholder="메시지를 입력하세요"></textarea>
			<input  class="btn btn-outline-succes" id="repSaveBtn" type="button" value="저장" />		
		</form>
		</div>               
		
		<div id="replyList"> </div>
		
		
		<template id="replyTemp">
			<div class= "repContent"></div>
			<div class= "repWriter"></div>
			<div class= "repRegDate"></div>
			<input type="button" value="삭제" class="btn btn-outline-danger delBtn" data-no="" />
			<hr>
		</template>
           
         
        <script type="text/javascript">
        	$('#delLink').on('click', function(ev){
        		var ok = confirm('삭제하시면 복구할수 없습니다. \n정말로 삭제하시겠습니까??');
        		if(!ok){ 
        		//	ev.preventDefault(); //이벤트에 대한 브라우저의 기본동작을 취소
        		return false;//이벤트 전파를 중단하고, 이벤트에대한 브라우저의 기본동작을 
        			}
        	});
        	
      //<template> 엘리먼트의 내용은 content 속성을 사용하여 접근
       var $repTemp = $(document.querySelector('#replyTemp').content);     
       
        
        //"${pageContext.request.contextPath}/reply/list.do" 로 GET 방식 요청을 전송하여
        // 현재 글 에 대한 댓글들을 받아오도록 구현
function refreshReplyList(){
		$.ajax({
		  url: "${pageContext.request.contextPath}/reply/list.do", //요청주소
		  method: "GET",	//요청방식
		  data: { repBbsNo : ${bbsMvo.bbsNo}}, 
		  dataType: "json"	//응답데이터타입
		}).done(function( data ) { // 요청 전송 후 성공적으로 응답을 받았을 때 실행
		   console.log(data);
/* 		   var listHtml = '';
		   for (var i=0; i<data.length;i++){
		   		var repVo = data[i];
		   		console.log(repVo.repContent, repVo.repWriter, repVo.repRegDate);
		   		listHtml += '<div>'+ repVo.repContent+'</div>';
		   		listHtml += '<div>'+ repVo.repWriter+'</div>' ;
		   		listHtml += '<div>'+ repVo.repRegDate+'</div>' ;
		   		if ( repVo.repWriter == '${loginUser.memId}' ){
		   			listHtml += '<div><input data-no="'+repVo.repNo+'" class="delBtn" type="button" value="삭제"></div>';
		   		}
		   		listHtml += '<hr>';
		   		
		   }
		   console.log(listHtml);
		   $('#replyList').html(listHtml); */
		   
		  
		   var listHtml = [];
		   for (var i=0; i<data.length;i++){
		   		var repVo = data[i];
		   		//console.log(repVo.repContent, repVo.repWriter, repVo.repRegDate);
		   		/* listHtml.push($('<div>').text(repVo.repContent));      //<div>repVo.repContent</div>
		   		listHtml.push($('<div>').text(repVo.repWriter));
		   		listHtml.push($('<div>').text(repVo.repRegDate)); 
		   		if ( repVo.repWriter == '${loginUser.memId}' ){
		   		  //listHtml += '<div><input data-no="'+repVo.repNo+'" class="delBtn" type="button" value="삭제"></div>';
			   		listHtml.push($('<input>').attr('data-no', repVo.repNo)
			   								  .attr('type', "button")
			   								  //.attr({'data-no': repVo.repNo, type:'button'})
			   								  .addClass('delBtn')//.attr('class', "delBtn")
			   								  .val('삭제')//.attr('value', "삭제")); 
               			);
		   		}
		   		listHtml.push($('<hr>')); */
		   		
		   		var $newRep = $repTemp.clone();
		   		$newRep.find('.repContent').text(repVo.repContent);
		   		$newRep.find('.repWriter').text(repVo.repWriter);
		   		$newRep.find('.repRegDate').text(repVo.repRegDate);
		   		if ( repVo.repWriter == '${loginUser.memId}' ){
		   			$newRep.find('.delBtn').attr('data-no', repVo.repNo);
		   		}else{
		   			$newRep.find('.delBtn').remove();
		   		}
		   		listHtml.push( $newRep );
		   	
		   } 
		   //console.log(listHtml);
		   $('#replyList').empty().append(listHtml);
		   
		   
		}).fail(function( jqXHR, textStatus ) {
		  alert( "Request failed: " + textStatus );
		});
	}
	
	
	$('#replyList').on('click', '.delBtn', function(){
		
		if(!confirm('삭제를 하면 복구할수 없습니다 정말 삭제해요?')) return;  
		
		alert('삭제!' +  $(this).attr('data-no')); 
		$.ajax({
			  url: "${pageContext.request.contextPath}/reply/del.do", //요청주소
			  method: "GET",	//요청방식
			  data: { repNo : $(this).attr('data-no')}, //요청파라미터
			  dataType: "json"	//응답데이터타입
			}).done(function( msg ) { 
				refreshReplyList();
			    alert(msg.result + "개의 댓글 삭제"); 
			}).fail(function( jqXHR, textStatus ) { 
			  alert( "Request failed: " + textStatus );
			});
	});
	
	refreshReplyList();
		
	
	

	//저장버튼을 클릭했을 때, AJAX로 댓글 저장 요청을 전송
	//AJAX
	//(1)XmlHttpRequest 객체 사용
	//(2)fetch() 함수 사용
	//(3)$.ajax() 메서드 사용
	
	$('#repSaveBtn').on('click', function() {
		$.ajax({
		  url: "${pageContext.request.contextPath}/reply/add.do", //요청주소
		  method: "POST",	//요청방식
		 // data: 'repBbsNo=${bbsMvo.bbsNo}&repContent='$('[name="repContent"]').val(), 문자형태로 (인코딩해야한다)
		  data: { repBbsNo : ${bbsMvo.bbsNo}, repContent : $('[name="repContent"]').val() }, //요청파라미터 객체형태
		 // data: $('#replyForm').serialize(), //입력요소가 많으면  파마리터 전송할때 활용할것
		  dataType: "json"	//응답데이터타입
		  // "json"으로 설정하면, 응답으로 받은 JSON 문자열을 자바스크립트 객체로 변환하여
		  //응답처리함수(done())에게 인자로 전달
		}).done(function( msg ) { // 요청 전송 후 성공적으로 응답을 받았을 때 실행
			refreshReplyList();
			//var data = JSON.parse(msg); //JSON(문자열)을 자바스크립트 객체로 변환
		  alert(msg.result + "개의 댓글 저장");
		  $('[name="repContent"]').val('');
		}).fail(function( jqXHR, textStatus ) { //요청 처리에 오류가 발생 했을때 실행
		  alert( "Request failed: " + textStatus );
		});
	});
</script>
<!-- </body>
</html> -->
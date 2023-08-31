<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- <title><tiles:getAsString name="title"/></title>-->
<title><tiles:insertAttribute name="title"/></title>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.7.0.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
  
</head>

<body>

		 <!-- tiles:insertAttribute태그를 사용하여 -->
		<!-- name 속성에 지정한 이름으로 타일즈를 통해 채워넣을 공간을 배치  -->
		<!-- attribute value가 타일즈 화면이름과 일치하는 경우 해당 화면을 주입
		attribute value가 /로 시작하는 경우 해당 경로의 템플릿 (jsp파일)주입 -->
		<!-- 그밖의 경우에는, attribute value 내용(문자열)을 그대로 주입 -->
		<div class="container">
		  <tiles:insertAttribute name="menu" />   
          <tiles:insertAttribute name="body" />        
          <tiles:insertAttribute name="footer" />
        </div>
</body>
</html>
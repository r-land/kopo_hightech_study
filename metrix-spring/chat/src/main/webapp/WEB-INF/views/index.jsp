<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="header.jsp"></jsp:include>
<script>
	const url = "ws://" + window.location.hostname + ":" + window.location.port + "/kopo/chatServer";
	
	const socket = new WebSocket(url);
	
	let connect = false;
	
	socket.onopen = () => {
		connect = true;
		alert("서버에 연결되었습니다");
	};
	
	socket.onclose = () => {
		connect = false;
		alert("서버에 연결이 종료되었습니다");
	};
	
	socket.onmessage = msg => {
		console.dir(msg);
		const chat = document.getElementById("chat"); 
		chat.innerHTML += "<li>" +msg.data + "</li>";
		
	};

	function send(){
		if(connect){
			const msg = document.getElementById("msg");
			
			socket.send(msg.value);
			
			msg.value = " "; //입력값 자동 지우기 
		}
	}
</script>
</head>
<body>
	<div class="container">
		<div>
			<ul id="chat"></ul>
		</div>
		<hr>
		<div>
			<label>메세지:</label>
			<input id="msg" type="text" size="80"/>
			<button onclick="send()">보내기</button>
		</div>
	</div>
</body>
</html>
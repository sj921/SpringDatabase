<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/resources/css/mygame.css" var="mygame_css" />
<c:url value="/resources/js/mygame.js" var="mygame_js" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Game Index</title>
<link rel="stylesheet" href="${mygame_css}" />
</head>
<body>
	
	<h3># 가위바위보 게임</h3>

	<ul>
		<li>처음 접속하는 사용자라면 사용자 이름을 먼저 입력해야 한다. (쿠키 or localStorage)</li>	
		<li>이름을 입력하거나 이미 존재하는 이름이 있다면 계속 진행할 수 있다</li>
		<li>전적은 계속 누적되며 승률도 나오고 나중에 들어와도 유지되어야 한다</li>
	</ul>
	
	<hr>

	<c:choose>
		<c:when test="${empty cookie.user.value }">
			<form action="./index" method="POST">
				<h3>이름을 설정해주세요.</h3>
				<input type="text" name="user" />
				<input type="submit" value="설정" />
			</form>		
		</c:when>
		<c:otherwise>
			<h4>${cookie.user.value } 님의 전적</h4>		
			<div id="record-panel"></div>
			<div id="computer"></div>
			<div id="message"></div>
			<div>
				<button class="decision" data-num="0">가위</button>
				<button class="decision" data-num="1">바위</button>
				<button class="decision" data-num="2">보</button>
				<button id="logout">로그아웃</button>			
			</div>
		</c:otherwise>
	</c:choose>

	<c:if test="${not empty cookie.user.value }">
		<script>
			const contextPath = '<%=request.getContextPath() %>';
			const userName = '${cookie.user.value}';
		</script>
		<script src="${mygame_js}"></script>
	</c:if>



</body>
</html>
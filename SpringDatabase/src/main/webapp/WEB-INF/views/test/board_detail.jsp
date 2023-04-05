<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h4>글 상세 정보</h4>

	<div>
		<c:forEach items="${boards }" var="board">
			<div>${board.board_id}</div>
			<div><a href="./board_modify">수정</a></div>
		</c:forEach>	
	</div>


</body>
</html>
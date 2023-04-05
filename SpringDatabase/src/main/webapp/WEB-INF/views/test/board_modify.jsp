<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="./list" method="GET">
	글쓴이 : 
	<input type="text" name="write_id" value="${board.write_id}" readonly />
	글 제목 : 
	<input type="text" name="write_title" size="60" value="${board.write_title}" /> <br>		
	글 내용 : <br>
	<textarea name="write_content" cols="60" rows="10">${board.write_content}</textarea> <br>
	<input type="hidden" name="board_id" value="${board.board_id}" />
	<input type="submit" value="Modify" />
	</form>


</body>
</html>
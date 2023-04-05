<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DB Test Index</title>
</head>
<body>

	<h3># DB Test Index</h3>

	<ul>
		<li><a href="./employees">employees 보러가기</a></li>
		<li><a href="./employees2">employees 보러가기 (Mybatis))</a></li>
		<li><a href="./board/get?board_id=14">글 하나 보기 (Mybatis)</a></li>
		<li><a href="./board/modify?board_id=87">글 수정 (Mybatis)</a></li>
		<li><a href="./board/remove?board_id=55">글 삭제 (Mybatis)</a></li>
		<li><a href="./board/list">글 전체 목록 보기</a></li>
	
	</ul>


	<!-- 
		<li><a href="./board/add?write_id=mybatis&write_pw=4321&write_title=Mybatis Test&write_content=hello!!">글 쓰기 (Mybatis)</a></li>
		<li><a href="./board/modify?write_title=modifytest&board_id=57">글 수정 (Mybatis)</a></li>

	 -->



</body>
</html>
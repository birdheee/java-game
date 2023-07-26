<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 리스트</title>
</head>
<body>
<h3>게시판 리스트</h3>
<table border="1">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성날짜</th>
		<th>수정날짜</th>
		<th>조회수</th>
	</tr>
	<tr>
	<c:forEach items="${boardInfoList}" var="boardInfo">
		<td>${boardInfo.biNum}</td>
		<td><a href="/board-info/view?biNum=${boardInfo.biNum}">${boardInfo.biTitle}</a></td>
		<td>${boardInfo.biWriter}</td>
		<td>${boardInfo.credat}</td>
		<td>${boardInfo.lmodat}</td>
		<td>${boardInfo.biCnt}</td>
	</c:forEach>
	</tr>
	<tr>
		<td colspan="6" align="right"><button>글쓰기</button></td>
	</tr>
</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
<h3>게시판</h3>
<c:forEach items="${boardInfoList}" var="boardInfo">
	${boardInfo.biNum}, 
	<a href="/board-info/view?biNum=${boardInfo.biNum}">${boardInfo.biTitle}</a>, 
	${boardInfo.biContent}, 
	${boardInfo.uiNum}, 
	${boardInfo.credat}, 
	${boardInfo.cretim}, 
	${boardInfo.lmodat}, 
	${boardInfo.lmotim}, 
	${boardInfo.active}<br>
</c:forEach>
</body>
</html>
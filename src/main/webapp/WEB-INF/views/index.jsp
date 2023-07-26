<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시작페이지</title>
</head>
<body>
<c:if test="${user!=null}">
	${user.uiName}님 안녕하세요.
	<button onclick="location.href='/user-info/logout'">로그아웃</button>
</c:if>
<c:if test="${user==null}">
	<button onclick="location.href='/user-info/login'">로그인</button>
</c:if>


</body>
</html>
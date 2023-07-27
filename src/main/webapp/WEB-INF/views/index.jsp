<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시작페이지</title>
<script src="/resources/js/bootstrap.js"></script>
<script src="/resources/js/bootstrap.bundle.js"></script>
<link rel="stylesheet" href="/resources/css/bootstrap.css">
<link rel="stylesheet" href="/resources/css/bootstrap-grid.css">
<link rel="stylesheet" href="/resources/css/bootstrap-reboot.css">
</head>
<body>
<!-- 내 세션 아이디 : <%=session.getId()%>  -->
<!-- 내 세션 타임아웃 : <%=session.getMaxInactiveInterval()%> -->
<c:if test="${user!=null}">
	<h3>${user.uiName}님 안녕하세요.</h3>
	<ul>
		<li><a href="/user-info/my"></a>내 정보</li>
		<li><a href="/board-info/list">게시판</a></li>
		<li><a href="/user-info/logout">로그아웃</a></li>
	</ul>
</c:if>
<c:if test="${user==null}">
	<button onclick="location.href='/user-info/login'">로그인</button>
</c:if><br>
</body>
</html>
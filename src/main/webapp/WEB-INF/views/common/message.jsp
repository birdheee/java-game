<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과</title>
</head>
<body>
<h3>결과</h3>

<script>
	alert('${msg}');
	location.href='${url}';
</script>
<%-- 
<div>
	${msg}
</div>
<button onclick="location.href='${url}'">확인</button>
--%>
</body>
</html>
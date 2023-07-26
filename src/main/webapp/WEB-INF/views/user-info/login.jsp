<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<h3>로그인</h3>
	<form action="/user-info/login" method="POST"> <!-- 보안 때문에 POST로 함 -->
		<input type="text" name="uiId" placeholder="ID"><br>
		<input type="password" name="uiPwd" placeholder="Password"><br>
		<button>로그인</button>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 정보 수정</title>
</head>
<body>
<h3>유저 정보 수정</h3>
<form method="POST" action="/user-info/update">
	<input type="hidden" name="uiNum" value="${userInfo.uiNum}">
	<input type="text" name="uiName" value="${userInfo.uiName}"><br>
	<input type="password" name="uiPwd" placeholder="비밀번호"><br>
	<textarea name="uiDesc" style="resize:none" cols="20" rows="10">${userInfo.uiDesc}</textarea><br>
	<input type="date" name="uiBirth" value="${userInfo.uiBirth}"><br>
	<button>수정 완료</button>
</form>
</body>
</html>
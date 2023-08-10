<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산기</title>
</head>
<body>
	<form method="GET" action="/calc">
		<input type="number" name="num1">
		<select name="op">
			<option value="+">더하기</option>
			<option value="-">빼기</option>
		</select>
		<input type="number" name="num2"><br>
		<button>계산</button>
	</form>
</body>
</html>
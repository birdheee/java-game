<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 쿠키는 브라우저에 저장됨, 세션은 브라우저를 유지하고 있을 때 하나를 저장함 --%>
<script>
	// document.cookie = 'name=haha;age=33';
	let toDay = new Date();
	toDay.setDate(toDay.getDate() + 1);
	let data = 'name==haha;path=/;expires=' + toDay.toGMTString() + ';';
	// document.cookie = data;
	console.log(document.cookie);
	console.log('hello');
</script>
</body>
</html>
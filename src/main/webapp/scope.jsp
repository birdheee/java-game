<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>SCOPE</h3>
<%
Map<String, String> map = new HashMap<>();
map.put("name", "홍길동");
map.put("age", "23");
map.put("address", "seoul");
// session.setAttribute("user", map);
%>
${user.name}
${user.age}
</body>
</html>
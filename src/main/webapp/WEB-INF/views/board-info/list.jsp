<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"/>
</head>
<body>
<div class="container">
<table class="table table-bordered">
  <thead>
    <tr>
      <th scope="col">번호</th>
      <th scope="col">제목</th>
      <th scope="col">작성자</th>
      <th scope="col">작성일</th>
    </tr>
  </thead>
  <tbody>
	  <c:forEach items="${boardInfoList}" var="boardInfo">
		<tr>
			<td>${boardInfo.biNum}</td> 
			<td><a href="/board-info/view?biNum=${boardInfo.biNum}">${boardInfo.biTitle}</a></td>
			<td>${boardInfo.uiNum}</td>
			<td>${boardInfo.credat}</td> 
		</tr>
		</c:forEach>
		<tr>
			<!-- 태그는 속성을 가질 수 있으며 무조건 String. 단, on만 script영역 -->
			<td colspan="4" align="right"><button type="button" class="btn btn-info" onclick="goPage('/board-info/insert')">글쓰기</button></td>
		</tr>
	</tbody>
</table>
</div>
<script>
	function goPage(url){
		location.href = url;
	}
</script>
</body>
</html>
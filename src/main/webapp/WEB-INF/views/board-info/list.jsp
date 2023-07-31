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
<form action="/board-info/list" method="GET">
<select name="searchType">
	<option value="1">제목</option>
	<option value="2">작성자</option>
	<option value="3">내용</option>
	<option value="4">제목+내용</option>
	<option value="5">작성자+내용</option>
	<option value="6">제목+작성자</option>
	<option value="7">제목+작성자+내용</option>
</select>
<input type="text" name="searchStr" placeholder="검색어">
<button class="btn btn-info">검색</button>
</form>
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
			<td>${boardInfo.uiName}</td>
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
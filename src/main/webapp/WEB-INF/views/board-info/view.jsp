<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 상세보기</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"/>
</head>
<body>
<div class="container">
<form method="POST" action="/board-info/delete">
<input type="hidden" name="biNum" value="${boardInfo.biNum}">
	<table class="table table-bordered">
	  <thead>
	  	<tr>
	  		<td colspan="2"><button type="button" class="btn btn-info" onclick="goPage('/board-info/list')">목록으로</button></td>
	  	</tr>
	    <tr>
	      <th scope="col">번호</th>
	      <td>${boardInfo.biNum}</td>
	    </tr>
	    <tr>
	    	<th scope="col">제목</th>
	    	<td>${boardInfo.biTitle}</td>
	    </tr>
	    <tr>
	    	<th scope="col">내용</th>
	    	<td>${boardInfo.biContent}</td>
	    </tr>
	    <tr>
	    	<th scope="col">작성자</th>
	    	<td>${boardInfo.uiNum}</td>
	    </tr>
	    <tr>
	    	<th scope="col">작성일</th>
	    	<td>${boardInfo.credat}</td>
	    </tr>
	    <c:if test="${user.uiNum == boardInfo.uiNum}">
	    <tr>
	    	<td colspan="2" align="right">
	    		<button type="button" class="btn btn-info" onclick="goPage('/board-info/update?biNum=${boardInfo.biNum}')">수정</button>
	    		<button type="submit" class="btn btn-info">삭제</button>
	    	</td>
	    </tr>
	    </c:if>
	  </thead>
	</table>
</form>
</div>
<script>
function goPage(url){
	location.href = url;
}
</script>
</body>
</html>
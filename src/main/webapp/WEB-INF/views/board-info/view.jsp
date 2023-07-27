<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 상세보기</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"/>
</head>
<body>
<h3>게시물 상세보기</h3>
<div class="container">
<table class="table table-bordered">
  <thead>
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
    <tr>
    	<td colspan="2" align="right">
    		<button type="button" class="btn btn-info">수정</button>
    		<button type="submit" class="btn btn-info">삭제</button>
    	</td>
    </tr>
  </thead>
</table>
</div>
</body>
</html>
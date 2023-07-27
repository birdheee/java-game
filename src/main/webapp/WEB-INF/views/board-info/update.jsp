<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 수정</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"/>
</head>
<body>
<h3>게시물 수정</h3>
<div class="container">
<form method="POST" action="board-info/update">
	<input type="hidden" name="biNum" value="${boardInfo.biNum}">
	<div class="form-group">
	   <label for="biTitle">글 제목</label>
	   <input type="text" class="form-control" id="biTitle" name="biTitle" value="${boardInfo.biTitle}">
	 </div>
	 <div class="form-group">
	   <label for="biContent">내용</label>
	   <textarea class="form-control" id="biContent" name="biContent">${boardInfo.biContent}</textarea>
	 </div>
	 <div align="right">
	 <button type="submit" class="btn btn-info">수정 완료</button>
	 </div>
</form>
</div>
</body>
</html>
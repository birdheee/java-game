<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 등록</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"/>
</head>
<body>
<div class="container">
<form method="POST" action="board-info/insert">
	<div class="form-group">
	   <label for="biTitle">글 제목</label>
	   <input type="text" class="form-control" id="biTitle" name="biTitle" placeholder="제목">
	 </div>
	 <div class="form-group">
	   <label for="biContent">내용</label>
	   <textarea class="form-control" id="biContent" name="biContent" placeholder="내용"></textarea>
	 </div>
	 <div align="right">
	 <button type="submit" class="btn btn-info">등록</button>
	 </div>
</form>
</div>
</body>
</html>
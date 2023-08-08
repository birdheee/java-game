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
<div class="container">
	<table class="table table-bordered">
		<tr>
	  		<td colspan="2"><button type="button" class="btn btn-info" onclick="goPage('/board-info/list')">목록으로</button></td>
	  	</tr>
	  	<tbody id="tBody">
	    <tr>
	      <th scope="col">번호</th>
	      <td id="biNum">${param.biNum}</td>
	    </tr>
	    <tr>
	    	<th scope="col">제목</th>
	    	<td id="biTitle"></td>
	    </tr>
	    <tr>
	    	<th scope="col">내용</th>
	    	<td id="biContent"></td>
	    </tr>
	    <tr>
	    	<th scope="col">작성자</th>
	    	<td id="uiName"></td>
	    </tr>
	    <tr>
	    	<th scope="col">작성일</th>
	    	<td id="credat"></td>
	    </tr>
	    <tr>
	    	<td colspan="2" align="right">
	    		<button type="button" class="btn btn-info" onclick="goPage('/board-info/update?biNum=${boardInfo.biNum}')">수정</button>
	    		<button type="submit" class="btn btn-info">삭제</button>
	    	</td>
	    </tr>
	  </tbody>
	</table>
</div>
<script>
	function goPage(url){
		location.href = url;
	}
	const loadFunc = function(){
		const xhr = new XMLHttpRequest();
		xhr.open('GET', '/json/one?biNum=${param.biNum}');
		xhr.onreadystatechange = function(){
			if(xhr.readyState === 4){
				if(xhr.status === 200){
					const board = JSON.parse(xhr.responseText);
					for(let key in board){ // 없는 키 값 찾지 않도록
						if(document.querySelector('#' + key)){
							document.querySelector('#' + key).innerText = board[key];
						}
					}
				}
			}
		}
		xhr.send();
	}
	window.addEventListener('load', loadFunc);
</script>
</body>
</html>
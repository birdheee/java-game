<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"/>
</head>
<body>
<div class="container">
	<select name="searchType" id="searchType">
		<option value="1">제목</option>
		<option value="2">작성자</option>
		<option value="3">내용</option>
		<option value="4">제목+내용</option>
		<option value="5">작성자+내용</option>
		<option value="6">제목+작성자</option>
		<option value="7">제목+작성자+내용</option>
	</select>
	<input type="text" name="searchStr" placeholder="검색어" id="searchStr">
	<button class="btn btn-info" onclick="loadFunc()">검색</button>
	<table class="table table-bordered">
	  <thead>
	    <tr>
	      <th scope="col">번호</th>
	      <th scope="col">제목</th>
	      <th scope="col">작성자</th>
	      <th scope="col">작성일</th>
	    </tr>
	  </thead>
	  <tbody id="tbody">
	  </tbody>
	  <tr>
	  	<!-- 태그는 속성을 가질 수 있으며 무조건 String. 단, on만 script영역 -->
	  	<td colspan="4" align="right"><button type="button" class="btn btn-info" onclick="goPage('/board-info/insert')">글쓰기</button></td>
	  </tr>
	</table>
</div>
<script>
	function goPage(url){
		lacation.href = url;
	}
	const loadFunc = function(){
		const xhr = new XMLHttpRequest();
		const searchStr = document.querySelector('#searchStr');
		const searchType = document.querySelector('#searchType');
		let url = '/json/list?';
		if(searchStr.value!==''){
			url += 'searchType=' + searchType.value + '&searchStr=' + searchStr.value;
		}
		xhr.open('GET', url);
		xhr.onreadystatechange = function(){
			if(xhr.readyState === 4){
				if(xhr.status === 200){
					const list = JSON.parse(xhr.responseText);
					let html = '';
					for(const board of list){
						html += '<tr>';
						html += '<td>' + board.biNum + '</td>';
						html += '<td>' + board.biTitle + '</td>';
						html += '<td>' + board.uiName + '</td>';
						html += '<td>' + board.credat + '</td>';
						html += '</tr>';
					}
					document.querySelector('#tbody').innerHTML = html;
				}
			}
		}
		xhr.send();
	}
	window.addEventListener('load', loadFunc);
</script>
</body>
</html>
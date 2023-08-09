<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>쿠키런 킹덤 캐릭터 게시판</title>
	<jsp:include page="/WEB-INF/views/common/head.jsp"/>
	<style>
		h3{
			margin-top:80px;
			margin-bottom:80px;
			text-align:center;
		}
	</style>
</head>
<body>
<div class="container">
	<h3>쿠키런 킹덤 캐릭터 게시판</h3>
	<select name="searchType" id="searchType">
		<option value="1">이름</option>
		<option value="2">유형</option>
		<option value="3">포지션</option>
		<option value="4">등급</option>
		<option value="5">개요</option>
	</select>
	<input type="text" name="searchStr" placeholder="검색어" id="searchStr">
	<button class="btn btn-info" onclick="loadFunc()">검색</button>
	<table class="table table-bordered">
	  <thead>
	    <tr>
	      <th scope="col">번호</th>
	      <th scope="col">이름</th>
	      <th scope="col">유형</th>
	      <th scope="col">포지션</th>
	      <th scope="col">등급</th>
	      <th scope="col">출시일</th>
	    </tr>
	  </thead>
	  <tbody id="tBody">
	  </tbody>
	  <tr>
	  	<!-- 태그는 속성을 가질 수 있으며 무조건 String. 단, on만 script영역 -->
	  	<td colspan="6" align="right"><button type="button" class="btn btn-info" onclick="goPage('/cookie-info/insert')">캐릭터 등록</button></td>
	  </tr>
	</table>
</div>
<script>
	function goPage(url){
		location.href = url;
	}
	const loadFunc = function(){
		const xhr = new XMLHttpRequest();
		const searchStr = document.querySelector('#searchStr');
		const searchType = document.querySelector('#searchType');
		let url = '/cookie-info/list?';
		if(searchStr.value!==''){
			url += 'searchType=' + searchType.value + '&searchStr=' + searchStr.value;
		}
		xhr.open('GET', url);
		xhr.onreadystatechange = function(){
			if(xhr.readyState === 4){
				if(xhr.status === 200){
					const list = JSON.parse(xhr.responseText);
					console.log(list);
					let html = '';
					for(const cookie of list){
						html += '<tr>';
						html += '<td>' + cookie.ciNum + '</td>';
						html += '<td><a href="/views/cookie-info/view?ciNum=' + cookie.ciNum + '">' + cookie.ciName + '</td>';
						html += '<td>' + cookie.ciType + '</td>';
						html += '<td>' + cookie.ciPos + '</td>';
						html += '<td>' + cookie.ciGrade + '</td>';
						html += '<td>' + cookie.ciBirth + '</td>';
						html += '</tr>';
					}
					document.querySelector('#tBody').innerHTML = html;
				}
			}
		}
		xhr.send();
	}
	window.addEventListener('load', loadFunc);
</script>
</body>
</html>
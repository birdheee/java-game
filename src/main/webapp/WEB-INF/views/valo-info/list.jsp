<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>발로란트 캐릭터 리스트</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"/>
</head>
<body>
<div class="container">
	<select name="searchType" id="searchType">
		<option value="1">이름</option>
		<option value="2">포지션</option>
		<option value="3">국적</option>
		<option value="4">개요</option>
	</select>
	<input type="text" name="searchStr" placeholder="검색어" id="searchStr">
	<button class="btn btn-info" onclick="loadFunc()">검색</button>
	<table class="table table-bordered">
	  <thead>
	    <tr>
	      <th scope="col">번호</th>
	      <th scope="col">이름</th>
	      <th scope="col">포지션</th>
	      <th scope="col">국적</th>
	    </tr>
	  </thead>
	  <tbody id="tbody">
	  </tbody>
	  <tr>
	  	<!-- 태그는 속성을 가질 수 있으며 무조건 String. 단, on만 script영역 -->
	  	<td colspan="4" align="right"><button type="button" class="btn btn-info" onclick="goPage('/valo-info/insert')">캐릭터 등록</button></td>
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
		let url = '/valo-info/list?';
		if(searchStr.value!==''){
			url += 'searchType=' + searchType.value + '&searchStr=' + searchStr.value;
		}
		xhr.open('GET', url);
		xhr.onreadystatechange = function(){
			if(xhr.readyState === 4){
				if(xhr.status === 200){
					const list = JSON.parse(xhr.responseText);
					let html = '';
					for(const valo of list){
						html += '<tr>';
						html += '<td>' + valo.viNum + '</td>';
						html += '<td><a href="/views/valo-info/view?viNum=' + valo.viNum + '">' + valo.viName + '</td>';
						html += '<td>' + valo.viPosition + '</td>';
						html += '<td>' + valo.viNation + '</td>';
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
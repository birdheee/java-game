<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>과목 게시판</title>
	<jsp:include page="/WEB-INF/views/common/head.jsp"/>
	<style>
		h2{
			margin-top:80px;
			margin-bottom:80px;
			text-align:center;
		}
		.search{
			float:right;
		}
	</style>
</head>
<body>
<div class="container">
	<h2>과목 게시판</h2>
	<div class="search">
		<select name="searchType" id="searchType">
			<option value="1">과목 이름</option>
			<option value="2">담당 교수</option>
			<option value="3">이수 구분</option>
			<option value="4">강의실</option>
		</select>
		<input type="text" name="searchStr" placeholder="검색어" id="searchStr">
		<button class="btn btn-primary" onclick="loadFunc()">검색</button>
	</div>
	<table class="table table-bordered">
	  <thead>
	    <tr>
	      <th scope="col">번호</th>
	      <th scope="col">과목 코드</th>
	      <th scope="col">과목 이름</th>
	      <th scope="col">담당 교수</th>
	      <th scope="col">이수 구분</th>
	      <th scope="col">학점</th>
	      <th scope="col">강의실</th>
	    </tr>
	  </thead>
	  <tbody id="tBody">
	  </tbody>
	  <tr>
	  	<!-- 태그는 속성을 가질 수 있으며 무조건 String. 단, on만 script영역 -->
	  	<td colspan="7" align="right"><button type="button" class="btn btn-primary" onclick="goPage('/lecture-info/insert')">과목 등록</button></td>
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
		let url = '/lecture-info/list?';
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
					for(const lecture of list){
						html += '<tr>';
						html += '<td>' + lecture.liNum + '</td>';
						html += '<td>' + lecture.liCode + '</td>';
						html += '<td><a href="/views/lecture-info/view?liNum=' + lecture.liNum + '">' + lecture.liName + '</td>';
						html += '<td>' + lecture.liPro + '</td>';
						html += '<td>' + lecture.liClass + '</td>';
						html += '<td>' + lecture.liGrades + '</td>';
						html += '<td>' + lecture.liRoom + '</td>';
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
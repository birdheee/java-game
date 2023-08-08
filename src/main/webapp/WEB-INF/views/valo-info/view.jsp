<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>캐릭터 상세보기</title>
	<jsp:include page="/WEB-INF/views/common/head.jsp"/>
	<style>
		th{
			width:80px;
		}
	</style>
</head>
<body>
<div class="container">
	<table class="table table-bordered">
		<tr>
	  		<td colspan="2"><button type="button" class="btn btn-info" onclick="goPage('/views/valo-info/list')">목록으로</button></td>
	  	</tr>
	  	<tbody id="tBody">
	    <tr>
	      <th scope="col">번호</th>
	      <td id="viNum">${param.viNum}</td>
	    </tr>
	    <tr>
	    	<th scope="col">이름</th>
	    	<td id="viName"></td>
	    </tr>
	    <tr>
	    	<th scope="col">포지션</th>
	    	<td id="viPosition"></td>
	    </tr>
	    <tr>
	    	<th scope="col">국적</th>
	    	<td id="viNation"></td>
	    </tr>
	    <tr>
	    	<th scope="col">개요</th>
	    	<td id="viDesc"></td>
	    </tr>
	    <tr>
	    	<td colspan="2" align="right">
	    		<button type="button" class="btn btn-info" onclick="goPage('/valo-info/update?viNum=${param.viNum}')">캐릭터 수정</button>
	    		<button type="submit" class="btn btn-info">캐릭터 삭제</button>
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
		xhr.open('GET', '/valo-info/view?viNum=${param.viNum}');
		xhr.onreadystatechange = function(){
			if(xhr.readyState === 4){
				if(xhr.status === 200){
					const valo = JSON.parse(xhr.responseText);
					for(let key in valo){
						if(document.querySelector('#' + key)){
							document.querySelector('#' + key).innerText = valo[key];
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
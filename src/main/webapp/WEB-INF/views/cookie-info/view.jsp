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
	  		<td colspan="2"><button type="button" class="btn btn-info" onclick="goPage('/views/cookie-info/list')">목록으로</button></td>
	  	</tr>
	  	<tbody id="tBody">
	    <tr>
	      <th scope="col">번호</th>
	      <td id="ciNum">${param.ciNum}</td>
	    </tr>
	    <tr>
	    	<th scope="col">이름</th>
	    	<td id="ciName"></td>
	    </tr>
	    <tr>
	    	<th scope="col">유형</th>
	    	<td id="ciType"></td>
	    </tr>
	    <tr>
	    	<th scope="col">포지션</th>
	    	<td id="ciPos"></td>
	    </tr>
	    <tr>
	    	<th scope="col">등급</th>
	    	<td id="ciGrade"></td>
	    </tr>
	    <tr>
	    	<th scope="col">출시일</th>
	    	<td id="ciBirth"></td>
	    </tr>
	    <tr>
	    	<th scope="col">스킬</th>
	    	<td id="ciSkill"></td>
	    </tr>
	    <tr>
	    	<th scope="col">개요</th>
	    	<td id="ciDesc"></td>
	    </tr>
	    <tr>
	    	<td colspan="2" align="right">
	    		<button type="button" class="btn btn-info" onclick="goPage('/cookie-info/update?ciNum=${param.ciNum}')">캐릭터 수정</button>
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
		xhr.open('GET', '/cookie-info/view?ciNum=${param.ciNum}');
		xhr.onreadystatechange = function(){
			if(xhr.readyState === 4){
				if(xhr.status === 200){
					const cookie = JSON.parse(xhr.responseText);
					for(let key in cookie){
						if(document.querySelector('#' + key)){
							document.querySelector('#' + key).innerText = cookie[key];
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
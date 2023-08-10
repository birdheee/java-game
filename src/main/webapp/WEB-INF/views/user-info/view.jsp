<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>유저 상세보기</title>
	<jsp:include page="/WEB-INF/views/common/head.jsp"/>
	<style>
		th{
			width:100px;
		}
	</style>
</head>
<body>
<div class="container">
	<table class="table table-bordered">
		<tr>
	  		<td colspan="2"><button type="button" class="btn btn-info" onclick="goPage('/user-info/list')">목록으로</button></td>
	  	</tr>
	  	<tbody id="tBody">
	    <tr>
	      <th scope="col">번호</th>
	      <td id="uiNum">${param.viNum}</td>
	    </tr>
	    <tr>
	    	<th scope="col">아이디</th>
	    	<td id="uiId"></td>
	    </tr>
	    <tr>
	    	<th scope="col">패스워드</th>
	    	<td id="uiPwd"></td>
	    </tr>
	    <tr>
	    	<th scope="col">이름</th>
	    	<td id="uiName"></td>
	    </tr>
	    <tr>
	    	<th scope="col">생년월일</th>
	    	<td id="uiBirth"></td>
	    </tr>
	    <tr>
	    	<th scope="col">소개</th>
	    	<td id="uiDesc"></td>
	    </tr>
	    <tr>
	    	<th scope="col">가입일</th>
	    	<td id="credat"></td>
	    </tr>
	    <tr>
	    	<td colspan="2" align="right">
	    		<button type="button" class="btn btn-info" onclick="goPage('/user-info/update?viNum=${param.uiNum}')">수정</button>
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
		xhr.open('GET', '/user-info/view?uiNum=${param.uiNum}');
		xhr.onreadystatechange = function(){
			if(xhr.readyState === 4){
				if(xhr.status === 200){
					const user = JSON.parse(xhr.responseText);
					for(let key in user){
						if(document.querySelector('#' + key)){
							document.querySelector('#' + key).innerText = user[key];
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름 : <input type="text" id="name"><br>
	아이디 : <input type="text" id="id"><br>
	비밀번호 : <input type="password" id="pwd"><br>
	자기소개 : <textarea id="desc"></textarea><br>
	성별 : <input type="radio" name="trans" value="남">남
	<input type="radio" name="trans" value="여">여<br>
	직업 : 
	<select id="job">
		<option value="">선택</option>
		<option value="개발자">개발자</option>
		<option value="백수">백수</option>
	</select><br>
	<button onclick="getInfo()">저장</button><br>
	결과 : <span id="result"></span>
<script>
	function getInfo(){
		const param = {
				name : document.querySelector('#name').value,
				id : document.querySelector('#id').value,
				pwd : document.querySelector('#pwd').value,
				desc : document.querySelector('#desc').value,
				trans : document.querySelector('[name=trans]:checked').value,
				job : document.querySelector('#job').value
		}
		const json = JSON.stringify(param);
		const xhr = new XMLHttpRequest();
		xhr.open('POST', '/input');
		xhr.setRequestHeader('Content-Type', 'application/json');
		xhr.onreadystatechange = function(){
			if(xhr.readyState === 4){
				if(xhr.status === 200){
					document.querySelector('#result').innerText = xhr.responseText;
				}
			}
		}
		xhr.send(json);
	}
</script>
</body>
</html>
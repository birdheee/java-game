<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	번호 : ${param.num}
	이름 : <input type="text" id="name"><br>
	나이 : <input type="text" id="age"><br>
	주소 : <input type="text" id="address"><br>
	<button onclick="sendObj()">수정 완료</button>
<script>
	function sendObj(){
		const param = {
				num : ${param.num},
				name : document.querySelector('#name').value,
				age : document.querySelector('#age').value,
				address : document.querySelector('#address').value
		}
		const json = JSON.stringify(param); // JSON으로 변환
		const xhr = new XMLHttpRequest();
		xhr.open('POST', '/list/update?num=${param.num}');
		xhr.setRequestHeader('Content-Type','application/json'); // 디폴트가 form임. 무슨 형태인지 알려줘야 함
		xhr.onreadystatechange = function(){
			if(xhr.readyState === 4){
				if(xhr.status === 200){
					const obj = JSON.parse(xhr.responseText);
					for(const key in obj){
						if(document.querySelector('#' + key)){
							document.querySelector('#' + key).value = obj[key];
						}
					}
					if(xhr.responseText === '1'){
						alert('정상 수정 되었습니다.');
						location.href = '/views/list';
					}else{
						alert('오류가 발생하였습니다. 다시 시도해주세요.');
					}
				}
			}
		}
		xhr.send(json);
	}
</script>
</body>
</html>
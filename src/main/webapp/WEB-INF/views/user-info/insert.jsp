<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 등록</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"/>
</head>
<body>
<div class="container">
	<div class="form-group">
	   <label for="uiName">이름</label>
	   <input type="text" class="form-control" id="uiName" name="uiName" placeholder="이름">
	 </div>
	 <div class="form-group">
	   <label for="uiId">아이디</label>
	   <input type="text" class="form-control" id="uiId" name="uiId" placeholder="아이디">
	 </div>
	 <div class="form-group">
	   <label for="uiPwd">패스워드</label>
	   <input type="password" class="form-control" id="uiPwd" name="uiPwd" placeholder="패스워드">
	 </div>
	 <div class="form-group">
	   <label for="uiBirth">생년월일</label>
	   <input type="date" class="form-control" id="uiBirth" name="uiBirth">
	 </div>
	 <div class="form-group">
	   <label for="uiDesc">소개</label>
	   <textarea class="form-control" id="uiDesc" name="uiDesc" placeholder="소개"></textarea>
	 </div>
	 <div align="right">
	 <button class="btn btn-info" onclick="sendObj()">등록</button>
	 </div>
</div>
<script>
	function sendObj(){
		const param = {
				uiName = document.querySelector('#uiName').value,
				uiId = document.querySelector('#uiId').value,
				uiPwd = document.querySelector('#uiPwd').value,
				uiBirth = document.querySelector('#uiBirth').value,
				uiDesc = document.querySelector('#uiDesc').value,
		}
		const json = JSON.stringify(param);
		const xhr = new XMLHttpRequest();
		xhr.open('POST', 'user-info/insert');
		xhr.setRequestHeader('Content-Type', 'application/json');
		xhr.onreadystatechange = function(){
			if(xhr.readyState === 4){
				if(xhr.status === 200){
					if(xhr.responseText === '1'){
						alert('정상 등록 되었습니다.');
					}else{
						alert('오류가 발생했습니다. 다시 시도해주세요.');
					}
				}
			}
		}
		xhr.send(json);
	}
</script>
</body>
</html>
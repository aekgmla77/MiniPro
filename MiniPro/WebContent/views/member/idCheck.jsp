<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중복 확인</title>
<script type="text/javascript">
	function formClose() {
		if(${check }) {
			window.opener.document.getElementById("mPassword").focus();
			// 사용할 수 있는 아이디는 패스워드로 보내기
		}else {
			window.opener.document.getElementById("mId").value="";
			window.opener.document.getElementById("mId").focus();
		}
		window.close();
	}
</script>
</head>
<body>
	<div align="center">
		<h3>${msg }</h3>${check }
		<button type="button" onclick="formClose(${check })">확인</button>
	</div>
</body>
</html>
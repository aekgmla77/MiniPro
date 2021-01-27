<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 form</title>
<script type="text/javascript">
	function formCheck() {
		
		if(frm.mPassword.value != frm.mPassword1.value){
			alert("패스워드가 일치하지 않습니다.")
			frm.mPassword1.value = null;
			frm.mPassword1.focus();
			return ture;
		}
		return false;
	}
	
	function idCheck(str) {
		var url = "idCheck.do?mid="+str;
		if(str == ""){
			alert("아이디를 입력하세요.");
			frm.mId.focus();
		}else {
			window.open(url, "아이디 중복확인", "width=300, height=300,top=100, left=100");
		}
	}
</script>
</head>
<jsp:include page="../common/menu.jsp"></jsp:include>
<body>
<div align="center"><h1>회 원 가 입</h1></div><br/>
	<div align="center">
		<form id = "frm" name="frm" onsubmit="formCheck()" action="memberJoin.do" method="post">
			<div>
				<table border="1">
					<tr>
						<th>아 이 디</th>
						<td><input type="text" id="mId" name="mId" size="20" required="required">&nbsp;
						<button type="button" onclick="idCheck(mId.value)">중복확인</button></td>
					<tr>	
					<tr>
						<th>비밀번호</th>
						<td><input type="password" id="mPassword" name="mPassword" size="31" required="required"></td>
					<tr>
					<tr>
						<th>비밀번호 확인</th>
						<td><input type="password" id="mPassword1" name="mPassword1" size="31" required="required"></td>
					<tr>
					<tr>
						<th>이 름</th>
						<td><input type="text" id="mName" name="mName" size="31" required="required"></td>
					<tr>
				</table>
			</div><br/>
			<div>
				<input type="submit" value="회원가입">&nbsp;&nbsp;&nbsp;
				<input type="reset" value="취소">
			</div>
		</form>
	</div>
</body>
</html>
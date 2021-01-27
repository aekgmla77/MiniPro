<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="../common/menu.jsp"></jsp:include>
<body>
<div align="center">
	<div>
		<h3>${vo.mName }님 ${vo.mId }로 회원가입 성공하셨습니다.</h3>
	</div>
	<div>
		<button type="button" onclick="location.href='loginForm.do'">로그인</button>
	</div>
</div>
</body>
</html>
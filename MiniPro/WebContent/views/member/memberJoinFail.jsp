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
		<h3>${vo.mId } 님 회원가입 실패하셨습니다.</h3>
	</div>
	<div>
		<button type="button" onclick="location='memberJoinForm.do'">가입 창</button>
	</div>
</div>
</body>
</html>
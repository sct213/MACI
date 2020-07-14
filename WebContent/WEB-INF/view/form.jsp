<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/doPost.do" method="post"> 
	<!--  action의 주소를 doPost.do로 잡으므로써 연결성을 부여한다.  -->
		이름: <input type="text" name="name">
		<br>
		<input type="submit">
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello</title>
</head>
<body>
	<%for(int i=0; i<5; i++){ %>
	
	<p><%=i %>번째 줄입니다.</p>
	
	<%} %>
</body>
</html>
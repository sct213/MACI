<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테이블</title>
</head>
<body>
	<table border="1">
		<% for(int i=0; i<3; i++) { %>
		<tr>
		<% for(int j=0; j<4; j++){ %>
		<td><%=i %>행 <%=j %>열</td>
	<%} %>
	</tr>
<%} %>
	</table>
</body>
</html>
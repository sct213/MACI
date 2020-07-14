<%@page import="poly.util.CmmUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String name = CmmUtil.nvl((String)request.getAttribute("name")); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%if(name=="양원석"){%>
	반갑습니다, <%=name %>님.
	<%} %><%else { %>
	다른 이름을 입력하셨군요.
	<%} %>
	</body>
</html>
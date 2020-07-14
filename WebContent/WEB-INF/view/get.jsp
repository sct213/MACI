<%@page import="poly.util.CmmUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%	// Ctrl + Space : 자동으로 import 
    	String name = CmmUtil.nvl((String)request.getAttribute("name"));
    %>	<!--  object로 들어갔기 때문에 형변환을 해줘야함 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	안녕하세요, <%= name %>님!
</body>
</html> 
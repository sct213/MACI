<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="poly.util.CmmUtil" %>
<%
	String res = CmmUtil.nvl((String) request.getAttribute("res"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지로부터 텍스트 인식 결과</title>
</head>
<body>
	<h2>이미지 인식 결과</h2>
	<hr />
	이미지로부터 텍스트 인식 결과는 <%=res %> 입니다.
</body>
</html>
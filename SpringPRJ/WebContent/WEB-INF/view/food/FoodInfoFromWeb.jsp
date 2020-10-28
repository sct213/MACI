<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="poly.util.CmmUtil" %>
<%
	String res = CmmUtil.nvl((String)request.getAttribute("res"),"0");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>폴리텍 식단 정보</title>
</head>
<body>
서울강서캠퍼스 식단홈페이지에서 <%=res %>개의 식단 정보가 수집되었습니다. 
</body>
</html>
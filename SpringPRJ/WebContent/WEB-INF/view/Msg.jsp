<%@page import="poly.dto.UserInfoDTO"%>
<%@page import=" static poly.util.CmmUtil.nvl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

String msg = nvl((String)request.getAttribute("msg"));

UserInfoDTO pDTO = (UserInfoDTO)request.getAttribute("pDTO");

if(pDTO==null){
	pDTO = new UserInfoDTO();
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입을 축하드립니다</title>
<script type="text/javascript">
	alert("<%=msg%>");
</script>
</head>
<body>
<%=nvl(pDTO.getUser_name()) %>님의 회원가입을 축하합니다.
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page errorPage="error.jsp" %>

<%
	//1. 브라우저에 연결된 세션 객체 종료
	session.invalidate();
	
	//2. 세션 종료 후 로그인 페이지로 이동시킨다.
	response.sendRedirect("login.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
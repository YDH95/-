<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page errorPage="error.jsp" %>

<%
	//1. �������� ����� ���� ��ü ����
	session.invalidate();
	
	//2. ���� ���� �� �α��� �������� �̵���Ų��.
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
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <!-- ������  error.jsp�� �̵�-->
<%@ page errorPage="error.jsp" %>
<%@ page import="board.BoardDO" %>
<%@ page import="board.BoardDAO" %>

<%

	String seq = request.getParameter("seq");
	System.out.println("seq��"+seq);
	BoardDO boardDO = new BoardDO();
	boardDO.setSeq(Integer.parseInt(seq));
	
	BoardDAO boardDAO = new BoardDAO();
	boardDAO.deleteBoard(boardDO);
	response.sendRedirect("getBoardList.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�Խñ� ���� ��Ʈ�ѷ�</title>
</head>
<body>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ page import="board.BoardDAO" %> 
<%@ page import="board.BoardDO" %>

<%
	request.setCharacterEncoding("UTF-8");	

	String seq = request.getParameter("seq");
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	
	BoardDO boardDO= new BoardDO();
	boardDO.setSeq(Integer.parseInt(seq));
	boardDO.setTitle(title);
	boardDO.setWriter(writer);
	boardDO.setContent(content);
	
	BoardDAO boardDAO = new BoardDAO();
	boardDAO.updateBoard(boardDO);
	
	//������
	response.sendRedirect("getBoardList.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�Խñ� ����</title>
</head>
<body>
	
</body>
</html>
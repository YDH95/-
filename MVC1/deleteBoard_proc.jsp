<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <!-- 에러시  error.jsp로 이동-->
<%@ page errorPage="error.jsp" %>
<%@ page import="board.BoardDO" %>
<%@ page import="board.BoardDAO" %>

<%

	String seq = request.getParameter("seq");
	System.out.println("seq는"+seq);
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
<title>게시글 삭제 컨트롤러</title>
</head>
<body>

</body>
</html>
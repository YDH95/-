<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <!-- 에러시  error.jsp로 이동-->
<%@ page errorPage="error.jsp" %>
<%@ page import="board.BoardDO" %>
<%@ page import="board.BoardDAO" %>
<%
	request.setCharacterEncoding("UTF-8");
	
	//입력 폼에서 넘어온 사용자 입력 정보 추출
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	System.out.println(title+" "+writer+" "+content); //콘솔 창으로 출력 확인.
	//2.BoardDO 클래스 객체 생성하여 입력 값들을 필드(중간저장소)에 저장(초기화)한다.
	BoardDO boardDO = new BoardDO();
	boardDO.setTitle(title);
	boardDO.setWriter(writer);
	boardDO.setContent(content);
	
	//3. BoardDAO 클래스 객체 생성 후 '게시글 등록' 메소드 호출
	BoardDAO boardDAO = new BoardDAO();
	boardDAO.insertBoard(boardDO);
	
	//포워딩
	response.sendRedirect("getBoardList.jsp");
	
	
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
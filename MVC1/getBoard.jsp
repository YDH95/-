<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <!-- 에러시  error.jsp로 이동-->
<%@ page errorPage="error.jsp" %>
<%@ page import="board.BoardDO" %>
<%@ page import="board.BoardDAO" %>

<%
	request.setCharacterEncoding("UTF-8");	
	//1. '전체 게시글 목록보기' 페이지 폼에서 '제목' 클릭했을 때 너머온 
	//상세 보기할 게시글번호 추출하기
	String seq = request.getParameter("seq");

	//2. BoardDO클래스 객체 생성
	BoardDO boardDO = new BoardDO();
	boardDO.setSeq(Integer.parseInt(seq));
	
	//3. BoardDAO클래스 개체 생성 후'게시글 상세보기'메소드 호출
	BoardDAO boardDAO = new BoardDAO();
	BoardDO board = boardDAO.getBoard(boardDO);
	
	request.setAttribute("board", board);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
.header {
  background-color: #f1f1f1;
  padding: 20px;
  text-align: center;
}

body {
  margin: 0;
}
</style>
</head>
<body>
	<div class="header">
		<h1>게시글 상세보기 페이지</h1>
	</div>
	<form action="updateBoard_proc.jsp" method="POST" name="displayForm">
		<input type="hidden" name="seq" value="${ board.seq }">
		<table>
			<tr>
				<td>제목</td>
				<td>
					<input type="text" name="title" value="${ board.title }">
				</td>
			</tr>
			
			<tr>
				<td>작성자</td>
				<td>
					<input type="text" name="writer" value="${  board.writer }">
				</td>
			</tr>
			
			<tr>
				<td>내용</td>
				<td>
					<textarea rows="20" cols="70" name="content">${ board.content }</textarea>
				</td>
			</tr>
			<tr>
				<td>등록일</td>
				<td>${  board.regDate }</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${  board.cnt }</td>
			</tr>		
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="글 수정">
				</td>
			</tr>
		</table>
		<hr>
		<a href="insertBoard.jsp">새 게시글 등록</a>&nbsp;&nbsp;
		<a href="deleteBoard_proc.jsp?seq=${board.seq}">게시글 삭제</a>&nbsp;&nbsp;
		<a href="getBoardList.jsp" class="btn">전체 게시글 목록 보기</a>
	</form>
</body>
</html>
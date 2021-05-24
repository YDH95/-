<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <!-- 에러시  error.jsp로 이동-->
<%@ page errorPage="error.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
	<form action="updateBoard.do" method="POST" name="displayForm">
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
		<a href="deleteBoard.do?seq=${board.getSeq()}">게시글 삭제</a>&nbsp;&nbsp;
		<a href="getBoardList.do" class="btn">전체 게시글 목록 보기</a>
	</form>
</body>
</html>
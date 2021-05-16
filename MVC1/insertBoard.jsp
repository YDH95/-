<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!-- 에러시  error.jsp로 이동-->
<%@ page errorPage="error.jsp" %>
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

\
</style>
</head>
<body>

	<div class="header">
		<h1>게시글 등록</h1>
	</div>
	<div align="center">
	<hr>
	<form action="insertBoard_proc.jsp" method="POST" name="insertForm">
		<table  border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td width="70">제목</td>
				<td align="left">
					<input type="text" name="title" required="required">					
				</td>
			</tr>
			<tr>
				<td width="70">작성자</td>
				<td align="left">
					<input type="text" name="writer" required="required" >					
				</td>
			</tr>
			
			<tr>
				<td>내용</td>
				<td align="left">
					<textarea rows="40" cols="90" name="content" required="required" minlength="1"></textarea>
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="글 등록">
				</td>
			</tr>
		</table>
	</form>
	<hr>
	<a href="getBoardList.jsp">전체 게시글 목록 보기</a>
</div>
</body>
</html>
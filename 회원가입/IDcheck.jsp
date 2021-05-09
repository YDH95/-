<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- 추가 -->

<%  // 한글 인코딩 처리
	request.setCharacterEncoding("EUC-KR");
%>
<!--jsp:useBean id="빈이름" class="자바빈 클래스 이름" scope="범위"/>
	useBean은 자바빈 객체를 생성하는 액션태그이다. -->
<jsp:useBean id="user" scope="page" class="DB.DBBean"></jsp:useBean>


<% //스크립트릿 안에는 자바 코드 기술 
	String user_id = request.getParameter("user_id");
	String user_pw = request.getParameter("user_ipw");
	int idCheck = user.confirmId(user_id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>idCheck.jsp 페이지</title>

</head>
<body>
	<table style="text-align: center;" > 
		<tr>
			<td align="center">
				<%
					if(idCheck == 1){ //ID가 중복인 경우
				%>
				<br>
				<%= user_id %> 는 이미 존재하는 ID입니다.&nbsp; <br> <br>
				<input type="button" value="닫기" onclick="javascript:self.close();
						opener.document.juminForm.user_id.focus();">
				<% 
					}else {
				%>
				<br>
				<%= user_id %> 는 사용 가능한 ID입니다. &nbsp;<br><br>
				<input type="button" value="닫기" onclick="javascript:self.close();
						opener.document.juminForm.user_pw.focus();">
				<% } %>
			</td>
		</tr>
	</table>
</body>
</html>
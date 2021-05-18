<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<jsp:useBean id="now" class="java.util.Date"/>
<body>
	<div>
		<h2>error_page.jsp</h2>
		<hr>
		<table>
			<tr style="width: 100%; background-color: pink" >
				<td>
					에러
				</td>
			</tr>
			<tr>
				<td>
					<%= now %><p> <!-- jsp기본제공자료 현시간을 알려줌 -->
					실패 URI : ${pageContext.errorData.requestURI}<br>
					상태코드 : ${pageContext.errorData.statusCode}<br>
					예외유형 : ${pageContext.errorData.throwable}
					</p>
				</td>
				
			</tr>
		</table>
	</div>
</body>
</html>
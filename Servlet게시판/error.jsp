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
					����
				</td>
			</tr>
			<tr>
				<td>
					<%= now %><p> <!-- jsp�⺻�����ڷ� ���ð��� �˷��� -->
					���� URI : ${pageContext.errorData.requestURI}<br>
					�����ڵ� : ${pageContext.errorData.statusCode}<br>
					�������� : ${pageContext.errorData.throwable}
					</p>
				</td>
				
			</tr>
		</table>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>

</script>
</head>
<body>
	<form method="POST" action="loginAction.jsp">
		<div align="center">
			<h1>�α���</h1>
			<table border="1">		
				<tr>
					<td>
					ID : <input type="text" name="user_id" id="user_id" maxlength="30"><br>
					PW : <input type="password" name="user_pw" id="user_pw" maxlength="30">
					</td>
				</tr>
				<tr align="center">
					<td>
					<button type="submit" name="login" value="�α���">�α���</button>
					<button type="button" name="regist" value="ȸ������" onclick="location=('regist.jsp')">ȸ������</button>
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>]
</html>
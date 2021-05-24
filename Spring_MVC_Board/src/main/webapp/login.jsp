<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=button], select {
  width: 100%;
  background-color: #D4F4FA;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=button]:hover {
  background-color: #368AFF;
  
}

input[type=password], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #D4F4FA;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #368AFF;
  
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<font style="font-family: fantasy;" size="30">login</font>
	<form action="login.do" name="loginForm" method="POST">
		<table>
		
			<tr>
				<td><font style="font-family: fantasy;">ID</font></td>
				<td> <input type="text" name="id"> </td>
				<td><a href="regist.jsp"><input type="button" value="regist"></a></td>	
			</tr>
			
			<tr>
				<td><font style="font-family: fantasy;">PW</font></td>
				<td><input type="password" name="password"></td>	
				<td><input type="submit" value="login"></td>
			</tr>
			
		</table>
	</form>
</div>
</body>
</html>
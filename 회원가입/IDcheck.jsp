<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- �߰� -->

<%  // �ѱ� ���ڵ� ó��
	request.setCharacterEncoding("EUC-KR");
%>
<!--jsp:useBean id="���̸�" class="�ڹٺ� Ŭ���� �̸�" scope="����"/>
	useBean�� �ڹٺ� ��ü�� �����ϴ� �׼��±��̴�. -->
<jsp:useBean id="user" scope="page" class="DB.DBBean"></jsp:useBean>


<% //��ũ��Ʈ�� �ȿ��� �ڹ� �ڵ� ��� 
	String user_id = request.getParameter("user_id");
	String user_pw = request.getParameter("user_ipw");
	int idCheck = user.confirmId(user_id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>idCheck.jsp ������</title>

</head>
<body>
	<table style="text-align: center;" > 
		<tr>
			<td align="center">
				<%
					if(idCheck == 1){ //ID�� �ߺ��� ���
				%>
				<br>
				<%= user_id %> �� �̹� �����ϴ� ID�Դϴ�.&nbsp; <br> <br>
				<input type="button" value="�ݱ�" onclick="javascript:self.close();
						opener.document.juminForm.user_id.focus();">
				<% 
					}else {
				%>
				<br>
				<%= user_id %> �� ��� ������ ID�Դϴ�. &nbsp;<br><br>
				<input type="button" value="�ݱ�" onclick="javascript:self.close();
						opener.document.juminForm.user_pw.focus();">
				<% } %>
			</td>
		</tr>
	</table>
</body>
</html>
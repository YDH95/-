<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page errorPage="error.jsp" %>
<%@ page import="user.UserDAO" %>
<%@ page import="user.UserDO" %>
<%@ page import="java.io.PrintWriter" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%
	//1. ����� �Է� �����Է�
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	//[�߿�] session ��ä�� "Ű" �� �����ϱ�
	session.setAttribute("idKey", id); //�̸��� name�� �Ӽ��� ���� value�� �����Ѵ�. 
	
	//2.UsetDO Ŭ���� ��ü ���� �� �ʵ�(�߰������)�� ���� �ʱ�ȭ�Ѵ�.
	UserDO userDO = new UserDO(); //��ü ����
	userDO.setId(id);
	userDO.setPassword(password);
	
	//3. UserDAO Ŭ���� ���� �� getUser() �޼ҵ� ȣ��
	UserDAO userDAO = new UserDAO(); //��ü ����
	UserDO user = userDAO.getUser(userDO); //UserDO�� userDO.setId(id);, userDO.setPassword(password);�Ѱ���
	
	//4. ������
	if(user != null){//user���� null�� �ƴϸ�
		out.println("<script>alert('�α��� ����')</script>");
		response.sendRedirect("getBoardList.jsp");
	}else{
		 PrintWriter script = response.getWriter();
	     script.println("<script>");
	     script.println("alert('�α��� ����')");
	     script.println("history.back()");
	     script.println("</script>");
	}
	
	
	  
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
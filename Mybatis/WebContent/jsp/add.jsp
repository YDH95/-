<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!-- �̸� �߰� --> 
<%@ page import="mybatis.dao.EmpDAO" %> 
    
<%
	//�Ѿ���� �Ķ���� �ޱ�(empno, ename, job)
	request.setCharacterEncoding("EUC-KR"); //��û�� �ѱ�ó��
	
	String empno = request.getParameter("empno");
	String ename = request.getParameter("ename");
	String position = request.getParameter("position");
	
	//������ ���� �Ķ���� ������ Mybatis ȯ�濡 �����Ͽ�
	//���̺� �����ϵ��� �Ѵ�.
	int cnt = EmpDAO.add(empno, ename, position);
	
	response.sendRedirect("total.jsp");
%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!-- 미리 추가 --> 
<%@ page import="mybatis.dao.EmpDAO" %> 
    
<%
	//넘어오는 파라미터 받기(empno, ename, job)
	request.setCharacterEncoding("EUC-KR"); //요청시 한글처리
	
	String empno = request.getParameter("empno");
	String ename = request.getParameter("ename");
	String position = request.getParameter("position");
	
	//위에서 받은 파라미터 값들을 Mybatis 환경에 전달하여
	//테이블에 저장하도록 한다.
	int cnt = EmpDAO.add(empno, ename, position);
	
	response.sendRedirect("total.jsp");
%>
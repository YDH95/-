<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page errorPage="error.jsp" %>
<%@ page import="user.UserDAO" %>
<%@ page import="user.UserDO" %>
<%@ page import="java.io.PrintWriter" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%
	//1. 사용자 입력 정보입력
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	//[중요] session 객채에 "키" 값 저장하기
	session.setAttribute("idKey", id); //이름이 name인 속성의 값을 value로 지정한다. 
	
	//2.UsetDO 클래스 객체 생성 후 필드(중간저장소)에 값을 초기화한다.
	UserDO userDO = new UserDO(); //객체 생성
	userDO.setId(id);
	userDO.setPassword(password);
	
	//3. UserDAO 클래스 생성 후 getUser() 메소드 호출
	UserDAO userDAO = new UserDAO(); //객체 생성
	UserDO user = userDAO.getUser(userDO); //UserDO에 userDO.setId(id);, userDO.setPassword(password);넘겨줌
	
	//4. 포워딩
	if(user != null){//user값이 null이 아니면
		out.println("<script>alert('로그인 성공')</script>");
		response.sendRedirect("getBoardList.jsp");
	}else{
		 PrintWriter script = response.getWriter();
	     script.println("<script>");
	     script.println("alert('로그인 실패')");
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
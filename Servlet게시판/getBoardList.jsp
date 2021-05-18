<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <!-- 클래스 불러오기 -->
    <%@ page errorPage="error.jsp" %>
    <%@ page import="com.company.Model2_Board.board.BoardDAO" %> 
    <%@ page import="com.company.Model2_Board.board.BoardDO" %>
    <%@ page import="java.util.List" %>
    <!-- JSTL 적용 -->
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <%
   		List<BoardDO> boardList = (List)session.getAttribute("boardList");
    %>
    
    <% 
    	//총게시글 갯수 구하는 방법
    	int totalList = boardList.size();
    	request.setAttribute("totalList", totalList);
    %>
    <%-- <% 서블릿으로 넘어감
    	request.setCharacterEncoding("UTF-8"); //한글
    	//검색 대상(제목 또는 작성자) 및 검색 텍스트 객체를 저장할 변수 설정
    	String searchField = null; //검색 대상(제목 또는 작성자)
    	String searchText = null; //검색 텍스트 객체 레퍼런스 변수
    	
    	if(request.getParameter("searchcondition") != null
    	&& request.getParameter("searchKeyword") != null){ //&&(and)
    	
    		searchField = request.getParameter("searchcondition");
    		searchText = request.getParameter("searchKeyword");
    		System.out.println(searchField+" "+searchText);
    	}
    	//BoardDAO 클래스 객체 생성
    	BoardDAO boardDAO = new BoardDAO();

    	List<BoardDO> boardList = boardDAO.getBoardList(searchField, searchText);
    	
    	request.setAttribute("boardList", boardList);
    	
    	
    %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
body {
  margin: 0;
}

.header {
  background-color: #f1f1f1;
  padding: 20px;
  text-align: center;
}

table {
  border-collapse: collapse;
  width: 100%;
}

tr:nth-child(even) {background-color: #f2f2f2;}

th{
  background-color: #4CAF50;
  color: white;
}

.dropbtn {
  background-color: #4CAF50;
  color: white;
  padding: 20px;
  font-size: 16px;
  border: none;
  cursor: pointer;
}

.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 20px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 20px 30px;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
  display: block;
}

.dropdown:hover .dropbtn {
  background-color: #3e8e41;
}
</style>
</head>
<body>
<div class="header">
	<h1><font style="color: gray;">게시판</font></h1>
</div>
<div align="right">
<div class="dropdown">
	<button class="dropbtn">menu</button>
	<div class="dropdown-content">
	<a href="logout.do">로그아웃</a>
	<a href="userDelete.jsp">회원탈퇴</a>
	</div>
<h3>${idKey}님 입장</h3>
<p>총게시글: ${totalList}</p>
</div>
</div>
	<form action="getBoardList.do" name="form2" method="POST" >
	<div align="center">
		<table border="1" cellpadding="0" cellspacing="0" style="width: 1200px;">
			<tr>
				<td>
					<select name="searchCondition">
						<option value="TITLE">제목</option>
						<option value="WRITER">작성자</option>
					</select>
					<input type="text" name="searchKeyword">
					<input type="submit" value="검색">
				</td>
			</tr>
		</table>
		<table  border="1" cellpadding="0" cellspacing="0" style="width: 1200px;">
			<tr>
				<th width="100">번호</th>
				<th width="200">제목</th>
				<th width="150">작성자</th>
				<th width="150">등록일</th>
				<th width="100">조회수</th>
			</tr>
			<%-- for문식
			</tr>
			<%for(BoardDO board : boardList){%>
				<tr>
				<% System.out.println(boardList.size()); %>
					
					<td align="center"><%= board.getSeq() %></td>
					<td align="left">
						<a href="getBoard.jsp?seq=<%= board.getSeq() %>">
						<%= board.getTitle() %></a>
					</td>
					<td align="center"><%= board.getWriter()%></td>
					<td align="center"><%= board.getRegDate()%></td>
					<td align="center"><%= board.getCnt()%></td>
					
				</tr>
			<%}%>
			 --%>
			<!-- jstl식 -->
			<c:forEach var="board" items="${boardList}">
			
				<tr>
				
					<td align="center"><c:out value="${board.getSeq()}"/></td>
					<td align="left">
						<a href="getBoard.do?seq=${board.getSeq()}">
						${board.getTitle()}</a>
					</td>
					<td align="center">${board.getWriter()}</td>
					<td align="center">${board.getRegDate()}</td>
					<td align="center">${board.getCnt()}</td>
				</tr>
			</c:forEach>
		</table>
		<hr>
		
		<a href="insertBoard.jsp" class="btn">새 게시글 등록</a>&nbsp;&nbsp;
		<a href="getBoardList.do" class="btn">전체 게시글 목록 보기</a>
	</div>
</form>

</body>
</html>
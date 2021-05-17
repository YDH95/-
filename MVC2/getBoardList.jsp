<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <!-- Ŭ���� �ҷ����� -->
    <%@ page errorPage="error.jsp" %>
    <%@ page import="com.company.Model2_Board.board.BoardDAO" %> 
    <%@ page import="com.company.Model2_Board.board.BoardDO" %>
    <%@ page import="java.util.List" %>
    <!-- JSTL ���� -->
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <%
   		List<BoardDO> boardList = (List)session.getAttribute("boardList");
    %>
    
    <% 
    	//�ѰԽñ� ���� ���ϴ� ���
    	int totalList = boardList.size();
    	request.setAttribute("totalList", totalList);
    %>
    <%-- <% �������� �Ѿ
    	request.setCharacterEncoding("UTF-8"); //�ѱ�
    	//�˻� ���(���� �Ǵ� �ۼ���) �� �˻� �ؽ�Ʈ ��ü�� ������ ���� ����
    	String searchField = null; //�˻� ���(���� �Ǵ� �ۼ���)
    	String searchText = null; //�˻� �ؽ�Ʈ ��ü ���۷��� ����
    	
    	if(request.getParameter("searchcondition") != null
    	&& request.getParameter("searchKeyword") != null){ //&&(and)
    	
    		searchField = request.getParameter("searchcondition");
    		searchText = request.getParameter("searchKeyword");
    		System.out.println(searchField+" "+searchText);
    	}
    	//BoardDAO Ŭ���� ��ü ����
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
  padding: 16px;
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
  min-width: 30px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
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
	<h1><font style="color: gray;">�Խ���</font></h1>
</div>
<div align="right">
<div class="dropdown">
	<button class="dropbtn">menu</button>
	<div class="dropdown-content">
	<a href="logout.do">�α׾ƿ�</a>
	<a href="#">ȸ������</a>
	</div>
<h3>${idKey}�� ����</h3>
<p>�ѰԽñ�: ${totalList}</p>
</div>
</div>
	<form action="getBoardList.do" name="form2" method="POST" >
	<div align="center">
		<table border="1" cellpadding="0" cellspacing="0" style="width: 1200px;">
			<tr>
				<td>
					<select name="searchCondition">
						<option value="TITLE">����</option>
						<option value="WRITER">�ۼ���</option>
					</select>
					<input type="text" name="searchKeyword">
					<input type="submit" value="�˻�">
				</td>
			</tr>
		</table>
		<table  border="1" cellpadding="0" cellspacing="0" style="width: 1200px;">
			<tr>
				<th width="100">��ȣ</th>
				<th width="200">����</th>
				<th width="150">�ۼ���</th>
				<th width="150">�����</th>
				<th width="100">��ȸ��</th>
			</tr>
			<%-- for����
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
			<!-- jstl�� -->
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
		
		<a href="insertBoard.jsp" class="btn">�� �Խñ� ���</a>&nbsp;&nbsp;
		<a href="getBoardList.do" class="btn">��ü �Խñ� ��� ����</a>
	</div>
</form>

</body>
</html>
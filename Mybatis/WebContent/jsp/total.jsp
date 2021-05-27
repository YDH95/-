<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!-- 미리 추가 -->  
<%@ page import="mybatis.vo.EmpVO" %> 
<%@ page import="mybatis.dao.EmpDAO" %> 
<%@ page import="java.util.List" %> 
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<!-- css 추가 -->
<style>
	table {
			width: 500px;
			border-collapse: collapse;
	}
	table, table th, table>tbody td {
			border: 1px solid black;
			padding: 4px;
	}	
	table thead>tr:first-child>th {
			border: 0px;
	}
	#add_win {
			width: 200px;
			border: 1px solid black;
			background-color: #fff;
			position:absolute;
			top: 100px;
			left: 580px;
			display: none;
	}
	#add_win input[type=text] {
			width: 90px;
			padding: 3px;
			border: 1px solid black;
			margin-bottom: 5px;
	}
</style>
</head>
<body>
	<header>
		<h1>사원 목록</h1>
	</header>
	<article>
		<table>
			<caption>사원들의 목록을 위한 테이블</caption>
			<thead>
				<tr>
					<th colspan="3" style="text-align: right;">
						<input type="button" value="사원추가" id="add_btn" onclick="addFun()"/>
					</th>					
				</tr>
				
				<tr>
					<th>사번</th>
					<th>이름</th>
					<th>직책</th>
				</tr>				
			</thead>
			<tbody>
				<%
					List<EmpVO> list = EmpDAO.getTotal();
					
					if(list != null && list.size() > 0) {
						for(EmpVO vo : list) {
				%>	
							<tr>
								<td><%=vo.getEmpno() %></td>
								<td><%=vo.getEname() %></td>
								<td><%=vo.getPosition() %></td>
							</tr>
				<%
									
						}//for문의 끝
					}//if문의 끝
				%>				
			</tbody>
		</table>
	</article>
	
	<div id="add_win">
		<header>
			<h2>사원 추가</h2>
		</header>	
		<div id="body">
			<form method="post" action="add.jsp">
				<label for="empno">사번:</label>
				<input type="text" id="empno" name="empno"/>
				<br/>
					
				<label for="ename">이름:</label>
				<input type="text" id="ename" name="ename"/>
				<br/>
					
				<label for="position">직책:</label>
				<input type="text" id="position" name="position"/>
				<br/><br/>
					
				<input type="button" value="추가" id="append_btn" onclick="sendData()"/>
				<input type="button" value="취소" id="cancel_btn" onclick="closeWin()"/>
			</form>
			<br/>
		</div>		
	</div>
	
	<script>
		function addFun() {  
			//현재 문서에서 아이디가 add_win인 요소를 검색!
			//document.getElementById() 함수로 DIV 객체를 가져온다.
			var addWin = document.getElementById("add_win");
			
			//display라는 속성을 html 화면에 일정구간(DIV 객체)를 보이게 "block" 으로 명시한다.
			addWin.style.display = "block"
		}
		
		function closeWin() {
			var addWin = document.getElementById("add_win");
			
			//display라는 속성을 html 화면에 일정구간(DIV 객체)를 안보이게 "none" 으로 명시한다.
			addWin.style.display = "none"
		}
		
		function sendData() {
			//add.jsp로 보내기 전에 유효성 검사를 한다.
			var empno = document.getElementById("empno").value;
			//var t_empno = $("#empno").val();  //jQuery 문법
			
			var ename = document.getElementById("ename").value;
			var position = document.getElementById("position").value;
			
			if(empno.trim().length < 1) {
				//1자도 입력하지 않은 경우
				document.getElementById("empno").value = "";
				alert("사번을 입력하세요");
				document.getElementById("empno").focus();
				return;
			}
			//나머지도 입력되었는지 확인한다.
			
			document.forms[0].submit();	  //전송!!! ---> add.jsp
		}
	</script>
</body>
</html>
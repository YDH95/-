<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!-- �̸� �߰� -->  
<%@ page import="mybatis.vo.EmpVO" %> 
<%@ page import="mybatis.dao.EmpDAO" %> 
<%@ page import="java.util.List" %> 
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<!-- css �߰� -->
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
		<h1>��� ���</h1>
	</header>
	<article>
		<table>
			<caption>������� ����� ���� ���̺�</caption>
			<thead>
				<tr>
					<th colspan="3" style="text-align: right;">
						<input type="button" value="����߰�" id="add_btn" onclick="addFun()"/>
					</th>					
				</tr>
				
				<tr>
					<th>���</th>
					<th>�̸�</th>
					<th>��å</th>
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
									
						}//for���� ��
					}//if���� ��
				%>				
			</tbody>
		</table>
	</article>
	
	<div id="add_win">
		<header>
			<h2>��� �߰�</h2>
		</header>	
		<div id="body">
			<form method="post" action="add.jsp">
				<label for="empno">���:</label>
				<input type="text" id="empno" name="empno"/>
				<br/>
					
				<label for="ename">�̸�:</label>
				<input type="text" id="ename" name="ename"/>
				<br/>
					
				<label for="position">��å:</label>
				<input type="text" id="position" name="position"/>
				<br/><br/>
					
				<input type="button" value="�߰�" id="append_btn" onclick="sendData()"/>
				<input type="button" value="���" id="cancel_btn" onclick="closeWin()"/>
			</form>
			<br/>
		</div>		
	</div>
	
	<script>
		function addFun() {  
			//���� �������� ���̵� add_win�� ��Ҹ� �˻�!
			//document.getElementById() �Լ��� DIV ��ü�� �����´�.
			var addWin = document.getElementById("add_win");
			
			//display��� �Ӽ��� html ȭ�鿡 ��������(DIV ��ü)�� ���̰� "block" ���� ����Ѵ�.
			addWin.style.display = "block"
		}
		
		function closeWin() {
			var addWin = document.getElementById("add_win");
			
			//display��� �Ӽ��� html ȭ�鿡 ��������(DIV ��ü)�� �Ⱥ��̰� "none" ���� ����Ѵ�.
			addWin.style.display = "none"
		}
		
		function sendData() {
			//add.jsp�� ������ ���� ��ȿ�� �˻縦 �Ѵ�.
			var empno = document.getElementById("empno").value;
			//var t_empno = $("#empno").val();  //jQuery ����
			
			var ename = document.getElementById("ename").value;
			var position = document.getElementById("position").value;
			
			if(empno.trim().length < 1) {
				//1�ڵ� �Է����� ���� ���
				document.getElementById("empno").value = "";
				alert("����� �Է��ϼ���");
				document.getElementById("empno").focus();
				return;
			}
			//�������� �ԷµǾ����� Ȯ���Ѵ�.
			
			document.forms[0].submit();	  //����!!! ---> add.jsp
		}
	</script>
</body>
</html>
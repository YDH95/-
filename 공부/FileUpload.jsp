<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
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

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
  
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
<script>
var count = 1; //���� ����

function addRow() {
	var dynamictable = document.getElementById('dynamic_table');
	var newRow = dynamictable.insertRow();
	var cell1 = newRow.insertCell();
	var cell2 = newRow.insertCell();
		
	cell1.innerHTML = '<input type="checkbox" name="checkboxObj"/>';
	cell2.innerHTML = '<input type="file" name="fileUpload'+count+'">';
	count++
}

function deleteRow() {
	
	var table = document.getElementById("dynamic_table");
	//������ ���
	//���� ������ŭ �ݺ�
	for(var i = 0; i<table.deleteRow.length; i++){
		var checkbox = document.getElementsByName('checkboxObj');
		var check = checkbox[i].checked;
		
		if(check){
			table.deleteRow(i);
		}
	}
}
	//���۸����� �Ѱ�
	/*var rows = dynamic_table.rows.length;
	var chk = 0;
	if(rows > 1){
		for(var i = 0; i<dynamicForm.checkboxObj.length; i++){
			if(dynamicForm.checkboxObj[i].checked == true){
				 table.deleteRow(i);
				 i--;
				 count--;
				 chk++;
			}
		}
		if(chk <= 0){
			alert("������ ���� üũ�� �ּ���.");
		}
	}*/
		
	

</script>
</head>
<body>
<div align="center">
<form name="dynamicForm" method="POST" action="viewpage.jsp" enctype="multipart/form-data"> 
	<h2>���� ���� ���� ���ε� �ϱ�</h2>
	<table border="1">
	<tr>
	<td>
	�ۼ���<input type="text" name="name">
	</td>
	</tr>
	<tr>
	<td>
	��&nbsp;��<input type="text" name="subject">
	</td>
	</tr>
	</table>
	<br>
	<input type="button" value="���߰�" onclick="addRow();">&nbsp;&nbsp;
	<input type="button" value="�����" onclick="deleteRow();"> <br> <br>
	<font>check   ���ε��� ���� �̸�</font>
	
		<table id="dynamic_table" border="1" cellspacing="0" cellpadding="0"></table>
		
		<br>
		<font color="red">���ε��� ������ �ִ� 10M ���� ������.</font> <br> <br>
		<input type="submit" value="���� �ø���">
		
	</form>
	</div>
</body>
</html>
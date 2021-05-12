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
var count = 1; //전역 변수

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
	//교수님 답안
	//행의 갯수만큼 반복
	for(var i = 0; i<table.deleteRow.length; i++){
		var checkbox = document.getElementsByName('checkboxObj');
		var check = checkbox[i].checked;
		
		if(check){
			table.deleteRow(i);
		}
	}
}
	//구글링으로 한것
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
			alert("삭제할 행을 체크해 주세요.");
		}
	}*/
		
	

</script>
</head>
<body>
<div align="center">
<form name="dynamicForm" method="POST" action="viewpage.jsp" enctype="multipart/form-data"> 
	<h2>동적 다중 파일 업로드 하기</h2>
	<table border="1">
	<tr>
	<td>
	작성자<input type="text" name="name">
	</td>
	</tr>
	<tr>
	<td>
	제&nbsp;목<input type="text" name="subject">
	</td>
	</tr>
	</table>
	<br>
	<input type="button" value="행추가" onclick="addRow();">&nbsp;&nbsp;
	<input type="button" value="행삭제" onclick="deleteRow();"> <br> <br>
	<font>check   업로드할 파일 이름</font>
	
		<table id="dynamic_table" border="1" cellspacing="0" cellpadding="0"></table>
		
		<br>
		<font color="red">업로드할 파일은 최대 10M 까지 가능함.</font> <br> <br>
		<input type="submit" value="파일 올리기">
		
	</form>
	</div>
</body>
</html>
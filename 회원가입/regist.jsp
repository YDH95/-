<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 화면</title>
<script src="./IDcheck.jsp"></script>
<script>
function change_email(){
    var kim = document.getElementById("email_sel").value;
    if(kim==""){
      document.getElementById("email_add").value = kim;
      document.getElementById("email_add").readOnly = false;
    }else{
      document.getElementById("email_add").value = kim;
      document.getElementById("email_add").readOnly = true;
    }
  }
</script>
<style>
table {
	margin-left: auto;
	margin-right: auto;
}

body {
	background-color: #EAEAEA;
}

font {
	text-align: center;
}

#title {
	text-align: center;
}

.star {
	color: red;
}
</style>
</head>

<body>

	<form name="juminForm" method="POST" action="Member_control.jsp">
		<input type="hidden" name="action" value="insert" />
		<!-- 왼쪽, 오른쪽 바깥여백을 auto로 주면 중앙정렬된다.  -->
		<div align="center">
			<b><font size="6" color="#191919">회원가입</font></b> <br> <br>
			<font color="red">＊</font>필수입력
		</div>
		<table border="1">
			<tr>
				<td colspan="2" align="center" style="background-color: #D4F4FA;">회원
					기본 정보</td>
			</tr>

			<tr>
				<td id="title">아이디<span class=star>＊</span></td>
				<td><input type="text" name="user_id" maxlength="20"
					placeholder="6자 이상의 영문과 숫자" required="required"> <input
					type="button" value="중복확인" onclick="IDCheck(user_id.value)">
				</td>
			</tr>

			<tr>
				<td id="title">비밀번호<span class=star>＊</span></td>
				<td><input type="password" name="user_pw" id="user_pw" maxlength="15"
					 required="required"></td>
			</tr>

			<tr>
			<td>이메일</td>
			<td>
				<input type="text" name="user_email" id="user_email"/> @ 
				<input type="text" name="user_email_domain" id="email_add"/>
				<select	name="email_sel" id="email_sel" onchange="change_email();">
				<option value="">직접선택입력</option>
				<option value="naver.com">naver.com</option>
				<option value="hanmail.net">hanmail.net</option>
				<option value="gmail.com">gmail.com</option>
				<option value="nate.com">nate.com</option>
				<option value="kakao.com">kakao.com</option>
				</select>
			</td>
		</tr>

			<tr>
				<td colspan="2" align="center" style=background:#D4F4FA><input type="submit"
					value="회원가입 등록"> &nbsp;<input type="reset" value="다시쓰기" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
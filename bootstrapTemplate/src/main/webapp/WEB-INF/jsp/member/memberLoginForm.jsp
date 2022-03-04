<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div align="center">
	
		<h1>로 그 인</h1>
	


		<form id="frm" name="frm" action="memberLoginSession.do" method="POST">
			<table border="1">
				<tr>
					<th width="150">ID</th>
					<td width="300"><input type="text" id="id" name="name">PASSWORD</td>
					<th>
				</tr>
				<tr>
					<th width="150">PASSWORD</th>
					<td width="300"><input type="password" id="password"
						name="password"></td>
				</tr>
			</table>
			<div>
				<button type="submit" onclick="formCheck()">로그인</button>
			</div>
		</form>
	
</div>

<script type="text/javascript">
	function formCheck() {
		if (frm.id.value == "") {
			alert("아이디를 입력하세요.");
			frm.id.focus();
			return false;
		}

		if (frm.password.value == "") {
			alert("패스워드를 입력하세요.");
			frm.password.focus();
			return false;
		}
		frm.submit();
	}
</script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div align="center">
	<h1>로 그 인</h1>
	<form id="frm" name="frm" action="memberLoginSession.do" method="POST">
		<table border="1">
			<tr>
				<th width="150">ID</th>
				<td width="300"><input type="text" id="id" name="id" required></td>
				<th>
			</tr>
			<tr>
				<th width="150">PASSWORD</th>
				<td width="300"><input type="password" id="password" name="password" required></td>
			</tr>
		</table>
		<div>
			<button type="submit">로그인</button>
			<button type="button">
				<a href="memberJoinForm.do">회원가입</a>
			</button>
		</div>
	</form>
</div>
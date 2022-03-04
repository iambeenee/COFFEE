<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div align="center">
	<h1>회 원 정 보 수 정</h1>

	<form id="frm" name="frm" action="memberUpdate.do" method="POST">
		<input type="hidden" name="id" value="${member.id }">
		<table>
				<tr>
					<th width="200">ID</th>
					<td>${member.id }</td>
				</tr>
				<tr>
					<th width="200">NAME</th>
					<td><input type="text" id="name" name="name" value="${member.name }"></td>
				</tr>
				<tr>
					<th width="200">PASSWORD</th>
					<td><input type="password" id="password" name="password" value="${member.password }"></td>
				</tr>
				<tr>
					<th width="200">PASSWORD CHECK</th>
					<td><input type="password" id="password1" name="password1" value="${member.password }"></td>
				</tr>
				<tr>
					<th width="200">ADDRESS</th>
					<td><input type="text" id="address" name="address" value="${member.address }"></td>
				</tr>
				<tr>
					<th width="200">TEL</th>
					<td><input type="text" id="tel" name="tel" value="${member.tel }"></td>
				</tr>
				<tr>
					<th width="200">EMAIL</th>
					<td><input type="email" id="email" name="email" value="${member.email }"></td>
				</tr>
		</table>
		<div>
			<button type="submit" onclick="formCheck()">수정완료</button>&nbsp;&nbsp;&nbsp;
			<button type="button" onclick="memberWithdrawal.do">회원탈퇴</button>
		</div>
	</form>
</div>

<script type="text/javascript">
	// 비번일치 여부
	function formCheck() {
		if (frm.password.value != frm.password1.value) {
			alert("비밀번호가 일치하지 않습니다.");
			frm.password.value = "";
			frm.password1.value = "";
			frm.password.focus();
			return false;
		}
		return true;
	}
</script>
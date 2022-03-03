<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
	<h1>회 원 정 보 수 정</h1>
</div>

<div>
	<form id="frm" name="frm" action="memberUpdate.do" method="POST">
		<table>
			<thead>
				<tr>
					<th width="200">NAME</th>
					<th width="200">PASSWORD</th>
					<th width="200">PASSWORD CHECK</th>
					<th width="100">ADDRESS</th>
					<th width="100">TEL</th>
					<th width="100">EMAIL</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vo" items="${members } var="member">
					<tr>
						<td><input id="name" name="name" value="${member.name }"></td>
						<td><input id="password" name="password"></td>
						<td><input id="password1" name="password1"></td>
						<td><input id="address" name="address" value="${member.address }"></td>
						<td><input id="tel" name="tel" value="${member.tel }"></td>
						<td><input id="email" name="email" value="${member.email }"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<div>
			<button type="submit" onclick="formCheck()">수정완료</button>&nbsp;&nbsp;&nbsp;
			<button type="button" onclick="#">회원탈퇴</button>
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
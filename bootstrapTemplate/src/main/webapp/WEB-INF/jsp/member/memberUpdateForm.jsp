<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
/* 한글 폰트 */
	h1{
		font-family: "Open Sans", sans-serif;
	}

/* Full-width input fields */
input {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

/* Set a style for all buttons */
button, .withdraw {
	display: inline-block;
	padding: 8px 30px;
	background-color: #ffbe33;
	color: #ffffff;
	border-radius: 45px;
	-webkit-transition: all 0.3s;
	transition: all 0.3s;
	border: none;
}

button, .withdraw:hover {
  background-color: #e69c00;
}

/* TABLE */
th {
	width: 170px;
}

td {
	width: 500px;
}
</style>

<body class="sub_page">
	<section class="food_section layout_padding">
		<div class="container" align="center">
			<div align='center'>
				<div class="heading_container heading_center">
					<h1>회 원 정 보 수 정</h1>
				</div>
				<br />

				<form id="frm" name="frm" action="memberUpdate.do" method="POST">
					<input type="hidden" name="id" value="${member.id }">
					<table>
						<tr>
							<th>ID</th>
							<td>${member.id }</td>
						</tr>
						<tr>
							<th>NAME</th>
							<td><input type="text" id="name" name="name"
								value="${member.name }"></td>
						</tr>
						<tr>
							<th>PASSWORD</th>
							<td><input type="password" id="password" name="password"
								value="${member.password }"></td>
						</tr>
						<tr>
							<th>PASSWORD CHECK</th>
							<td><input type="password" id="password1" name="password1"
								value="${member.password }"></td>
						</tr>
						<tr>
							<th>ADDRESS</th>
							<td><input type="text" id="address" name="address"
								value="${member.address }"></td>
						</tr>
						<tr>
							<th>TEL</th>
							<td><input type="text" id="tel" name="tel"
								value="${member.tel }"></td>
						</tr>
						<tr>
							<th>EMAIL</th>
							<td><input type="email" id="email" name="email"
								value="${member.email }"></td>
						</tr>
					</table>
					<br/>
					<div>
						<button type="submit" onclick="formCheck()">수정완료</button>
						&nbsp;&nbsp;&nbsp;
						<a class="withdraw" href="memberDelete.do">회원탈퇴</a>
					</div>
				</form>
			</div>
		</div>
	</section>
</body>

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
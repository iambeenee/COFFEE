<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style>
/* Full-width input fields */
input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

/* Set a style for all buttons */
button, .join {
	display: inline-block;
	padding: 8px 30px;
	background-color: #ffbe33;
	color: #ffffff;
	border-radius: 45px;
	-webkit-transition: all 0.3s;
	transition: all 0.3s;
	border: none;
}

button, .join:hover {
	background-color: #e69c00;
}
</style>

<body class="sub_page">
	<section class="food_section layout_padding">
		<div class="container" align="center">
			<div class="heading_container heading_center">
				<h2>LOGIN</h2>
			</div>
			<br />
			<p></p>
			<form id="frm" name="frm" action="memberLoginSession.do" method="POST" onsubmit="check_id_submit(event)">
				<table>
					<tr>
						<th>ID</th>
						<td width="300"><input type="text" id="id" name="id" required></td>
						<th>
					</tr>
					<tr>
						<th>PASSWORD</th>
						<td width="300"><input type="password" id="password"
							name="password" required></td>
					</tr>
					<tr>
						<td><br /></td>
					<tr>
						<td width="150"></td>
						<td width="300">
							<button class="login" type="submit">로그인</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<a class="join" href="memberJoinForm.do">회원가입</a>
						</td>
					</tr>
				</table>
				<div></div>
			</form>
		</div>
	</section>
</body>
<script>
	function check_id_submit(e) {
		e.preventDefault();
		frm.submit();
	}
</script>
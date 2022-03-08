<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style>
input[type=text], textarea {
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

div>input {
	display: inline-block;
	padding: 8px 30px;
	background-color: #ffbe33;
	color: #ffffff;
	border-radius: 45px;
	-webkit-transition: all 0.3s;
	transition: all 0.3s;
	border: none;
}

div>input:hover {
	background-color: #e69c00;
}

table {
	border-spacing: 10px;
	border-collapse: separate;
}

th {
	width: 100px;
}
</style>

<body class="sub_page">
	<section class="food_section layout_padding">
		<div class="container" align="center">
			<div align='center'>
				<div class="heading_container heading_center">
					<h2>NOTICE</h2>
				</div>
				<br />
				<form id="frm" name="frm" action="noticeInsert.do" method="POST">
					<div>
						<table>
							<tr>
								<th>Subject</th>
								<td><input type="text" size="90" id="subject" required
									name="subject"></td>
							</tr>
							<tr>
								<th>Content</th>
								<td><textarea id="content" name="content" rows="20" required
										cols="90"></textarea></td>
							</tr>
						</table>
					</div>
					<br />
					<div>
						<input type="submit" value="등록하기">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" value="새로 작성하기">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" value="목록가기" onClick="location.href='noticeList.do'">
					</div>
				</form>
			</div>
		</div>
	</section>
</body>
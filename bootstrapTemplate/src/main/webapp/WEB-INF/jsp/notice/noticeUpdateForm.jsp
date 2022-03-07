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

button {
	display: inline-block;
	padding: 8px 30px;
	background-color: #ffbe33;
	color: #ffffff;
	border-radius: 45px;
	-webkit-transition: all 0.3s;
	transition: all 0.3s;
	border: none;
}

button:hover {
  background-color: #e69c00;
}

th {
	width:100px;
}
</style>

<body class="sub_page">
	<section class="food_section layout_padding">
		<div class="container" align="center">
			<div align='center'>
			<div class="heading_container heading_center">
					<h2>NOTICE</h2>
				</div>
				<br/>
				<form id="frm" name="frm" action="noticeUpdate.do" method="POST">
					<input type="hidden" name="noticeNo" value="${notice.noticeNo }">
					<div>
						<table>
							<tr>
								<th>DATE</th>
								<td >${notice.nDate }</td>
								<th>HIT</th>
								<td colspan="10">${notice.hit }</td>
							</tr>
							<tr>
								<th>Subject</th>
								<td colspan="3"><input type="text" size="90" id="subject"
									name="subject" value="${notice.nSubject }"></td>
							</tr>
							<tr>
								<th>Content</th>
								<td colspan="3">
									<textarea id="content" name="content" rows="20" cols="90">${notice.nContent }</textarea>
								</td>
							</tr>
						</table>
					</div>
					<br />
					<div>
						<button type="submit">수정완료</button>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" onClick="location.href='noticeSelect.do?noticeNo=${notice.noticeNo }'">돌아가기</button>
					</div>
				</form>
			</div>
		</div>
	</section>
</body>
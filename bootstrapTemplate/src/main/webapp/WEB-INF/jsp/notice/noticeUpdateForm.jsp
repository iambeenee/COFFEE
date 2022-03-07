<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<body class="sub_page">
	<section class="food_section layout_padding">
		<div class="container" align="center">
			<div align='center'>
				<div class="heading_container heading_center">
					<h1>수 정 하 기</h1>
				</div>
				<br />
				<form id="frm" name="frm" action="noticeUpdate.do" method="POST">
					<input type="hidden" name="noticeNo" value="${notice.noticeNo }">
					<div>
						<table>
							<tr>
								<th>No</th>
								<td>${notice.noticeNo }</td>
								<th>Date</th>
								<td>${notice.nDate }</td>
								<th>Hit</th>
								<td>${notice.hit }</td>
							</tr>
							<tr>
								<th>Subject</th>
								<td colspan="5"><input type="text" id="subject"
									name="subject" value="${notice.nSubject }"></td>
							</tr>
							<tr>
								<th>Content</th>
								<td colspan="5"><textarea id="content" name="content"
										rows="6" cols="90">${notice.nContent }</textarea></td>
							</tr>
						</table>
					</div>
					<br />
					<div>
						<button type="submit">수정완료</button>
					</div>
				</form>
			</div>
		</div>
	</section>
</body>
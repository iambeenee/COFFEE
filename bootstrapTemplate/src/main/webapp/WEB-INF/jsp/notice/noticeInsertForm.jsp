<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<body class="sub_page">
	<section class="food_section layout_padding">
		<div class="container" align="center">
			<div align='center'>
				<div class="heading_container heading_center">
					<h1>공지사항 등록하기</h1>
				</div>
				<br />
				
				<form id="frm" name="frm" action="noticeInsert.do" method="POST">
					<div>
						<table>
							<tr>
								<th>Subject</th>
								<td><input type="text" id="subject" name="subject"></td>
							</tr>
							<tr>
								<th>Content</th>
								<td>
									<textarea id="content" name="content" rows="6" cols="90"></textarea>
								</td>
							</tr>
						</table>
					</div><br/>
					<div>
						<input type="submit" value="등록하기">&nbsp;&nbsp;&nbsp;
						<input type="reset" value="새로 작성하기">&nbsp;&nbsp;&nbsp;
						<input type="button" value="목록가기" onclick="location.href='noticeList.do'">
					</div>
				</form>
			</div>
		</div>
	</section>
</body>
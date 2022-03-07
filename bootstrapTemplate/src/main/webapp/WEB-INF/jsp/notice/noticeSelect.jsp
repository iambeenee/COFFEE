<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body class="sub_page">
	<section class="food_section layout_padding">
		<div class="container" align="center">
			<div align='center'>
				<div class="heading_container heading_center">
					<h1>공지사항 내용보기</h1>
				</div>
				<br />
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
							<td colspan="5">${notice.nSubject }</td>
						</tr>
						<tr>
							<th>Content</th>
							<td colspan="5">${notice.nContent }</td>
						</tr>
					</table>
				</div>
				<br />
				<div>
					<button type="button" onclick="location.href='noticeList.do'">목록보기</button>
					<c:if test="${author eq 'admin'}">
						<button type="button" onclick="location.href='noticeUpdateForm.do?noticeNo=${notice.noticeNo }'">수정하기</button>
						<button type="button" onclick="location.href='noticeDelete.do?noticeNo=${notice.noticeNo }'">삭제하기</button>
					</c:if>
				</div>
			</div>
		</div>
	</section>
</body>
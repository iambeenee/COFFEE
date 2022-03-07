<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
table {
	border-spacing: 15px;
	border-collapse: separate;
	font-size: 18px;
}

th {
	width: 150px;
}

td {
	width: 300px;
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
</style>

<body class="sub_page">
	<section class="food_section layout_padding">
		<div class="container" align="center">
			<div align='center'>
			<div class="heading_container heading_center">
					<h2>NOTICE</h2>
				</div>
				<br/>
				<div>
					<table>
						<tr>
							<th>DATE</th>
							<td colspan="30">${notice.nDate }</td>
							<td colspan="38"></td>
							<th style="float: right">HIT</th>
							<td>${notice.hit }</td>
						</tr>
						<tr>
							<th>SUBJECT</th>
							<td colspan="70">${notice.nSubject }</td>
						</tr>
						<tr>
							<th rowspan="22">CONTENT</th>
							<td rowspan="22" colspan="70" style="line-height: 50px">${notice.nContent }</td>
						</tr>
					</table>
				</div>
				<br />
				<div>
					<button type="button" onclick="location.href='noticeList.do'">목록보기</button>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<c:if test="${author eq 'admin'}">
						<button type="button"
							onclick="location.href='noticeUpdateForm.do?noticeNo=${notice.noticeNo }'">수정하기</button>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button"
							onclick="location.href='noticeDelete.do?noticeNo=${notice.noticeNo }'">삭제하기</button>
					</c:if>
				</div>
			</div>
		</div>
	</section>
</body>
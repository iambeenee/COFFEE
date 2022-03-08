<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
table {
	border-spacing: 10px;
	border-collapse: separate;
	font-size: 20px;
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
				<form id="frm" name="frm" action="noticeSelect.do" method="POST">
					<input type="hidden" id="noticeNo" name="noticeNo">
				</form>
				<br />
				<div>
					<table>
						<tr>
							<th width="50">No</th>
							<th width="400">Subject</th>
							<th width="250">Date</th>
							<th width="50">Hit</th>
						</tr>
						<c:forEach items="${notices}" var="notice">
							<tr onclick="formSubmit(${notice.noticeNo})">
								<th>${notice.noticeNo }</th>
								<td>${notice.nSubject }</td>
								<td>${notice.nDate }</td>
								<td>${notice.hit }</td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<br />
				<div>
					<c:if test="${author eq 'admin' }">
						<button type="button" onClick="location.href='noticeInsertForm.do'">등록</button>
					</c:if>
				</div>
			</div>
		</div>
	</section>
</body>

<script type="text/javascript">
	function formSubmit(noticeNo) {
		frm.noticeNo.value = noticeNo;
		frm.submit();
	}
</script>
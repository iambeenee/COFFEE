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
					<h2>Q&A</h2>
				</div>
				<br />
				<div>
				<input type="hidden" id="id" name="id">
					<table>
						<tr>
							<th>DATE</th>
							<td>${origin.qDate }</td>
							<th>HIT</th>
							<td>${origin.hit }</td>
						</tr>
						<tr>
							<th>SUBJECT</th>
							<td>${origin.qSubject }</td>
						</tr>
						<tr>
							<th>CONTENT</th>
							<td>${origin.qContent }</td>
						</tr>
						<tr>
							<th>┗ REPLY</th>
							<td>${reply.qReply }</td>
							<th>DATE</th>
							<td>${reply.qDate }</td>
						</tr>
					</table>
				</div>
				<br /> <br />
				<div>
					<button type="button" onclick="location.href='qnaList.do'">목록보기</button>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<button type="button" onclick="qnaDelete(event)">삭제하기</button>
					<c:if test="${author eq 'admin' }">
						<button type="button" onclick="location.href='#'">답변등록</button>
					</c:if>
				</div>
			</div>
		</div>
	</section>
</body>

<script>
	function qnaDelete(e){
		e.preventDefault();
		if()
	}
</script>
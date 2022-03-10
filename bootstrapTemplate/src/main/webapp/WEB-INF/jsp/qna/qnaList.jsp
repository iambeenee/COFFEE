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
					<h2>Q&A LIST</h2>
				</div>
				<br />
					<form id="frm" name="frm" action="qnaSelect.do" method="POST">
						<input type="hidden" id="qNo" name="qNo">
						<input type="hidden" id="id" name="id">
					</form>
				<br />
				<div>
					<table>
						<tr>
							<th width="50">No</th>
							<th width="300">Subject</th>
							<th width="100">Id</th>
							<th width="250">Date</th>
							<th width="50">Hit</th>
						</tr>
						<c:forEach items="${qnas }" var="qna">
							<tr onclick="formSubmit(${qna.qNo})">
								<td>${qna.qNo}</td>
								<td>${qna.qSubject }</td>
								<td>${qna.id }</td>
								<td>${qna.qDate }</td>
								<td>${qna.hit }</td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<br />
				<div>
					<c:if test="${not empty id && author eq 'user' }">
						<button type="submit" onClick="location.href='qnaInsertForm.do'">등록</button>
					</c:if>
				</div>
			</div>
		</div>
	</section>
</body>

<script type="text/javascript">
	function formSubmit(qNo){
		if(frm.qNo.value = qNo){
			if(frm.id.value != id;){
				alert('읽기권한이 없습니다.');
				return;
			}
		}
		frm.submit();
	}
</script>
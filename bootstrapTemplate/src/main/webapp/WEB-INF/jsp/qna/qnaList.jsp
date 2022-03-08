<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
				</form>
				<br/>
				<div>
					<table>
						<tr>
							<th>No</th>
							<th>Subject</th>
							<th>Id</th>
							<th>Date</th>
							<th>Hit</th>
						</tr>
						<c:if test="${qna }" var="qna">
							<tr onClick="formSubmit(${qna.qNo})">
								<td>${qna.qNo }</td>
								<td>${qna.qSubject }</td>
								<td>${ }</td>
								<td></td>
								<td></td>
							</tr>
						</c:if>
					</table>
				</div>
				
			</div>
		</div>
	</section>
</body>
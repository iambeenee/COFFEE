<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
/* 한글 폰트 */
	h1{
		font-family: "Open Sans", sans-serif;
	}
</style>

<body class="sub_page">
	<section class="food_section layout_padding">
		<div class="container" align="center">
			<div align='center'>
				<div class="heading_container heading_center">
					<h1>회 원 정 보</h1>
				</div>
				<br />

				<table>
					<thead>
						<tr>
							<th width="100">id</th>
							<th width="100">name</th>
							<th width="200">address</th>
							<th width="200">tel</th>
							<th width="200">email</th>
							<th width="200">join date</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${members }" var="member">
							<tr>
								<td>${member.id }</td>
								<td>${member.name }</td>
								<td>${member.address }</td>
								<td>${member.tel }</td>
								<td>${member.email }</td>
								<td>${member.date }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</section>
</body>
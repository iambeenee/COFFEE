<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div align="center">
	<div>
		<h1>NOTICE</h1>
	</div>

	<form id="frm" name="frm" action="memberList.do" method="post">
		<input type="hidden" id="id" name="id">
	</form>
	<div>
		<table class="table">
			<thead>
				<tr>
					<th width="100">id</th>
					<th width="200">name</th>
					<th width="100">address</th>
					<th width="100">tel</th>
					<th width="100">email</th>
					<th width="100">join date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vo" items="${members }" var="member">
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
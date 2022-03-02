<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<!-- 왼쪽 상단 메뉴 -->
	<div class="container px-4 px-lg-5">
		<a class="navbar-brand" href="main.do">COFFEE BEANS</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
					role="button" data-bs-toggle="dropdown" aria-expanded="false">SHOP</a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item" href="#!">원두</a></li>
						<li><a class="dropdown-item" href="#!">생두</a></li>
						<li><a class="dropdown-item" href="#!">선물세트</a></li>
						<li><a class="dropdown-item" href="#!">추출도구</a></li>
					</ul></li>

				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="#!">About us</a></li>

				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
					role="button" data-bs-toggle="dropdown" aria-expanded="false">COMMUNITY</a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item" href="#!">NOTICE</a></li>
						<li><a class="dropdown-item" href="#!">Q&A</a></li>
					</ul></li>
			</ul>
			<form class="d-flex">
				<button class="btn btn-outline-dark" type="submit">
					<i class="bi-cart-fill me-1"></i> Cart <span
						class="badge bg-dark text-white ms-1 rounded-pill">0</span>
				</button>
			</form>
		</div>
	</div>

	<!-- 오른쪽 상단 로그인 -->
	<div>
		<c:if test="${empty id }">
			<a href="#">Login</a>
			<a href="#">JOIN</a>
		</c:if>
		<c:if test="${not empty id }">
			<a href="logout.do">LogOut</a>
		</c:if>
			<a href="#">MYPAGE</a>
			<a href="#">MYCART</a>
	</div>

</nav>
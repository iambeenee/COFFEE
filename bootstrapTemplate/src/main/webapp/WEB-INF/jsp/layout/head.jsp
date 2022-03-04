<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="hero_area">
	<!-- header section strats -->
	<header class="header_section">
		<div class="container">
			<nav class="navbar navbar-expand-lg custom_nav-container ">
				<a class="navbar-brand" href="main.do">
					<span>COFFEE BEANS</span>
				</a>

				<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
					<span class=""> </span>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav  mx-auto ">
						<li class="nav-item"><a class="nav-link"
							href="productList.do">Products</a></li>
						<li class="nav-item"><a class="nav-link" href="aboutUs.do">About
								US</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Community</a>
						</li>
						<c:if test="${author eq 'admin' }">
							<li class="nav-item"><a class="nav-link" href="#">MemberList</a>
							</li>
						</c:if>
					</ul>
					<div class="user_option">
						<c:if test="${not empty id}">
							<a href="memberUpdateForm.do" class="user_link">MYPAGE</a>
							<a href="#" class="user_link">CART</a>
							<a href="logout.do" class="order_online">LOGOUT</a>
						</c:if>
						<c:if test="${empty id }">
							<a href="memberLogin.do" class="order_online"> LOGIN </a>
						</c:if>
					</div>
				</div>
			</nav>
		</div>
	</header>
<!-- end header section -->
<div class="hero_area">
	<div class="bg-box">
		<img src="images/coffee.jpg" alt="">
	</div>

	<!-- slider section -->
	<section class="slider_section ">
		<div id="customCarousel1" class="carousel slide" data-ride="carousel">
			<div class="carousel-inner">
				<div class="carousel-item active">
					<div class="container ">
						<div class="row">
							<div class="col-md-7 col-lg-6 ">
								<div class="detail-box">
									<h1>원두</h1>
									<p>Doloremque, itaque aperiam facilis rerum, commodi,
										temporibus sapiente ad mollitia laborum quam quisquam esse
										error unde. Tempora ex doloremque, labore, sunt repellat
										dolore, iste magni quos nihil ducimus libero ipsam.</p>
									<div class="btn-box">
										<a href="" class="btn1"> 주문하기 </a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="carousel-item ">
					<div class="container ">
						<div class="row">
							<div class="col-md-7 col-lg-6 ">
								<div class="detail-box">
									<h1>생두</h1>
									<p>Doloremque, itaque aperiam facilis rerum, commodi,
										temporibus sapiente ad mollitia laborum quam quisquam esse
										error unde. Tempora ex doloremque, labore, sunt repellat
										dolore, iste magni quos nihil ducimus libero ipsam.</p>
									<div class="btn-box">
										<a href="" class="btn1"> 주문하기 </a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="carousel-item">
					<div class="container ">
						<div class="row">
							<div class="col-md-7 col-lg-6 ">
								<div class="detail-box">
									<h1>추출도구</h1>
									<p>Doloremque, itaque aperiam facilis rerum, commodi,
										temporibus sapiente ad mollitia laborum quam quisquam esse
										error unde. Tempora ex doloremque, labore, sunt repellat
										dolore, iste magni quos nihil ducimus libero ipsam.</p>
									<div class="btn-box">
										<a href="" class="btn1"> 주문하기 </a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="container">
				<ol class="carousel-indicators">
					<li data-target="#customCarousel1" data-slide-to="0" class="active"></li>
					<li data-target="#customCarousel1" data-slide-to="1"></li>
					<li data-target="#customCarousel1" data-slide-to="2"></li>
				</ol>
			</div>
		</div>

	</section>
	<!-- end slider section -->
</div>

</div>

<script>
	// Get the modal
	var modal = document.getElementById('id01');

	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
	}
</script>
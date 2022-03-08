<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>
.pname {
	text-align: center;
}

h3 {
	font-family: "Open Sans", sans-serif;
}

table {
	border-spacing: 10px;
	border-collapse: separate;
	font-size: 20px;
}

image {
	width: 80px;
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

<script type="text/javascript">
	function addCartBtn() {
		if (confirm("쇼핑카트에 담으시겠습니까?")) { //확인
			//javascript form submit
			document.getElementById("addCartForm").submit();
			//command:addcart가 전송되어 AddCartController가 실행됨
		} else { //취소
			return;
		}
	}
</script>
<body class="sub_page">
	<section class="food_section layout_padding">
		<div class="container" align="center">
			<form id="frm" name="frm" action="addToCart.do" method="POST">
				<input type="hidden" name="pno" value="${product.pno }">
				<div align='center'>
			
					<h3 class="pname">${product.pname }</h3>
					<br/>
					<table>
						<tr>
							<td rowspan='4'><img src="images/${product.image }"
								width="350" height="400" style="margin-right: 20px;"></td>
							<td>
								<table>
									<tr>
										<th></th>
									</tr>
									<tr>
										<td width="550">${product.pcontent }</td>
									</tr>
									<tr>
										<td><fmt:formatNumber value="${product.price}"
												pattern="###,###,###" />원</td>
									</tr>
									<tr>
										<td>수량</td>
									</tr>
									<tr>
										<td>
											
											<input type="hidden" name="command" value="addcart">
											<button type="submit" onclick="addCartBtn();">장바구니 담기</button>
											
										</td>
									</tr>
								</table>
							</td>
						</tr>


					</table>
				</div>
			</form>

		</div>
	</section>
</body>

</html>
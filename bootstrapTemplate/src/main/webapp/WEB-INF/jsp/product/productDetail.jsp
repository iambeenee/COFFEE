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

document.addEventListener("DOMContentLoaded", function() {

	const frm = document.getElementsByName("frm"), 
		  price = document.frm.price, 
		  quantity = document.frm.quantity, 
		  add = document.frm.add, 
		  minus = document.frm.minus, 
		  amount = document.frm.amount;


	if (frm) {
		amount.value = price.value;

		let quantityval = quantity.value;
		amountval = amount.value;
		priceval = price.value;

		if (add) {
			add.addEventListener('click', function() {
				quantityval++;
				amountval = quantityval * priceval;
				quantity.value = quantityval;
				amount.value = amountval;
				console.log(quantityval, amountval, priceval);
			})
		}
		if (minus) {
			minus.addEventListener('click', function() {
				
				if (quantity.value > 1) {
					quantityval--;
					amountval = quantityval * priceval;
					quantity.value = quantityval;
					amount.value = amountval;
					console.log(quantityval, amountval, priceval);
				} else {
					quantityval = 1;
				}
			})
		}
	}
})

	
	
</script>


<body class="sub_page">
	<section class="food_section layout_padding">
		<div class="container" align="center">
			<form id="frm" name="frm" action="addToCart.do" method="POST">
				<input type="hidden" name="pno" value="${product.pno}">
				<div align='center'>

					<h3 class="pname">${product.pname }</h3>
					<br />
					<table>
						<tr>
							<td rowspan='4'><img src="images/${product.image}"
								width="350" height="400" style="margin-right: 20px;"></td>
							<td>
								<table>
									<tr>
										<th></th>
									</tr>
									<tr>
										<td width="550">${product.pcontent}</td>
									</tr>
									<tr>
										<td><fmt:formatNumber value="${product.price}"
												pattern="###,###,###" />???</td>
									</tr>
									<tr>
										<td>?????? <input type="hidden" name="price"
											value="${product.price}"> <input type="button"
											value=" - " name="minus"> <input type="text"
											name="quantity" value="1" size="3" max="10"> <input
											type="button" value=" + " name="add"> <br>
										</td>
									</tr>
									<tr>
										<td>??? ?????? ?????? <input type="text" name="amount" size="11"
											readonly>???
										</td>
									</tr>
									<tr>
										<td><input type="hidden" name="command" value="addcart">
											<button type="submit" onclick="addCartBtn();">????????????
												??????</button></td>
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

<script>
/*  function addCartBtn() {
if (${id} != 0) {
	
}
if (confirm("??????????????? ??????????????????????")) { //??????
	//javascript form submit
	document.getElementById("addcart").submit();
	//command:addcart??? ???????????? AddCartController??? ?????????
} else { //??????
	return;
}

	//?????? ?????????
if (confirm("??????????????? ?????????????????????!\n??????????????? ?????????????????????????")) {
	location.href = ""
} else { // ?????? ?????????
	location.href = ""
} 
}  */
</script>

</html>
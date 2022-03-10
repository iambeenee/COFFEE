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
	function deleteItemBtn() {
		if (confirm("장바구니에서 해당 상품을 삭제하시겠습니까?")) {
			//javascript form submit
			document.getElementById("deleteItemForm").submit();
			//command(deleteCart)와 itemNo(${item.itemNo})이 front로 제출된다.
		} else {
			return;
		}
	}

	function fnPay() {
		alert("결제 API를 발급 받으시기 바랍니다.");
	}

	function fnClear() {
		if (confirm("장바구니를 비우시겠습니까?")) {
			location.href = "CartClear.";
		}
	}

	function fnGo() {
		location.href = "ShopMallMain.jsp";
	}

	출처: https: //upcake.tistory.com/264 [오늘이라도]
</script>

<body class="sub_page">
	<section class="food_section layout_padding">
		<div class="container" align="center">
			<div align='center'>
				<div class="heading_container heading_center">
					<h3>장바구니</h3>

					<c:choose>
						<c:when test="${empty cartList}">
							장바구니에 담긴 상품이 없습니다.
						</c:when>

						<c:otherwise>
							<form id="frm" name="frm" action="orderForm.do" method="POST">

								<table>
									<tr>
										<th width="60">선택</th>
										<th width="80">이미지</th>
										<th width="400">상품명</th>
										<th width="50">단가</th>
										<th width="50">수량</th>
										<th width="100">금액</th>
									</tr>
									<c:forEach items="${cartList}" var="cart">
										<tr>
											<td><input type="checkbox"></td>
											<td><img src="images/${cart.image}" width="40"
												height="30"></td>
											<td>${cart.pname}</td>
											<td>${cart.price}</td>
											<td>${cart.quantity}</td>
											<td>${cart.amount}</td>

										</tr>
									</c:forEach>

								</table>
								<br />
								<div>총 결제 금액 : ${totalAcount }</div>
							</form>
						</c:otherwise>
					</c:choose>
					<input type='button' value='결제하기' onclick='fnPay()' /> <input
						type='button' value='장바구니 비우기' onclick='fnClear()' /> <input
						type='button' value='쇼핑 계속하기' onclick='fnGo()' />

				</div>
			</div>
		</div>
	</section>


</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<title>Insert title here</title>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>

<style>
	#image,
	#pname,
	#price,
	#pcontent {
		width: 400px;
	}

	#pcontent {
		height: 500px;
	}
	.select_img img {
		margine: 20px, 0;
	}
</style>

<body>

	<script>
		$(document).ready(function () {
			$('#image').change(function () {
				console.log('hhhh')
				if (this.files && this.files[0]) {
					var reader = new FileReader();
					reader.onload = function (data) {
						$('.select_img img').attr('src', data.target.result).width(500);
					}
					reader.readAsDataURL(this.files[0]);
				}
			});
		});
	</script>



	<div align="center">

		<div>
			<h3>상 품 등 록</h3>
		</div>


		<div>
			<form id="frm" action="productUpload.do" method="post">
				<div>
					<table>
						<tr>
							<th width="100">상품이미지</th>
							<td>
							<div class="inputArea">
							<label for="image">이미지</label>
							<input type="file" id="image" name="image" />
							<div class="select_img"> <img src="" /></div>
							</div>
							</td>
						</tr>
						<tr>
							<th width="100">분류</th>
							<td><select id="kind" name="kind">
									<option value="a">원두</option>
									<option value="b">생두</option>
									<option value="c">선물세트</option>
									<option value="d">추출도구</option>
								</select></td>
						</tr>
						<tr>
							<th>상품명</th>
							<td><input type="text" id="pname" name="pname" required="required"></td>
						</tr>
						<tr>
							<th>판매금액</th>
							<td><input type="text" id="price" name="price" required="required"></td>
						</tr>
						<tr>
							<th>상품설명</th>
							<td><input type="text" id="pcontent" name="pcontent" required="required"></td>
						</tr>
					</table>

					<input type="submit" value="등록">

				</div>
			</form>
		</div>
	</div>


</body>

</html>
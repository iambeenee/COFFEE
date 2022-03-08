<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<style>
input[type=text]{
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

input[type=file]{
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid white;
	box-sizing: border-box;
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

th {
	width: 100px;
}

#image, #pname, #price, #pcontent {
	width: 400px;
}

#pcontent {
	height: 500px;
}

.select_img img {
	margine: 20px, 0;
}
</style>



<script>
	//업로드할 이미지파일의 섬네일을 띄워주는 function
	$(document).ready(function() {
		$('#image').change(function() {
			if (this.files && this.files[0]) {
				var reader = new FileReader();
				reader.onload = function(data) {
					$('.select_img img').attr('src', data.target.result).width(500);
				}
				reader.readAsDataURL(this.files[0]);
				}
			});
		});
</script>


<body class="sub_page">
	<section class="food_section layout_padding">
		<div class="container" align="center">
			<div align='center'>
				<div class="heading_container heading_center">
					<h3>상 품 등 록</h3>
				</div>
				<br />
				<div>
					<form id="frm" action="productUpload.do" method="post">
						<table>
							<tr>
								<th>상품이미지</th>
								<td><input type="file" id="image" name="image" />
									<div class="select_img">
										<img src="" />
									</div>
								</td>
							</tr>
							<tr>
								<th>분류</th>
								<td><select id="kind" name="kind">
										<option value="a">원두</option>
										<option value="b">드립백</option>
										<option value="c">선물세트</option>
										<option value="d">추출도구</option>
								</select></td>
							</tr>
							<tr>
								<th>상품명</th>
								<td><input type="text" id="pname" name="pname" required></td>
							</tr>
							<tr>
								<th>판매금액</th>
								<td><input type="text" id="price" name="price" required></td>
							</tr>
							<tr>
								<th>상품설명</th>
								<td><input type="text" id="pcontent" name="pcontent" required></td>
							</tr>
						</table>
						<br/>
						<div>
							<button type="submit">등록</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
</body>
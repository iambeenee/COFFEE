<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품등록</title>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath }/ckeditor/ckeditor.js"></script>
	<script>
		$(function () {
			CKEDITOR.replace('content', {
				filebrowserUploadUrl: "${pageContext.request.contextPath}/fileUpload"
			})
		});
</script>
	
	
</head>

<style>
#pname, #price, #pcontent {
	width:400px;
}
#pcontent {
	height:500px;
}
</style>

<body>

	<div align="center">
		<div><h3>상 품 등 록</h3></div>

	<div>
		<form id="frm" action="productUpload.do" method="post">
			<div>
				<table>
					<tr>
						<th width="100">상품이미지</th>
						<td width="500"><input type="image" id="image" name="image"
							required="required"></td>
					</tr>
					<tr>
						<th>분류</th>
						<td><select id="kind" name="kind">
								<option value="a">원두</option>
								<option value="b">생두</option>
								<option value="c">선물세트</option>
								<option value="d">추출도구</option></select>
						</td>
					<tr>
					<tr>
						<th>상품명</th>
						<td><input type="text" id="pname" name="pname"
							required="required"></td>
					</tr>
					<tr>
						<th>판매금액</th>
						<td><input type="text" id="price" name="price"
							required="required"></td>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품등록</title>
</head>

<style>
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

div {
  border-radius: 5px;
  
}
</style>

<body>

	
	<h3 align="center">상품등록</h3>

<div>
  <form action="/action_page.php">
  
    
    <label for="pname">상품명</label>
    <input type="text" id="pname" name="pname">

	<label for="price">판매금액</label>
	<input type="text" id="price" name="price">
	
    <label for="pcontent">상품설명</label>
    <input type="text" id="pcontent" name="pcontent">

    <label for="kind">분류</label>
    <select id="kind" name="kind">
      <option value="a">원두</option>
      <option value="b">생두</option>
      <option value="c">선물세트</option>
      <option value="d">추출도구</option>
    </select>
  
    <input type="submit" value="등록">
  </form>
</div>



	
</body>


</html>
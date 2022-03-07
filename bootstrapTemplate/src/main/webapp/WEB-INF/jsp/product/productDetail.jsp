<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function addCartBtn(){
		if (confirm("쇼핑카트에 담으시겠습니까?")){ //확인
			//javascript form submit
			document.getElementById("addCartForm").submit();
			//command:addcart가 전송되어 AddCartController가 실행됨
		} else { //취소
			return;
		}
	}
</script>
<body>




</body>
</html>
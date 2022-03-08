<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style>
/* Full-width input fields */
input {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

/* Set a style for all buttons */
button.idCheck {
	display: inline-block;
	padding: 5px 10px;
	border: none;
	background-color: white;
	color: black;
	-webkit-transition: all 0.3s;
	transition: all 0.3s;
	background-color: white;
}

button.idCheck:hover {
	font-size: large;
	font-weight: 500;
	color: #ffbe33;
}

div>button {
	display: inline-block;
	padding: 8px 30px;
	background-color: #ffbe33;
	color: #ffffff;
	border-radius: 45px;
	-webkit-transition: all 0.3s;
	transition: all 0.3s;
	border: none;
}

div>button:hover {
	background-color: #e69c00;
}

th {
	width: 170px;
}
</style>

<body class="sub_page">
	<section class="food_section layout_padding">
		<div class="container" align="center">
			<div align='center'>
				<div class="heading_container heading_center">
					<h2>JOIN</h2>
				</div>
				<br />
				<div>
					<form id="frm" name="frm" action="memberJoinSession.do"
						method="POST">
						<div>
							<table>
								<tr>
									<th>ID</th>
									<td><input type="text" id="id" name="id" size="60"
										required placeholder="ID"></td>
									<td><button class="idCheck" onclick="id_Check(event)"
											id="idCheck" value="No">중복체크</button></td>
								</tr>
								<tr>
									<th>PASSWORD</th>
									<td><input type="password" id="password" name="password"
										size="60" required placeholder="PASSWORD"></td>
								</tr>
								<tr>
									<th>PASSWORD CHECK</th>
									<td><input type="password" id="password1" name="password1"
										size="60" required placeholder="PASSWORD CHECK"></td>
								</tr>
								<tr>
									<th>NAME</th>
									<td><input type="text" id="name" name="name" size="60" required
										placeholder="NAME"></td>
								</tr>
								<tr>
									<th>ADDRESS</th>
									<td><input type="text" id="address" name="address" required
										size="60" placeholder="ADDRESS"></td>
								</tr>
								<tr>
									<th>TEL</th>
									<td><input type="text" id="tel" name="tel" size="60" required
										placeholder="010-1234-5678"></td>
								</tr>
								<tr>
									<th>EMAIL</th>
									<td><input type="email" id="email" name="email" size="60" required
										placeholder="abc@abc.com"></td>
								</tr>
							</table>
						</div>
						<br />
						<div>
							<button type="submit" onclick="formCheck()">회원가입</button>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<button type="reset">취 소</button>
							&nbsp;&nbsp;&nbsp;
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
</body>

<script type="text/javascript">
	// ajax로 아이디를 중복체크
	function id_Check(e) {
		e.preventDefault();
		const xhttp = new XMLHttpRequest(); // aJax객체를 생성
		const id = frm.id.value;
		xhttp.onreadystatechange = function() { // ajax가 동작될 때 실행하는 메소드
			if (xhttp.readyState == 4) { // 통신이 연결돼서 데이터가 다 전달되었다면
				if (xhttp.status == 200) { // 정상적으로 종료되었을 때
					let b = xhttp.responseText; // 결과데이터 받는 부분
					if (b == '1') {
						alert(id + "는 사용가능한 아이디 입니다.");
						frm.idCheck.value = "Yes";
						frm.idCheck.style.display = "none";
						frm.password.focus();
					} else {
						alert(id + "는 이미 사용중인 이이디 입니다.");
						frm.id.value = "";
						frm.id.focus();
					}
				}
			}
		}
		xhttp.open("GET", "ajaxIdCheck.do?id=" + id); // 호출해야 할 방법과 주소
		xhttp.send(); // ajax 호출하는 부분
	}

	// 비밀번호 일치여부 확인
	function formCheck() {
		if (frm.idCheck.value != 'Yes') {
			alert("아이디 중복체크를 해주세요.");
			frm.id.focus();
		}

		if (frm.password.value != frm.password1.value) {
			alert("비밀번호가 일치하지 않습니다.");
			frm.password.value = "";
			frm.password1.value = "";
			frm.password.focus();
		}
	}
</script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div align='center'>
	<div>
		<h1>회 원 가 입</h1>
	</div>

	<div>
		<form id="frm" name="frm" action="memberJoin.do" method="POST">
			<div>
				<table border="1">
					<tr>
						<th width="150">아 이 디</th>
						<td width="700"><input type="text" id="id" name="id" size="60" required="required" placeholder="아이디를 입력해 주세요.">&nbsp;&nbsp;
							<button type="button" onclick="idCheck()" id="idCheck" value="unChecked">중복체크</button>
						</td>
					</tr>
					<tr>
						<th width="150">비밀번호</th>
						<td width="700"><input type="password" id="password" name="password" size="60" required="required" placeholder="비밀번호를 입력해 주세요."></td>
					</tr>
					<tr>
						<th width="150">비밀번호 확인</th>
						<td width="700"><input type="password" id="password1" name="password1" size="60" required="required" placeholder="비밀번호를 한 번 더 입력해 주세요."></td>
					</tr>
					<tr>
						<th width="150">이 름</th>
						<td width="700"><input type="text" id="name" name="name" size="60" required="required" placeholder="이름을 입력해 주세요."></td>
					</tr>
					<tr>
						<th width="150">주 소</th>
						<td width="700"><input type="text" id="address" name="address" size="60" required="required" placeholder="주소를 입력해 주세요."></td>
					</tr>
					<tr>
						<th width="150">전화번호</th>
						<td width="700"><input type="text" id="address" name="address" size="60" required="required" placeholder="010-1234-5678"></td>
					</tr>
				</table>
			</div><br/>
			
			<div>
				<button type="button" onclick="formCheck()">회원가입</button>&nbsp;&nbsp;&nbsp;
				<button type="reset">취 소</button>&nbsp;&nbsp;&nbsp;
				<button type="button" onclick="location.href='main.do'">홈</button>
			</div>
		</form>
	</div>
</div>

<script type="text/javascript">
	// ajax로 아이디를 중복체크
	function idCheck() {
		const xhttp = new XMLHttpRequest(); // aJax객체를 생성
		const id = frm.id.value;
		xhttp.onreadystatechange = function() { // ajax가 동작될 때 실행하는 메소드
			if (xhttp.readyState == 4) { // 통신이 연결돼서 데이터가 다 전달되었다면
				if (xhttp.status == 200) { // 정상적으로 종료되었을 때
					let b = xhttp.responseText; // 결과데이터 받는 부분
					if (b == '1') {
						alert(id + "는 사용가능한 아이디 입니다.");
						frm.idCheck.value = "checked";
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
			return false;
		}

		if (frm.password.value != frm.password1.value) {
			alert("비밀번호가 일치하지 않습니다.");
			frm.password.value = "";
			frm.password1.value = "";
			frm.password.focus();
			return false;
		}
		return true;
	}
</script>
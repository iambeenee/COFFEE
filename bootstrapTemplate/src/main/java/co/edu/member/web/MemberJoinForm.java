package co.edu.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.DbCommand;

public class MemberJoinForm implements DbCommand{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 회원가입 폼 호출
		return "member/memberJoinForm.tiles";
	}

}

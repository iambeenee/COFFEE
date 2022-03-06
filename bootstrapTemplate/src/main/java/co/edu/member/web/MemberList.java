package co.edu.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.DbCommand;
import co.edu.member.MemberService;
import co.edu.member.MemberServiceImpl;

public class MemberList implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 회원 목록
		MemberService memberDAO = new MemberServiceImpl();
		request.setAttribute("members", memberDAO.selectMemberList());
		
		return "member/memberList.tiles";
	}

}

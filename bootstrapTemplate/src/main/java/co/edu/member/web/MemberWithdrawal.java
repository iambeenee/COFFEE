package co.edu.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.DbCommand;
import co.edu.member.service.MemberService;
import co.edu.member.serviceImpl.MemberServiceImpl;
import co.edu.member.vo.MemberVO;

public class MemberWithdrawal implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 회원탈퇴처리
		MemberService memberDAO = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		
		memberDAO.deleteMember(vo);
		
		return "member/memberWithdrawal.tiles";
	}

}

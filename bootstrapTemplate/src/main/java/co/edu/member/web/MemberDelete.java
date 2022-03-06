package co.edu.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.DbCommand;
import co.edu.member.MemberService;
import co.edu.member.MemberServiceImpl;
import co.edu.member.MemberVO;

public class MemberDelete implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 회원탈퇴처리
		MemberService memberDAO = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo.setName(request.getParameter("name"));
		vo.setAddress(request.getParameter("address"));
		vo.setTel(request.getParameter("tel"));
		vo.setEmail(request.getParameter("email"));
		vo.setDate(request.getParameter("date"));
		vo.setAuthor(request.getParameter("author"));
		
		int n = memberDAO.deleteMember(vo);
		if(n != 0) {
			request.setAttribute("message", "탈퇴가 정상적으로 처리되었습니다. 이용해 주셔서 감사합니다.");
			return "member/memberMessage.tiles";
		} else {
			request.setAttribute("message", "탈퇴가 정상적으로 처리되지 않았습니다. 다시 시도해 주세요");
			return "member/memberMessage.tiles";
		}
	}

}

package co.edu.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.common.DbCommand;
import co.edu.member.MemberService;
import co.edu.member.MemberServiceImpl;
import co.edu.member.MemberVO;

public class MemberUpdateForm implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 회원정보 수정 폼 호출
		HttpSession session = request.getSession();
		String searchId = (String) session.getAttribute("id");
		MemberVO vo = new MemberVO();
		vo.setId(searchId);

		MemberService service = new MemberServiceImpl();
		vo = service.selecteMember(vo);
		
		request.setAttribute("member", vo);

		return "member/memberUpdateForm.tiles";
	}
}

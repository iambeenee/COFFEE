package co.edu.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.DbCommand;
import co.edu.member.MemberService;
import co.edu.member.MemberServiceImpl;
import co.edu.member.MemberVO;

public class MemberJoinSession implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 회원가입 처리
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

		int n = memberDAO.insertMember(vo);
		if(n != 0) {
			request.setAttribute("message", "회원가입을 축하합니다.");
			return "member/memberMessage.tiles";
		} else {
			return "memberJoinForm.do";
		}
	}
}

package co.edu.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.common.DbCommand;
import co.edu.member.service.MemberService;
import co.edu.member.serviceImpl.MemberServiceImpl;
import co.edu.member.vo.MemberVO;

public class MemberLoginSession implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 로그인 처리
		MemberService memberDAO = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		HttpSession session = request.getSession(); // 서버가 가지고 있는 세션 객체를 호출

		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));

		vo = memberDAO.loginCheck(vo);
		System.out.println(vo.getName());
		// 세션처리
		if (vo.getName() != null) {
			session.setAttribute("id", vo.getId());
			session.setAttribute("name", vo.getName());
			session.setAttribute("author", vo.getAuthor());
			
			System.out.println(vo.getAuthor());
			
			return "main.do";

		} else {
			request.setAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
			return "memberLoginFail.do";
		}
	}

}

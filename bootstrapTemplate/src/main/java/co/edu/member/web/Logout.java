package co.edu.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.common.DbCommand;
import co.edu.member.vo.MemberVO;

public class Logout implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 로그아웃 처리
		HttpSession session = request.getSession();
		session.invalidate(); // 세션자체를 삭제
		
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		
		request.setAttribute("message", vo.getId() + "님 정상적으로 로그아웃되었습니다.");
		
		return "member/memberMessage.tiles";
	}

}

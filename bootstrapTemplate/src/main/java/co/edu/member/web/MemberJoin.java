package co.edu.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.common.DbCommand;
import co.edu.member.service.MemberService;
import co.edu.member.serviceImpl.MemberServiceImpl;
import co.edu.member.vo.MemberVO;

public class MemberJoin implements DbCommand{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 세션객체에 서버가 가지고있는 세션객체를 담음
		HttpSession session = request.getSession();
		
		// 회원가입 처리
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		member.setAddress(address);
		member.setTel(tel);
		
		MemberService service = new MemberServiceImpl();
		service.insertMember(member);
		
		session.setAttribute("idd", id);
		request.setAttribute("member", member);
		
		
		return "main/main.tiles";
	}

}

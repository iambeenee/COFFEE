package co.edu.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mvel2.sh.Command;

import co.edu.member.service.MemberService;
import co.edu.member.serviceImpl.MemberServiceImpl;

public class AjaxIdCheck implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// Ajax를 이용한 아이디 중복체크
		MemberService memberDao = new MemberServiceImpl();
		String id = request.getParameter("id");
		
		boolean b = memberDao.isIdcheck(id);
		
		if (b) {
			return "ajax:1"; // 사용가능한 아이디
		} else {
			return "ajax:0"; // 이미존재하는 이이디
		}
	}

}

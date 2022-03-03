package co.edu.member.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.member.serviceImpl.MemberServiceImpl;

@WebServlet("/ajaxIdCheck")
public class AjaxIdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AjaxIdCheck() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 한글깨짐 방지
		String id = request.getParameter("id");
		PrintWriter out = response.getWriter(); // 결과를 돌려주기 위해
		MemberServiceImpl dao = new MemberServiceImpl(); // 모델시작
		int idCheck = dao.idCheck(id);
		
		if(idCheck == 0) {
			System.out.println("사용 불가");
		} else if (idCheck == 1) {
			System.out.println("사용 가능");
		}
		out.write(idCheck);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

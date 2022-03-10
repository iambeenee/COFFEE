package co.edu.common;

import java.io.IOException;

import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.aboutus.AboutUs;
import co.edu.cart.web.CartList;
import co.edu.member.web.MemberJoinForm;
import co.edu.member.web.MemberList;
import co.edu.member.web.MemberLogin;
import co.edu.member.web.MemberLoginSession;
import co.edu.member.web.MemberUpdate;
import co.edu.member.web.MemberUpdateForm;
import co.edu.notice.web.NoticeList;
import co.edu.notice.web.NoticeSelect;
import co.edu.notice.web.NoticeUpdate;
import co.edu.notice.web.NoticeUpdateForm;
import co.edu.notice.web.NoticeDelete;
import co.edu.notice.web.NoticeInsert;
import co.edu.notice.web.NoticeInsertForm;
import co.edu.member.web.MemberDelete;
import co.edu.member.web.MemberJoinSession;
import co.edu.product.web.ProductDetail;
import co.edu.product.web.ProductForm;
import co.edu.product.web.ProductList;
import co.edu.product.web.ProductUpload;
import co.edu.qna.web.QnaList;
import co.edu.qna.web.QnaSelect;
import co.edu.member.web.AjaxIdCheck;
import co.edu.member.web.Logout;

//@WebServlet("/FrontController")
public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private HashMap<String, DbCommand> map = new HashMap<String, DbCommand>();

	public FrontController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		// 시작페이지
		map.put("/main.do", new MainPage()); 
		
		// member
		map.put("/memberLogin.do", new MemberLogin()); // 로그인 호출
		map.put("/memberLoginSession.do", new MemberLoginSession()); // 로그인 후 세션처리
		map.put("/logout.do", new Logout()); // 로그아웃-세션제거
		map.put("/memberJoinForm.do", new MemberJoinForm()); //회원가입 폼 호출
		map.put("/ajaxIdCheck.do", new AjaxIdCheck()); // 아이디 중복체크(ajax)
		map.put("/memberJoinSession.do", new MemberJoinSession()); //회원가입 후 세션처리
		map.put("/memberUpdateForm.do", new MemberUpdateForm()); // 회원정보 수정 폼 호출
		map.put("/memberUpdate.do", new MemberUpdate()); // 회원정보 수정 처리
		map.put("/memberList.do", new MemberList()); // 회원목록 호출
		map.put("/memberDelete.do", new MemberDelete()); // 회원탈퇴
		
		//ABOUT US
		map.put("/aboutUs.do", new AboutUs());
		
		//PRODUCT
		map.put("/productList.do", new ProductList()); //상품리스트
		map.put("/productForm.do", new ProductForm()); //상품등록(관리자 권한)
		map.put("/productUpload.do", new ProductUpload()); //상품업로드
		map.put("/productDetail.do", new ProductDetail()); //상품상세페이지
		
		//CART
		map.put("/cartList.do", new CartList());    //장바구니
		
		//NOTICE
		map.put("/noticeList.do", new NoticeList()); // 리스트
		map.put("/noticeSelect.do", new NoticeSelect()); // 선택 - 세부내역보기
		map.put("/noticeInsertForm.do", new NoticeInsertForm()); // 등록 폼 호출
		map.put("/noticeInsert.do", new NoticeInsert()); // 등록 처리
		map.put("/noticeUpdateForm.do", new NoticeUpdateForm()); // 수정 폼 호출
		map.put("/noticeUpdate.do", new NoticeUpdate()); // 수정 처리
		map.put("/noticeDelete.do", new NoticeDelete()); //삭제 처리
		
		//Q&A
		map.put("/qnaList.do", new QnaList()); // 리스트
		map.put("/qnaSelect.do", new QnaSelect()); // 선택 - 세부내역보기
		

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO 실제처리할 command를 호출하고, 결과를 돌려줄 페이지를 작성하는 곳
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = uri.substring(contextPath.length());

		DbCommand dbCommand = map.get(path);
		String viewPage = dbCommand.execute(request, response);

		if (viewPage != null) {
			// ajax 응답
			if (viewPage.startsWith("ajax:")) {
				response.setContentType("text/plain; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5));
				return;
			}

			// 뷰페이지 포워드
			if (viewPage.endsWith(".jsp"))
				viewPage = "WEB-INF/jsp/" + viewPage;
			
			// main/main.tiles => main/main.jsp(template.jsp)
			System.out.println(viewPage);
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}

}

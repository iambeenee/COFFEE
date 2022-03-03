package co.edu.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
import co.edu.member.web.MemberJoin;
=======
import co.edu.aboutus.AboutUs;
>>>>>>> branch 'master' of https://github.com/iambeenee/COFFEE.git
import co.edu.member.web.MemberJoinForm;
import co.edu.member.web.MemberLoginForm;
import co.edu.product.web.ProductForm;
import co.edu.product.web.ProductList;
import co.edu.product.web.ProductUpload;


//@WebServlet("/FrontController")
public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private HashMap<String, DbCommand> map = new HashMap<String, DbCommand>();

	public FrontController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		// 호출명 저장소
		map.put("/main.do", new MainPage()); // 시작페이지
		map.put("/memberLoginForm.do", new MemberLoginForm()); // 로그인 폼 호출
		map.put("/memberJoinForm.do", new MemberJoinForm()); // 회원가입 폼 호출
		map.put("/memberJoin.do", new MemberJoin());
		
		//ABOUT US
		map.put("/aboutUs.do", new AboutUs());
		
		
		//PRODUCT
		map.put("/productList.do", new ProductList()); //상품리스트
		map.put("/productForm.do", new ProductForm()); //상품등록(관리자 권한)
		map.put("/productUpload.do", new ProductUpload()); //상품업로드

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

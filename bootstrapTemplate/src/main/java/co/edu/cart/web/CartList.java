package co.edu.cart.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.common.DbCommand;
import co.edu.product.ProductVO;

public class CartList implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 장바구니 리스트
		HttpSession session = request.getSession();
		String searchNo = request.getParameter("pno");
		searchNo = searchNo == null ? "1" : searchNo;
		
		ProductVO vo = new ProductVO();
		vo.setPno(Integer.parseInt(searchNo));
		
		request.setAttribute("product", vo);
		
		return "cart/cartList.tiles";
	}

}

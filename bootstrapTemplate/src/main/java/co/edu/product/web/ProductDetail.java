package co.edu.product.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.common.DbCommand;
import co.edu.product.ProductService;
import co.edu.product.ProductServiceImpl;
import co.edu.product.ProductVO;

public class ProductDetail implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 상품 상세 페이지
		HttpSession session = request.getSession();
		String searchNo = request.getParameter("pno");
		searchNo = searchNo == null ? "1" : searchNo;
		ProductVO vo = new ProductVO();
		vo.setPno(Integer.parseInt(searchNo));

		ProductService dao = new ProductServiceImpl();
		vo = dao.selectProduct(vo);

		request.setAttribute("product", vo);

		return "product/productDetail.tiles";
	}
}

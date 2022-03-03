package co.edu.product.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.common.DbCommand;
import co.edu.product.ProductService;
import co.edu.product.ProductServiceImpl;
import co.edu.product.ProductVO;

public class ProductUpload implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 서버가 가지고 있는 세션객체를 담음
		HttpSession session = request.getSession();
		
		// 상품 등록 처리
		String pName = request.getParameter("p_name");
		String kind = request.getParameter("kind");
		String price = request.getParameter("price");
		String pContent = request.getParameter("p_content");
		String image = request.getParameter("p_content");
		String regDate = request.getParameter("reg_date");
		
		ProductVO product = new ProductVO();
		product.setProductpName(pName);
		product.setProductKind(kind);
		product.setProductPrice(price);
		product.setProductpContent(pContent);
		product.setProductImage(image);
		product.setProductRegDate(regDate);
		
		ProductService service = new ProductServiceImpl();
		service.insertProduct(product);
		
		session.setAttribute("p_name", pName);
		request.setAttribute("", product);
		return null;
	}

}

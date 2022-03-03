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
		
		
		// 상품 등록 처리
		String pName = request.getParameter("p_name");
		String kind = request.getParameter("kind");
		String price = request.getParameter("price");
		String pContent = request.getParameter("p_content");
		String image = request.getParameter("p_content");
		String regDate = request.getParameter("reg_date");
		
		ProductVO product = new ProductVO();
		product.setpName(pName);
		product.setKind(kind);
		product.setPrice(Integer.parseInt(price));
		product.setpContent(pContent);
		product.setImage(image);
		product.setRegDate(regDate);
		
		ProductService service = new ProductServiceImpl();
		service.insertProduct(product);
		
		
		return "product/productList.tiles";
	}

}

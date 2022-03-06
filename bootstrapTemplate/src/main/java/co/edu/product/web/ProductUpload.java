package co.edu.product.web;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import co.edu.common.DbCommand;
import co.edu.product.ProductService;
import co.edu.product.ProductServiceImpl;
import co.edu.product.ProductVO;

public class ProductUpload implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		// 상품 등록 처리
		String pname = request.getParameter("p_name");
		String kind = request.getParameter("kind");
		String price = request.getParameter("price");
		String pcontent = request.getParameter("p_content");
		String image = request.getParameter("image");
		String regdate = request.getParameter("reg_date");
		
		ProductVO product = new ProductVO();
		product.setPname(pname);
		product.setKind(kind);
		product.setPrice(Integer.parseInt(price));
		product.setPcontent(pcontent);
		product.setImage(image);
		product.setRegdate(regdate);
		
		ProductService service = new ProductServiceImpl();
		service.insertProduct(product);
		
		
		return "product/productList.tiles";
	}

}

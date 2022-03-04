package co.edu.product.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.DbCommand;
import co.edu.product.ProductService;
import co.edu.product.ProductServiceImpl;
import co.edu.product.ProductVO;

public class ProductList implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 상품 리스트
		ProductService service = new ProductServiceImpl();
		List<ProductVO> list = service.selectProductList();
		
		request.setAttribute("list", list);
		request.setAttribute("products", "hhhhh");
		
		return "product/productList.tiles";
	}

}

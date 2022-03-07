package co.edu.product.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.DbCommand;

public class ProductDetail implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 상품 상세 페이지
		
		
		
		
		return "product/productDetail.tiles";
	}

}

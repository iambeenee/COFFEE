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
		ProductService productDAO = new ProductServiceImpl();
		ProductVO vo = new ProductVO();
		
		vo.setPname(request.getParameter("pname"));
		vo.setKind(request.getParameter("kind"));
		vo.setPrice(Integer.parseInt(request.getParameter("price")));
		vo.setPcontent(request.getParameter("pcontent"));
		vo.setImage(request.getParameter("image"));
				
		int n = productDAO.insertProduct(vo);
		
		if(n != 0) {
			return "productList.do";
		} else {
			return "product/productForm.tiles";
		}
				
		
	}

}

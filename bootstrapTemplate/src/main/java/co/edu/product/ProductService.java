package co.edu.product;

import java.util.List;

public interface ProductService {

	List<ProductVO> selectProductList();   //상품전체조회
	ProductVO selectProduct(ProductVO vo); //상품단건조회
	public int insertProduct(ProductVO vo); //상품등록
	public int updateProduct(ProductVO vo); //상품정보수정
	public int deleteProduct(ProductVO vo); //상품삭제
}

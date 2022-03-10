package co.edu.cart.vo;

import java.util.List;

public interface CartService {
	
	List<CartVO> selectCartList();		//장바구니에 담긴 상품 전체보기
	CartVO selectCart(CartVO vo); 		//한건조회
	public int insertCart(CartVO vo); 	//장바구니에 상품 추가
	public int updateCart(CartVO vo); 	//장바구니 상품 정보(수량,가격) 수정
	public int deleteCart(CartVO vo); 	//장바구니 상품 삭제
	
}

package co.edu.cart.vo;

import java.util.List;

public interface CartService {
	
	List<CartVO> selectCartList();		//카트전체보기
	CartVO selectCart(CartVO vo); //한건조회
	public int insertCart(CartVO vo); //장바구니에 상품 추가
	public int updateCart(CartVO vo); //장바구니 정보 수정
	public int deleteCart(CartVO vo); //장바구니 삭제
	
}

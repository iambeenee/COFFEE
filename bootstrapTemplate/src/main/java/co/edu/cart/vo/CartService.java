package co.edu.cart.vo;

import java.util.List;

public interface CartService {
	
	List<CartVO> cartMoney();		
	void insert(CartVO vo);             //장바구니 추가
	List<CartVO> listCart(String id);   //사용자의 장바구니에 담긴 상품 전체보기
	void delete(int cno);				//장바구니 개별 삭제
	void deleteAll(String id);			//장바구니 비우기
	void update(int cno); 				
	int sumMoney(String id);			//장바구니 금액 합계
	int countCart(String id, int pno);  //장바구니 상품 갯수
	void updateCart(CartVO vo);			//장바구니 수정
	void modifyCart(CartVO vo);
	
}

package co.edu.cart.web;

import java.util.ArrayList;

import co.edu.product.ProductVO;

public class Cart {

	private ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
	public ArrayList<ProductVO> getProductList() {
		return productList;
	}
	
	
	//상품번호(pno)에 해당하는 상품이 없으면 -1 리턴, 있으면 해당 상품 객체의 리스트에서 인덱스를 반환
	public int findIndexByNo( pno) {
		int index = -1;
		
		
		// i = 리스트 인덱스 번호
		// index = 리스트에 존재하는 상품의 위치(인덱스)
		for(int i=0; i<productList.size(); i++) {
			//리스트에 i번째(인덱스)의 pno가 입력받은 pno와 일치했을 때,
			//index는 상품의 위치를 반환해준다.
			if(productList.get(i).getPno().contentEquals(pno)) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	/*
	 * add(ProductVO):void
	 * 1) 장바구니에 상품 추가
	 * 2) 장바구니에 상품이 중복되면 DuplicateItemException을 발생시키고 throw 한다.
	 */
	
	public void addCart(ProductVO vo) throws DuplicateProductException {
		//기존 리스트에 추가하려는 상품이 존지하면(-1) DuplicateProductException 발생
		if (findIndexByNo(vo.getPno()) != -1) {
			throw new DuplicateProductException();
		}
		//중복되지 않으면 add
		productList.add(vo);
	}
	
	/*
	 * removeProduct(String pno):void
	 * 3)장바구니에서 상품을 삭제
	 */
	public void removeProduct(String pno) {
		//pno를 통해 해당 상품의 index를 받아옴
		int index = findIndexByNo(pno);
		//list에서 해당 index 객체 삭제
		productList.remove(index);
	}
	
	/*
	 * getTotal
	 */
}

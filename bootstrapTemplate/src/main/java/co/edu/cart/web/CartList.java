package co.edu.cart.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.DbCommand;

public class CartList implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "cart/cartList.tiles";
	}

}

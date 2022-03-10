package co.edu.cart.vo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.cart.vo.CartService;
import co.edu.cart.vo.CartVO;
import co.edu.common.DAO;

public class CartServiceImpl extends DAO implements CartService {

	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<CartVO> selectCartList() {
		// 장바구니 전체 조회
		List<CartVO> cart = new ArrayList<>();
		CartVO vo;
		String sql = "select c.c_no, c.id, p.price, c.quantity, c.amount, p.* from products p, cart c\r\n"
				+ "where p.p_no = c.p_no ORDER BY c.c_no";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new CartVO();
				vo.setCno(rs.getInt("c_no"));
				vo.setId(rs.getString("id"));
				vo.setPno(rs.getInt("p_no"));
				vo.setPrice(rs.getInt("price"));
				vo.setQuantity(rs.getInt("quantity"));
				vo.setAmount(rs.getInt("amount"));
				vo.setPname(rs.getString("p_name"));
				vo.setImage(rs.getString("image"));
				
				cart.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cart;
	}

	@Override
	public CartVO selectCart(CartVO vo) {
		// 단건선택
		String sql = "SELECT * FROM cart WHERE c_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getCno());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo = new CartVO();
				vo.setCno(rs.getInt("c_no"));
				vo.setId(rs.getString("id"));
				vo.setPno(rs.getInt("p_no"));
				vo.setQuantity(rs.getInt("quantity"));
				vo.setAmount(rs.getInt("amount"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	@Override
	public int insertCart(CartVO vo) {
		// 장바구니 추가
		String sql = "INSERT INTO cart (c_no, id, p_no, quantity, amount)" + "VALUES(cart_seq.nextval, ?, ?, ?, ?)";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, vo.getId());
			psmt.setInt(2, vo.getPno());
			psmt.setInt(3, vo.getQuantity());
			psmt.setInt(4, vo.getAmount());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	@Override
	public int updateCart(CartVO vo) {
		// 장바구니 수정
		String sql = "UPDATE cart SET quantity = ?, amount = ? WHERE c_no = ?";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getQuantity());
			psmt.setInt(2, vo.getAmount());
			psmt.setInt(3, vo.getCno());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	@Override
	public int deleteCart(CartVO vo) {
		// 장바구니 삭제
		String sql = "DELETE FROM cart WHERE c_no = ?";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getCno());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

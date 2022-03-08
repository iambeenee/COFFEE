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
		String sql = "SELECT * FROM cart ORDER BY c_no";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
					vo = new CartVO();
					vo.setCno(rs.getInt("cno"));
					vo.setId(rs.getString("id"));
					vo.setPno(rs.getInt("pno"));
					vo.setQuantity(rs.getInt("quantity"));
					vo.setAmount(rs.getInt("amount"));
				}
			} catch(SQLException e) {
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
			if(rs.next()) {
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
		String sql = "INSERT INTO cart (c_no, id, p_no, quantity, amount)"
					+ "VALUES(cart_seq.nextval, ?, ?, ?, ?)";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getId());
		}
		return;
	}

	@Override
	public int updateCart(CartVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCart(CartVO vo) {
		// TODO Auto-generated method stub
		return 0;
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

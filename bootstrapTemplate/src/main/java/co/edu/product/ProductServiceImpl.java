package co.edu.product;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.common.DAO;

public class ProductServiceImpl extends DAO implements ProductService {

	private PreparedStatement psmt;
	private ResultSet rs;
	
	@Override
	public List<ProductVO> selectProductList() {
		// 상품전체조회
		List<ProductVO> products = new ArrayList<>();
		ProductVO vo;
		String sql = "SELECT * FROM products ORDER BY p_no";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new ProductVO();
				vo.setPno(rs.getInt("p_no"));
				vo.setPname(rs.getString("p_name"));
				vo.setKind(rs.getString("kind"));
				vo.setPrice(Integer.parseInt(rs.getString("price")));
				vo.setPcontent(rs.getString("p_content"));
				vo.setImage(rs.getString("image"));
				vo.setRegdate(rs.getString("reg_date"));
				products.add(vo);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return products;
	}

	@Override
	public ProductVO selectProduct(ProductVO vo) {
		// 상품단건조회
		String sql = "SELECT * FROM products WHERE p_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getPno());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo = new ProductVO();
				vo.setPno(rs.getInt("p_no"));
				vo.setPname(rs.getString("p_name"));
				vo.setKind(rs.getString("kind"));
				vo.setPrice(Integer.parseInt(rs.getString("price")));
				vo.setPcontent(rs.getString("p_content"));
				vo.setImage(rs.getString("image"));
				vo.setRegdate(rs.getString("reg_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return vo;
	}

	@Override
	public int insertProduct(ProductVO vo) {
		// 상품등록
		String sql = "INSERT INTO products (p_no, p_name, kind, price, p_content, image, reg_date) "
				   + "VALUES(product_seq.nextval, ?, ?, ?, ?, ?, sysdate)";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getPname());
			psmt.setString(2, vo.getKind());
			psmt.setInt(3, vo.getPrice());
			psmt.setString(4, vo.getPcontent());
			psmt.setString(5, vo.getImage());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	@Override
	public int updateProduct(ProductVO vo) {
		String sql = "UPDATE products SET p_name = ?, kind = ?, price = ?, p_content = ?, image = ? WHERE p_no = ?";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getPname());
			psmt.setString(2, vo.getKind());
			psmt.setInt(3, vo.getPrice());
			psmt.setString(4, vo.getPcontent());
			psmt.setString(5, vo.getImage());
			psmt.setInt(6, vo.getPno());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	@Override
	public int deleteProduct(ProductVO vo) {
		// 상품삭제
		String sql = "DELETE FROM products WHERE p_no = ?";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getPno());
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

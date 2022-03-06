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
				vo.setpNo(rs.getInt("p_no"));
				vo.setpName(rs.getString("p_name"));
				vo.setKind(rs.getString("kind"));
				vo.setPrice(rs.getInt("price"));
				vo.setpContent(rs.getString("p_content"));
				vo.setImage(rs.getString("image"));
				vo.setRegDate(rs.getString("reg_date"));
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
			psmt.setInt(1, vo.getpNo());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo = new ProductVO();
				vo.setpNo(rs.getInt("p_no"));
				vo.setpName(rs.getString("p_name"));
				vo.setKind(rs.getString("kind"));
				vo.setPrice(rs.getInt("price"));
				vo.setpContent(rs.getString("p_content"));
				vo.setImage(rs.getString("image"));
				vo.setRegDate(rs.getString("reg_date"));
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
		String sql = "INSERT INTO products VALUES(product_seq.nextval, ?, ?, ?, ?, ?, ?)";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getpName());
			psmt.setString(2, vo.getKind());
			psmt.setInt(3, vo.getPrice());
			psmt.setString(4, vo.getpContent());
			psmt.setString(5, vo.getImage());
			psmt.setString(6, vo.getRegDate());
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
			psmt.setString(1, vo.getpName());
			psmt.setString(2, vo.getKind());
			psmt.setInt(3, vo.getPrice());
			psmt.setString(4, vo.getpContent());
			psmt.setString(5, vo.getImage());
			psmt.setInt(6, vo.getpNo());
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
		String sql = "DELETE FORM products WHERE p_no = ?";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getpNo());
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

package co.edu.member.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.common.DAO;
import co.edu.member.service.MemberService;
import co.edu.member.vo.MemberVO;

public class MemberServiceImpl extends DAO implements MemberService {
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<MemberVO> selectMemberList() {
		// 회원 전체 조회
		List<MemberVO> members = new ArrayList<>();
		MemberVO vo;
		String sql = "SELECT * FROM MEMBERS ORDER BY ID";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setAddress(rs.getString("address"));
				vo.setTel(rs.getString("tel"));
				vo.setDate(rs.getString("date"));
				vo.setEmail(rs.getString("email"));
				vo.setAuthor(rs.getString("author"));
				members.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return members;
	}

	@Override
	public MemberVO selecteMember(MemberVO vo) {
		// 회원 단건 조회
		String sql = "SELECT * FROM MEMBERS WHERE ID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setAddress(rs.getString("address"));
				vo.setTel(rs.getString("tel"));
				vo.setEmail(rs.getString("email"));
				vo.setDate(rs.getString("date"));
				vo.setAuthor(rs.getString("author"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return vo;
	}

	@Override
	public int insertMember(MemberVO vo) {
		// 회원 가입
		String sql = "INSERT INTO MEMBERS (ID, PASSWORD, NAME, ADDRESS, TEL, EMAIL) VALUES (?, ?, ?, ?, ?, ?) ";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPassword());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getAddress());
			psmt.setString(5, vo.getTel());
			psmt.setString(6, vo.getEmail());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	@Override
	public int updateMember(MemberVO vo) {
		// 회원정보수정
		String sql = "UPDATE MEMBERS SET PASSWORD = ?, NAME = ?, ADDRESS = ?, TEL = ?, EMAIL = ? WHERE ID = ?";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getPassword());
			psmt.setString(2, vo.getName());
			psmt.setString(3, vo.getAddress());
			psmt.setString(4, vo.getTel());
			psmt.setString(5, vo.getEmail());
			psmt.setString(6, vo.getId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	@Override
	public int deleteMember(MemberVO vo) {
		// 회원탈퇴
		String sql = "DELETE FORM MEMBERS WHERE ID = ?";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	@Override
	public MemberVO loginCheck(MemberVO vo) {
		// 로그인 정보
		String sql = "SELECT * FROM MEMBERS WHERE ID = ? AND PASSWORD = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPassword());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setName(rs.getString("name"));
<<<<<<< HEAD
				vo.setAddress(rs.getString("address"));
				vo.setTel(rs.getString("tel"));
				vo.setEmail(rs.getString("email"));
=======
>>>>>>> branch 'master' of https://github.com/iambeenee/COFFEE.git
				vo.setAuthor(rs.getString("author"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	@Override
	public boolean isIdcheck(String id) {
		// 아이디 중복 체크
		String sql = "SELECT CASE WHEN COUNT(ID) = 1 THEN 0 ELSE 1 END AS ID FROM MEMBERS WHERE ID = ?";
		boolean b = false;

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				if (rs.getInt("id") != 0) {
					b = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return b;
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

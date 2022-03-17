package co.edu.qna;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.edu.common.DAO;

public class QnaServiceImpl extends DAO implements QnaService {
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<QnaVO> selectQnaList() {
		// 전체조회
		List<QnaVO> qna = new ArrayList<>();
		QnaVO vo = new QnaVO();
		String sql = "SELECT * FROM QNA WHERE Q_REP IS NULL";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new QnaVO();
				vo.setqNo(rs.getInt("q_no"));
				vo.setId(rs.getString("id"));
				vo.setqSubject(rs.getString("q_subject"));
				vo.setqContent(rs.getString("q_content"));
				vo.setqDate(rs.getString("q_date"));
				vo.setHit(rs.getInt("hit"));
				vo.setqRep(rs.getInt("q_rep"));
				qna.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return qna;
	}

	@Override
	public HashMap<String, QnaVO> selectQna(QnaVO vo1) {
		// 단건조회
		HashMap<String, QnaVO> map = new HashMap<>();
		String sql = "select * from (\r\n"
				+ "select 'Origin' origin, q_no, id, q_subject, q_content, q_date, hit, '' q_reply from qna\r\n"
				+ "where q_no = ?\r\n" //
				+ "union all\r\n"//
				+ "select 'Reply' origin, q_no, null id, null q_subject, null q_content, q_date, null hit, q_content q_reply  from qna\r\n"
				+ "where q_rep = ?)\r\n"//
				+ "group by origin, q_no, id, q_subject, q_content, q_date, hit, q_reply";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo1.getqNo());
			psmt.setInt(2, vo1.getqNo());
			rs = psmt.executeQuery();

			while (rs.next()) {
				QnaVO vo = new QnaVO();
				String category = rs.getString("origin");
				vo.setqNo(rs.getInt("q_no"));
				vo.setId(rs.getString("id"));
				vo.setqSubject(rs.getString("q_subject"));
				vo.setqContent(rs.getString("q_content"));
				vo.setqDate(rs.getString("q_date"));
				vo.setHit(rs.getInt("hit"));
				vo.setqReply(rs.getString("q_reply"));
				addCount(vo.getqNo());

				map.put(category, vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return map;
	}

	public void addCount(int qNo) {
		String sql = "UPDATE QNA SET HIT = HIT + 1 WHERE Q_NO = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, qNo);
			int n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			close();
		}
	}

	@Override
	public int insertQna(QnaVO vo) {
		// 등록
		String sql = "INSERT INTO QNA(Q_NO, ID, Q_SUBJECT, Q_CONTENT, Q_DATE, HIT) VALUES (QNA_SEQ.NEXTVAL, ?, ?, ?, SYSDATE, 0)";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getqSubject());
			psmt.setString(3, vo.getqContent());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	@Override
	public int deleteQna(QnaVO vo) {
		// 삭제
		String sql = "DELETE FROM QNA WHERE Q_NO = ?";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getqNo());
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

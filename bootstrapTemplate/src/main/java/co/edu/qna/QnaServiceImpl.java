package co.edu.qna;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.common.DAO;

public class QnaServiceImpl extends DAO implements QnaService {
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<QnaVO> selectQnaList() {
		// 전체조회
		List<QnaVO> qna = new ArrayList<>();
		QnaVO vo = new QnaVO();
		String sql = "SELECT *FROM QNA";
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
	public QnaVO selectQna(QnaVO vo) {
		// 단건조회
		String sql = "SELECT * FROM QNA WHERE Q_NO = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getqNo());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setqSubject(rs.getString("q_subject"));
				vo.setqContent(rs.getString("q_content"));
				vo.setqDate(rs.getString("q_date"));
				vo.setHit(rs.getInt("hit"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	@Override
	public int insertQna(QnaVO vo) {
		// 등록
		
		return 0;
	}

	@Override
	public int deleteQna(QnaVO vo) {
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

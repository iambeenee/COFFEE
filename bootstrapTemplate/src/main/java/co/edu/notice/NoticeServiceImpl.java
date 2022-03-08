package co.edu.notice;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.common.DAO;

public class NoticeServiceImpl extends DAO implements NoticeService {
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<NoticeVO> selectNoticeList() {
		// 전체조회
		List<NoticeVO> notice = new ArrayList<>();
		NoticeVO vo;
		String sql = "SELECT * FROM NOTICE ORDER BY NOTICE_NO";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new NoticeVO();
				vo.setNoticeNo(rs.getInt("notice_no"));
				vo.setnSubject(rs.getString("n_subject"));
				vo.setnContent(rs.getString("n_content"));
				vo.setnDate(rs.getString("n_date"));
				vo.setHit(rs.getInt("hit"));
				notice.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return notice;
	}

	@Override
	public NoticeVO selectNotice(NoticeVO vo) {
		// 단건조회
		String sql = "SELECT * FROM NOTICE WHERE NOTICE_NO = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getNoticeNo());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setnSubject(rs.getString("n_subject"));
				vo.setnContent(rs.getString("n_content"));
				vo.setnDate(rs.getString("n_date"));
				vo.setHit(rs.getInt("hit"));
				addCount(vo.getNoticeNo());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	public void addCount(int noticeNo) {
		String sql = "UPDATE NOTICE SET HIT = HIT + 1 WHERE NOTICE_NO = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, noticeNo);
			int n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	@Override
	public int insertNotice(NoticeVO vo) {
		// 공지사항 등록
		String sql = "INSERT INTO NOTICE(NOTICE_NO, N_SUBJECT, N_CONTENT, N_DATE, HIT) VALUES (NOTICE_SEQ.NEXTVAL, ?, ?, SYSDATE, 0)";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getnSubject());
			psmt.setString(2, vo.getnContent());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	@Override
	public int updateNotice(NoticeVO vo) {
		// 수정
		String sql = "UPDATE NOTICE SET N_SUBJECT = ?, N_CONTENT = ? WHERE NOTICE_NO = ?";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getnSubject());
			psmt.setString(2, vo.getnContent());
			psmt.setInt(3, vo.getNoticeNo());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	@Override
	public int deleteNotice(NoticeVO vo) {
		// 삭제
		String sql = "DELETE FROM NOTICE WHERE NOTICE_NO = ?";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getNoticeNo());
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

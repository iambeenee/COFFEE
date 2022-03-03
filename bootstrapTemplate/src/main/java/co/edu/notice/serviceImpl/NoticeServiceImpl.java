package co.edu.notice.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.common.DAO;
import co.edu.notice.service.NoticeService;
import co.edu.notice.vo.NoticeVO;

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
			while(rs.next()) {
				vo = new NoticeVO();
				vo.setNoticeNo(rs.getInt("noticeNo"));
				vo.setnSubject(rs.getString("nSubject"));
				vo.setnContent(rs.getString("nContent"));
				vo.setnDate(rs.getString("nDate"));
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
	public int insertNotice(NoticeVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateNotice(NoticeVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteNotice(NoticeVO vo) {
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

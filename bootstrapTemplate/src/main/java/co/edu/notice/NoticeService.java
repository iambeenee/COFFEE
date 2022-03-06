package co.edu.notice;

import java.util.List;

public interface NoticeService {
	List<NoticeVO> selectNoticeList(); //전체조회
	//NoticeVO selectNotice(NoticeVO vo); //단건조회
	public int insertNotice(NoticeVO vo); //공지사항 등록
	public int updateNotice(NoticeVO vo); //공지사항 수정
	public int deleteNotice(NoticeVO vo); //공지사항 삭제
}

package co.edu.notice.service;

import java.util.List;

import co.edu.notice.vo.NoticeVO;

public interface NoticeService {
	List<NoticeVO> selectNoticeList(); //전체조회
	//NoticeVO selectNotice(NoticeVO vo); //단건조회
	public int insertNotice(NoticeVO vo); //공지사항 입력
	public int updateNotice(NoticeVO vo); //공지사항 수정
	public int deleteNotice(NoticeVO vo); //공지사항 삭제
}

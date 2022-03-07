package co.edu.notice.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.DbCommand;
import co.edu.notice.NoticeService;
import co.edu.notice.NoticeServiceImpl;
import co.edu.notice.NoticeVO;

public class NoticeSelect implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 공지사항 선택 - 세부내역보기
		NoticeService noticeDAO = new NoticeServiceImpl(); 
		NoticeVO vo = new NoticeVO();
		vo.setNoticeNo(Integer.parseInt(request.getParameter("noticeNo")));
		vo = noticeDAO.selectNotice(vo);
		request.setAttribute("notice", vo);
		
		return "notice/noticeSelect.tiles";
	}

}

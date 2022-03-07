package co.edu.notice.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.DbCommand;
import co.edu.notice.NoticeService;
import co.edu.notice.NoticeServiceImpl;

public class NoticeList implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 공지사항 리스트 호출
		NoticeService noticeDAO = new NoticeServiceImpl();
		request.setAttribute("notices", noticeDAO.selectNoticeList());
		
		return "notice/noticeList.tiles";
	}

}

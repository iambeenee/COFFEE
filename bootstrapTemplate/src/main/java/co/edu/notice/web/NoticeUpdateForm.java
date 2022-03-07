package co.edu.notice.web;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import co.edu.common.DbCommand;
import co.edu.notice.NoticeService;
import co.edu.notice.NoticeServiceImpl;
import co.edu.notice.NoticeVO;

public class NoticeUpdateForm implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 수정 폼 호출
		NoticeService dao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setNoticeNo(Integer.parseInt(request.getParameter("noticeNo")));
		request.setAttribute("notice", dao.selectNotice(vo));
		
		return "notice/noticeUpdateForm.tiles";
	}

}

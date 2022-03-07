package co.edu.notice.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.DbCommand;
import co.edu.notice.NoticeService;
import co.edu.notice.NoticeServiceImpl;
import co.edu.notice.NoticeVO;

public class NoticeDelete implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 삭제처리
		NoticeService dao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setNoticeNo(Integer.parseInt(request.getParameter("noticeNo")));
		
		int n = dao.deleteNotice(vo);
		if(n != 0) {
			return "noticeList.do";
		} else {
			request.setAttribute("message", "삭제가 정상적으로 처리되지 않았습니다. 다시 시도해 주세요");
			return "member/memberMessage.tiles";
		}
	}

}

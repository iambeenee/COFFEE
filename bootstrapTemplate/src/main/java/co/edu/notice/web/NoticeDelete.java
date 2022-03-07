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
//		vo.setnSubject(request.getParameter("nSubject"));
//		vo.setnContent(request.getParameter("nCountent"));
//		vo.setnDate(request.getParameter("nDate"));
//		vo.setHit(Integer.parseInt(request.getParameter("hit")));
		
		int n = dao.deleteNotice(vo);
		if(n != 0) {
			return "notice/noticeList.tiles";
		} else {
			request.setAttribute("message", "삭제가 정상적으로 처리되지 않았습니다. 다시 시도해 주세요");
			return "member/memberMessage.tiles";
		}
	}

}

package co.edu.notice.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.DbCommand;
import co.edu.notice.NoticeService;
import co.edu.notice.NoticeServiceImpl;
import co.edu.notice.NoticeVO;

public class NoticeInsert implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 공지사항 등록 처리
		NoticeService dao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setnSubject(request.getParameter("subject"));
		vo.setnContent(request.getParameter("content"));

		int n = dao.insertNotice(vo);
		
		if(n !=0) {
			return "noticeList.do";
		} else {
			request.setAttribute("message", "정상처리되지않았습니다. 다시 시도해주세요.");
			return "member/memberMessage.tiles";
		}
		
	}

}

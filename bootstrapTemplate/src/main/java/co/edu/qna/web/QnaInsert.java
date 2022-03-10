package co.edu.qna.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.DbCommand;
import co.edu.qna.QnaService;
import co.edu.qna.QnaServiceImpl;
import co.edu.qna.QnaVO;

public class QnaInsert implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 등록처리
		QnaService dao = new QnaServiceImpl();
		QnaVO vo = new QnaVO();
		vo.setId(request.getParameter("id"));
		vo.setqSubject(request.getParameter("subject"));
		vo.setqContent(request.getParameter("content"));
		
		int n = dao.insertQna(vo);
		if(n != 0) {
			return "qnaList.do";
		} else {
			request.setAttribute("message", "정상처리되지않았습니다. 다시 시도해주세요.");
			return "member/memberMessage.tiles";
		}
	}

}

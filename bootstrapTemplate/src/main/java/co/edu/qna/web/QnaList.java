package co.edu.qna.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.DbCommand;
import co.edu.qna.QnaService;
import co.edu.qna.QnaServiceImpl;

public class QnaList implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// qna 리스트 호출
		QnaService qDao = new QnaServiceImpl();
		request.setAttribute("qna", qDao.selectQnaList());
		
		return "qna/qnaList.tiles";
	}

}

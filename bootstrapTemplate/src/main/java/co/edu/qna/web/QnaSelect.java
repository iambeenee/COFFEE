package co.edu.qna.web;

import java.util.HashMap;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.DbCommand;
import co.edu.qna.QnaService;
import co.edu.qna.QnaServiceImpl;
import co.edu.qna.QnaVO;

public class QnaSelect implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// Q&A 선택 - 세부내역보기
		QnaService dao = new QnaServiceImpl();
		QnaVO vo = new QnaVO();
		vo.setqNo(Integer.parseInt(request.getParameter("qNo")));
		HashMap<String, QnaVO> map = dao.selectQna(vo);
		
		request.setAttribute("origin", map.get("Origin"));
		request.setAttribute("reply", map.get("Reply"));

		return "qna/qnaSelect.tiles";
	}

}

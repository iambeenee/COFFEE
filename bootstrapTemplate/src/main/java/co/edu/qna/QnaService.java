package co.edu.qna;

import java.util.List;

public interface QnaService {
	List<QnaVO> selectQnaList(); //전체조회
	QnaVO selectQna(QnaVO vo); //단건조회
	public int insertQna(QnaVO vo); //질문 등록
	public int deleteQna(QnaVO vo); // 질문 삭제
	
}

package co.edu.qna;

import java.util.HashMap;
import java.util.List;

public interface QnaService {
	List<QnaVO> selectQnaList(); //전체조회
	HashMap<String, QnaVO> selectQna(QnaVO vo); //질문 단건조회
	public int insertQna(QnaVO vo); //등록 등록
	public int deleteQna(QnaVO vo); // 질문 삭제
	
}

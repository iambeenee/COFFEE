package co.edu.qna;

public class QnaVO {
	//
	private int qNo; // qna 번호
	private String qName; // 작성자 -> member(id)참조
	private String qSubject; // 제목
	private String qContent; // 내용
	private String qRep; // 답변 여부
	private String qDate; // 작성날짜
	private int hit; // 조회수
	
	//
	public int getqNo() {
		return qNo;
	}
	public void setqNo(int qNo) {
		this.qNo = qNo;
	}
	public String getqName() {
		return qName;
	}
	public void setqName(String qName) {
		this.qName = qName;
	}
	public String getqSubject() {
		return qSubject;
	}
	public void setqSubject(String qSubject) {
		this.qSubject = qSubject;
	}
	public String getqContent() {
		return qContent;
	}
	public void setqContent(String qContent) {
		this.qContent = qContent;
	}
	public String getqRep() {
		return qRep;
	}
	public void setqRep(String qRep) {
		this.qRep = qRep;
	}
	public String getqDate() {
		return qDate;
	}
	public void setqDate(String qDate) {
		this.qDate = qDate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
}

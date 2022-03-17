package co.edu.qna;

public class QnaVO {
	//
	private int qNo;
	private String id;
	private String qSubject;
	private String qContent;
	private String qDate;
	private int hit;
	private int qRep;
	private String qReply;

	//
	public int getqNo() {
		return qNo;
	}

	public void setqNo(int qNo) {
		this.qNo = qNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public int getqRep() {
		return qRep;
	}

	public void setqRep(int qRep) {
		this.qRep = qRep;
	}

	public String getqReply() {
		return qReply;
	}

	public void setqReply(String qReply) {
		this.qReply = qReply;
	}
}

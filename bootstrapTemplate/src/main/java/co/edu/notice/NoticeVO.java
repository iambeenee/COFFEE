package co.edu.notice;

public class NoticeVO {
	private int noticeNo;
	private String nSubject;
	private String nContent;
	private String nDate;
	private int hit;
	
	//
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getnSubject() {
		return nSubject;
	}
	public void setnSubject(String nSubject) {
		this.nSubject = nSubject;
	}
	public String getnContent() {
		return nContent;
	}
	public void setnContent(String nContent) {
		this.nContent = nContent;
	}
	public String getnDate() {
		return nDate;
	}
	public void setnDate(String nDate) {
		this.nDate = nDate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
}

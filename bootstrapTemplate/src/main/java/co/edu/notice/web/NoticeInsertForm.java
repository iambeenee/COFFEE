package co.edu.notice.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.DbCommand;

public class NoticeInsertForm implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 공지사항 등록 폼 호출
		
		return "notice/noticeInsertForm.tiles";
	}

}

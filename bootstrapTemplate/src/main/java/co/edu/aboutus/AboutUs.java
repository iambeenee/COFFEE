package co.edu.aboutus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.DbCommand;

public class AboutUs implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// about us 페이지 불러오기
		return "aboutus/aboutUs.tiles";
	}

}

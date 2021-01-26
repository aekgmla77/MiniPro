package co.micol.minipro.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.minipro.common.Service;

public class Logout implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// TODO 세션 remove
		HttpSession session = request.getSession();
//		String mid = (String) session.getAttribute("mid");
//		request.setAttribute("mid", mid);
		session.invalidate(); //session(권한, 아이디, 메뉴 등) 깨주는 역할
//		return "views/member/logout.jsp";
		return "main.do";
		
	}

}

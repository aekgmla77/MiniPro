package co.micol.minipro.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.minipro.common.Service;
import co.micol.minipro.member.dao.MemberDao;

public class MemberIdCheck implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// TODO 아이디 중복 확인
		MemberDao dao = new MemberDao();
		String id = request.getParameter("mid");
		boolean bool = dao.isIdCheck(id);
		String message = null;
		
		if(bool) {
			message = id + "는 사용 가능한 ID입니다.";
		}else {
			message = id + "는 이미 존재하는 ID입니다.";
		}
		request.setAttribute("msg", message);
		request.setAttribute("check", bool);
		return "views/member/idCheck.jsp";
	}

}

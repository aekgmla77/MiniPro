package co.micol.minipro.member.service;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import co.micol.minipro.common.Service;
import co.micol.minipro.member.dao.MemberDao;

public class Login implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// TODO 로그인 과정 처리
		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();
		vo.setmId(request.getParameter("mId"));
		vo.setmPassword(request.getParameter("mPassword"));
		
		vo = dao.select(vo);  //로그인 체크하기 dao 호출
		
		String viewPage = null;
		
		if(vo.getmAuth() != null) {
			HttpSession session = request.getSession();  //세션객체 호출
			session.setAttribute("mid", vo.getmId());  //세션 아이디
			session.setAttribute("mauth", vo.getmAuth());  //세션에 권한을 담음.
			request.setAttribute("vo", vo);
			viewPage = "views/member/loginSuccess.jsp";
		} else {
			viewPage = "views/member/loginFail.jsp";
		}
		
		return viewPage;
	}

}

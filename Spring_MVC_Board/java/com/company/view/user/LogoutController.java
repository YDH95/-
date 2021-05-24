package com.company.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LogoutController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. 브라우저에 연결된 세션 객체 종료
		// [중요] 검색 결과를 세션객체에 저장하고 포워딩
		HttpSession session = request.getSession();
		session.invalidate();
		// invalidate: 함수는 세션을 없애고 세션에 속해있는 값들을 모두 없앤다.
		// 2. 세션 종료 후 로그인 페이지로 이동시킨다.
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:login.jsp");
		return mav;
	}

}

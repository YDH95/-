package com.company.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LogoutController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. �������� ����� ���� ��ü ����
		// [�߿�] �˻� ����� ���ǰ�ü�� �����ϰ� ������
		HttpSession session = request.getSession();
		session.invalidate();
		// invalidate: �Լ��� ������ ���ְ� ���ǿ� �����ִ� ������ ��� ���ش�.
		// 2. ���� ���� �� �α��� �������� �̵���Ų��.
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:login.jsp");
		return mav;
	}

}

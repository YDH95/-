package com.company.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController { //POJO Ŭ������ ����
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		System.out.println("�α׾ƿ�");
		
		return "login.jsp";
		
	}

}
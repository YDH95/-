package com.company.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController { //POJO 클래스로 구현
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		System.out.println("로그아웃");
		
		return "login.jsp";
		
	}

}
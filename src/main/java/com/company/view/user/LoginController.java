package com.company.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.Spring_Annotation_Board.user.UserDAO;
import com.company.Spring_Annotation_Board.user.UserDO;
@Controller
public class LoginController { //POJO Ŭ������ ����

	@RequestMapping("/login.do")
	public String login(UserDO userDO, UserDAO userDAO, HttpSession session) {
		UserDO user = userDAO.getUser(userDO);
		
		if (user != null) {
			System.out.println("�α��� ����");
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		} else {
			System.out.println("�α��� ����");
			return "login.jsp";
		}
			
	}
}
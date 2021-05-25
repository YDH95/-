package com.company.view.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.Spring_Annotation_Board.user.UserDAO;
import com.company.Spring_Annotation_Board.user.UserDO;

@Controller
public class UserController { //POJOÅ¬·¡½º
	
	@RequestMapping("/insertUser.do")
		public String setUser(UserDO userDO, UserDAO userDAO) {
			userDAO.setUser(userDO);
		return "login.jsp";
		
	}
	

}

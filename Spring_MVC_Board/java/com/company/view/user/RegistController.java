package com.company.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.company.Spring_MVC_Board.user.UserDAO;
import com.company.Spring_MVC_Board.user.UserDO;

public class RegistController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ȸ������ �Է� ó����");
		//�Է� ������ �Ѿ�� ����� �Է� ���� ����
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String password = request.getParameter("password");		
		String role = "User";
		
		//2.BoardDO Ŭ���� ��ü �����Ͽ� �Է� ������ �ʵ�(�߰������)�� ����(�ʱ�ȭ)�Ѵ�.
		UserDO userDO = new UserDO();
		userDO.setName(name);
		userDO.setId(id);
		userDO.setPassword(password);
		userDO.setRole(role);
		
		//3. BoardDAO Ŭ���� ��ü ���� �� '�Խñ� ���' �޼ҵ� ȣ��
		UserDAO userDAO = new UserDAO();
		userDAO.setUser(userDO);
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:login.do");
		
		return mav;
	}

}

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
		System.out.println("회원가입 입력 처림됨");
		//입력 폼에서 넘어온 사용자 입력 정보 추출
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String password = request.getParameter("password");		
		String role = "User";
		
		//2.BoardDO 클래스 객체 생성하여 입력 값들을 필드(중간저장소)에 저장(초기화)한다.
		UserDO userDO = new UserDO();
		userDO.setName(name);
		userDO.setId(id);
		userDO.setPassword(password);
		userDO.setRole(role);
		
		//3. BoardDAO 클래스 객체 생성 후 '게시글 등록' 메소드 호출
		UserDAO userDAO = new UserDAO();
		userDAO.setUser(userDO);
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:login.do");
		
		return mav;
	}

}

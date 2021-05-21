package com.company.view.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.MVC_FW_Board.user.UserDAO;
import com.company.MVC_FW_Board.user.UserDO;
import com.company.view.controller.Controller;

public class LoginController implements Controller{

	@Override //재정의해라
	public String HandleRequest(HttpServletRequest request, HttpServletResponse response) {
		//1. 사용자 입력 정보 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		//2. DO클래스 객체 생성 후 중간저장에 초기화
		UserDO userDO = new UserDO(); //getter, setter가있는 UserDO클래스 객체생성
		userDO.setId(id);
		userDO.setPassword(password);
		
		//3. DAO 클래스 객체 생성 후 getUser() 메소드 호출하면서 userDO 객체에 넘김
		UserDAO userDAO = new UserDAO();
		UserDO user = userDAO.getUser(userDO);
		
		//4. 포워딩
		if(user != null) {
			System.out.println("로그인성공");
			HttpSession session = request.getSession();
			//[중요] session 객채에 "키" 값 저장하기
			session.setAttribute("idKey", id); //이름이 name인 속성의 값을 value로 지정한다.
			return "getBoardList.do"; //리턴 타입이 String 객체이다.
		}else {
			PrintWriter script;
			try {
				script = response.getWriter();
				System.out.println("로그인 실패");
			    script.println("<script>");
			    script.println("alert('Login failure')");
			    script.println("history.back()");
			    script.println("</script>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//return "login"; //리턴 타입이 String 객체이다.
		}
		return "login";
	}

}

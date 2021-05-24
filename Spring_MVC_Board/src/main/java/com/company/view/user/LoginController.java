package com.company.view.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.company.Spring_MVC_Board.user.UserDAO;
import com.company.Spring_MVC_Board.user.UserDO;

/**
 * MVC �����ӿ�ũ ��ݰ� �ٸ����� springframwork���� �����ϴ� Controller �������̽��� �� ��Ʈ�ѷ� Ŭ��������
 * ������Ų�ٴ°�
 * 
 */
public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. ����� �Է� ���� ����
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		// 2. DOŬ���� ��ü ���� �� �߰����忡 �ʱ�ȭ
		UserDO userDO = new UserDO(); // getter, setter���ִ� UserDOŬ���� ��ü����
		userDO.setId(id);
		userDO.setPassword(password);

		// 3. DAO Ŭ���� ��ü ���� �� getUser() �޼ҵ� ȣ���ϸ鼭 userDO ��ü�� �ѱ�
		UserDAO userDAO = new UserDAO();
		UserDO user = userDAO.getUser(userDO);

		// 4. ������
		ModelAndView mav = new ModelAndView(); 
		//����Ŭ���� ���� ModelAndView�� �����Ϳ� �̵��ϰ��� �ϴ� View Page�� ���� �����Ѵ�

		if (user != null) {
			System.out.println("�α��μ���");
			HttpSession session = request.getSession();
			// [�߿�] session ��ä�� "Ű" �� �����ϱ�
			session.setAttribute("idKey", id); // �̸��� idKey�� �Ӽ��� ���� value�� �����Ѵ�.
			mav.setViewName("redirect:getBoardList.do"); 
			//setViewName(String view): ������ view �̸��� ����
		} else {
			PrintWriter script;
			try {
				script = response.getWriter();
				System.out.println("�α��� ����");
				script.println("<script>");
				script.println("alert('Login failure')");
				script.println("history.back()");
				script.println("</script>");
				mav.setViewName("redirect:login.jsp");
				//setViewName(String view): ������ view �̸��� ����
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// return "login"; //���� Ÿ���� String ��ü�̴�.
		}
		return mav;
	}

}
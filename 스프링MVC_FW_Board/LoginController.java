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

	@Override //�������ض�
	public String HandleRequest(HttpServletRequest request, HttpServletResponse response) {
		//1. ����� �Է� ���� ����
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		//2. DOŬ���� ��ü ���� �� �߰����忡 �ʱ�ȭ
		UserDO userDO = new UserDO(); //getter, setter���ִ� UserDOŬ���� ��ü����
		userDO.setId(id);
		userDO.setPassword(password);
		
		//3. DAO Ŭ���� ��ü ���� �� getUser() �޼ҵ� ȣ���ϸ鼭 userDO ��ü�� �ѱ�
		UserDAO userDAO = new UserDAO();
		UserDO user = userDAO.getUser(userDO);
		
		//4. ������
		if(user != null) {
			System.out.println("�α��μ���");
			HttpSession session = request.getSession();
			//[�߿�] session ��ä�� "Ű" �� �����ϱ�
			session.setAttribute("idKey", id); //�̸��� name�� �Ӽ��� ���� value�� �����Ѵ�.
			return "getBoardList.do"; //���� Ÿ���� String ��ü�̴�.
		}else {
			PrintWriter script;
			try {
				script = response.getWriter();
				System.out.println("�α��� ����");
			    script.println("<script>");
			    script.println("alert('Login failure')");
			    script.println("history.back()");
			    script.println("</script>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//return "login"; //���� Ÿ���� String ��ü�̴�.
		}
		return "login";
	}

}

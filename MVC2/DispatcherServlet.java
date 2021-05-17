package com.company.view.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.Model2_Board.board.BoardDAO;
import com.company.Model2_Board.board.BoardDO;
import com.company.Model2_Board.user.UserDAO;
import com.company.Model2_Board.user.UserDO;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DispatcherServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// String uri = "http://localhost:8080/Model2_Board/login.do ��û�ϸ�
		String uri = request.getRequestURI(); // /Model2_Board/login.do �� ������
		String path = uri.substring(uri.lastIndexOf("/")); // substring(������'/' ���Ե��ε������� ~ ������ �ε���)

		if (path.equals("/login.do")) {
			String id = request.getParameter("id");
			String password = request.getParameter("password");

			UserDO userDO = new UserDO();
			userDO.setId(id);
			userDO.setPassword(password);

			UserDAO userDAO = new UserDAO();
			UserDO user = userDAO.getUser(userDO);

			if (user != null) {
				System.out.println("�α��μ���");
				HttpSession session = request.getSession();
				//[�߿�] session ��ä�� "Ű" �� �����ϱ�
				session.setAttribute("idKey", id); //�̸��� name�� �Ӽ��� ���� value�� �����Ѵ�.
				response.sendRedirect("getBoardList.do");
			} else {
				 PrintWriter script = response.getWriter();
			     script.println("<script>");
			     script.println("alert('Login failure')");
			     script.println("history.back()");
			     script.println("</script>");
			}
		} else if (path.equals("/getBoardList.do")) {
			String searchField = ""; // �˻���� ��ü ���۷�������
			String searchText = ""; // �˻��ؽ�Ʈ

			// System.out.println("searchCondition>>>>" +
			// request.getParameter("searchCondition"));
			if (request.getParameter("searchCondition") != "" && request.getParameter("searchKeyword") != "") {
				searchField = request.getParameter("searchCondition");
				searchText = request.getParameter("searchKeyword");
			}

			// BoardDAO Ŭ���� ��ü ������ �޼��� ȣ��
			BoardDAO boardDAO = new BoardDAO();
			List<BoardDO> boardList = boardDAO.getBoardList(searchField, searchText);

			// [�߿�] �˻� ����� ���ǰ�ü�� �����ϰ� ������
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			// request.setAttribute("boardList", boardList);

			// ������
			response.sendRedirect("getBoardList.jsp");
			// ---------------------------------------------------------
		} else if (path.equals("/getBoard.do")) {
			System.out.println("�Խñ� �󼼺��� ó����");

			// 1. '��ü �Խñ� ��Ϻ���' ������ ������ '����' Ŭ������ �� �ʸӿ�
			// �� ������ �Խñ۹�ȣ �����ϱ�
			String seq = request.getParameter("seq");

			// 2. BoardDOŬ���� ��ü ����
			BoardDO boardDO = new BoardDO();
			boardDO.setSeq(Integer.parseInt(seq));

			// 3. BoardDAOŬ���� ��ü ���� ��'�Խñ� �󼼺���'�޼ҵ� ȣ��
			BoardDAO boardDAO = new BoardDAO();
			BoardDO board = boardDAO.getBoard(boardDO);
			
			// [�߿�] �˻� ����� ���ǰ�ü�� �����ϰ� ������
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			
			//������
			response.sendRedirect("getBoard.jsp");
			//-------------------------------------------------------
		} else if (path.equals("/insertBoard.do")) {
			System.out.println("�Խñ� �Է� ó����");
			//�Է� ������ �Ѿ�� ����� �Է� ���� ����
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			System.out.println(title+" "+writer+" "+content); //�ܼ� â���� ��� Ȯ��.
			//2.BoardDO Ŭ���� ��ü �����Ͽ� �Է� ������ �ʵ�(�߰������)�� ����(�ʱ�ȭ)�Ѵ�.
			BoardDO boardDO = new BoardDO();
			boardDO.setTitle(title);
			boardDO.setWriter(writer);
			boardDO.setContent(content);
			
			//3. BoardDAO Ŭ���� ��ü ���� �� '�Խñ� ���' �޼ҵ� ȣ��
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.insertBoard(boardDO);
			
			//������
			response.sendRedirect("getBoardList.do");
			
		} else if (path.equals("/updateBoard.do")) {
			String seq = request.getParameter("seq");
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			BoardDO boardDO= new BoardDO();
			boardDO.setSeq(Integer.parseInt(seq));
			boardDO.setTitle(title);
			boardDO.setWriter(writer);
			boardDO.setContent(content);
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.updateBoard(boardDO);
			
			//������
			response.sendRedirect("getBoardList.do");
			
		} else if (path.equals("/deleteBoard.do")) {
			String seq = request.getParameter("seq");
			System.out.println("seq��"+seq);
			BoardDO boardDO = new BoardDO();
			boardDO.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.deleteBoard(boardDO);
			response.sendRedirect("getBoardList.do");
			
		} else if (path.equals("/logout.do")) {
			//1. �������� ����� ���� ��ü ����
			// [�߿�] �˻� ����� ���ǰ�ü�� �����ϰ� ������
			HttpSession session = request.getSession();
			session.invalidate();
			
			//2. ���� ���� �� �α��� �������� �̵���Ų��.
			response.sendRedirect("login.jsp");
		}
	}

}
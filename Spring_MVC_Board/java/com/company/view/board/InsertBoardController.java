package com.company.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.company.Spring_MVC_Board.board.BoardDAO;
import com.company.Spring_MVC_Board.board.BoardDO;

public class InsertBoardController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("�Խñ� �Է� ó����");
		//�Է� Form�±� �ȿ��� �Ѿ�� ����� �Է� ���� ����
		request.setCharacterEncoding("UTF-8");
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
		ModelAndView mav = new ModelAndView();
		//����Ŭ���� ���� ModelAndView�� �����Ϳ� �̵��ϰ��� �ϴ� View Page�� ���� �����Ѵ�
		
		//View ���� ����
		mav.setViewName("redirect:getBoardList.do");
		//setViewName(String view): ������ view �̸��� ����
		
		return mav;
	}

}

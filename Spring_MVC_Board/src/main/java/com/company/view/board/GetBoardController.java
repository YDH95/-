package com.company.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.company.Spring_MVC_Board.board.BoardDAO;
import com.company.Spring_MVC_Board.board.BoardDO;

public class GetBoardController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
		
		//������
		ModelAndView mav = new ModelAndView();
		/*
		 * ����Ŭ���� ���� ModelAndView�� �����Ϳ� �̵��ϰ��� �ϴ� 
		 * View Page�� ���� �����Ѵ�
		 */
		mav.addObject("board", board);
		//addObject(String name, Object value):	view�� ������ ���� ����
		mav.setViewName("getBoard");
		//setViewName(String view): ������ view �̸��� ����
		
		return mav;
	}

}

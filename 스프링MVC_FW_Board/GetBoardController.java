package com.company.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.MVC_FW_Board.board.BoardDAO;
import com.company.MVC_FW_Board.board.BoardDO;
import com.company.view.controller.Controller;

public class GetBoardController implements Controller{

	@Override
	public String HandleRequest(HttpServletRequest request, HttpServletResponse response) {
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
		
		return "getBoard";
	}

}

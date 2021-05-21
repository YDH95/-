package com.company.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.MVC_FW_Board.board.BoardDAO;
import com.company.MVC_FW_Board.board.BoardDO;
import com.company.view.controller.Controller;

public class InsertBoardController implements Controller{

	@Override
	public String HandleRequest(HttpServletRequest request, HttpServletResponse response) {
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
		
		return "getBoardList.do";
	}

}

package com.company.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.MVC_FW_Board.board.BoardDAO;
import com.company.MVC_FW_Board.board.BoardDO;
import com.company.view.controller.Controller;

public class GetBoardListController implements Controller{

	@Override
	public String HandleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("��ü �Խñ� �˻�");
		
		String searchField = ""; // �˻���� ��ü ���۷�������
		String searchText = ""; // �˻��ؽ�Ʈ

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

		return "getBoardList"; //String ��ü ����Ÿ��
	}
	
}

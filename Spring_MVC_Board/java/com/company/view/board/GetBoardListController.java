package com.company.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.company.Spring_MVC_Board.board.BoardDAO;
import com.company.Spring_MVC_Board.board.BoardDO;

public class GetBoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

		//������
		ModelAndView mav = new ModelAndView();
		//����Ŭ���� ���� ModelAndView�� �����Ϳ� �̵��ϰ��� �ϴ� View Page�� ���� �����Ѵ�

		//Model ������ "boardList" �̸����� ����
		mav.addObject("boardList", boardList);
		
		//View ���� ����
		mav.setViewName("getBoardList");
		//setViewName(String view): ������ view �̸��� ����
		
		return mav;
	}

}

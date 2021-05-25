package com.company.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.Spring_Annotation_Board.board.BoardDAO;
import com.company.Spring_Annotation_Board.board.BoardDO;

/*
 * 5���� Controller Ŭ�������� ���ս�Ų ��Ʈ�ѷ�
 * [�߿�] POJO Ŭ���� ����
 */

/**
 * 
 *  model ��ü
 *	Controller ���� ������ �����͸� ��Ƽ� View �� ������ �� ����ϴ� ��ü.
 *  - addAttribute("Ű", "��") �޼ҵ带 ����Ͽ� ������ ������ ����
 */
/*
 * @Controller ������̼��� ���� Ŭ���� ��ü�� �޸𸮿� �����ϴ� ����� �����Ѵ�.
 * ������ �ܼ��� ��ü�� �����ϴ� �Ϳ� ��ġ�� �ʰ�, DispatcherServlet�� �ν��ϴ�
 * Controller ��ü�� ����� �ش�.
 */
@Controller
public class BoardController {

	//��ü �Խñ� ��� ��ȸ ó�� �޼ҵ�
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardDO boardDO, BoardDAO boardDAO, Model model, String searchField, String searchText) {
		
		model.addAttribute("boardList", boardDAO.getBoardList(searchField, searchText));
		
		return "getBoardList.jsp";
		
	}
	//�Խñ� �󼼺��� �޼ҵ�
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardDO boardDO, BoardDAO boardDAO, Model model, String searchField, String searchText) {
		model.addAttribute("board", boardDAO.getBoard(boardDO));
		
		return "getBoard.jsp";
		
	}
	//�Խñ� ��� �޼ҵ�
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardDO boardDO, BoardDAO boardDAO) {
		boardDAO.insertBoard(boardDO);
		
		return "getBoardList.do";
	}
	//�Խñ� ���� �޼ҵ�
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardDO boardDO, BoardDAO boardDAO) {
		boardDAO.updateBoard(boardDO);
		
		return "getBoardList.do";
	}
	//�Խñ� ���� �޼ҵ�
		@RequestMapping("/deleteBoard.do")
		public String deleteBoard(BoardDO boardDO, BoardDAO boardDAO) {
			boardDAO.deleteBoard(boardDO);
			
			return "getBoardList.do";
		}
		
}



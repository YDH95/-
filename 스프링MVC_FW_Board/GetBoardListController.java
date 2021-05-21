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
		System.out.println("전체 게시글 검색");
		
		String searchField = ""; // 검색대상 객체 레퍼런스변수
		String searchText = ""; // 검색텍스트

		if (request.getParameter("searchCondition") != "" && request.getParameter("searchKeyword") != "") {
			searchField = request.getParameter("searchCondition");
			searchText = request.getParameter("searchKeyword");
		}

		// BoardDAO 클래스 객체 생성후 메서드 호출
		BoardDAO boardDAO = new BoardDAO();
		List<BoardDO> boardList = boardDAO.getBoardList(searchField, searchText);

		// [중요] 검색 결과를 세션객체에 저장하고 포워딩
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);

		return "getBoardList"; //String 객체 리턴타입
	}
	
}

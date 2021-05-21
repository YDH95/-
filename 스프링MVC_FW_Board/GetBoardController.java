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
		System.out.println("게시글 상세보기 처리됨");

		// 1. '전체 게시글 목록보기' 페이지 폼에서 '제목' 클릭했을 때 너머온
		// 상세 보기할 게시글번호 추출하기
		String seq = request.getParameter("seq");

		// 2. BoardDO클래스 객체 생성
		BoardDO boardDO = new BoardDO();
		boardDO.setSeq(Integer.parseInt(seq));

		// 3. BoardDAO클래스 개체 생성 후'게시글 상세보기'메소드 호출
		BoardDAO boardDAO = new BoardDAO();
		BoardDO board = boardDAO.getBoard(boardDO);
		
		// [중요] 검색 결과를 세션객체에 저장하고 포워딩
		HttpSession session = request.getSession();
		session.setAttribute("board", board);
		
		return "getBoard";
	}

}

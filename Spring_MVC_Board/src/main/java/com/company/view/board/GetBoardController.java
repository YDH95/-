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
		
		//포워딩
		ModelAndView mav = new ModelAndView();
		/*
		 * 내장클래스 생성 ModelAndView는 데이터와 이동하고자 하는 
		 * View Page를 같이 저장한다
		 */
		mav.addObject("board", board);
		//addObject(String name, Object value):	view에 전달할 값을 설정
		mav.setViewName("getBoard");
		//setViewName(String view): 응답할 view 이름을 설정
		
		return mav;
	}

}

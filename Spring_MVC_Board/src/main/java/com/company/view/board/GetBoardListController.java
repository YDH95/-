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

		//포워딩
		ModelAndView mav = new ModelAndView();
		//내장클래스 생성 ModelAndView는 데이터와 이동하고자 하는 View Page를 같이 저장한다

		//Model 정보를 "boardList" 이름으로 저장
		mav.addObject("boardList", boardList);
		
		//View 정보 저장
		mav.setViewName("getBoardList");
		//setViewName(String view): 응답할 view 이름을 설정
		
		return mav;
	}

}

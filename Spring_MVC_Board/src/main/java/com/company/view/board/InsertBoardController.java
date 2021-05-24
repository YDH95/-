package com.company.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.company.Spring_MVC_Board.board.BoardDAO;
import com.company.Spring_MVC_Board.board.BoardDO;

public class InsertBoardController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("게시글 입력 처림됨");
		//입력 Form태그 안에서 넘어온 사용자 입력 정보 추출
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title"); 
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		System.out.println(title+" "+writer+" "+content); //콘솔 창으로 출력 확인.
		
		//2.BoardDO 클래스 객체 생성하여 입력 값들을 필드(중간저장소)에 저장(초기화)한다.
		BoardDO boardDO = new BoardDO();
		boardDO.setTitle(title);
		boardDO.setWriter(writer);
		boardDO.setContent(content);
		
		//3. BoardDAO 클래스 객체 생성 후 '게시글 등록' 메소드 호출
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(boardDO);
		
		//포워딩
		ModelAndView mav = new ModelAndView();
		//내장클래스 생성 ModelAndView는 데이터와 이동하고자 하는 View Page를 같이 저장한다
		
		//View 정보 저장
		mav.setViewName("redirect:getBoardList.do");
		//setViewName(String view): 응답할 view 이름을 설정
		
		return mav;
	}

}

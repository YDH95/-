package com.company.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.MVC_FW_Board.board.BoardDAO;
import com.company.MVC_FW_Board.board.BoardDO;
import com.company.view.controller.Controller;

public class InsertBoardController implements Controller{

	@Override
	public String HandleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("게시글 입력 처림됨");
		//입력 폼에서 넘어온 사용자 입력 정보 추출
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
		
		return "getBoardList.do";
	}

}

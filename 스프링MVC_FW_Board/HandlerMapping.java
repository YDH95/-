package com.company.view.controller;

import java.util.HashMap;
import java.util.Map;

import com.company.view.board.DeleteBoardController;
import com.company.view.board.GetBoardController;
import com.company.view.board.GetBoardListController;
import com.company.view.board.InsertBoardController;
import com.company.view.board.UPdateBoardController;
import com.company.view.user.LoginController;
import com.company.view.user.LogoutController;

/*
 * handlerMapping
 * 
 * - dispatcherServlet로 받은 요청을 Controller로 보내지는데, 
 * 이런 요청이 어떤 방식으로 보내지는지(매핑하는지)
 * 그 방법을 정해주는 클래스가 handler
 * 
 * - 핸들러 매핑은 프로퍼티스파일(환경설정파일) 을 통해서 
 * 유지보수를 더 간소화 할 수가 있다.
 */

public class HandlerMapping {
	//객체 자료구조
	private Map<String, Controller> mappings;
	
	//생성자
	public HandlerMapping() {
		//HashMap 객체 생성
		mappings = new HashMap<String, Controller>();
		
		mappings.put("/login.do", new LoginController()); 
		mappings.put("/getBoardList.do", new GetBoardListController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/updateBoard.do", new UPdateBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		mappings.put("/logout.do", new LogoutController());
	}
	//사용자 정의 메소드 구현
	public Controller getController(String path) {
		
		return mappings.get(path);
	}
	
	
}

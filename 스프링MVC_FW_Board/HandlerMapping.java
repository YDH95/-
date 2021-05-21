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
 * - dispatcherServlet�� ���� ��û�� Controller�� �������µ�, 
 * �̷� ��û�� � ������� ����������(�����ϴ���)
 * �� ����� �����ִ� Ŭ������ handler
 * 
 * - �ڵ鷯 ������ ������Ƽ������(ȯ�漳������) �� ���ؼ� 
 * ���������� �� ����ȭ �� ���� �ִ�.
 */

public class HandlerMapping {
	//��ü �ڷᱸ��
	private Map<String, Controller> mappings;
	
	//������
	public HandlerMapping() {
		//HashMap ��ü ����
		mappings = new HashMap<String, Controller>();
		
		mappings.put("/login.do", new LoginController()); 
		mappings.put("/getBoardList.do", new GetBoardListController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/updateBoard.do", new UPdateBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		mappings.put("/logout.do", new LogoutController());
	}
	//����� ���� �޼ҵ� ����
	public Controller getController(String path) {
		
		return mappings.get(path);
	}
	
	
}

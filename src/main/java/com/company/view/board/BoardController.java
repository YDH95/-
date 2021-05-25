package com.company.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.Spring_Annotation_Board.board.BoardDAO;
import com.company.Spring_Annotation_Board.board.BoardDO;

/*
 * 5개의 Controller 클래스들을 통합시킨 컨트롤러
 * [중요] POJO 클래스 구현
 */

/**
 * 
 *  model 객체
 *	Controller 에서 생성된 데이터를 담아서 View 로 전달할 때 사용하는 객체.
 *  - addAttribute("키", "값") 메소드를 사용하여 전달할 데이터 세팅
 */
/*
 * @Controller 어노테이션이 붙은 클래스 객체를 메모리에 생성하는 기능을 제공한다.
 * 하지만 단순히 객체를 생성하는 것에 그치지 않고, DispatcherServlet이 인식하는
 * Controller 객체를 만들어 준다.
 */
@Controller
public class BoardController {

	//전체 게시글 목록 조회 처리 메소드
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardDO boardDO, BoardDAO boardDAO, Model model, String searchField, String searchText) {
		
		model.addAttribute("boardList", boardDAO.getBoardList(searchField, searchText));
		
		return "getBoardList.jsp";
		
	}
	//게시글 상세보기 메소드
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardDO boardDO, BoardDAO boardDAO, Model model, String searchField, String searchText) {
		model.addAttribute("board", boardDAO.getBoard(boardDO));
		
		return "getBoard.jsp";
		
	}
	//게시글 등록 메소드
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardDO boardDO, BoardDAO boardDAO) {
		boardDAO.insertBoard(boardDO);
		
		return "getBoardList.do";
	}
	//게시글 수정 메소드
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardDO boardDO, BoardDAO boardDAO) {
		boardDAO.updateBoard(boardDO);
		
		return "getBoardList.do";
	}
	//게시글 삭제 메소드
		@RequestMapping("/deleteBoard.do")
		public String deleteBoard(BoardDO boardDO, BoardDAO boardDAO) {
			boardDAO.deleteBoard(boardDO);
			
			return "getBoardList.do";
		}
		
}



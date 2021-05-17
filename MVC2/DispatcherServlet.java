package com.company.view.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.Model2_Board.board.BoardDAO;
import com.company.Model2_Board.board.BoardDO;
import com.company.Model2_Board.user.UserDAO;
import com.company.Model2_Board.user.UserDO;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DispatcherServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// String uri = "http://localhost:8080/Model2_Board/login.do 요청하면
		String uri = request.getRequestURI(); // /Model2_Board/login.do 를 가져옴
		String path = uri.substring(uri.lastIndexOf("/")); // substring(마지막'/' 포함된인덱스부터 ~ 마지막 인덱스)

		if (path.equals("/login.do")) {
			String id = request.getParameter("id");
			String password = request.getParameter("password");

			UserDO userDO = new UserDO();
			userDO.setId(id);
			userDO.setPassword(password);

			UserDAO userDAO = new UserDAO();
			UserDO user = userDAO.getUser(userDO);

			if (user != null) {
				System.out.println("로그인성공");
				HttpSession session = request.getSession();
				//[중요] session 객채에 "키" 값 저장하기
				session.setAttribute("idKey", id); //이름이 name인 속성의 값을 value로 지정한다.
				response.sendRedirect("getBoardList.do");
			} else {
				 PrintWriter script = response.getWriter();
			     script.println("<script>");
			     script.println("alert('Login failure')");
			     script.println("history.back()");
			     script.println("</script>");
			}
		} else if (path.equals("/getBoardList.do")) {
			String searchField = ""; // 검색대상 객체 레퍼런스변수
			String searchText = ""; // 검색텍스트

			// System.out.println("searchCondition>>>>" +
			// request.getParameter("searchCondition"));
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
			// request.setAttribute("boardList", boardList);

			// 포워딩
			response.sendRedirect("getBoardList.jsp");
			// ---------------------------------------------------------
		} else if (path.equals("/getBoard.do")) {
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
			
			//포워딩
			response.sendRedirect("getBoard.jsp");
			//-------------------------------------------------------
		} else if (path.equals("/insertBoard.do")) {
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
			
			//포워딩
			response.sendRedirect("getBoardList.do");
			
		} else if (path.equals("/updateBoard.do")) {
			String seq = request.getParameter("seq");
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			BoardDO boardDO= new BoardDO();
			boardDO.setSeq(Integer.parseInt(seq));
			boardDO.setTitle(title);
			boardDO.setWriter(writer);
			boardDO.setContent(content);
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.updateBoard(boardDO);
			
			//포워딩
			response.sendRedirect("getBoardList.do");
			
		} else if (path.equals("/deleteBoard.do")) {
			String seq = request.getParameter("seq");
			System.out.println("seq는"+seq);
			BoardDO boardDO = new BoardDO();
			boardDO.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.deleteBoard(boardDO);
			response.sendRedirect("getBoardList.do");
			
		} else if (path.equals("/logout.do")) {
			//1. 브라우저에 연결된 세션 객체 종료
			// [중요] 검색 결과를 세션객체에 저장하고 포워딩
			HttpSession session = request.getSession();
			session.invalidate();
			
			//2. 세션 종료 후 로그인 페이지로 이동시킨다.
			response.sendRedirect("login.jsp");
		}
	}

}
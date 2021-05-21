package com.company.view.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.view.user.LoginController;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private HandlerMapping handlerMapping;
    private ViewResolver viewResolver;
   
    @Override
    /**
     * init() 를 재정의 한 이유
     *  => 서블릿의 init() 메소드는 서블릿 객체가 생성된
     *     후에 멤버변수를 초기화하기 위해 자동으로 실행된다.
     */
    public void init() throws ServletException {
    	handlerMapping = new HandlerMapping();
    	viewResolver = new ViewResolver();
    	viewResolver.setPrefix("./");
    	viewResolver.setSuffix(".jsp");
    }
    
    //생성자
    public DispatcherServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		process(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 클라이언트 요청 정보 추출
		// String uri = "http://localhost:8080/MVC_FW_Board/login.do 요청하면
		//				 http => 프로토콜, localhost =>호스트명, 서버포트번호 => 8080, 프로젝트 경로 => MVC_FW_Board/login.do
		String uri = request.getRequestURI(); // /MVC_FW_Board/login.do 를 가져옴
		String path = uri.substring(uri.lastIndexOf("/")); // substring(마지막'/' 포함된인덱스부터 ~ 마지막 인덱스) /login.do
		
		//2.HandlerMapping을 통해서 path에 해당하는 Controller을 검색한다. 
		Controller ctrl = handlerMapping.getController(path); 
		//handlerMapping으로 넘어가서 /login.do의 값을 가져옴new LoginController();
		
		//3. 검색된 new LoginController();를 실행한다.
		String viewName = ctrl.HandleRequest(request, response);
		
		//4. ViewResolver를 통해서 viewName에 해당하는 페이지로 포워딩을 검색한다.
		String view = null;//변수생성 동시 초기화
		
		if(viewName.contains(".do")) { //viewName안에 .do가 포함되있다면
			view = viewName; //view변수에 viewName을 넣음
		}else {
			view = viewResolver.getView(viewName); 
			//.do가 없으면viewResolver클래스로 넘어가서 ./login.jsp를 붙여서 로그인창으로 되돌아감
		}
		//5. 페이지로 이동한다.
		response.sendRedirect(view);
	}

}

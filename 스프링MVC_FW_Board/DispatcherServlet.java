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
     * init() �� ������ �� ����
     *  => ������ init() �޼ҵ�� ���� ��ü�� ������
     *     �Ŀ� ��������� �ʱ�ȭ�ϱ� ���� �ڵ����� ����ȴ�.
     */
    public void init() throws ServletException {
    	handlerMapping = new HandlerMapping();
    	viewResolver = new ViewResolver();
    	viewResolver.setPrefix("./");
    	viewResolver.setSuffix(".jsp");
    }
    
    //������
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
		//1. Ŭ���̾�Ʈ ��û ���� ����
		// String uri = "http://localhost:8080/MVC_FW_Board/login.do ��û�ϸ�
		//				 http => ��������, localhost =>ȣ��Ʈ��, ������Ʈ��ȣ => 8080, ������Ʈ ��� => MVC_FW_Board/login.do
		String uri = request.getRequestURI(); // /MVC_FW_Board/login.do �� ������
		String path = uri.substring(uri.lastIndexOf("/")); // substring(������'/' ���Ե��ε������� ~ ������ �ε���) /login.do
		
		//2.HandlerMapping�� ���ؼ� path�� �ش��ϴ� Controller�� �˻��Ѵ�. 
		Controller ctrl = handlerMapping.getController(path); 
		//handlerMapping���� �Ѿ�� /login.do�� ���� ������new LoginController();
		
		//3. �˻��� new LoginController();�� �����Ѵ�.
		String viewName = ctrl.HandleRequest(request, response);
		
		//4. ViewResolver�� ���ؼ� viewName�� �ش��ϴ� �������� �������� �˻��Ѵ�.
		String view = null;//�������� ���� �ʱ�ȭ
		
		if(viewName.contains(".do")) { //viewName�ȿ� .do�� ���Ե��ִٸ�
			view = viewName; //view������ viewName�� ����
		}else {
			view = viewResolver.getView(viewName); 
			//.do�� ������viewResolverŬ������ �Ѿ�� ./login.jsp�� �ٿ��� �α���â���� �ǵ��ư�
		}
		//5. �������� �̵��Ѵ�.
		response.sendRedirect(view);
	}

}

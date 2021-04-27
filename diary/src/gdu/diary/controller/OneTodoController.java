package gdu.diary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gdu.diary.service.TodoService;
import gdu.diary.vo.Member;
import gdu.diary.vo.Todo;

/**
 * Servlet implementation class TodoOneController
 */
@WebServlet("/auth/oneTodo")
public class OneTodoController extends HttpServlet {
	private TodoService todoService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("==========OneTodoController controller ==========");
		int todoNo = Integer.parseInt(request.getParameter("todoNo"));
		this.todoService = new TodoService();
		
		HttpSession session = request.getSession();
		int memberNo =((Member)(session.getAttribute("sessionMember"))).getMemberNo();
		
		Todo oneTodo= new Todo(); //List<todo>로 안받고 1개라서 Todo로 받음.
		
		oneTodo = (Todo) this.todoService.Onetodo(memberNo,todoNo);
		if (oneTodo != null) {
			request.setAttribute("oneTodo",oneTodo);
			request.getRequestDispatcher("/WEB-INF/view/auth/oneTodo.jsp").forward(request,response);
		}else {
			request.getRequestDispatcher("/auth/diary").forward(request,response); //으아니 request.getContextPath()가 필요없다니 흙
		}
		
	}

}

package gdu.diary.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gdu.diary.service.TodoService;
import gdu.diary.vo.Todo;

/**
 * Servlet implementation class TodoOneController
 */
@WebServlet("/auth/oneTodo")
public class OneTodoController extends HttpServlet {
	private TodoService todoService;
	private Todo todo;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("==========OneTodoController controller ==========");
		int todoNo = Integer.parseInt(request.getParameter("todoNo"));
		this.todoService = new TodoService();
		
		List<Todo> oneTodo= new ArrayList<>();
		
		oneTodo = this.todoService.Onetodo(todoNo);
		System.out.println("===== todo"+oneTodo.toString());
		
		request.setAttribute("oneTodo",oneTodo);
		request.getRequestDispatcher("/WEB-INF/view/auth/oneTodo.jsp").forward(request,response);
	}

}

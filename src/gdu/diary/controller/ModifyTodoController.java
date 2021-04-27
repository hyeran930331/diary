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

@WebServlet("/auth/modifyTodo")
public class ModifyTodoController extends HttpServlet {
	
	private TodoService todoService;
	private Todo todo;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("==========ModifyTodoController controller get ==========");

		int todoNo = (int)(Integer.parseInt(request.getParameter("todoNo")));
		this.todoService = new TodoService();
		
		HttpSession session = request.getSession();
		int memberNo =((Member)(session.getAttribute("sessionMember"))).getMemberNo();
		
		Todo oneTodo= new Todo(); //List<todo>로 안받고 1개라서 Todo로 받음.
		
		
		oneTodo = (Todo) this.todoService.Onetodo(memberNo,todoNo);

		request.setAttribute("oneTodo",oneTodo);
		request.getRequestDispatcher("/WEB-INF/view/auth/modifyTodo.jsp?TodoNo="+todoNo).forward(request, response);
		//response.sendRedirect(request.getContextPath()+"/WEB-INT/view/auth/modifyTodo.jsp?TodoNo="+todoNo);할때 안되었음
		
		//특정 조건일 때에 지정한 페이지로 이동하고 싶은 경우 많이 사용되는 것이 response.sendRedirect() 메소드
		//response.sendRedirect()리다이렉트 메소드 이후에 코드가 실행된다는 점
		
		//request.getRequestDispatcher()디스패처.포워드 이후의 코드가 무시된다.
		//브라우저에 출력되는 페이지와 URL에 명시된 페이지 이름이 서로 다름.(request를 공유)
		//개발자들이 게시판을 이용할 때 요청속도가 느려 Refresh를 계속해서 누를 경우 똑같은 글이 계속해서 저장되는 것을 경험한 적이 있을 것이다. 
		//RequestDispatcher를 이용할 경우에는 같은 문제가 발생하는 경우가 많다.
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("==========ModifyTodoController controller post ==========");
		int todoNo = (int)(Integer.parseInt(request.getParameter("todoNo")));
		HttpSession session = request.getSession();
		int memberNo =((Member)(session.getAttribute("sessionMember"))).getMemberNo();
		
		this.todo = new Todo();
		todo.setMemeberNo(memberNo);
		todo.setTodoNo(todoNo);
		todo.setTodoDate(request.getParameter("todoDate"));
		todo.setTodoFontColor(request.getParameter("todoFontColor"));
		todo.setTodoTitle(request.getParameter("todoTitle"));
		todo.setTodoContent(request.getParameter("todoContent"));
		
		this.todoService = new TodoService();
		
		int rowCnt = 0;
		rowCnt = this.todoService.modifyTodo(todo);
		
		if (rowCnt <= 0 ) { //어떨때 가능할까... 혹시 모르니깐 해놓는 if문...
			response.sendRedirect(request.getContextPath()+"/auth/modifyTodo?TodoNo="+todoNo);
		} else if (rowCnt >0) {
			response.sendRedirect(request.getContextPath()+"/auth/oneTodo?todoNo=" + todoNo);
			//또 틀렸드아... 왜지 왜 감이 안오지...
		}
	}

}

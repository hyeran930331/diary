package gdu.diary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gdu.diary.service.MemberService;
import gdu.diary.service.TodoService;
import gdu.diary.vo.Member;
import gdu.diary.vo.Todo;

@WebServlet("/auth/removeTodo")
public class RemoveTodoController extends HttpServlet {
	
	private TodoService todoService;
	private MemberService memberService;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("==========RemoveTodoController controller get ==========");

		int todoNo = (int)(Integer.parseInt(request.getParameter("todoNo")));
		this.todoService = new TodoService();
		HttpSession session = request.getSession();
		int memberNo =((Member)(session.getAttribute("sessionMember"))).getMemberNo();
		
		Todo oneTodo= new Todo(); //List<todo>로 안받고 1개라서 Todo로 받음.
		oneTodo = (Todo) this.todoService.Onetodo(memberNo,todoNo);
		
		request.setAttribute("oneTodo",oneTodo);
		request.getRequestDispatcher("/WEB-INF/view/auth/removeTodo.jsp?todoNo="+todoNo).forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("==========RemoveTodoController controller post ==========");

		int todoNo = (int)(Integer.parseInt(request.getParameter("todoNo")));
		System.out.println("======= todoNo" +todoNo);
		String memberPw = request.getParameter("memberPw");
		
		this.todoService = new TodoService();
		HttpSession session = request.getSession();
		String memberId =((Member)(session.getAttribute("sessionMember"))).getMemberId();
		
		int rowCnt = 0;
		
		this.memberService = new MemberService();
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		
		Member returnMember;
		returnMember = this.memberService.getMemberByKey(member);
		if(returnMember == null) {
			System.out.println("로그인 실패=비번실패=삭제실패");
			response.sendRedirect(request.getContextPath()+"auth/removeTodo.jsp?todoNo="+todoNo);
		} else if (returnMember != null)  {
			
			System.out.println("\n 로그인 성공=비번성공\n");
			
			this.todoService = new TodoService();
			rowCnt = todoService.removeTodo(todoNo);
			if (rowCnt <0 ) {
				System.out.println(" 했지만 삭제실패?");
				response.sendRedirect(request.getContextPath()+"/auth/oneTodo.jsp?todoNo="+todoNo);
			} else if (rowCnt > 0 ) {
				System.out.println("######삭제성공");
				response.sendRedirect(request.getContextPath()+"/auth/diary");
			}
		}
	}
}

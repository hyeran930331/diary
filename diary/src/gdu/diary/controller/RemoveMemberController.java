package gdu.diary.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gdu.diary.service.MemberService;
import gdu.diary.vo.Member;
import gdu.diary.dao.MemberDao;

/**
 * Servlet implementation class RemoveMemberController
 */
@WebServlet("/auth/removeMember")
public class RemoveMemberController extends HttpServlet {
	private MemberService memberService;
	
	// 컴트롤러가 실행되면, 비밀번호 입력 폼으로 넘어가야함
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/auth/removeMember.jsp").forward(request, response);
	}
	
	// 컨트롤러가 삭제 폼-액션을 받았다면,
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("==========removeMember controller ==========");
		String memberPw = request.getParameter("memberPw");
		Member member = (Member)request.getSession().getAttribute("sessionMember");
		member.setMemberPw(memberPw);
		
		this.memberService = new MemberService();
		boolean result = this.memberService.removeMemberByKey(member);
		if(result == false) { //if(!result) {
			System.out.println("=====탈퇴 실패");
			response.sendRedirect(request.getContextPath()+"/auth/removeMember");
			return;
			}
		response.sendRedirect(request.getContextPath()+"/auth/logout");
	}

}

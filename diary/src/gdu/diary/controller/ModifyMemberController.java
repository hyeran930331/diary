package gdu.diary.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gdu.diary.service.MemberService;
import gdu.diary.util.DBUtil;
import gdu.diary.vo.Member;

@WebServlet("/auth/modifyMember")
public class ModifyMemberController extends HttpServlet {
	private MemberService memberService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/auth/modifyMember.jsp").forward(request,response);
		
		Member member = (Member)request.getSession().getAttribute("sessionMember");
		System.out.println("$$$$$ member : "+ member.getMemberId());
		//Cannot invoke forward(HttpServletRequest, HttpServletResponse) on the primitive type void
		//request로 줘야함 +.sendRedirect는 Parameter값 넘기는 방법
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("========== ModifyMemberController ==========");
		this.memberService = new MemberService();
		String newMemberPw = request.getParameter("newMemberPw");
		String oldMemberPw = request.getParameter("oldMemberPw");
		
		
		Member member = (Member)request.getSession().getAttribute("sessionMember");
		member.setMemberPw(oldMemberPw);
		
		this.memberService = new MemberService();

		try {
			int rowCnt = memberService.modifyMember(member, newMemberPw);
			if (rowCnt > 0) {
				System.out.println("=====수정성공");
				response.sendRedirect(request.getContextPath()+"/auth/logout");
			}else {
				System.out.println("=====수정실패");
				response.sendRedirect(request.getContextPath()+"/login");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath()+"/auth/modifyMember");
		}

	}

}

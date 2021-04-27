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

/**
 * Servlet implementation class AddMemberController
 */
@WebServlet("/addMember")
public class AddMemberController extends HttpServlet {
	private MemberService memberService;
	
    //controller실행시
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/addMember.jsp").forward(request, response);
	}

	//form-action 요청시
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=========== AddMemberController ==========");
		this.memberService = new MemberService();
		//Service :Controller에 의해 호출되어 실제 비즈니스 로직과 트랜잭션을 처리
		//dao :Service에 의해 호출되어 DB CRUD를 담당
		
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		
		int memberIntoRowCnt;
		
		try {
			memberIntoRowCnt = this.memberService.addMember(member);
			if(memberIntoRowCnt == 0) {
				System.out.println("회원가입 실패");
				response.sendRedirect(request.getContextPath()+"/addMember");
			} else {
				System.out.println("회원가입 성공");
				response.sendRedirect(request.getContextPath()+"/login");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath()+"/addMember");
		}
		
		
	}
}



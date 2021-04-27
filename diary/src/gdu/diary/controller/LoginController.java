package gdu.diary.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gdu.diary.service.MemberService;
import gdu.diary.util.DBUtil;
import gdu.diary.vo.Member;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private MemberService memberService; //역시 빨간줄은 해답을 알고있어.
	private DBUtil dbUtil;

	//로그인 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);//경로 오타 _
	}
	
	//로그인 액션 doPost는 많으니깐. 오버라이딩
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("==========login controller ==========");
		this.memberService = new MemberService();
		this.dbUtil = new DBUtil();
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw"); //소문자로 p써서 오류났었음
		System.out.println("===== memberId"+memberId);
		System.out.println("===== memberPw"+memberPw);
		
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);

		Member returnMember;
		try {
			returnMember = this.memberService.getMemberByKey(member);
			if(returnMember == null) {
				System.out.println("로그인 실패");

			} else {
				System.out.println("로그인 성공"); //4:12 안나옴. ->4:30
				HttpSession session = request.getSession();
				//session.setAttribute(memberPw, session);
				session.setAttribute("sessionMember", returnMember);
				System.out.println("===== returnMember"+returnMember); //4:12 안나옴. ->4:30
				//Cannot invoke "gdu.diary.vo.Member.setMemberNo(int)" because "returnMember" is null
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+"/login");
		//Dispatcher아니고 Redirect! webServlet을 달고 = "로그인 성공" sessionMember를 보낸다.
	}
}

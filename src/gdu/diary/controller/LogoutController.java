package gdu.diary.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutController
 */
@WebServlet("/auth/logout")
public class LogoutController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesssion = request.getSession();
		sesssion.invalidate();
		response.sendRedirect(request.getContextPath()+"/login");
	}

	

}

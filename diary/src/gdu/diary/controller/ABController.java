package gdu.diary.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gdu.diary.dao.ADao;
import gdu.diary.dao.BDao;
import gdu.diary.service.ABService;
import gdu.diary.util.DBUtil;

/**
 * Servlet implementation class ABController
 */
@WebServlet("/ABController")
public class ABController extends HttpServlet {
	private ABService abService;
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.abService = new ABService();
		this.abService.insert();
	}
}


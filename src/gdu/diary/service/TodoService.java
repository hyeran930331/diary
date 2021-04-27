package gdu.diary.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gdu.diary.dao.TodoDao;
import gdu.diary.util.DBUtil;
import gdu.diary.vo.Todo;

public class TodoService {
	private TodoDao todoDao;
	private DBUtil dbUtil;
	private Todo todo;
	
	public int removeTodo(int todoNo) {
		System.out.println("$$$$$$$$$$ removeTodo TodoService $$$$$$$$$$");
		this.dbUtil = new DBUtil();
		this.todoDao = new TodoDao();
		Connection conn = null;
		int rowCnt = 0;
		
		try {
			conn=this.dbUtil.getConnection();
			rowCnt = this.todoDao.deleteTodoByTodo(conn, todoNo);
			System.out.println("$$$$$$ 삭제 rowCnt : "+rowCnt);
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	
		return rowCnt;
	}
	
	public int modifyTodo(Todo todo) {
		System.out.println("$$$$$$$$$$ modifyTodo TodoService $$$$$$$$$$");
		this.dbUtil = new DBUtil();
		this.todoDao = new TodoDao();
		Connection conn = null;
		int rowCnt = 0;
		
		try {
			conn=this.dbUtil.getConnection();
			rowCnt = this.todoDao.updateTodo(conn, todo);
			if (rowCnt >0) {
				System.out.println("$$$$$ 수정성공");
				conn.commit();
			} else {
				System.out.println("$$$$$ 수정실패");
				conn.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("$$$$$ rowCnt : "+rowCnt);
		return rowCnt;
	}
	
	public Todo Onetodo(int memberNo, int todoNo) {
		System.out.println("$$$$$$$$$$ Onetodo TodoService $$$$$$$$$$");
		this.dbUtil = new DBUtil();
		this.todoDao = new TodoDao();
		this.todo = new Todo();
		Connection conn = null;
		
		try {
			conn=this.dbUtil.getConnection();
			todo = this.todoDao.selectTodoListByTodo(conn, memberNo, todoNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return todo;
	}
	
	public Todo Onetodo(int todoNo) {
		this.dbUtil = new DBUtil();
		this.todoDao = new TodoDao();
		Connection conn = null;
		Todo todo = new Todo();
		
		try {
			conn=this.dbUtil.getConnection();
			todo = this.todoDao.selectTodoListByTodo(conn,todoNo);
			System.out.println("##### todo+"+todo.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return todo;
	}
	
	public int addTodo(Todo todo) {
		this.dbUtil = new DBUtil();
		this.todoDao = new TodoDao();
		Connection conn = null;
		int rowCnt = 0;
		try {
			conn=this.dbUtil.getConnection();
			rowCnt = this.todoDao.insertTodo(conn, todo);
			conn.commit();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rowCnt;
	}
}

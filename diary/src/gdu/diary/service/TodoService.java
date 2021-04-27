package gdu.diary.service;

import java.sql.Connection;
import java.sql.SQLException;


import gdu.diary.dao.TodoDao;
import gdu.diary.util.DBUtil;
import gdu.diary.vo.Todo;

public class TodoService {
	private TodoDao todoDao;
	private DBUtil dbUtil;
	private Todo todo;
	
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return rowCnt;
	}
}

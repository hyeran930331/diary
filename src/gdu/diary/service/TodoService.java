package gdu.diary.service;

import java.sql.Connection;
import java.sql.SQLException;

import gdu.diary.dao.TodoDao;
import gdu.diary.util.DBUtil;
import gdu.diary.vo.Todo;

public class TodoService {
	private TodoDao todoDao;
	private DBUtil dbUtil;
	
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

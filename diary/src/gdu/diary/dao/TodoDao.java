package gdu.diary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gdu.diary.util.DBUtil;
import gdu.diary.vo.Member;
import gdu.diary.vo.Todo;

public class TodoDao {
	
	public int updateTodo(Connection conn, Todo todo) throws SQLException {
		PreparedStatement stmt = null;
		int rowCnt =0;
		
		try {
			stmt = conn.prepareStatement(TodoQuery.UPDATE_TODO_BY_TODO);
			stmt.setString(1, todo.getTodoDate());
			stmt.setString(2, todo.getTodoFontColor());
			stmt.setString(3, todo.getTodoTitle());
			stmt.setString(4, todo.getTodoContent());
			stmt.setInt(5, todo.getTodoNo());	
			stmt.setInt(6, todo.getMemberNo());
			rowCnt = stmt.executeUpdate();
		
		} finally {
			stmt.close();
		}
		return rowCnt;
	}

	public Todo selectTodoListByTodo(Connection conn, int memberNo, int todoNo) throws SQLException {
		System.out.println("~~~~~~~~~~~~ selectTodoList ByTodo  Memberdao~~~~~~~~~~~");
		Todo todo = new Todo(); //
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement(TodoQuery.SELECT_TODO_BY_TODO);
			stmt.setInt(1, todoNo);	
			stmt.setInt(2, memberNo);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				todo.setMemeberNo(rs.getInt("memberNo"));
				todo.setTodoNo(Integer.parseInt(rs.getString("todoNo")));
				todo.setTodoDate(rs.getString("todoDate"));
				todo.setTodoTitle(rs.getString("todoTitle"));
				todo.setTodoContent(rs.getString("todoContent"));
				todo.setTodoFontColor(rs.getString("todoFontColor"));
			} else {
				todo = null;
			}
		} finally {
			stmt.close();
			
		}
		return todo;
	}
	
	public List<Todo> selectTodoListByDate(Connection conn, int memberNo, int targetYear, int targetMonth) throws SQLException {
		System.out.println("~~~~~~~~~~~~ selectTodoListByDate  Memberdao~~~~~~~~~~~");
		List<Todo> list = new ArrayList<>(); //
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement(TodoQuery.SELECT_TODO_LIST_BY_DATE);
			stmt.setInt(1, targetYear);
			stmt.setInt(2, targetMonth);
			stmt.setInt(3, memberNo);			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Todo todo = new Todo();
				todo.setMemeberNo(rs.getInt("memberNo"));
				todo.setTodoNo(Integer.parseInt(rs.getString("todoNo")));
				todo.setTodoDate(rs.getString("todoDate"));
				todo.setTodoTitle(rs.getString("todoTitle"));
				todo.setTodoFontColor(rs.getString("todoFontColor"));
				list.add(todo);
				}
		} finally {
			stmt.close();
			
		}
		return list;
	}
	
	public int insertTodo (Connection conn, Todo todo) throws SQLException{
		System.out.println("~~~~~~~~~~~~ insertTodo  Memberdao~~~~~~~~~~~");
		int rowCnt = 0;
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement(TodoQuery.INSERT_TODO);
			stmt.setInt(1, todo.getMemberNo());
			stmt.setString(2, todo.getTodoDate());
			stmt.setString(3, todo.getTodoTitle());
			stmt.setString(4, todo.getTodoContent());
			stmt.setString(5, todo.getTodoFontColor());
			rowCnt = stmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			stmt.close();
		}	
		return rowCnt;
	}

	public int deleteTodoByMember (Connection conn, int memberNo) throws SQLException{
		System.out.println("~~~~~~~~~~~~ deleteMember  Memberdao~~~~~~~~~~~");
		int rowCnt = 0;
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement(TodoQuery.DELETE_TODO_BY_MEMBER);
			stmt.setInt(1, memberNo);
			rowCnt = stmt.executeUpdate();
		} finally {
			stmt.close();
		}	
		return rowCnt;
	}

	public int updateMember(Connection conn, Member oldMember, Member newMember)throws SQLException {
		System.out.println("~~~~~~~~~~~~ updateMember  Memberdao~~~~~~~~~~~");
		int rowCnt = 0;
		
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement(MemberQuery.UPDATE_IDPW_BY_MEMBER);
			stmt.setInt(1, oldMember.getMemberNo());
			stmt.setString(2, newMember.getMemberId());
			stmt.setString(3, newMember.getMemberPw());
			rowCnt = stmt.executeUpdate();
		} finally {
			stmt.close();
		}	
		return rowCnt;
	}

	public int deleteTodoByTodo(Connection conn, int todoNo) throws SQLException {
		System.out.println("~~~~~~~~~~~~ deleteTodoByTodo  Memberdao~~~~~~~~~~~");
		int rowCnt = 0;
		
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement(TodoQuery.DELETE_TODO_BY_TODO);
			stmt.setInt(1, todoNo);
			rowCnt = stmt.executeUpdate();
			System.out.println("~~~~~~~ 삭제 rowCnt :" +rowCnt);
		} finally {
			stmt.close();
		}	
		return rowCnt;
	}


}

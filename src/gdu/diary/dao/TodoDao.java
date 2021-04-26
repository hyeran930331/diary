package gdu.diary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import gdu.diary.util.DBUtil;
import gdu.diary.vo.Member;
import gdu.diary.vo.Todo;

public class TodoDao {
	private DBUtil dbUtil;
	
	public int insertTodo (Connection conn, Todo todo) throws SQLException{
		System.out.println("~~~~~~~~~~~~ insertTodo  Memberdao~~~~~~~~~~~");
		int rowCnt = 0;
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement(TodoQuery.INSERT_TODO);
			stmt.setInt(1, todo.getMemeberNo());
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
}

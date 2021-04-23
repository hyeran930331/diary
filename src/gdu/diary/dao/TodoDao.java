package gdu.diary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import gdu.diary.util.DBUtil;

public class TodoDao {
	private DBUtil dbUtil;

	public int deleteToDoByMember (Connection conn, int memberNo) throws SQLException{
		System.out.println("~~~~~~~~~~~~ deleteMember  Memberdao~~~~~~~~~~~");
		this.dbUtil = new DBUtil();
		int rowCnt = 0;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement(TodoQuery.DELETE_TODO_BY_MEMBER);
			stmt.setInt(1, memberNo);
			rowCnt = stmt.executeUpdate();
		} finally {
			dbUtil.close(null, stmt, null);
		}	
		return rowCnt;
	}
}

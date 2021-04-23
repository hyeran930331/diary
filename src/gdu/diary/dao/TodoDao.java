package gdu.diary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import gdu.diary.util.DBUtil;
import gdu.diary.vo.Member;

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

	public int updateMember(Connection conn, Member oldMember, Member newMember)throws SQLException {
		System.out.println("~~~~~~~~~~~~ updateMember  Memberdao~~~~~~~~~~~");
		this.dbUtil = new DBUtil();
		int rowCnt = 0;
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement(MemberQuery.UPDATE_IDPW_BY_MEMBER);
			stmt.setInt(1, oldMember.getMemberNo());
			stmt.setString(2, newMember.getMemberId());
			stmt.setString(3, newMember.getMemberPw());
			rowCnt = stmt.executeUpdate();
		} finally {
			dbUtil.close(null, stmt, null);
		}	
		return rowCnt;
	}
}

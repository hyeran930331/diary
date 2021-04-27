package gdu.diary.dao;

import java.sql.*;

import gdu.diary.util.DBUtil;

//트랜잭션 - 하나의 이유로 묶은것. 
public class ADao {

	public void insert(Connection conn) throws SQLException{
		System.out.println("A table insert execute");
		PreparedStatement stmt1 = null;
	
		try {
			//같은 connection 아래
			//conn.setAutoCommit(false);
			stmt1 = conn.prepareStatement("A insert 쿼리");
			stmt1.execute();	

		} finally {
			stmt1.close();
		}
	}
}

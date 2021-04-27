package gdu.diary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import gdu.diary.util.DBUtil;

//트랜잭션
public class BDao {
	
	public void insert(Connection conn) throws SQLException{
		PreparedStatement stmt2 = null;
		
		try {
			//이건 별게
			stmt2 = conn.prepareStatement("B insert 쿼리");
			stmt2.execute();
			
		} finally {
			stmt2.close();
		}
	}
}


package gdu.diary.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBUtil {
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/diary","root","java1004");
			conn.setAutoCommit(false); //커밋안하면 취소되게 설정
		} catch(SQLException e) {
			e.printStackTrace();
		}
		//1) finally 절을 구현하여 conn.close()를 하면 안되는 이유?
		return conn;//conn을 전달하는 역할을 한다.
	}
}
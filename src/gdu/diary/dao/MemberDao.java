package gdu.diary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import gdu.diary.util.DBUtil;
import gdu.diary.vo.Member;

public class MemberDao {
	private DBUtil dbUtil;
	
	public Member selectMemberByKey(Connection conn, Member member) throws SQLException{
		System.out.println("~~~~~~~~~~~~ selectMemberByKey dao~~~~~~~~~~~");
		this.dbUtil = new DBUtil();
		
		Member returnMember = null; 		//이것도 이름에리턴이 들어가서 알고 있는것.
		PreparedStatement stmt = null;
		ResultSet rs = null;
		//이젠 이건 기본값인데
		
		
		try {
			stmt = conn.prepareStatement(MemberQuery.SELECT_MEMBER_BY_KEY);
			//sql을 이젠 직접치지 않고 final String 값으로 받는다.
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
			System.out.println("~~~~~~"+ member.getMemberId());
			System.out.println("~~~~~~"+ member.getMemberPw());
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				returnMember = new Member(); //요거 안씀 4:30 성공
				returnMember.setMemberNo(rs.getInt("memberNo"));
				returnMember.setMemberId(rs.getString("memberId"));
				System.out.println("~~~~~~getMemberNo : "+ returnMember.getMemberNo()); //4:12 안됨 ->4:30
				System.out.println("~~~~~~getMemberId : "+ returnMember.getMemberId());
			}
		}finally {
			dbUtil.close(null, stmt, rs);
		}
		return returnMember;
	}
}

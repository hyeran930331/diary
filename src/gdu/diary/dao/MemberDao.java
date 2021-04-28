package gdu.diary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import gdu.diary.util.DBUtil;
import gdu.diary.vo.Member;

//resultset preparedstatement connetion jdbcAPI
//쿼리호출 -> -sql -> RDBM(마리나디비) -> vo건내주기
public class MemberDao {
	
	public int updateMember(Connection conn, Member oldMember, String newMemberPw) throws SQLException{
		System.out.println("~~~~~~~~~~~~ updateMember  Memberdao~~~~~~~~~~~");
		int rowCnt = 0;
		
		PreparedStatement stmt = null;
		System.out.println("~~~~~~  newMemberPw"+newMemberPw);
		System.out.println("~~~~~~ oldMember.getMemberNo()"+oldMember.getMemberNo());
		System.out.println("~~~~~~ oldMember.getMemberPw()"+oldMember.getMemberPw());
		
		try {
			stmt = conn.prepareStatement(MemberQuery.UPDATE_IDPW_BY_MEMBER);
			//쿼리에 맞는 변수를 넣는건 무척 중요한일입니다.
			stmt.setString(1, newMemberPw);
			stmt.setInt(2, oldMember.getMemberNo());
			stmt.setString(3, oldMember.getMemberPw());
			
			rowCnt = stmt.executeUpdate();
			System.out.println("~~~~~~ 수정rowCnt"+rowCnt);
		} finally {
			stmt.close();
		}	
		return rowCnt;
	}
	
	public int insertMember(Connection conn, Member member) throws SQLException{
		System.out.println("############ insertMember  Memberdao###########");
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int rowCnt = 0;
		
		try {
			stmt = conn.prepareStatement(MemberQuery.INSERT_MEMBER);
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
			rowCnt = stmt.executeUpdate();
		}finally {
			stmt.close();
		}	
		return rowCnt;
	}
	
	public int findMemberId(Connection conn, String memberId) throws SQLException{
		System.out.println("\n ############ findMemberId  Memberdao###########");
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int rowCnt = 0;
		//이젠 이건 기본값인데
		
		//conn은
		try {
			stmt = conn.prepareStatement(MemberQuery.SELECT_MEMBERID);
			//sql을 이젠 직접치지 않고 final String 값으로 받는다.
			stmt.setString(1, memberId);
			System.out.println("### memberId : "+memberId);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				rowCnt= rowCnt+1;
			}
			
			System.out.println("### rowCnt : "+rowCnt);
			if (rowCnt>0) {
				System.out.println("###이미 있는 아이디 입니다");
			} else {
				System.out.println("###사용가능한 아이디 입니다");
			}
		} finally {
			stmt.close();
		}
		return rowCnt;
	}
	
	public int deleteMemberByKey(Connection conn, Member member) throws SQLException{
		System.out.println("############ deleteMember  Memberdao###########");
		int rowCnt = 0;
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement(MemberQuery.DELETE_MEMBER_BY_KEY);
			stmt.setInt(1, member.getMemberNo());
			stmt.setString(2, member.getMemberPw());
			rowCnt = stmt.executeUpdate();
		} finally {
			stmt.close();
		}	
		return rowCnt;
	}
	
	public int insertMember (Connection conn, String memberId, String memberPw) throws SQLException{
		System.out.println("############ insertMember  Memberdao###########");
		int rowCnt = 0;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement(MemberQuery.INSERT_MEMBER);
			stmt.setString(1, memberId);
			stmt.setString(2, memberPw);
			rs = stmt.executeQuery();
			
			//id중복검사.
			
		} finally {
			stmt.close();
			rs.close();
		}
		return rowCnt;
	}
	
	public Member selectMemberByKey(Connection conn, Member member) throws SQLException{
		System.out.println("############ selectMemberByKey  Memberdao###########");
		
		Member returnMember = null; 		//이것도 이름에리턴이 들어가서 알고 있는것.
		PreparedStatement stmt = null;
		ResultSet rs = null;
		//이젠 이건 기본값인데
		
		//conn은
		try {
			stmt = conn.prepareStatement(MemberQuery.SELECT_MEMBER_BY_KEY);
			//sql을 이젠 직접치지 않고 final String 값으로 받는다.
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
			System.out.println("######"+ member.getMemberId());
			System.out.println("######"+ member.getMemberPw());
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				returnMember = new Member(); //요거 안씀 4:30 성공
				returnMember.setMemberNo(rs.getInt("memberNo"));
				returnMember.setMemberId(rs.getString("memberId"));
				System.out.println("######getMemberNo : "+ returnMember.getMemberNo()); //4:12 안됨 ->4:30
				System.out.println("######getMemberId : "+ returnMember.getMemberId());
			}
		}finally {
			stmt.close();
			rs.close();
		}
		return returnMember;
	}

	
}

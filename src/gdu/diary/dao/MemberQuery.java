package gdu.diary.dao;//패키지 안에

public class MemberQuery { //클래스를 만든다. 그래서 필요할때 import gdu.diary.dao.MemberQuery; 를 하고 그다음 아래 메소드들을 쓸 수 있다. = 
	public final static String SELECT_MEMBER_BY_KEY; // MemberQuery.SELECT_MEMBER_BY_KEY를 쓴다면 SELECT_MEMBER_BY_KEY변수명의 String을 가진다.
	
	static{ 
		SELECT_MEMBER_BY_KEY = "SELECT member_no memberNo, member_id memberId From member WHERE member_id=? AND member_pw=PASSWORD(?)";
	} //SELECT_MEMBER_BY_KEY는 member_id와 member_no가 있을때, memberNo memberId를 member로 부터 
	
	public final static String INSERT_MEMBER;
	static {
		INSERT_MEMBER = "INSERT INTO member(member_id, member_pw, member_date) VALUES(?,PASSWORD(?),now())";
	}
	
	public final static String DELETE_MEMBER_BY_KEY;
	static {
		DELETE_MEMBER_BY_KEY = "DELETE FROM member WHERE member_no=? AND member_pw=PASSWORD(?)";
	}
	
	public final static String SELECT_MEMBERID; // MemberQuery.SELECT_MEMBER_BY_KEY를 쓴다면 SELECT_MEMBER_BY_KEY변수명의 String을 가진다.
	static{ 
		SELECT_MEMBERID = "SELECT member_no memberNo From member WHERE member_id=?";
	}
	
	public static String UPDATE_IDPW_BY_MEMBER;
	static {
		UPDATE_IDPW_BY_MEMBER = "UPDATE member SET member_pw=PASSWORD(?) WHERE member_no=? AND member_pw=PASSWORD(?)";
	}
}

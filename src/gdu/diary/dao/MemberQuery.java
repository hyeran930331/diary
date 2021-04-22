package gdu.diary.dao;//패키지 안에

public class MemberQuery { //클래스를 만든다. 그래서 필요할때 import gdu.diary.dao.MemberQuery; 를 하고 그다음 아래 메소드들을 쓸 수 있다. = 
	public final static String SELECT_MEMBER_BY_KEY; // MemberQuery.SELECT_MEMBER_BY_KEY를 쓴다면 SELECT_MEMBER_BY_KEY변수명의 String을 가진다.
	
	static{ 
		SELECT_MEMBER_BY_KEY = "SELECT member_no memberNo, member_id memberId From member WHERE member_id=? AND member_pw=PASSWORD(?)";
	} //SELECT_MEMBER_BY_KEY는 member_id와 member_no가 있을때, memberNo memberId를 member로 부터 
}

package gdu.diary.service;

import java.sql.Connection;
import java.sql.SQLException;

import gdu.diary.dao.MemberDao;
import gdu.diary.util.DBUtil;
import gdu.diary.vo.Member;

public class MemberService {
	private DBUtil dbUtil;
	private MemberDao memberDao;
	// 다른 클래스/메소드(sql 기반)랑 헷갈리면 안되니깐 서비스는 같은뜻 다른식의 표현으로 씀
	// select -> get
	// insert -> add
	// update -> modify
	// delete -> remove
	
	public Member getMemberByKey(Member member) {
		this.memberDao = new MemberDao();
		this.dbUtil = new DBUtil();
		Member returnMember = null;
		Connection conn = null;
		try {
			conn = dbUtil.getConnection();
			returnMember = this.memberDao.selectMemberByKey(conn, member);
			conn.commit();//commit을 안하면 안되요. 
			//jdbc(자바에서 데이터베이스에 접속할 수 있도록 하는 자바 API)에서 
			//트랜잭션(데이터 처리의 단위, SQL문을 하나의 논리작업단위로 묶은것)
			//(모두가 정상이면 정상종료. 하나라도 오류가 있다면 취소)처리를 하려면 
			//conn.commit()과 conn.rollback()을 사용하면 된다!
			//커밋은 db에 저장하고 트랜잭션을 종료
			//롤백은 변경을 모두 취소하고 트랜잭션을 종료 savepoint로 복구시키는 명령
			
			// 커밋과 롤백을 쓰려면 다음 설정을 꼭 해줘야만 한다!
			//(시작 지점에서 설정해주면 된다. 디폴트가 true이기 때문)
			//conn.setAutoCommit(false); 
			// ->여기서 시작지점이라하믄 DBUtil.getConnection try{}

		} catch (SQLException e){ //sqlexcaption을 발견하면,
			try { //맞으면
				conn.rollback(); //취소취소
				e.printStackTrace();// 에러코드 출력
			} catch (SQLException e1){ // ??왜하는걸까요? 
				e1.printStackTrace(); // 근데 없으면 작동이 안되요~
			}
			e.printStackTrace();
		} finally {
			this.dbUtil.close(conn, null, null); //뭘 하든 마지막엔 다 종료
		}
		
		return returnMember;
	}
}

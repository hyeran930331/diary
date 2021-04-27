package gdu.diary.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gdu.diary.dao.TodoDao;
import gdu.diary.util.DBUtil;
import gdu.diary.vo.Todo;

public class DiaryService {
	private TodoDao todoDao;
	private DBUtil dbUtil;
	
	public Map<String, Object> getDiary(int memberNo, String targetYear, String targetMonth){
		
		//타켓(없으면 오늘)의 년, 월, 일
		Calendar target = Calendar.getInstance();
		
		if(targetYear != null) {
			target.set(Calendar.YEAR, Integer.parseInt(targetYear));
		}
		if(targetMonth != null) {
			target.set(Calendar.MONTH, Integer.parseInt(targetMonth)-1); //month가 13이면 자동으로 year값을 늘려준다. month가 0이면 자동으로 year값을 내려준다.
		}
		
		//타켓(없으면 오늘)달의 1일(날짜)의 위치값
		target.set(Calendar.DATE, 1); //왜 필요하지??
		
		
		//앞의 빈셀 startBlank //1숫자앞에 와야한 빈셀의 갯수.
		int startBlank = target.get(Calendar.DAY_OF_WEEK)-1;
		//타켓(없으면 오늘)달의 마지막일의 숫자 endDay //target렬 마지막 날짜
		int endDay = target.getActualMaximum(Calendar.DATE);
	
		
		
		int endBlank = 0;
		//전체 셀의 갯수(>=마지막일 && 7로 나누어 떨어짐)
		//(startBlank + endDay + endBlank %7) ==0
		if ((startBlank + endDay)%7 !=0) { //앞빈칸과 마지막일의 숫자 == 0이 아니라면,
			//뒷의 빈셀 endBlank -> 7-(startBlank + endDay)%7
			endBlank = 7- ((startBlank + endDay)%7);
		}
		
		int totalCell = startBlank + endDay + endBlank;
		
		Map<String, Object> map = new HashMap<String, Object>();		
		
		map.put("targetYear", target.get(Calendar.YEAR));
		map.put("targetMonth", target.get(Calendar.MONTH)+1);
		map.put("startBlank", startBlank);
		map.put("endDay", endDay);
		map.put("endBlank", endBlank);
		map.put("totalCell", totalCell);
		
		//2. targetYear, targetMonth
		this.dbUtil = new DBUtil();//
		this.todoDao = new TodoDao();
		List<Todo> todoList = null;
		List<Map <String, Object>> ddayList = null;
		Connection conn = null;
		
		try {
			conn= this.dbUtil.getConnection();
			todoList = this.todoDao.selectTodoListByDate(conn, memberNo, target.get(Calendar.YEAR), target.get(Calendar.MONTH)+1);
			ddayList = this.todoDao.selectTodoDayList(conn, memberNo);
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		map.put("todoList", todoList);
		map.put("ddayList", ddayList);
		return map;
	}
	
	
}

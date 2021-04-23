package gdu.diary.service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class DiaryService {
	public Map<String, Object> getDiary(String targetYear, String targetMonth){
		
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
		
		return map;
	}
}

package gdu.diary.dao;

public class TodoQuery {
	public final static String DELETE_TODO_BY_MEMBER;
	static {
		DELETE_TODO_BY_MEMBER = "DELETE FROM todo WHERE member_no=?";
	}
	
	public final static String INSERT_TODO;
	static {
		INSERT_TODO = "INSERT INTO todo( member_no, todo_date, todo_title, todo_content, todo_font_color, todo_add_date) VALUES(?,?,?,?,?, NOW())";
	}
	
	public final static String SELECT_TODO_LIST_BY_DATE;
	static {
		SELECT_TODO_LIST_BY_DATE = "SELECT member_no memberNo, todo_font_color TodoFontColor, todo_no todoNo, left(todo_title,10) todoTitle, DAY(todo_date) todoDate FROM todo WHERE YEAR(todo_date)=? AND MONTH(todo_date)=? AND member_no=?";
	}
	
	public final static String SELECT_TODO_LIST_BY_TODO;
	static {
		SELECT_TODO_LIST_BY_TODO = "SELECT member_no memberNo, todo_font_color TodoFontColor, todo_no todoNo, todo_title todoTitle, todo_date todoDate, todo_content todoContent FROM todo WHERE todo_no=?";
	}
	
	public final static String SELECT_TODO_DDAY_LIST;
	static {
		SELECT_TODO_DDAY_LIST = "SELECT todo_no todoNo, todo_date todoDate, todo_title todoTitle, DATEDIFF(todo_date,DATE(NOW())) dday FROM todo  WHERE member_no=? AND todo_date >= DATE(NOW()) ORDER BY todo_date ASC LIMIT 10";
	}
	
	public final static String SELECT_TODO_BY_TODO;
	static {
		SELECT_TODO_BY_TODO = "SELECT member_no memberNo, todo_font_color TodoFontColor, todo_no todoNo, todo_title todoTitle, todo_date todoDate, todo_content todoContent FROM todo WHERE todo_no=? AND member_no =?";
	}
	
	public final static String UPDATE_TODO_BY_TODO;
	static {
		UPDATE_TODO_BY_TODO = "UPDATE todo SET todo_date=?, todo_font_color=?, todo_title=?, todo_content=?  WHERE todo_no=? AND member_no=?";
	}
	
	public final static String DELETE_TODO_BY_TODO;
	static {
		DELETE_TODO_BY_TODO = "DELETE FROM todo WHERE todo_no=?";
	}
}

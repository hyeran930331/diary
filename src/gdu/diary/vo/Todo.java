package gdu.diary.vo;

public class Todo {
	private int todoNo;
	private int memeberNo;
	private String todoDate;
	private String todoFontColor;
	private String todoTitle;
	private String todoContent;
	
	public int getTodoNo() {
		return todoNo;
	}
	public void setTodoNo(int todoNo) {
		this.todoNo = todoNo;
	}
	public int getMemeberNo() {
		return memeberNo;
	}
	public void setMemeberNo(int memeberNo) {
		this.memeberNo = memeberNo;
	}
	public String getTodoDate() {
		return todoDate;
	}
	public void setTodoDate(String todoDate) {
		this.todoDate = todoDate;
	}
	public String getTodoFontColor() {
		return todoFontColor;
	}
	public void setTodoFontColor(String todoFontColor) {
		this.todoFontColor = todoFontColor;
	}
	public String getTodoTitle() {
		return todoTitle;
	}
	public void setTodoTitle(String todoTitle) {
		this.todoTitle = todoTitle;
	}
	public String getTodoContent() {
		return todoContent;
	}
	public void setTodoContent(String todoContent) {
		this.todoContent = todoContent;
	}
}

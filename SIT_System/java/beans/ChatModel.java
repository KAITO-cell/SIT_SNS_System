package beans;

public class ChatModel {
	
	private String studentid;
	private String textid;
	//TextArea text = new TextArea();
	private String text;
	private String time;
	
	public ChatModel(){}
	
	public ChatModel(String textid, String studentid , String text, String time) {
		this.textid = textid;
		this.studentid = studentid;
		this.text = text;
		this.time = time;
	}
	
	public String getStudentid() {
		return studentid;
	}
	public String getTextid() {
		return textid;
	}
	public String getText() {
		return text;
	}
	public String getTime() {
		return time;
	}
}

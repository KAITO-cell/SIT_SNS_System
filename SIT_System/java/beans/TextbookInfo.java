package beans;

public class TextbookInfo {
	
	private String textId; 
	private String studentId;
	private String studentName;
	private String department;
	private String subject;
	private String textName;
	private String authorName;
	private String publisherName;
	private String campusName;
	
	public String getTextId() {
		return textId;
	}
	
	public String getStudentId() {
		return studentId;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public String getTextName() {
		return textName;
	}
	
	public String getAuthorName() {
		return authorName;
	}
	
	public String getPublisherName() {
		return publisherName;
	}
	
	public String getCampusName() {
		return campusName;
	}
	
	//setメソッド
	
	public void setTextId(String textId) {
		this.textId = textId;
	}
	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public void setTextName(String textName) {
		this.textName = textName;
	}
	
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	
	public void setCampusName(String campusName) {
		this.campusName = campusName;
	}
	
	
}

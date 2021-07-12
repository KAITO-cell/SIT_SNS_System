/**************************************************************************************************
 ***  File Name      : Request.java
 ***  Version        : V2.0
 ***  Designer       : 奈良操樹
 ***  Date           : 2021.07.11
 ***  Purpose        : 教科書リスト画面で選択された教科書の情報をセッションに登録する
 ***
 **************************************************************************************************/
/*
 *** Revision :
 *** V1.0 : 奈良操樹,2021.06.28
 *** V1.1 : 奈良操樹,2021.07.02
 */
package beans;

import java.io.Serializable;

public class ChatModel implements Serializable{
	
	private String roomID;
	private String studentID;
	private String text;
	private String time;

	public ChatModel(){
		
	}

	public ChatModel(String roomid, String studentid , String text, String time) {
		this.roomID = roomid;
		this.studentID = studentid;
		this.text = text;
		this.time = time;
	}
	
	public String getStudentID() {
		return this.studentID;
	}
	public String getRoomid() {
		return this.roomID;
	}
	public String getText() {
		return this.text;
	}
	public String getTime() {
		return this.time;
	}
	
}

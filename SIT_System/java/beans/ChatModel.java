  
  /**************************************************************************************************
 ***  File Name      : ChatModel.java
 ***  Version        : V1.0
 ***  Designer       : 樋口大成
 ***  Date           : 2021.06.17
 ***  Purpose        : ChatDAO.javaによりデータベースから読みだした値に基づくインスタンス生成のための変数を定義する。
 ***                   
 **************************************************************************************************/
/*
 *** Revision :
 *** V1.0 : 樋口大成,2021.06.17
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

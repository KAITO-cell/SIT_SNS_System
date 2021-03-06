  
  /**************************************************************************************************
 ***  File Name      : TextChatModel.java
 ***  Version        : V1.0
 ***  Designer       : 石塚啓将
 ***  Date           : 2021.06.17
 ***  Purpose        : ChatDAO.javaによりデータベースから読みだした値に基づくインスタンス生成のための変数を定義する。
 ***                   
 **************************************************************************************************/
/*
 *** Revision :
 *** V1.0 : 石塚啓将,2021.06.17
 */
package beans;

import java.io.Serializable;

public class TextChatModel implements Serializable{

	private String studentid;
	private String textid;
	private String text;
	private String time;

	public TextChatModel(){
		
	}

	public TextChatModel(String textid, String studentid , String text, String time) {
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

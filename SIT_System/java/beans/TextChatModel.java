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

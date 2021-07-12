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

public class ScheduleModel implements Serializable{

	String first;
	String second;
	String third;
	String fourth;
	String fifth;
	String sixth;
	String seventh;
	
	public ScheduleModel(String first, String second, String third, String fourth, String fifth, String sixth, String seventh) {

		this.first = first;
		this.second = second;
		this.third = third;
		this.fourth = fourth;
		this.fifth = fifth;
		this.sixth = sixth;
		this.seventh = seventh;
	}

	public String getFirst() {
		return this.first;
	}
	public String getSecond() {
		return this.second;
	}
	public String getThird() {
		return this.third;
	}
	public String getFourth() {
		return this.fourth;
	}
	public String getFifth() {
		return this.fifth;
	}
	public String getSixth() {
		return this.sixth;
	}
	public String getSeventh() {
		return this.seventh;
	}
	
}

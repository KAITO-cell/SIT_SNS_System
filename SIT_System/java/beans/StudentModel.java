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

public class StudentModel implements Serializable {
	
    private String studentID;
    private String password;
    private String password_check ;
    private String studentName;
    
    public StudentModel() {
  	  
    }
    
    public StudentModel(String id, String pass) {
    	this.studentID = id;
    	this.password = pass;
    }
    
    public StudentModel(String id, String pass, String name) {
    	this.studentID = id ;
    	this.password = pass;
    	this.studentName = name ;
    }

    public String getStudentID(){
        return this.studentID;
    }
    public String getStudentPass(){
        return this.password;
    }
    public String getStudentPass_Check(){
        return this.password_check;
    }
    public String getStudentName(){
        return this.studentName;
    }
    
}

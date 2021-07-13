  
  /**************************************************************************************************
 ***  File Name      : StudentModel.java
 ***  Version        : V1.1
 ***  Designer       : 寺岡克起
 ***  Date           : 2021.07.13
 ***  Purpose        : StudentDAO.javaによりデータベースから読みだした値に基づくインスタンス生成のための変数を定義する。
 ***                   
 **************************************************************************************************/
/*
 *** Revision :
 *** V1.0 : 寺岡克起,2021.06.17
 *** V1.1 : 寺岡克起,2021.07.13
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

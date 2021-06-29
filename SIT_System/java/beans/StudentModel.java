package beans;

import java.io.Serializable;

public class StudentModel implements Serializable {
    private String studentID;
    private String password;
    private String password_check ;
    private String studentName;
    
    public StudentModel() {
  	  
    }
    
//    public StudentModel(String name) {
//    	this.studentName = name ;
//    }
    
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
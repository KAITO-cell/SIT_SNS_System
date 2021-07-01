//package 
package beans;

import java.io.Serializable;

public class RegisterListModel implements Serializable {
    private String textID;
    private String studentID;
    private String studentName;
    private String department;
    private String subject;
    private String textName;
    private String author;
    private String publish;
    private String campus;

    public RegisterListModel(String tI,String stdID,String stdN,String dep,String sub,String tN,String aut,String pub,String cam){
        this.textID=tI;
        this.studentID=stdID;
        this.studentName=stdN;
        this.department=dep;
        this.subject=sub;
        this.textName=tN;
        this.author=aut;
        this.publish=pub;
        this.campus=cam;
    }
    
    public RegisterListModel(String stdID,String stdN,String dep,String sub,String tN,String aut,String pub,String cam){
        this.studentID=stdID;
        this.studentName=stdN;
        this.department=dep;
        this.subject=sub;
        this.textName=tN;
        this.author=aut;
        this.publish=pub;
        this.campus=cam;
    }

    public String getTextID(){
        return this.textID;
    }

    public String getStudentID(){
        return this.studentID;
    }
    public String getStudentName(){
        return this.studentName;
    }
    public String getDepartment(){
        return this.department;
    }    
    public String getSubject(){
        return this.subject;
    }
    public String getTextName(){
        return this.textName;
    }
    public String getAuthor(){
        return this.author;
    }
    public String getPublish(){
        return this.publish;
    }
    public String getCampus(){
        return this.campus;
    }

}
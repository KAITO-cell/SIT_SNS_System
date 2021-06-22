//package 


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
        this.studenName=stdN;
        this.department=dep;
        this.subject=sub;
        this.textName=tN;
        this.author=aut;
        this.publish=pub;
        this.campus=cam;
    }

    public String getTextID(){
        return this.textId;
    }

    public String getStudentID(){
        return this.studentID;
    }
    public String getStudentName(){
        return this.getStudentName;
    }
    public String getDepartMent(){
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
        return this.campus
    }

}
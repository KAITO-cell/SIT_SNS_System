//package name


public class StudentModel {
    private String studentID;
    private String password;
    private String studentName;

    public StudentModel(String stdID,String pass,String stdName){
        this.studentID = stdID;
        this.password = pass;
        this.studentName = stdName;
    }

    public String getStudentID(){
        return this.studentID;
    }
    public String getPassword(){
        return this.password;
    }
    public String getStudentName(){
        return this.studentName;
    }

}
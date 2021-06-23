package beans;

import java.io.Serializable;

public class Student implements Serializable {
  private String id;
  private String pass;
  private String pass_check;
  private String name;

  public Student() {
	  
  }
  
  public Student(String id, String pass) {
	this.id = id;
	this.pass = pass;
  }
  
  public Student(String id, String pass, String name) {
	this.id = id ;
	this.pass = pass;
	this.name = name ;
  }

  public Student(String id, String pass, String pass_check, String name) {
	this.id = id ;
	this.pass = pass;
    this.pass_check = pass_check;
    this.name = name ;
  }

  public String getId() {
    return id;
  }

  public String getPass() {
    return pass;
  }
  
  public String getPass_check() {
	return pass_check;
  }

  public String getName() {
    return name;
  }
}
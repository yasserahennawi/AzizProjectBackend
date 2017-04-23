package com.ht.AzizBackend.ModelLayer;

public class Student {
  private String student_ID;
  private String student_Firstname;
  private String student_lastname;
  private String student_gander;
  private String section;
  private String division;
  private String stage;
  private String address;

  public Student(String student_ID, String student_Firstname, String student_lastname, String student_gander, String section, String division, String stage, String address) {
    this.student_ID = student_ID;
    this.student_Firstname = student_Firstname;
    this.student_lastname = student_lastname;
    this.student_gander = student_gander;
    this.section = section;
    this.division = division;
    this.stage = stage;
    this.address = address;
  }

  public String getStudent_ID() {
    return student_ID;
  }

  public String getStudent_Firstname() {
    return student_Firstname;
  }

  public String getStudent_lastname() {
    return student_lastname;
  }

  public String getStudent_gander() {
    return student_gander;
  }

  public String getSection() {
    return section;
  }

  public String getDivision() {
    return division;
  }

  public String getStage() {
    return stage;
  }

  public String getAddress() {
    return address;
  }
  
  
}

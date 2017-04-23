package com.ht.AzizBackend.ModelLayer;

public class Subject {

  private String subject_id;
  private String sub_dept_name;
  private String subject_name;
  private String chr_no;
  private String subject_degree;

  public Subject(String subject_id, String sub_dept_name, String subject_name, String chr_no, String subject_degree) {
    this.subject_id = subject_id;
    this.sub_dept_name = sub_dept_name;
    this.subject_name = subject_name;
    this.chr_no = chr_no;
    this.subject_degree = subject_degree;
  }

  public String getSubject_id() {
    return subject_id;
  }

  public String getSub_dept_name() {
    return sub_dept_name;
  }

  public String getSubject_name() {
    return subject_name;
  }

  public String getChr_no() {
    return chr_no;
  }

  public String getSubject_degree() {
    return subject_degree;
  }

}

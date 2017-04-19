package com.ht.AzizBackend.ModelLayer;

public class Staff {

  private String staffID;
  private String staffFirstname;
  private String staffLastname;
  private String gender;
  private String degree;
  private String address;

  public Staff(String staffID, String staffFirstname, String staffLastname, String gender, String degree, String address) {
    this.staffID = staffID;
    this.staffFirstname = staffFirstname;
    this.staffLastname = staffLastname;
    this.gender = gender;
    this.degree = degree;
    this.address = address;
  }

  public String getStaffID() {
    return staffID;
  }

  public String getStaffFirstname() {
    return staffFirstname;
  }

  public String getStaffLastname() {
    return staffLastname;
  }

  public String getGender() {
    return gender;
  }

  public String getDegree() {
    return degree;
  }

  public String getAddress() {
    return address;
  }

}

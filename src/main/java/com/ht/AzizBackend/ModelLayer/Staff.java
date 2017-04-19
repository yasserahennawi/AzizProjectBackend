package com.ht.AzizBackend.ModelLayer;

public class Staff {

  private String staffID;
  private String staffFirstname;
  private String staffSecondname;
  private String gender;
  private String degree;
  private String address;

  public Staff(String staffID, String staffFirstname, String staffSecondname, String gender, String degree, String address) {
    this.staffID = staffID;
    this.staffFirstname = staffFirstname;
    this.staffSecondname = staffSecondname;
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
    return staffSecondname;
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

package com.ht.AzizBackend.ModelLayer;

public class Staff {

  private String staff_id;
  private String staff_firstname;
  private String staff_secondname;
  private String ganeder;
  private String degree;
  private String address;

    public Staff(String staff_id, String staff_firstname, String staff_secondname, String ganeder, String degree, String address) {
        this.staff_id = staff_id;
        this.staff_firstname = staff_firstname;
        this.staff_secondname = staff_secondname;
        this.ganeder = ganeder;
        this.degree = degree;
        this.address = address;
    }

    public String getStaff_id() {
        return staff_id;
    }

    public String getStaff_firstname() {
        return staff_firstname;
    }

    public String getStaff_secondname() {
        return staff_secondname;
    }

    public String getGaneder() {
        return ganeder;
    }

    public String getDegree() {
        return degree;
    }

    public String getAddress() {
        return address;
    }

}

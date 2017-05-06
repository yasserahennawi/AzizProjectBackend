/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ht.AzizBackend.DBLayer;

import com.ht.AzizBackend.ModelLayer.Staff;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class StaffRepository {

  private Statement stat;
  private ResultSet rs;

  public StaffRepository() {
    try {
      SQLConfig config = SQLConfig.getInstance();
      System.out.println("Database connection established");
      stat = config.con.createStatement();

    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public Staff addStaff(Staff staff) throws Exception {
    try {
      String insert = "INSERT INTO staff(staff_id, staff_firstname, staff_secondname, ganeder, degree, address) VALUES('" + staff.getStaff_id() + "','" + staff.getStaff_firstname() + "','" + staff.getStaff_secondname()+ "','" + staff.getGaneder() + "','" + staff.getDegree() + "','" + staff.getAddress() + "')";
      stat.executeUpdate(insert);
    } catch (Exception e) {
      throw e;
    }
    return staff;
  }

  public ArrayList<Staff> getAllStaff() throws Exception {
    try {
      String query = "SELECT * FROM staff";
      rs = stat.executeQuery(query);
      ArrayList<Staff> staffs = new ArrayList<>();
      while (rs.next()) {
        String staff_id = rs.getString("staff_id");
        String staff_firstname = rs.getString("staff_firstname");
        String staff_secondname = rs.getString("staff_secondname");
        String ganeder = rs.getString("ganeder");
        String degree = rs.getString("degree");
        String address = rs.getString("address");
        Staff staff = new Staff(staff_id, staff_firstname, staff_secondname, ganeder, degree, address);
        staffs.add(staff);
      }
      return staffs;

    } catch (Exception e) {
      throw e ;
    }

  }
  public ArrayList<Staff> getStaffByID(String id) throws Exception {
    try {
      String query = "SELECT * FROM staff WHERE staff_id='" + id + "'";
      rs = stat.executeQuery(query);
      ArrayList<Staff> staffs = new ArrayList<>();
      while (rs.next()) {
        String staff_id = rs.getString("staff_id");
        String staff_firstname = rs.getString("staff_firstname");
        String staff_secondname = rs.getString("staff_secondname");
        String ganeder = rs.getString("ganeder");
        String degree = rs.getString("degree");
        String address = rs.getString("address");
        Staff staff = new Staff(staff_id, staff_firstname, staff_secondname, ganeder, degree, address);
        staffs.add(staff);
      }
      return staffs;
    } catch (Exception e) {
      throw e ;
    }
  }
  
  public Staff deleteStaff(Staff staff) throws Exception {
    try {
      String delete = "DELETE FROM staff WHERE staff_id = '" + staff.getStaff_id() + "'" ;
      stat.executeUpdate(delete);
    } catch (Exception e) {
      throw e ;
    }
    return staff;
  }

  public Staff editStaff(Staff oldStaff, Staff newStaff) throws Exception {
    try {
      String edit = 
        "UPDATE staff SET "
        + "staff_id = '" + newStaff.getStaff_id()
        + "', staff_firstname = '" + newStaff.getStaff_firstname()
        + "', staff_secondname = '" + newStaff.getStaff_secondname()
        + "', ganeder = '" + newStaff.getGaneder()
        + "', degree = '" + newStaff.getDegree()
        + "', address = '" + newStaff.getAddress()
        + "' WHERE staff_id = '" + oldStaff.getStaff_id()+"'";
      stat.executeUpdate(edit);
    } catch (Exception e) {
      throw e ;
    }
    return newStaff;
  }
}

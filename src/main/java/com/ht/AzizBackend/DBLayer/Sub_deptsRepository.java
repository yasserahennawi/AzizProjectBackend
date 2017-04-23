/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ht.AzizBackend.DBLayer;

import com.ht.AzizBackend.ModelLayer.Sub_dept;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Sub_deptsRepository {

  private Statement stat;
  private ResultSet rs;

  public Sub_deptsRepository() {
    try {
      SQLConfig config = SQLConfig.getInstance();
      System.out.println("Database connection established");
      stat = config.con.createStatement();

    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public Sub_dept addSub_dept(Sub_dept sub_dept) throws Exception {
    try {
      String insert = "INSERT INTO sub_depts(sub_dept_id, sub_dept_name) VALUES('" + sub_dept.getSub_dept_id() + "','" + sub_dept.getSub_dept_name()+ "')";
      stat.executeUpdate(insert);
    } catch (Exception e) {
      throw e;
    }
    return sub_dept;
  }

  public ArrayList<Sub_dept> getSub_deptByID(String id) throws Exception {
    try {
      String query = "SELECT * FROM sub_dept WHERE sub_dept_id='" + id + "'";
      rs = stat.executeQuery(query);
      ArrayList<Sub_dept> sub_depts = new ArrayList<>();
      while (rs.next()) {
        String sub_dept_id = rs.getString("sub_dept_id");
        String sub_dept_name = rs.getString("sub_dept_name");
        Sub_dept sub_dept = new Sub_dept(sub_dept_id, sub_dept_name);
        sub_depts.add(sub_dept);
      }
      return sub_depts;
    } catch (Exception e) {
      throw e ;
    }
  }

  public ArrayList<Sub_dept> getAllSub_dept() throws Exception {
    try {
      String query = "SELECT * FROM sub_dept";
      rs = stat.executeQuery(query);
      ArrayList<Sub_dept> sub_depts = new ArrayList<>();
      while (rs.next()) {
        String sub_dept_id = rs.getString("sub_dept_id");
        String sub_dept_name = rs.getString("sub_dept_name");
        Sub_dept sub_dept = new Sub_dept(sub_dept_id, sub_dept_name);
        sub_depts.add(sub_dept);
      }
      return sub_depts;
    } catch (Exception e) {
      throw e ;
    }
  }
}

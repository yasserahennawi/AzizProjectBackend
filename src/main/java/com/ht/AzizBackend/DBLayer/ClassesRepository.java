/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ht.AzizBackend.DBLayer;

import com.ht.AzizBackend.ModelLayer.Classes;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ClassesRepository {

  private Statement stat;
  private ResultSet rs;

  public ClassesRepository() {
    try {
      SQLConfig config = SQLConfig.getInstance();
      System.out.println("Database connection established");
      stat = config.con.createStatement();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public Classes addClasses(Classes classes) throws Exception {
    try {
      String insert = "INSERT INTO staff(class_id, class_type) VALUES('" + classes.getClassID() + "','" + classes.getClassType() + "')";
      stat.executeUpdate(insert);
    } catch (Exception e) {
      throw e;
    }
    return classes;
  }

  public ArrayList<Classes> getClassesByID(String id) throws Exception {
    try {
      String query = "SELECT * FROM classes WHERE classID='" + id + "'";
      rs = stat.executeQuery(query);
      ArrayList<Classes> classesArray = new ArrayList<>();
      while (rs.next()) {
        String classID = rs.getString("classID");
        String classType = rs.getString("classType");
        Classes classes = new Classes(classID, classType);
        classesArray.add(classes);
      }
      return classesArray;
    } catch (Exception e) {
      throw e ;
    }
  }

  public ArrayList<Classes> getAllClasses() throws Exception {
    try {
      String query = "SELECT * FROM classes";
      rs = stat.executeQuery(query);
      ArrayList<Classes> classesArray = new ArrayList<>();
      while (rs.next()) {
        String class_id = rs.getString("class_id");
        String class_type = rs.getString("class_type");
        Classes classes = new Classes(class_id, class_type);
        classesArray.add(classes);
      }
      return classesArray;
    } catch (Exception e) {
      throw e ;
    }
  }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ht.AzizBackend.DBLayer;

import com.ht.AzizBackend.ModelLayer.Subject;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SubjectsRepository {

  private Statement stat;
  private ResultSet rs;

  public SubjectsRepository() {
    try {
      SQLConfig config = SQLConfig.getInstance();
      System.out.println("Database connection established");
      stat = config.con.createStatement();

    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public Subject addSubject(Subject subject) throws Exception {
    try {
      String insert = "INSERT INTO subjects(subject_id, sub_dept_name, subject_name, chr_no, subject_degree) VALUES('" + subject.getSubject_id() + "','" + subject.getSub_dept_name()+ "','" + subject.getSubject_name() + "','" + subject.getChr_no() + "','" + subject.getSubject_degree() + "')";
      stat.executeUpdate(insert);
    } catch (Exception e) {
      throw e;
    }
    return subject;
  }

  public ArrayList<Subject> getSubjectByID(String id) throws Exception {
    try {
      String query = "SELECT * FROM subjects WHERE subject_id='" + id + "'";
      rs = stat.executeQuery(query);
      ArrayList<Subject> subjects = new ArrayList<>();
      while (rs.next()) {
        String subject_id = rs.getString("subject_id");
        String sub_dept_name = rs.getString("sub_dept_name");
        String subject_name = rs.getString("subject_name");
        String chr_no = rs.getString("chr_no");
        String subject_degree = rs.getString("subject_degree");
        Subject subject = new Subject(subject_id, sub_dept_name, subject_name, chr_no, subject_degree);
        subjects.add(subject);
      }
      return subjects;

    } catch (Exception e) {
      throw e ;
    }
  }

  public ArrayList<Subject> getAllSubject() throws Exception {
    try {
      String query = "SELECT * FROM subjects";
      rs = stat.executeQuery(query);
      ArrayList<Subject> subjects = new ArrayList<>();
      while (rs.next()) {
        String subject_id = rs.getString("subject_id");
        String sub_dept_name = rs.getString("sub_dept_name");
        String subject_name = rs.getString("subject_name");
        String chr_no = rs.getString("chr_no");
        String subject_degree = rs.getString("subject_degree");
        Subject subject = new Subject(subject_id, sub_dept_name, subject_name, chr_no, subject_degree);
        subjects.add(subject);
      }
      return subjects;

    } catch (Exception e) {
      throw e ;
    }
  }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ht.AzizBackend.DBLayer;

import com.ht.AzizBackend.ModelLayer.Subject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SubjectsRepository {

  private Statement stat;
  private ResultSet rs;

  public SubjectsRepository(){
      SQLConfig config = null;
      try {
          config = SQLConfig.getInstance();
          stat = config.con.createStatement();
      } catch (Exception ex) {
          Logger.getLogger(SubjectsRepository.class.getName()).log(Level.SEVERE, null, ex);
          Logger.getLogger(SubjectsRepository.class.getName()).log(Level.SEVERE, null, ex);
      }
  }

  public Subject addSubject(Subject subject) throws Exception {
    try {
      String insert = "INSERT INTO subjects(subject_id, sub_depts_name, subject_name, chr_no, subject_degree) VALUES('" + subject.getSubject_id() + "','" + subject.getSub_dept_name()+ "','" + subject.getSubject_name() + "','" + subject.getChr_no() + "','" + subject.getSubject_degree() + "')";
      stat.executeUpdate(insert);
      return subject;
    } catch (Exception e) {
      throw e;
    }
  }

  public ArrayList<Subject> getAllSubject() throws Exception {
    try {
      String query = "SELECT * FROM subjects";
      rs = stat.executeQuery(query);
      ArrayList<Subject> subjects = new ArrayList<>();
      while (rs.next()) {
        String subject_id = rs.getString("subject_id");
        String sub_depts_name = rs.getString("sub_depts_name");
        String subject_name = rs.getString("subject_name");
        String chr_no = rs.getString("chr_no");
        String subject_degree = rs.getString("subject_degree");
        Subject subject = new Subject(subject_id, sub_depts_name, subject_name, chr_no, subject_degree);
        subjects.add(subject);
      }
      return subjects;

    } catch (Exception e) {
      throw e ;
    }
  }

  public ArrayList<Subject> getSubjectByID(String id) throws Exception {
    try {
      String query = "SELECT * FROM subjects WHERE subject_id='" + id + "'";
      rs = stat.executeQuery(query);
      ArrayList<Subject> subjects = new ArrayList<>();
      while (rs.next()) {
        String subject_id = rs.getString("subject_id");
        String sub_depts_name = rs.getString("sub_depts_name");
        String subject_name = rs.getString("subject_name");
        String chr_no = rs.getString("chr_no");
        String subject_degree = rs.getString("subject_degree");
        Subject subject = new Subject(subject_id, sub_depts_name, subject_name, chr_no, subject_degree);
        subjects.add(subject);
      }
      return subjects;

    } catch (Exception e) {
      throw e ;
    }
  }


  public Subject deleteSubject(Subject subject) throws Exception {
    try {
      String delete = "DELETE FROM subjects WHERE subject_id = '" + subject.getSubject_id()+ "'" ;
      stat.executeUpdate(delete);
    } catch (Exception e) {
      throw e ;
    }
    return subject;
  }

}

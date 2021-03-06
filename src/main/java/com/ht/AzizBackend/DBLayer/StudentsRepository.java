/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ht.AzizBackend.DBLayer;

import com.ht.AzizBackend.ModelLayer.Student;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentsRepository {

  private Statement stat;
  private ResultSet rs;

  public StudentsRepository() {
    try {
      SQLConfig config = SQLConfig.getInstance();
      stat = config.con.createStatement();

    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public Student addStudent(Student student) throws Exception {
    try {
      String insert = "INSERT INTO students(student_id, student_firstname, student_lastname, student_gander, section, division, stage, address) VALUES('" + student.getStudent_ID() + "','" + student.getStudent_Firstname() + "','" + student.getStudent_lastname() + "','" + student.getStudent_gander() + "','" + student.getSection() + "','" + student.getDivision()+ "','" + student.getStage() + "','" + student.getAddress() + "')";
      stat.executeUpdate(insert);
    } catch (Exception e) {
      throw e;
    }
    return student;
  }

  public ArrayList<Student> getAllStudent() throws Exception {
    try {
      String query = "SELECT * FROM students";
      rs = stat.executeQuery(query);
      ArrayList<Student> students = new ArrayList<>();
      while (rs.next()) {
        String student_id = rs.getString("student_id");
        String student_firstname = rs.getString("student_firstname");
        String student_lastname = rs.getString("student_lastname");
        String student_gander = rs.getString("student_gander");
        String section = rs.getString("section");
        String division = rs.getString("division");
        String stage = rs.getString("stage");
        String address = rs.getString("address");
        Student student = new Student(student_id, student_firstname, student_lastname, student_gander, section, division, stage, address);
        students.add(student);
      }
      return students;
    } catch (Exception e) {
      throw e ;
    }
  }

  public ArrayList<Student> getStudentByID(String id) throws Exception {
    try {
      String query = "SELECT * FROM students WHERE student_id='" + id + "'";
      rs = stat.executeQuery(query);
      ArrayList<Student> students = new ArrayList<>();
      while (rs.next()) {
        String student_id = rs.getString("student_id");
        String student_firstname = rs.getString("student_firstname");
        String student_lastname = rs.getString("student_lastname");
        String student_gander = rs.getString("student_gander");
        String section = rs.getString("section");
        String division = rs.getString("division");
        String stage = rs.getString("stage");
        String address = rs.getString("address");
        Student student = new Student(student_id, student_firstname, student_lastname, student_gander, section, division, stage, address);
        students.add(student);
      }
      return students;

    } catch (Exception e) {
      throw e ;
    }
  }
  

  public Student deleteStudent(Student student) throws Exception {
    try {
      String delete = "DELETE FROM students WHERE student_id = '" + student.getStudent_ID() + "'" ;
      stat.executeUpdate(delete);
    } catch (Exception e) {
      throw e ;
    }
    return student;
  }

  public Student editStudent(Student oldStudent, Student newStudent) throws Exception {
    try {
      String edit = 
        "UPDATE students SET "
        + "student_id = '" + newStudent.getStudent_ID()
        + "', student_firstname = '" + newStudent.getStudent_Firstname()
        + "', student_lastname = '" + newStudent.getStudent_lastname()
        + "', student_gander = '" + newStudent.getStudent_gander()
        + "', section = '" + newStudent.getSection()
        + "', division = '" + newStudent.getDivision()
        + "', stage = '" + newStudent.getStage()
        + "', address = '" + newStudent.getAddress()
        + "' WHERE student_id = '" + oldStudent.getStudent_ID()+"'";
      stat.executeUpdate(edit);
    } catch (Exception e) {
      throw e ;
    }
    return newStudent;
  }
    
}

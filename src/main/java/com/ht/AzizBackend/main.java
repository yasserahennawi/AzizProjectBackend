/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ht.AzizBackend;

import com.google.gson.Gson;
import com.ht.AzizBackend.DBLayer.ClassesRepository;
import com.ht.AzizBackend.DBLayer.StaffRepository;
import com.ht.AzizBackend.DBLayer.StudentsRepository;
import com.ht.AzizBackend.DBLayer.Sub_deptsRepository;
import com.ht.AzizBackend.DBLayer.SubjectsRepository;
import com.ht.AzizBackend.ModelLayer.Staff;
import java.util.ArrayList;
import spark.Request;
import spark.Response;
import static spark.Spark.*;

public class main {

  static StaffRepository staffRepository = new StaffRepository();
  static ClassesRepository classesRepository = new ClassesRepository();
  static StudentsRepository studentsRepository = new StudentsRepository();
  static Sub_deptsRepository sub_deptsRepository = new Sub_deptsRepository();
  static SubjectsRepository subjectsRepository = new SubjectsRepository();
  static ArrayList<Staff> staff ;
  public static void main(String[] args) {
      
    enableCORS("*", "*", "*");
    
    Gson gson = new Gson();
      
    get( "/" , (Request req , Response res) -> {
        return "wzza tezo 7mra";
    });
    
    get ( "/api/staffs" , (req,res) -> {
        try {
          String json = gson.toJson(staffRepository.getAllStaff());
          res.type("application/json");
          return json;
        } catch ( Exception e ){
          return e;
        }
    });
    
    get ( "/api/classes" , (req,res) -> {
        try {
          String json = gson.toJson(classesRepository.getAllClasses());
          res.type("application/json");
          return json;
        } catch ( Exception e ){
          return e;
        }
    });
    
    get ( "/api/students" , (req,res) -> {
        try {
          String json = gson.toJson(studentsRepository.getAllStudent());
          res.type("application/json");
          return json;
        } catch ( Exception e ){
          return e;
        }
    });
    
    get ( "/api/subjects" , (req,res) -> {
        try {
          String json = gson.toJson(subjectsRepository.getAllSubject());
          res.type("application/json");
          return json;
        } catch ( Exception e ){
          return e;
        }
    });
    
    get ( "/api/sub_depts" , (req,res) -> {
        try {
          String json = gson.toJson(sub_deptsRepository.getAllSub_dept());
          res.type("application/json");
          return json;
        } catch ( Exception e ){
          return e;
        }
    });
  }

  private static void enableCORS(final String origin, final String methods, final String headers) {

    options("/*", (request, response) -> {

      String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
      if (accessControlRequestHeaders != null) {
        response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
      }

      String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
      if (accessControlRequestMethod != null) {
        response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
      }

      return "OK";
    });

    before((request, response) -> {
      response.header("Access-Control-Allow-Origin", origin);
      response.header("Access-Control-Request-Method", methods);
      response.header("Access-Control-Allow-Headers", headers);
      // Note: this may or may not be necessary in your particular application
      response.type("application/json");
    });
  }
}
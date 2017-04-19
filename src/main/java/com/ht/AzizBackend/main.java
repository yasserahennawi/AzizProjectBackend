/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ht.AzizBackend;

import com.ht.AzizBackend.DBLayer.StaffRepository;
import com.ht.AzizBackend.ModelLayer.Staff;
import java.util.ArrayList;
import spark.Request;
import spark.Response;
import static spark.Spark.*;

public class main {

    static StaffRepository staffRepository = new StaffRepository();
    static ArrayList<Staff> staff ;
  public static void main(String[] args) {
      
      StringBuilder stringBuilder = new StringBuilder();
      
    get( "/" , (Request req , Response res) -> {
        return "wzza tezo 7mra";
    });
    get ( "/staff/:staffID" , (req,res) -> {
        try {
          staff = staffRepository.getStaffByID(req.params("staffID"));
            return staff.get(0).getStaffFirstname();
        }  catch  ( Exception e ){
            return e;
        }
    });
  }
  
}

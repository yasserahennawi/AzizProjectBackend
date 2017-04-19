/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ht.AzizBackend;

import java.sql.ResultSet;
import java.sql.Statement;

public class SQLRepository {

  private Statement stat;
  private ResultSet rs;

  public SQLRepository() {
    try {
      SQLConfig config = SQLConfig.getInstance();
      System.out.println("Database connection established");
      stat = config.con.createStatement();

    } catch (Exception e) {
      System.out.println(e);
    }
  }

}

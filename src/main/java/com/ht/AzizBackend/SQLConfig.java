/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ht.AzizBackend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lenovo
 */
public class SQLConfig {

  public Connection con;
  private static SQLConfig instance;

  private SQLConfig() {
    try {

      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/project", "root", "");
      if (con != null) {
        System.out.println("Connected to the database");
      }

    } catch (SQLException | ClassNotFoundException e) {
      System.out.println("Not connected");

    }
  }

  public static SQLConfig getInstance() {
    if (instance == null) {
      instance = new SQLConfig();
    }
    return instance;

  }
}

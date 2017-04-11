package com.cmpe281.dao;

import java.sql.*;
import java.util.*;


public class ConnectionManager {

   static Connection con;
   static String url;
         
   public static Connection getConnection()
   {
     
      try
      {
         String url = "jdbc:odbc:" + "cmpe281_MultiTenant"; 
         // assuming "DataSource" is your DataSource name

         //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         Class.forName("com.mysql.jdbc.Driver"	);
         
         try
         {            	
            con = DriverManager.getConnection(url,"root","dishkim02"); 
        	//  con=DriverManager.getConnection(  
        	//		 "jdbc:mysql://localhost:3306/cmpe281_MultiTenant","root","dishkim02");  
             								
         // assuming your SQL Server's	username is "username"               
         // and password is "password"
              
         }
         
         catch (SQLException ex)
         {
            ex.printStackTrace();
         }
      }

      catch(ClassNotFoundException e)
      {
         System.out.println(e);
      }

   return con;
}
}

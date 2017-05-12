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
         String url = "jdbc:odbc:" + "cmpe281tenant"; 
         // assuming "DataSource" is your DataSource name

         //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         Class.forName("com.mysql.jdbc.Driver"	);
         
         try
         {            	
           // con = DriverManager.getConnection(url,"kimtani90","dishkim02"); 
        	  con=DriverManager.getConnection(  
        			 "jdbc:mysql://multitenantinstancesql.cqfoiwzat0wy.us-west-2.rds.amazonaws.com:3306/cmpe281tenant","kimtani90","dishkim02");  
             								
         
              
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

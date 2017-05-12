package com.cmpe281.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cmpe281.domain.Tenant;


public class TenantDAO {

	static Connection currentCon = null;
	static ResultSet rs = null;  



	public static Tenant save(Tenant tenant) {

		//preparing some objects for connection 
		PreparedStatement prep = null; 
		PreparedStatement prep1 = null;


		String sql = "update UML_Parser_TenantC set GRADE=?, STATUS=?, COMMENTS=? where ID=?";
		String sql1 = "update TENANT_DATA set COLUMN_5=?,COLUMN_6=?,COLUMN_7=? where TENANT_ID=?";


		// "System.out.println" prints in the console; Normally used to trace the process

		System.out.println("Query: "+sql);

		try 
		{
			//connect to DB 
			currentCon = ConnectionManager.getConnection();

			prep = currentCon.prepareStatement(sql);
			prep.setString(1, tenant.getGrade());
			prep.setString(2, tenant.getStatus());
			prep.setString(3, tenant.getComments());
			prep.setString(4, tenant.getId());
			prep.executeUpdate();
			prep.close();

			prep1 = currentCon.prepareStatement(sql1);
			prep1.setString(1, tenant.getGrade());
			prep1.setString(2, tenant.getStatus());
			prep1.setString(3, tenant.getComments());
			prep1.setString(4, "TC");
			prep1.executeUpdate();
			prep1.close();

		}  

		catch (Exception ex) 
		{
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		} 

		//some exception handling
		finally 
		{
			if (rs != null)	{
				try {
					rs.close();
				} catch (Exception e) {}
				rs = null;
			}

			if (prep != null) {
				try {
					prep.close();
				} catch (Exception e) {}
				prep = null;
			}
			
			if (prep1 != null) {
				try {
					prep1.close();
				} catch (Exception e) {}
				prep1 = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}

		return tenant;

	}	
}


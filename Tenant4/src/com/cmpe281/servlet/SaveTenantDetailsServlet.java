package com.cmpe281.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cmpe281.dao.TenantDAO;
import com.cmpe281.domain.Tenant;

public class SaveTenantDetailsServlet  extends HttpServlet {
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
		
		boolean imageDisplay = false;
    	
		 if(request.getParameter("button").equals("save")){
	        	Tenant tenant = saveTenantDetails(request);
	        	TenantDAO.save(tenant);
	        	HttpSession session = request.getSession(true);			
	    		session.setAttribute("imageDisplay", imageDisplay);
	            response.sendRedirect("fileupload.jsp");
	        }
	 }
	 
	 public static Tenant saveTenantDetails(HttpServletRequest request){
	    	
	    	Tenant tenant= new Tenant();
	    	tenant.setFirstName(request.getParameter("fname"));
	    	tenant.setLastName(request.getParameter("lname"));
	    	tenant.setEnrollmentId(request.getParameter("enrolid"));
	    	tenant.setBand(request.getParameter("band"));
	    	tenant.setDone(request.getParameter("done"));
	    	tenant.setId("1001");
	    	tenant.setComments(request.getParameter("comments"));
	    	
	    	return tenant;
	    }
	  
	 
}

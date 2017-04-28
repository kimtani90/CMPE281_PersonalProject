package com.cmpe281.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cmpe281.dao.UserDAO;
import com.cmpe281.domain.UserBean;

public class LoginServlet extends HttpServlet {


public void doGet(HttpServletRequest request, HttpServletResponse response) 
       throws ServletException, java.io.IOException {

	try
	{	    
		String message = "";																																																		
		UserBean user = new UserBean();
		user.setUserName(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		
		if (user.getUsername()!=null && !user.getUsername().equals("")
			&& user.getPassword()!=null && !user.getPassword().equals(""))
		{		
			
			user = UserDAO.login(user);
				  
			if (user.isValid())
			{	
				message = "Login Successfull!";
				   
				//session.setAttribute("currentSessionUser",user); 
				
			}
			
			else 
				message = "Invalid credentials!";
				
		} 
			HttpSession session = request.getSession(true);			
			session.setAttribute("message",message);
			response.sendRedirect  ("login.jsp"); //logged-in page      	
			//response.sendRedirect("success.html"); //logged-in page
	}	
	
	
	catch (Exception e) 	    
	{
		e.printStackTrace();
	}	
}
}


package com.cmpe281.servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cmpe281.dao.UserDAO;
import com.cmpe281.domain.UserBean;

/**
* Servlet implementation class LoginServlet
*/
public class LoginServlet extends HttpServlet {


public void doGet(HttpServletRequest request, HttpServletResponse response) 
       throws ServletException, java.io.IOException {

try
{	    

UserBean user = new UserBean();
user.setUserName(request.getParameter("un"));
user.setPassword(request.getParameter("pw"));

//user = UserDAO.login(user);
  /* 
if (user.isValid())
{

HttpSession session = request.getSession(true);	    
session.setAttribute("currentSessionUser",user); 
response.sendRedirect("login.jsp"); //logged-in page      		
}

else 
response.sendRedirect("invalidLogin.jsp"); //error page */
if(user.getUsername().equals("admin") && user.getPassword().equals("admin"))
{
	response.sendRedirect("fileupload.jsp");
	return;
}
else
{
	response.sendRedirect("error.html");
	return;
}
} 


catch (Throwable theException) 	    
{
System.out.println(theException); 
}
}
}


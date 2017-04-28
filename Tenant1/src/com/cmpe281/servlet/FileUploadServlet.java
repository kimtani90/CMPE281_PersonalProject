package com.cmpe281.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.cmpe281.domain.Tenant;

public class FileUploadServlet extends HttpServlet {
    private static final String UPLOAD_DIRECTORY = "/usr/share/apache-tomcat-7.0.77/webapps/artifacts";
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  	
    	
    	
        //process only if its multipart content
        if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                                         new DiskFileItemFactory()).parseRequest(request);
              
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        String name = new File(item.getName()).getName();                      
                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                        
                        Process process = runJar(name);
                        if(process!=null){
                        process.waitFor();
                        }
                        
                       // UnzipUtility unzipper = new UnzipUtility();                        
                      //  unzipper.unzip(UPLOAD_DIRECTORY + File.separator + name, UPLOAD_DIRECTORY);
                    }
                }
                HttpSession session = request.getSession(true);
    	    	List<Tenant> tenantList = new ArrayList<Tenant>();
    		    	Tenant t= new Tenant();
    		    	t.setFirstName("Dishant");
    		    	t.setLastName("Dishant");
    		    	t.setGrade("A");
    		    	t.setId("11");
    		    	tenantList.add(t);
    		    	session.setAttribute("tenantList", tenantList);
    	    	
    	    	
               //File uploaded successfully
    		    	request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
               request.setAttribute("message", "File Upload Failed due to " + ex);
            }          
         
        }else{
            request.setAttribute("message",
                                 "Sorry this Servlet only handles file upload request");
        }
    
        response.sendRedirect("fileupload.jsp");
      //  response.sendRedirect("success.html");
    	
     
    }
    
    public static Process runJar(String name) {
    	Process process = null;
    	try {
	    	ProcessBuilder pb = new ProcessBuilder("java", "-jar", UPLOAD_DIRECTORY + File.separator+"sequence-10.0.jar", "--headless", UPLOAD_DIRECTORY + File.separator + name);
			process = pb.start(); 
			
			
            
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
    	return process;
    }
  
}


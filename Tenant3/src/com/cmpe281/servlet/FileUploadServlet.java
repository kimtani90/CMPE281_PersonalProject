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

import com.cmpe281.dao.TenantDAO;
import com.cmpe281.domain.Tenant;
import com.cmpe281.utility.UnzipUtility;

public class FileUploadServlet extends HttpServlet {
    private static final String UPLOAD_DIRECTORY = "/usr/share/apache-tomcat-7.0.77/webapps/artifacts";
    private static final String IMAGE_DIRECTORY ="/usr/share/apache-tomcat-7.0.77/webapps/Tenant3/images/";
	// private static final String UPLOAD_DIRECTORY = "E:/cmpe202-UMLParser-master";
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  	
    	
    	boolean imageDisplay = false;
    	
        //process only if its multipart content
    	
    	//if(!request.getParameter("file").equals("") && request.getParameter("button").equals("Upload")){
	        if(ServletFileUpload.isMultipartContent(request)){
	            try {
	                List<FileItem> multiparts = new ServletFileUpload(
	                                         new DiskFileItemFactory()).parseRequest(request);
	              
	                for(FileItem item : multiparts){
	                    if(!item.isFormField()){
	                        String name = new File(item.getName()).getName();                      
	                        item.write( new File(UPLOAD_DIRECTORY + "/" + name));
	                        
	                        UnzipUtility unzipper = new UnzipUtility();                        
	                        unzipper.unzip(UPLOAD_DIRECTORY + "/" + name, UPLOAD_DIRECTORY);
	                        
	                        Process process = runJar(name);
	                        if(process!=null){
	                        process.waitFor();
	                        }
	                        
	                        imageDisplay = true;
	                    	
	                    }
	                }
	                
	               
	            } catch (Exception ex) {
	               request.setAttribute("message", "File Upload Failed due to " + ex);
	            }          
	        }
	  //  }
        
    	HttpSession session = request.getSession(true);			
		session.setAttribute("imageDisplay", imageDisplay);
        response.sendRedirect("fileupload.jsp");
      
    }
    
    public static Process runJar(String name) {
    	Process process = null;
    	try {
	    	//ProcessBuilder pb = new ProcessBuilder("java", "-jar", UPLOAD_DIRECTORY + File.separator+"sequence-10.0.jar", "--headless", UPLOAD_DIRECTORY + File.separator + name);
    		//ProcessBuilder pb = new ProcessBuilder("sh", "umlparser.sh", UPLOAD_DIRECTORY + "/"+name, name);
    		String folderName = name.substring(0, name.lastIndexOf('.'));
    		
    		ProcessBuilder pb = new ProcessBuilder("java", "-jar", UPLOAD_DIRECTORY + "/"+"umlparser.jar",UPLOAD_DIRECTORY + "/"+folderName, IMAGE_DIRECTORY +"image");
    		process = pb.start();	
			
            
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
    	return process;
    }
    
   
}


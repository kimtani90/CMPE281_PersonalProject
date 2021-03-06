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
    private static final String IMAGE_DIRECTORY ="/usr/share/apache-tomcat-7.0.77/webapps/Tenant2/images/";
	
 //  private static final String UPLOAD_DIRECTORY = "E:";
   // private static final String IMAGE_DIRECTORY ="E:";
	
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  	
    	
    	boolean imageDisplay = false;
    	
        //process only if its multipart content
    	
    	
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
	    
        
    	HttpSession session = request.getSession(true);			
		session.setAttribute("imageDisplay", imageDisplay);
        response.sendRedirect("fileupload.jsp");
      
    }
    
    public static Process runJar(String name) {
    	Process process = null;
    	try {
    		String folderName = name.substring(0, name.lastIndexOf('.'));
	    	//ProcessBuilder pb = new ProcessBuilder("java", "-jar", UPLOAD_DIRECTORY + File.separator+"sequence-10.0.jar", "--headless", UPLOAD_DIRECTORY + File.separator + name);
    //		System.out.println("sh "+ UPLOAD_DIRECTORY + "/"+"umlparser.sh", UPLOAD_DIRECTORY + "/"+folderName+ " image");
    	//	ProcessBuilder pb = new ProcessBuilder("/bin/bash","sh", UPLOAD_DIRECTORY + "/"+"umlparser.sh", UPLOAD_DIRECTORY + "/"+folderName, IMAGE_DIRECTORY+"image");
    		
    		ProcessBuilder pb = new ProcessBuilder("java", "-jar", UPLOAD_DIRECTORY + "/"+"vinayakparser.jar",UPLOAD_DIRECTORY + "/"+folderName, IMAGE_DIRECTORY);
    		process = pb.start();	
			
            
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
    	return process;
    }
    
   
}


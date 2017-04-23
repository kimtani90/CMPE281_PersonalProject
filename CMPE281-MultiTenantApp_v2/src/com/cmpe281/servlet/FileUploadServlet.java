package com.cmpe281.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
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
import com.cmpe281.utility.UnzipUtility;

/**
 * Servlet to handle File upload request from Client
 * @author Dishant Kimtani
 */
public class FileUploadServlet extends HttpServlet {
    private static final String UPLOAD_DIRECTORY = "E:/cmpe202-master/umlmodels/sequence";
  
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
                        //String filePath =
                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                        runJar(name);
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
        //response.sendRedirect("success.html");
    	
     
    }
    
    public static void runJar(String name) {
    	try {
	    	ProcessBuilder pb = new ProcessBuilder("java", "-jar", "E:/cmpe202-master/umlmodels/sequence/sequence-10.0.jar", "--headless", UPLOAD_DIRECTORY + File.separator + name);
			pb.start();        
            
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
        
    }
  
}


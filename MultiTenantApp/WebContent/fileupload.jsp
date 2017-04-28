<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

      <link rel="stylesheet" href="./css/style.css">
      <style>
      
</style>
</head>
<body>

<form action="FileUploadServlet" method="post" enctype="multipart/form-data">
<div class="file-upload-form">

<c:out value="${message}"></c:out>
	<br>
Select a file to upload: <br />
                <input type="file" name="file" />
                <input type="submit" value="upload" />
                
     </div>
             
    <div class="tab">
    
    <table border="1" width="500" id="tbl">
    <tr>
        <td width="119"><b>ID</b></td>
        <td width="234"><b>First Name</b></td>
        <td width="234"><b>Last Name</b></td>
        <td width="234"><b>Grade</b></td>
    </tr>
    
     
 
    <c:forEach items="${tenantList}" var="tenant">
        <tr>
            <td><c:out value="${tenant.id}"></c:out></td>
            <td><c:out value="${tenant.firstName}"></c:out></td>
            <td><c:out value="${tenant.lastName}"></c:out></td>
            <td><c:out value="${tenant.grade}"></c:out></td>
        <!--     <td><input type="checkbox" name="text" value="${element.id}" />
            <td><input type="submit" name="s" value="go" /></td>      
 --> 
        </tr>
        </c:forEach>
        
</table>
</div>
            </form> 


</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Multi Tenant App</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- Plugin CSS -->
    <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/sb-admin.css" rel="stylesheet">
  
</head>

<body>
	
<form action="FileUploadServlet" method="post" enctype="multipart/form-data">
    <!-- Navigation -->
    <nav id="mainNav" class="navbar static-top navbar-toggleable-md navbar-inverse bg-inverse">
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarExample" aria-controls="navbarExample" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarExample">
            <ul class="sidebar-nav navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="http://multitenantalb-346108846.us-west-2.elb.amazonaws.com:8080/Tenant1/fileupload.jsp"><i class="fa fa-fw fa-dashboard"></i> Tenant A</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="http://multitenantalb-346108846.us-west-2.elb.amazonaws.com:8080/Tenant2/fileupload.jsp"><i class="fa fa-fw fa-area-chart"></i> Tenant B</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="http://multitenantalb-346108846.us-west-2.elb.amazonaws.com:8080/Tenant3/fileupload.jsp"><i class="fa fa-fw fa-table"></i> Tenant C</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="http://multitenantalb-346108846.us-west-2.elb.amazonaws.com:8080/Tenant4/fileupload.jsp"><i class="fa fa-fw fa-edit"></i> Tenant D</a>
                </li>                
            </ul>
            <ul class="navbar-nav ml-auto">
              
                <li class="nav-item">
                    <a class="nav-link" href="http://multitenantalb-346108846.us-west-2.elb.amazonaws.com:8080/MultiTenantApp/login.jsp"><i class="fa fa-fw fa-sign-out"></i> Logout</a>
                </li>
            </ul>
        </div>
    </nav>

    <div class="content-wrapper py-3">

        <div class="container-fluid">

            <!-- Breadcrumbs -->
            <ol class="breadcrumb">
                <li class="breadcrumb-item">Select a file to upload:</li>
                
            </ol>

            <div style="height:400px;">
            <div style="width: 48%; float:left">
			   <input type="file" required name="file" style="background-color:#292b2c; margin-top:50px;" class="btn btn-primary"/>
                <br><br>
                <input type="submit" name = "button" value="Upload" style="background-color:#292b2c;" class="btn btn-primary"/>
                <br><br>
			</div>
			
			
			
			<c:if test="${imageDisplay eq true}">
			
			   <img src="/Tenant2/images/output.png" style="width:550px;height:400px;" >
			</c:if>
		<!--  	<div style="width: 40%; float:right">
			
			   <img src="/artifacts/image.png" style="width:400px;height:200px;">
			</div>-->
			
			</div>
		</form>
		<form action="SaveTenantDetailsServlet" method="get">	
                
            <!-- Area Chart Example -->
            <div class="card mb-3">
                <div class="card-header">
                    <i class="fa fa-area-chart"></i> Grading Details
                </div>
                <div class="card-block">
                <div class="row">
                 
				<div class="form-group col-lg-4" >
					<label>First Name</label>
					<input type="text" name="fname" class="form-control" value="Vinayak" readonly>
			
				</div>
				<div class="form-group col-lg-4">
					<label>Last Name</label>
					<input type="text" name="lname" class="form-control" id="" value="Nigam" readonly>
				
				</div>
				<div class="form-group col-lg-4">
					<label>Enrollment Id</label>
					<input type="text" name="enrolid" class="form-control" id="" value="1111" readonly>
				</div>
								
		<!--  		<div class="form-group col-lg-6">
					<label>Email Address</label>
					<input type="" name="" class="form-control" id="" value="" >
				</div>
				
				<div class="form-group col-lg-6">
					<label>Repeat Email Address</label>
					<input type="" name="" class="form-control" id="" value="">
				</div>			
				-->
				

				<div class="col-sm-4">
				
				<label class="inline-block">Scale:
					<select name="scale" class="form-control" required>
					  <option value="">-Select-</option>
					  <option value="1">1</option>
					  <option value="2">2</option>
					  <option value="3">3</option>
					  <option value="4">4</option>
					  <option value="5">5</option>
					</select>	
				</label>&nbsp;&nbsp;&nbsp;
				<label class="inline-block">Points:
					<select name="points" class="form-control" required>
					  <option value="">-Select-</option>
					  <option value="1">1</option>
					  <option value="2">2</option>
					  <option value="3">3</option>
					  <option value="4">4</option>
					  <option value="5">5</option>
					</select>	
				</label>	
					</div>	
							
				<div class="col-sm-4">
					
				<label >Extra Credit:
					<select name="ecredit" class="form-control" required>
					  <option value="">-Select-</option>
					  <option value="1">1</option>
					  <option value="2">2</option>
					  <option value="3">3</option>
					  <option value="4">4</option>
					  <option value="5">5</option>
					</select>	
				</label></div>
				
				<div class="col-sm-4">
					
				</div>				
				<div class="form-group col-sm-12">
					<label for="comment">Comment:</label>
  					<textarea name="comments" class="form-control" rows="3" id="comment" required></textarea>
		
				</div>
				
				<div class="col-sm-4">
        			<button type="submit" name = "button" value="save" style="background-color:#292b2c;" class="btn btn-primary">Save</button>
      			</div>
			
	
                </div>
                </div>
                
            </div>

           
        </div>
        <!-- /.container-fluid -->

    </div>
    <!-- /.content-wrapper -->

    <a class="scroll-to-top rounded" href="#">
        <i class="fa fa-chevron-up"></i>
    </a>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/tether/tether.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="vendor/chart.js/Chart.min.js"></script>
    <script src="vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Custom scripts for this template -->
    <script src="js/sb-admin.min.js"></script>
</form>
</body>

</html>
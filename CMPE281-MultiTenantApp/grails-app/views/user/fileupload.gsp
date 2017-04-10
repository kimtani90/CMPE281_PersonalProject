<html>
<head>
<title>Multi Tenant Application</title>
<meta name="layout" content="main" />
<style type="text/css" media="screen">
#align{
background-color:brown;
color:black;
padding:50px;
width:400px
}

</style>
</head>
<body>


<h1>File Upload:</h1><br>

			 <g:form action="fileupload" method="post" enctype="multipart/form-data">
	                <div class="dialog">
	                    <table>
	                        <tbody>
	                            <tr class="prop">
	                                <td valign="top" class="name">
	                                    <label for="fileUpload">Upload:</label>
	                                </td>
	                                <td valign="top" >
	                                    <input type="file" id="fileUpload" name="fileUpload" />
	                                </td>
	                            </tr>
	                        </tbody>
	                    </table>
	                </div>
	                <div class="buttons">
	                    <span class="button"><g:actionSubmit class="upload" value="Upload" action="upload" /></span>
	                </div>
	            </g:form>



</body>
</html>
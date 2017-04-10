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
<g:if test="${session.user}">
<g:if test="${flash.message}">Welcome back ${flash.message}</g:if>
<g:else>Logged in as <B>${session.user}</B></g:else>
<g:link action="logout">Logout</g:link>
</g:if>
<g:else>
<g:form controller="user" action="login" style="padding-left:500px" >
<div id="align">
<label for="name">Username</label>
<input type="text" name="username"/><br><br>
<label for="password">Password</label>
<input type="password" name="password"/><br><br>
<button name="button" type="submit" >Login</button>

<div>
</g:form>
</g:else>

</body>
</html>
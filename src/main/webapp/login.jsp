<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Group 29 ASE Assignment 2</title>
  </head>
  <body>
 		<h1>Login form</h1>
 		 <h3><s:property value="errorMessage"/></h3>
         <s:form action="login">
	      <s:textfield name="user.username" label="Username" type="text" value=""/>
	      <s:textfield name="user.password" label="Password" type="password" value=""/>
      	 <s:submit value="login"/>
    </s:form>	
  </body>
</html>
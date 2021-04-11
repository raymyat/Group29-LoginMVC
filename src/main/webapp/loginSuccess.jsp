<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login success</title>
  </head>
  <body>
    <h2>Login Successful!</h2>
    <h3>Welcome <s:property value="user.username"/></h3>
  </body>
</html>
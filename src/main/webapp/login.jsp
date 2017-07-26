<%--
  Created by IntelliJ IDEA.
  User: tharindu
  Date: 7/25/17
  Time: 5:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login page</title>
    <link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="content">
    <fieldset>
        <legend>Navigation menu</legend>
        <a href="index.jsp">Home</a>
        <!-- here the action's value will be used to map the corresponding
            methodLogin.controllerller needs to be executed on form submit.
            modelAttribute value should be camelCase name of bean
            added earlier as model in sprLogin.controllerller
            -->
        <sf:form action="doLogin.obj" modelAttribute="userBean">
            <!-- to display error message from action method if any -->
            <sf:errors />
            <br />
            <sf:label path="userId">UserName:</sf:label>
            <sf:input path="userId" />
            <br />
            <!-- to display validation error message if any -->
            <sf:errors path="userId" />
            <br />
            <sf:label path="password">Password:</sf:label>
            <sf:password path="password" />
            <br />
            <sf:errors path="password" />
            <br />
            <input type="submit" value="Login" /><br />"

        </sf:form>
    </fieldset>
</div>
</body>
</html>

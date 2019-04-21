<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">

<head>
    <title>Spring Security Tutorial</title>
    <link rel="stylesheet" type="text/css" th:href="@{/css/login.css}"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
<form action="/registration" method="get">
    <button class="btn btn-md btn-warning btn-block" type="Submit">Go To Registration Page</button>
</form>

<div class="container">
	<h1>dang nhap</h1>
    
    <form action="/login" method="POST" class="form-signin" onsubmit="return validateEmail()">
        <h3 class="form-signin-heading" text="Welcome"></h3>
        <br/>

        <input type="text" id="email" name="email" th:placeholder="Email"
               class="form-control"/> <br/>
        <input type="password" th:placeholder="Password"
               id="password" name="password" class="form-control"/> <br/>

        <div align="center">
        </div>
        <button class="btn btn-lg btn-primary btn-block" name="Submit" value="Login" type="Submit"
                text="Login">Login</button>
    </form>
</div>
</body>
</html>
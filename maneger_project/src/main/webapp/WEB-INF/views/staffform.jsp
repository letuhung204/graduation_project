<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Khoa Form</title>
<!-- Bootstrap CSS -->
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous" />
<!-- Font Awesome -->
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous" />
<!-- Custom style -->
<link href="../static/css/style.css" th:href="@{/css/style.css}"
	rel="stylesheet" />

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<spring:url value="/staff/save" var="saveURL" />
		<h2>Staff Form</h2>
		<form:form modelAttribute="staff" method="post" action="${saveURL }"
			cssClass="form" onsubmit="return checkPhone() && validateEmail()">
			<form:hidden path="id" />
			<div class="form-group">
				<label>ID</label>
				<form:input path="id" cssClass="form-control" id="mastaff" readonly="true"/>
			</div>
			<div class="form-group">
				<label>First Name</label>
				<form:input path="firstname" cssClass="form-control" id="firstname" />
			</div>
			<div class="form-group">
				<label>Full Name</label>
				<form:input path="fullname" cssClass="form-control" id="fullname" />
			</div>
			<div class="form-group">
				<label>Email</label>
				<form:input path="email" cssClass="form-control" id="email" />
			</div>
			<div class="form-group">
				<label>Position</label>
				<form:input path="position" cssClass="form-control" id="position" />
			</div>
			<div class="form-group">
				<label>Sex</label>
				<form:input path="sex" cssClass="form-control" id="sex" />
			</div>
			<div class="form-group">
				<label>Skill</label>
				<form:input path="skill" cssClass="form-control" id="skill" />
			</div>
			<div class="form-group">
				<label>address</label>
				<form:input path="address" cssClass="form-control" id="address" />
			</div>
			<div class="form-group">
				<label>Telephone</label>
				<form:input path="telephone" cssClass="form-control" id="telephone" />
			</div>
			<div class="text-center">
				<button type="submit" class="btn btn-primary">Save</button>
				<button type="button" class="btn btn-primary"
					onclick="return window.location='/staff';">Cancel</button>
			</div>
		</form:form>

	</div>
</body>
</html>
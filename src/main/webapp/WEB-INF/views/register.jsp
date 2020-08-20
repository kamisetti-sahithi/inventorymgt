<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>Employee Registeration</title>
</head>
<body>

<h1>Employee Registeration submits get request</h1>

<form method="get" action="/processregister">

<div>

<label>Name</label>
<input type="text"  name="ename">

</div>

<div>

<label>Salary</label>
<input type="number"  name="salary">

</div>


<div>

<label>Age</label>
<input type="number"  name="age">

</div>

<div>
<label>Password</label>
<input type="password"  name="password">

</div>

<input type="submit" value="Create Employee">

</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>Employee Details</title>
</head>
<body>

<h1>Employee Details </h1>

id is <c:out value="${employee.id}"  />
<br>
name is <c:out value="${employee.name}"  />
<br>
salary is <c:out value="${employee.salary}"  />
<br>
age is <c:out value="${employee.age}"  />


<a href="/logout"> Log out </a>

</body>
</html>
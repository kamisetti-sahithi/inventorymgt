<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>computer Details</title>
</head>
<body>

<h1>computer Details </h1>

id is <c:out value="${computer.id}"  />
<br>
name is <c:out value="${computer.name}"  />
<br>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Listing all Computers</title>
</head>
<body>

	<h1>Listing all the Computers</h1>


	<c:forEach items="${computers}" var="computer">

		<c:out value="${computer.name}" />

		<c:out value="${computer.id}" />

		<c:out value="${computer.diskSize}" />
		<br>

	</c:forEach>

</body>
</html>
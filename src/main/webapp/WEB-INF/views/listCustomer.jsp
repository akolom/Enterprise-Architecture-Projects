<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>All Customers</title>
</head>
<body>
	<h1>List of Customers</h1>
<table width=97%  border="1"  style="margin:20px">
			<tr>
			<td>First Name</td>
			<td>Last Name</td>
			<td>Date of Birth</td>
			<td>Place of Birth</td>
			<td>Street</td>
			<td>City</td>
			<td>State</td>
			<td>Zip</td>
			<td>Action</td>
			
			
			</tr>
			<c:forEach items="${customers}" var="customer">
				<tr>
					
					<td>${customer.firstName}</td>
					<td>${customer.lastName}</td>
					<td>${customer.dateOfBirth}</td>
					<td>${customer.placeOfBirth}</td>
					<td>${customer.address.street}</td>
					<td>${customer.address.city}</td>
					<td>${customer.address.state}</td>
					<td>${customer.address.zip}</td>
					<td><a href="edit/${customer.id}">Edit</a> | 
					<a href="remove/${customer.id}">Delete</a>
					
					</td>
					
		
				</tr>
			</c:forEach>
			</table>
			<form action="add" method="get">
			<input name="submit"
					type="submit" value="Add Customer">
			</form>

</body>
</html>
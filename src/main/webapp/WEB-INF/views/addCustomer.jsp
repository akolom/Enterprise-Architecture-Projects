<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Create Customer</title>
</head>
<body>
	<form:form modelAttribute="newCustomer" action="save">
		<form:errors path="*" cssStyle="Color:RED"></form:errors>
		<fieldset>

			<p>
				<label for="firstName"><spring:message
						code="customer.firstName" /> </label>
				<form:input path="firstName" id="firstName" />

			</p>

			<p>
				<label for="lasttName"><spring:message
						code="customer.lastName" /> </label>
				<form:input path="lastName" id="lastName" />

			</p>


			<p>
				<label for="dateOfBirth"><spring:message
						code="customer.dateOfBirth" /> </label>
				<form:input path="dateOfBirth" id="dateOfBirth" />

			</p>

			<p>
				<label for="placeOfBirth"><spring:message
						code="customer.placeOfBirth" /> </label>
				<form:input path="placeOfBirth" id="placeOfBirth" />

			</p>

			<p>
				<label for="street"><spring:message code="address.street" />
				</label>
				<form:input path="address.street" id="street" />

			</p>
			<p>
				<label for="city"><spring:message code="address.city" /> </label>
				<form:input path="address.city" id="city" />

			</p>

			<p>
				<label for="state"><spring:message code="address.state" />
				</label>
				<form:input path="address.state" id="state" />

			</p>
			<p>
				<label for="zip"><spring:message code="address.zip" /> </label>
				<form:input path="address.zip" id="zip" />

			</p>

			<p id="buttons">
				<input name="reset" type="reset"> <input name="submit"
					type="submit" value="Add Customer">
			</p>

		</fieldset>

	</form:form>

	<form:form action="/customerCrud/list" method="GET">
		<input name="submit" type="submit" value="Back">
	</form:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Expense</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="bg-light">
	<div class="container col-6 d-flex justify-content-between gap-3 align-content-center py-5 px-2 margin-2">
		<h1 class="text-primary">Edit Expense</h1>
		<div class="pt-1">
			<a class="btn btn-primary" href="/expenses">Home</a>
		</div>
	</div>
	<div class="container card bg-dark text-light col-6 d-flex flex-column justify-content-center gap-3 align-content-center p-5 margin-2">
		<form:form action="/expenses/${expense.id}" method="POST" modelAttribute="expense">
			<input type="hidden" name="_method" value="PUT" />
			<div class="p-2 d-flex flex-column justify-content-start gap-1">
				<div class="d-flex flex-column gap-2 ps-2">
					<form:label path="name">Expense Name</form:label>
					<form:errors class="text-danger fw-bold fst-italic" path="name"/>
					<form:input class="form-control" type="text" path="name" />
				</div>
				<div class="d-flex flex-column gap-2 ps-2">
					<form:label path="vendor">Vendor</form:label>
					<form:errors class="text-danger fw-bold fst-italic" path="vendor"/>
					<form:input class="form-control" type="text" path="vendor" />
				</div>
				<div class="d-flex flex-column gap-2 ps-2">
					<form:label path="amount">Amount</form:label>
					<form:errors class="text-danger fw-bold fst-italic" path="amount"/>
					<form:input class="form-control" type="number" path="amount" />
				</div>
				<div class="d-flex flex-column gap-2 ps-2">
						<form:label path="description">Description</form:label>
						<form:errors class="text-danger fw-bold fst-italic" path="description"/>
						<form:textarea class="form-control" path="description" cols="10" rows="3"></form:textarea>
					</div>
			</div>
			<div class="text-end pe-2">
				<button class="btn btn-success" type="submit">Edit Expense</button>						
			</div>
		</form:form>
	</div>
</body>
</html>
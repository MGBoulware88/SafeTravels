<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Expense</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="bg-light">
	<div class="container col-6 d-flex justify-content-between gap-3 align-content-center py-5 px-2 margin-2">
		<h1 class="text-primary">Expense Details</h1>
		<div class="pt-1">
			<a class="btn btn-primary" href="/expenses">Home</a>
		</div>
	</div>
	<div class="container bg-dark text-light col-6 d-flex justify-content-center gap-3 align-content-center p-5 margin-2">
		<div class="container d-flex flex-column justify-content-between align-items-start gap-2">
			<p>Expense Name:</p>
			<p>Expense Description:</p>
			<p>Vendor</p>
			<p>Amount Spent:</p>
		</div>
		<div class="container d-flex flex-column justify-content-between align-items-start gap-2">
			<p><c:out value="${expense.name}"/></p>
			<p><c:out value="${expense.description}"/></p>
			<p><c:out value="${expense.vendor}"/></p>
			<p>$<c:out value="${df.format(expense.amount)}"/></p>
		</div>
	</div>
</body>
</html>
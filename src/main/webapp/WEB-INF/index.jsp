<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Safe Travels</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="bg-light">
	<div class="container d-flex flex-column justify-content-center gap-3 align-content-center p-5 margin-2">
		<h1 class="text-primary">Safe Travels</h1>
 		<table class="table table-bordered table-striped table-dark">
 			<thead>
				<tr>
 					<th>Expense</th>
					<th>Vendor</th>
					<th>Amount</th>
 					<th colspan="2" >Actions</th>
 				</tr>
 			</thead>
			<tbody>
 				<c:forEach var="expense" items="${allExpenses}">
				<tr>
 					<td class=""><a href="/expenses/${expense.id}"><c:out value="${expense.name}"/></a></td>
 					<td class=""><c:out value="${expense.vendor}"/></td>
					<td class="">$<c:out value="${df.format(expense.amount)}" /></td>
 					<td><a class="btn btn-success" href="/expenses/edit/${expense.id}">Edit</a></td>
 					<td>
						<form method="POST" action="/expenses/delete/${expense.id}">
 							<input type="hidden" name="_method" value="DELETE" />
 							<button class="btn btn-danger" type="submit">Delete</button>
 						</form>
 					</td>
 				</tr>
 				</c:forEach>
 			</tbody>
 		</table>
		<br />
		<!-- I'd rather put this on a differnet page, but the wireframe had it on index -->
		<div class="container card bg-dark text-light col-6 d-flex flex-column justify-content-center gap-3 align-content-center p-5 margin-2">
			<h1 class="text-primary text-center">New Expense</h1>
		
			<form:form action="/expenses/create" method="POST" modelAttribute="expense">
				<div class="p-2 d-flex flex-column bg-dark text-light justify-content-start gap-1">
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
						<form:input class="form-control" type="number" step="any" path="amount" />
					</div>
					<div class="d-flex flex-column gap-2 ps-2">
						<form:label path="description">Description</form:label>
						<form:errors class="text-danger fw-bold fst-italic" path="description"/>
						<form:textarea class="form-control" path="description" cols="10" rows="3"></form:textarea>
					</div>
				</div>
				<div class="text-end pe-2">
					<button class="btn btn-primary" type="submit">Submit</button>						
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>
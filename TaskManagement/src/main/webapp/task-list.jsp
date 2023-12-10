<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Task Management</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: green">
			<div>
				<a href="<%=request.getContextPath()%>" class="navbar-brand">
					App Home </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/IssueList"
					class="nav-link">issues</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="row">
		<div class="container">
			<h3 class="text-center">List of issues</h3>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/IssueForm"
					class="btn btn-success">Add New Issue</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Description</th>
						<th>Assigned Person</th>
						<th>Issue Date</th>
						<th>Status</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="issue" items="${TaskList}">

						<tr>
							<td><c:out value="${issue.taskId}" /></td>
							<td><c:out value="${issue.taskDescription}" /></td>
							<td><c:out value="${issue.assignedPerson}" /></td>
							<td><c:out value="${issue.issueDate}" /></td>
							<td><c:out value="${issue.taskStatus}" /></td>
							<td><a
								href="IssueEditForm?taskId=<c:out value='${issue.taskId}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="IssueDelete?taskId=<c:out value='${issue.taskId}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>

</body>
</html>
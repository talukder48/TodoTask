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

	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">

				<form action="CreateIssue" method="post">

					<h2>Add New Task</h2>

					<fieldset class="form-group">
						<label>Description </label> <input type="text"
							class="form-control" name="taskDescription" required="required">
					</fieldset>

					<fieldset class="form-group">
						<label>Assigned To</label> <input type="text" class="form-control"
							name="assignedPerson" required="required">
					</fieldset>

					<fieldset class="form-group">
						<label>Issue Date</label> <input type="date" class="form-control"
							name="issueDate" required="required">
					</fieldset>



					<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>
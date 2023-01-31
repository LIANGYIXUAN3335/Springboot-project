<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
	<link href = "webjars/bootstrap/5.1.3/css/bootstrap.min.css
	" rel = "stylesheet">
		<title>List Todos Page</title>
	</head>
	<body>
	<div class  = "container">
		Welcome to the todo page ${name} })!
		<hr>
		<h1> your todos are</h1>
		<table class = "table">
			<thead>
				<tr>
					<th>id</th>
					<th>description</th>
					<th>target date</th>
					<th>done?</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach item = "${todos}" var = "todo">
					<tr>
						<td>${todo.id}</td>
						<td>${todo.description}</td>
						<td>${todo.targetDate}</td>
						<td>${todo.done}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href = "add-todo" class = "btn btn-success">Add todo</a>
		</div>
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"
></script>
		<script src="webjars/jquery/3.6.0/jquery.min.js"></script>

	</body>
	</body>
</html>
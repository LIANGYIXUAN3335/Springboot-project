<%@ include file = "common/header.jsp" %>
<%@ include file = "common/navigation.jsp" %>
	<div class  = "container">
		Welcome to the todo page ${name} !
		<hr>
		<h1> Your todos are</h1>
		<table class = "table">
			<thead>
				<tr>
					<th>description</th>
					<th>target date</th>
					<th>done?</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.description}</td>
						<td>${todo.targetDate}</td>
						<td>${todo.done}</td>
						<td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">DELETE</a>
						<td><a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href = "add-todo" class = "btn btn-success">Add todo</a>
		</div>
	<%@ include file = "common/footer.jsp" %>
	</body>
</html>
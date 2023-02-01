<%@ include file = "common/header.jsp" %>
<%@ include file = "common/navigation.jsp" %>
		Welcome to the login page!
		<div>${errormessage}</div>
			<form method = "post">
			name: <input type = "text" name = "name">
			password: <input type = "password" name = "password">
			<input type = "submit">
			</form>
<%@ include file = "common/footer.jsp" %>
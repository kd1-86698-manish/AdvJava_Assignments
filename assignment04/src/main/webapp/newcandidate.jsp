<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Candidate</title>
</head>
<body>
	<h2>Add new candidate</h2>
	<p>${param.message }</p>
	<hr />

	<form method="post" action="addcandidate.jsp">
		<h2>Add Candidate</h2>
		Name : <input type="text" name="name" /> <br> <br /> Party: <input
			type="text" name="party" /> <br> <br /> <input type="submit"
			value="Add Candidate">
	</form>

</body>
</html>
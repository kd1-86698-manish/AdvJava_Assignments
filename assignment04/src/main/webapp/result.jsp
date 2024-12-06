
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
</head>
<body>
	<h2>Voting Result</h2>
	<p>${param.message }</p>
	<hr />



	<jsp:useBean id="rb" class="com.beans.ResultBean"></jsp:useBean>
	${rb.fetchCandidate()}

	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Party</th>
				<th>Votes</th>
				<th>Actions</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="c" items="${rb.candList }">
				<tr>
					<td>${c.id }</td>
					<td>${c.name }</td>
					<td>${c.party }</td>
					<td>${c.votes }</td>
					<td><a href="editcand.jsp?id=${c.id }">Edit</a> <a
						href="deletecandidate.jsp?id=${c.id }">Delete</a></td>
				</tr>
			</c:forEach>

		</tbody>


	</table>

	<p>${param.msg }</p>

	<a href="newcandidate.jsp">Add new Candidate</a>
	<a href="logout.jsp">Sign Out</a>

</body>
</html>
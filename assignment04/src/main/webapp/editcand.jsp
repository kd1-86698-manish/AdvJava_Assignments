<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Candidate</title>
</head>
<body>

	<h2>Edit Candidate</h2>
	<p>${param.message }</p>
	<hr />

	<jsp:useBean id="fcb" class="com.beans.FindCandidateBean" />
	<jsp:setProperty name="fcb" property="candId" param="id" />
	${fcb.findCandidate()}
	<form method="post" action="updatecand.jsp">

		<input type="hidden" name="id" value="${fcb.cand.id }" /> <br /> <br />
		Name : <input type="text" name="name" value="${fcb.cand.name}" /><br />
		<br /> Party : <input type="text" name="party"
			value="${fcb.cand.party}" /> <br /> <br />Votes : <input
			type="text" name="votes" value="${fcb.cand.votes}"
			readonly="readonly" /> <br /> <br /> <input type="submit"
			value="Update">
	</form>

</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body>

	<h2>Update candidate</h2>
	<p>${param.message }</p>
	<hr />

	<jsp:useBean id="ucb" class="com.beans.UpdateCandidateBean"></jsp:useBean>
	<jsp:setProperty name="ucb" property="*" />
	${ucb.updateCandidate()}
	<c:choose>

		<c:when test="${ucb.count==1}">
			<jsp:forward page="result.jsp">
				<jsp:param name="msg" value="Candidate Updated Successfully" />
			</jsp:forward>
		</c:when>
		<c:otherwise>
			<jsp:forward page="result.jsp">
				<jsp:param name="msg" value="Candidate Failed to Updated " />
			</jsp:forward>

		</c:otherwise>

	</c:choose>


</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body>



	<jsp:useBean id="dcb" class="com.beans.DeleteCandidateBean" />
	<jsp:setProperty name="dcb" property="*" />
	${dcb.deleteCandidate()}
	<c:choose>

		<c:when test="${dcb.count==1}">
			<jsp:forward page="result.jsp">
				<jsp:param name="msg" value="Candidate Delted Successfully" />
			</jsp:forward>
		</c:when>
		<c:otherwise>
			<jsp:forward page="result.jsp">
				<jsp:param name="msg" value="Candidate Failed to delete" />
			</jsp:forward>

		</c:otherwise>

	</c:choose>


</body>
</html>
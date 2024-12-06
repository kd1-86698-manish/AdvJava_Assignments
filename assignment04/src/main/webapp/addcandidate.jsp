<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Candidate</title>
</head>
<body>

	<h2>Add New Candidate</h2>
	<jsp:useBean id="acb" class="com.beans.AddCandidateBean" />

	<jsp:setProperty name="acb" property="*" />
	${acb.addCandidate()}
	<c:choose>
		<c:when test="${acb.count==1}">
			<c:redirect url="result.jsp"></c:redirect>
		</c:when>
		<c:otherwise>
			<h1>Candidate Failed to add</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>
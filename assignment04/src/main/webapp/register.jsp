<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

</head>
<body>
	<h2>Register</h2>

	<jsp:useBean id="rb" class="com.beans.RegisterBean" />

	<jsp:setProperty name="rb" property="*" />
	${rb.register()}
	<c:choose>
		<c:when test="${rb.count==1}">

			<c:redirect url="index.jsp"></c:redirect>
		</c:when>
		<c:otherwise>
			<h1>Registration Failed</h1>
		</c:otherwise>
	</c:choose>



</body>
</html>
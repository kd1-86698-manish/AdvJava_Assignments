<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LoginJsp</title>
</head>
<body>


	<jsp:useBean id="lb" class="com.beans.LoginBean" scope="session" />
	<jsp:setProperty property="*" name="lb" />
	${lb.loginUser()}
	<c:choose>
		<c:when test="${lb.user!=null}">


			<c:choose>

				<c:when test="${lb.user.role =='admin'}">


					<jsp:forward page="result.jsp">
						<jsp:param value="Hello ${lb.user.first_name}(Admin)"
							name="message" />
					</jsp:forward>


				</c:when>

				<c:otherwise>

					<jsp:forward page="candidatelist.jsp">
						<jsp:param value="Hello ${lb.user.first_name}(Voter)"
							name="message" />
					</jsp:forward>
				</c:otherwise>

			</c:choose>


		</c:when>
		<c:otherwise>

			<h2>Login Failed</h2>
			<p>Invalid email or password</p>
			<p>
				<a href="index.jsp"> Login again</a>
			</p>


		</c:otherwise>
	</c:choose>

</body>
</html>
package com.manish;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String qualification = req.getParameter("qualification");
		String university = req.getParameter("university");
		String birth = req.getParameter("birth");

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Student Info</title>");
		out.println("<style type='text/css'>");

		out.println("* {");
		out.println("    margin: 0;");
		out.println("    padding: 0;");
		out.println("    box-sizing: border-box;");
		out.println("}");

		out.println("body {");
		out.println("    font-family: Arial, sans-serif;");
		out.println("    background-color: #f9f9f9;");
		out.println("    display: flex;");
		out.println("    justify-content: center;");
		out.println("    align-items: center;");
		out.println("    height: 100vh;");
		out.println("    margin: 0;");
		out.println("    padding: 20px;");
		out.println("}");

		out.println(".container {");
		out.println("    background-color: pink;");
		out.println("    padding: 40px;");
		out.println("    border-radius: 8px;");
		out.println("    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);");
		out.println("    width: 100%;");
		out.println("    max-width: 600px;");
		out.println("}");

		out.println("h1 {");
		out.println("    text-align: center;");
		out.println("    margin-bottom: 20px;");
		out.println("    color: #333;");
		out.println("}");

		out.println("h3 {");
		out.println("    font-size: 18px;");
		out.println("    color: #555;");
		out.println("    margin-bottom: 10px;");
		out.println("}");

		out.println("p {");
		out.println("    font-size: 16px;");
		out.println("    margin-bottom: 20px;");
		out.println("}");

		out.println("</style>");
		out.println("</head>");

		out.println("<body>");

		out.println("<div class='container'>");
		out.println("<h1>Student Information</h1>");

		out.println("<h3>First Name : " + firstName + "</h3>");
		out.println("<h3>Last Name : " + lastName + "</h3>");
		out.println("<h3>Qualification : " + qualification + "</h3>");
		out.println("<h3>University  : " + university + "</h3>");
		out.println("<h3>Date of Birth : " + birth + "</h3>");

		out.println("</div>");

		out.println("</body>");
		out.println("</html>");

	}

}

package com.manish;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {

	List<Marks> list = new ArrayList<Marks>();

	@Override
	public void init() throws ServletException {

		list.add(new Marks("Java Programming ", 80.0));
		list.add(new Marks("Web Programming ", 80.0));
		list.add(new Marks("Database Programming ", 80.0));

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Marks Information</title>");
		out.println("<style type='text/css'>");
		/* Reset for margin, padding, and box-sizing for all elements */
		out.println("* {");
		out.println("    margin: 0;");
		out.println("    padding: 0;");
		out.println("    box-sizing: border-box;");
		out.println("}");

		/* Body Styling */
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

		/* Main Container Styling */
		out.println(".container {");
		out.println("    background-color: white;");
		out.println("    padding: 40px;");
		out.println("    border-radius: 8px;");
		out.println("    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);");
		out.println("    width: 100%;");
		out.println("    max-width: 600px;");
		out.println("}");

		/* Heading Styling */
		out.println("h1 {");
		out.println("    text-align: center;");
		out.println("    margin-bottom: 20px;");
		out.println("    color: #333;");
		out.println("}");

		/* Table Styling */
		out.println("table {");
		out.println("    width: 100%;");
		out.println("    border-collapse: collapse;");
		out.println("    margin-top: 20px;");
		out.println("}");

		out.println("th, td {");
		out.println("    padding: 12px 15px;");
		out.println("    text-align: left;");
		out.println("    border: 1px solid #ddd;");
		out.println("    font-size: 16px;");
		out.println("}");

		out.println("th {");
		out.println("    background-color: #007BFF;");
		out.println("    color: white;");
		out.println("}");

		out.println("tr:nth-child(even) {");
		out.println("    background-color: #f2f2f2;");
		out.println("}");

		out.println("</style>");
		out.println("</head>");

		out.println("<body>");

		out.println("<div class='container'>");
		out.println("<h1>Marks Information</h1>");
		out.println("<table>");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>Subject</th>");
		out.println("<th>Marks</th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");

		// Loop through the list of marks and display each row
		for (Marks m : list) {
		    out.println("<tr>");
		    out.println("<td>" + m.getSubject() + "</td>");
		    out.println("<td>" + m.getMarks() + "</td>");
		    out.println("</tr>");
		}

		out.println("</tbody>");
		out.println("</table>");
		out.println("</div>");

		out.println("</body>");
		out.println("</html>");
			
			
		}
	}


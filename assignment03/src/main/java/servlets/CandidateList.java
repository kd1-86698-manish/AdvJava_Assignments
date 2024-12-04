package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daos.CandidateDao;
import com.daos.CandidateDaoImpl;
import com.entities.Candidate;

@WebServlet("/candlist")
public class CandidateList extends HttpServlet {

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

		List<Candidate> list = new ArrayList<>();

		try (CandidateDao canDao = new CandidateDaoImpl()) {

			list = canDao.findAll();

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Candidate List</title>");
		out.println("<style>");
		out.println("p { color: #555; font-size: 18px; text-align: center; margin-bottom: 20px; }");
		out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f9; margin: 0; padding: 20px; }");
		out.println("h2 { color: #333; text-align: center; }");
		out.println("hr { margin: 20px 0; }");
		out.println(
				"form { background-color: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); max-width: 500px; margin: 0 auto; }");
		out.println(".candidate-item { margin-bottom: 15px; }");
		out.println("input[type='radio'] { margin-right: 10px; }");
		out.println(
				"input[type='submit'] { width: 100%; padding: 12px; background-color: #4CAF50; color: white; border: none; border-radius: 5px; cursor: pointer; }");
		out.println("input[type='submit']:hover { background-color: #45a049; }");
		out.println(".user-info { text-align: center; font-size: 16px; margin-bottom: 20px; }");
		out.println(".signup-link { text-align: center; margin-top: 20px; }");
		out.println(".signup-link a { text-decoration: none; color: #007bff; font-size: 14px; }");
		out.println(".signup-link a:hover { text-decoration: underline; }");
		out.println("</style>");
		out.println("</head>");

		ServletContext color = this.getServletContext();
		String bgColor = color.getInitParameter("bg.color");

		out.printf("<body style=background-color:%s >", bgColor);

		ServletContext app = this.getServletContext();
		String appTitle = app.getInitParameter("app.title");

		Cookie[] arr = req.getCookies();
		String userName = "", role = "";
		if (arr != null) {
			for (Cookie c : arr) {
				if (c.getName().equals("uname"))
					userName = c.getValue();
				if (c.getName().equals("role"))
					role = c.getValue();
			}
		}

		// User Greeting
		out.println("<div class='user-info'>");
		out.printf("<h2>%s</h2>", appTitle);
		out.println("<h1>Hello, " + userName + " [" + role + "]</h1>");
		out.println("</div>");

		out.println("<hr/>");

		ServletContext ctx = this.getServletContext();
		String ann = (String) ctx.getAttribute("annoucement");

		if (ann != null) {
			out.println("<p style='color:red' text-align:centre> Note : " + ann + "</p>");
		}

		// Candidate List Form
		out.println("<h2>Candidate List</h2>");
		out.println("<form method='post' action='vote'>");

		for (Candidate c : list) {
			out.printf(
					"<div class='candidate-item'><input type='radio' name='candidate' value='%d' id='candidate-%d'/>",
					c.getId(), c.getId());
			out.printf("<label for='candidate-%d'>%s</label></div>\n", c.getId(), c.getName());
		}

		out.println("<br/><input type='submit' value='Vote'/>");
		out.println("</form>");

		// Signup Link (if applicable)
		out.println("<div class='signup-link'>");
		out.println("<p>Don't have an account? <a href='signup.html'>Sign Up</a></p>");
		out.println("</div>");

		out.println("</body>");
		out.println("</html>");

	}
}

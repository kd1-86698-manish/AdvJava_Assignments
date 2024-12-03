package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daos.CandidateDao;
import com.daos.CandidateDaoImpl;
import com.entities.Candidate;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {

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
		out.println("<title>Voting Result</title>");
		out.println("<style>");
		out.println(
				"body { font-family: Arial, sans-serif; background-color: #f4f4f9; margin: 0; padding: 20px; display: flex; justify-content: center; align-items: center; height: 100vh; }");
		out.println(
				".container { background-color: white; padding: 30px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); width: 100%; max-width: 900px; height: 100vh; }");
		out.println("h2 { text-align: center; color: #333; font-size: 24px; margin-bottom: 20px; }");
		out.println("p { color: #555; font-size: 18px; text-align: center; margin-bottom: 20px; }");
		out.println("table { width: 100%; border-collapse: collapse; margin-top: 20px; }");
		out.println("th, td { padding: 12px; text-align: left; border: 1px solid #ddd; }");
		out.println("th { background-color: #4CAF50; color: white; }");
		out.println("tr:nth-child(even) { background-color: #f2f2f2; }");
		out.println("tr:hover { background-color: #ddd; }");
		out.println(".actions { text-align: center; }");
		out.println(
				".actions a { color: #007bff; text-decoration: none; padding: 5px 10px; border: 1px solid #007bff; border-radius: 4px; }");
		out.println(".actions a:hover { background-color: #007bff; color: white; }");
		out.println(".sign-out-link { text-align: center; margin-top: 20px; font-size: 16px; }");
		out.println(".sign-out-link a { color: #007bff; text-decoration: none; }");
		out.println(".sign-out-link a:hover { text-decoration: underline; }");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");

		out.println("<div class='container'>");

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

		out.println("<h2>Welcome, " + userName + " [ " + role + " ]</h2>");
		out.println("<p>Here are the current voting results:</p>");
		out.println("<table>");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>ID</th>");
		out.println("<th>Name</th>");
		out.println("<th>Party</th>");
		out.println("<th>Votes</th>");
		out.println("<th>Actions</th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		for (Candidate c : list) {
			out.println("<tr>");
			out.println("<td>" + c.getId() + "</td>");
			out.println("<td>" + c.getName() + "</td>");
			out.println("<td>" + c.getParty() + "</td>");
			out.println("<td>" + c.getVotes() + "</td>");
			out.println("<td class='actions'><a href='#'>Details</a> | <a href='#'>Edit</a></td>");
			out.println("</tr>");
		}
		out.println("</tbody>");
		out.println("</table>");

		out.println("<div class='sign-out-link'>");
		out.println("<p><a href='candidate.html'>Add New Candidate</a></p>");
		out.println("<p><a href='index.html'>Sign Out</a></p>");
		out.println("</div>");

		out.println("</div>"); // Closing the container div

		out.println("</body>");
		out.println("</html>");

	}
}

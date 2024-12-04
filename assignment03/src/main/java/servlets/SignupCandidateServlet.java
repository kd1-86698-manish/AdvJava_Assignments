package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daos.CandidateDao;
import com.daos.CandidateDaoImpl;
import com.entities.Candidate;

@WebServlet("/signupcandidate")
public class SignupCandidateServlet extends HttpServlet {

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

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		String name = req.getParameter("name");
		String party = req.getParameter("party");

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Candidate Sign Up</title>");
		out.println("<style>");
		out.println("body {");
		out.println("    font-family: Arial, sans-serif;");
		out.println("    background-color: #f4f4f9;");
		out.println("    margin: 0;");
		out.println("    padding: 20px;");
		out.println("    display: flex;");
		out.println("    justify-content: center;");
		out.println("    align-items: center;");
		out.println("    height: 100vh;");
		out.println("}");
		out.println(".container {");
		out.println("    background-color: white;");
		out.println("    padding: 30px;");
		out.println("    border-radius: 8px;");
		out.println("    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);");
		out.println("    width: 100%;");
		out.println("    max-width: 500px;");
		out.println("}");
		out.println("h1, h3 {");
		out.println("    text-align: center;");
		out.println("    color: #333;");
		out.println("}");
		out.println("p {");
		out.println("    text-align: center;");
		out.println("    font-size: 16px;");
		out.println("    color: #555;");
		out.println("}");
		out.println("a {");
		out.println("    color: #007bff;");
		out.println("    text-decoration: none;");
		out.println("}");
		out.println("a:hover {");
		out.println("    text-decoration: underline;");
		out.println("}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");

		out.println("<div class='container'>");

		try (CandidateDao canDao = new CandidateDaoImpl()) {

			Candidate c = new Candidate(0, name, party, 0);

			int count = canDao.save(c);

			if (count == 1) {
				out.println("<h1>Success!</h1>");
				out.println("<h3>Candidate Registered Successfully!</h3>");
			} else {
				out.println("<h1>Oops!</h1>");
				out.println("<h3>Something went wrong. Please try again.</h3>");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

		out.println("<p><a href='index.html'>Go Back to Sign Up</a></p>");
		out.println("</div>");

		out.println("</body>");
		out.println("</html>");

	}

}

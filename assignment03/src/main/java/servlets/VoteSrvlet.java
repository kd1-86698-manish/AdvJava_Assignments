package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.daos.CandidateDao;
import com.daos.CandidateDaoImpl;
import com.daos.UserDao;
import com.daos.UserDaoImpl;
import com.entities.User;

@WebServlet("/vote")
public class VoteSrvlet extends HttpServlet {

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

		String candID = req.getParameter("candidate");
		int id = Integer.parseInt(candID);

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Voting Status</title>");

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
		out.println("    max-width: 600px;");
		out.println("}");
		out.println("h1, h2, h4 {");
		out.println("    text-align: center;");
		out.println("    color: #333;");
		out.println("}");

		out.println("h1 {");
		out.println("    font-size: 32px;");
		out.println("    margin-bottom: 20px;");
		out.println("}");

		out.println("h2 {");
		out.println("    font-size: 24px;");
		out.println("    margin-top: 20px;");
		out.println("    color: #007bff;");
		out.println("}");

		out.println("h4.success {");
		out.println("    font-size: 18px;");
		out.println("    color: #28a745;");
		out.println("    margin-top: 10px;");
		out.println("}");

		out.println("h4.error {");
		out.println("    font-size: 18px;");
		out.println("    color: #dc3545;");
		out.println("    margin-top: 10px;");
		out.println("}");

		out.println("p {");
		out.println("    text-align: center;");
		out.println("    font-size: 16px;");
		out.println("    color: #555;");
		out.println("    margin-top: 30px;");
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
		ServletContext color = this.getServletContext();
		String bgColor = color.getInitParameter("bg.color");

		out.printf("<body style=background-color:%s >", bgColor);
		ServletContext app = this.getServletContext();
		String appTitle = app.getInitParameter("app.title");
		

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
		out.printf("<h1>%s</h1>", appTitle);
		out.println("<h1>Welcome, " + userName + "!</h1>");
		out.println("<h2>Voting Status</h2>");

		HttpSession session = req.getSession(false);
		if (session == null) {
//			resp.sendRedirect("index.html");
			resp.sendError(440);
			return;
		}
		User user = (User) session.getAttribute("curUser");

		if (user.getStatus() == 0) {

			try (CandidateDao canDao = new CandidateDaoImpl()) {
				int count = canDao.incrVote(id);
				if (count == 1) {

					user.setStatus(1);
					try (UserDao userDao = new UserDaoImpl()) {
						count = userDao.updateUser(user);
						if (count == 1)
							out.println("<h4> You Succesfully casted Your Voted</h4>");
					}

				} else {
					out.println("<h4 class='error'>Your voting failed. Please try again.</h4>");
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		} else {
			out.println("<h4 class='success'>You have already voteed.</h4>");
		}

		out.println("<p><a href='logout'>Sign Out</a></p>");
		out.println("</div>");

		out.println("</body>");
		out.println("</html>");

	}

}

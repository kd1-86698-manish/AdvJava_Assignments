package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

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

		Cookie c1 = new Cookie("uname", "");
		c1.setMaxAge(-1);
		resp.addCookie(c1);

		Cookie c2 = new Cookie("role", "");
		c2.setMaxAge(-1);
		resp.addCookie(c2);

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Logout</title>");
		out.println("<style>");
		out.println(
				"body { font-family: Arial, sans-serif; background-color: #f4f4f9; margin: 0; padding: 20px; display: flex; justify-content: center; align-items: center; height: 100vh; text-align: center; }");
		out.println(
				".container { background-color: white; padding: 40px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); width: 100%; max-width: 400px; }");
		out.println("h2 { color: #333; font-size: 24px; margin-bottom: 20px; }");
		out.println("p { color: #555; font-size: 18px; margin-bottom: 20px; }");
		out.println(".back-link { margin-top: 20px; }");
		out.println(".back-link a { color: #007bff; text-decoration: none; font-size: 16px; }");
		out.println(".back-link a:hover { text-decoration: underline; }");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");

		out.println("<div class='container'>");
		out.println("<h2>Thank You</h2>");
		out.println("<p>See you after 5 years.</p>");
		out.println("<div class='back-link'>");
		out.println("<p><a href='index.html'>Login Again</a></p>");
		out.println("</div>");
		out.println("</div>"); // Closing the container div

		out.println("</body>");
		out.println("</html>");

	}
}

package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daos.UserDao;
import com.daos.UserDaoImpl;
import com.entities.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

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

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		try (UserDao userDao = new UserDaoImpl()) {

			User dbUser = userDao.findByEmail(email);

			if (dbUser != null && dbUser.getPassword().equals(password)) {

				Cookie c1 = new Cookie("uname", dbUser.getFirst_name());
				c1.setMaxAge(3600);
				resp.addCookie(c1);

				Cookie c2 = new Cookie("role", dbUser.getRole());
				c2.setMaxAge(3600);
				resp.addCookie(c2);

				if (dbUser.getRole().equals("admin")) {
					resp.sendRedirect("result");
				} else {
					resp.sendRedirect("candlist");
				}
			} else {

				out.println("<html>");
				out.println("<head>");
				out.println("<title>Login</title>");
				out.println("<style>");
				out.println(
						"body { font-family: Arial, sans-serif; background-color: #f4f4f9; margin: 0; padding: 20px; display: flex; justify-content: center; align-items: center; height: 100vh; }");
				out.println(
						".container { background-color: white; padding: 40px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); width: 100%; max-width: 400px; }");
				out.println("h2 { text-align: center; color: #333; margin-bottom: 20px; }");
				out.println("p { color: red; text-align: center; font-size: 16px; }");
				out.println(
						"input[type='text'], input[type='password'] { width: 100%; padding: 12px; margin: 8px 0 20px 0; border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box; font-size: 16px; }");
				out.println(
						"input[type='submit'] { width: 100%; padding: 12px; background-color: #4CAF50; color: white; border: none; border-radius: 4px; font-size: 16px; cursor: pointer; }");
				out.println("input[type='submit']:hover { background-color: #45a049; }");
				out.println(".back-link { text-align: center; margin-top: 10px; }");
				out.println(".back-link a { color: #007bff; text-decoration: none; font-size: 14px; }");
				out.println(".back-link a:hover { text-decoration: underline; }");
				out.println("</style>");
				out.println("</head>");
				out.println("<body>");

				out.println("<div class='container'>");
				out.println("<h2>Login</h2>");
				out.println("<p>Sorry, Invalid Email & Password</p>");
				out.println("<form method='post' action='login'>");

				out.println("<input type='text' name='email' placeholder='Enter your email' required>");
				out.println("<input type='password' name='password' placeholder='Enter your password' required>");

				out.println("<input type='submit' value='Login'>");
				out.println("</form>");

				out.println("<div class='back-link'>");
				out.println("<p><a href='index.html'>Login Again</a></p>");
				out.println("</div>");

				out.println("</div>"); // Closing the container div

				out.println("</body>");
				out.println("</html>");

			}

		} catch (Exception e) {

			e.printStackTrace();
			throw new ServletException(e);
		}

	}
}

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daos.UserDao;
import com.daos.UserDaoImpl;
import com.entities.User;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {

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

		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String birth = req.getParameter("dob");
		Date dob = Date.valueOf(birth);

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Sign up</title>");
		out.println("<body>");
		try (UserDao userDao = new UserDaoImpl()) {

			User u = new User(0, firstName, lastName, email, password, dob, 0, "voter");

			int count = userDao.saveUser(u);

			if (count == 1) {

				out.println("<h3>User Register Succesfully.....</h3>");
			} else {
				out.println("<h3>User Failed to Register.....</h3>");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		out.println("<p> <a href='index.html'>Sign In</a> </p>");
		out.println("</body>");
		out.println("</html>");
	}
}

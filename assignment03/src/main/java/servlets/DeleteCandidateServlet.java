package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daos.CandidateDao;
import com.daos.CandidateDaoImpl;

@WebServlet("/delcand")
public class DeleteCandidateServlet extends HttpServlet {

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

		String candId = req.getParameter("id");
		int id = Integer.parseInt(candId);

		try (CandidateDao canDao = new CandidateDaoImpl()) {

			int count = canDao.deleteById(id);
			String message = "Candidate deleted " + count + "...!!";
			req.setAttribute("msg", message);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);

		}
		RequestDispatcher rd = req.getRequestDispatcher("result");
		rd.forward(req, resp);
	}
}

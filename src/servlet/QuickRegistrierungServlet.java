package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanRegister;
import dao.QuickRegistrierungDao;

@WebServlet("/QuickRegistrierungServlet")
public class QuickRegistrierungServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private QuickRegistrierungDao daoRegistrierung = new QuickRegistrierungDao();

	public QuickRegistrierungServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String username = request.getParameter("username");
			String emailadresse = request.getParameter("emailadresse");

			if (emailadresse != "" && username != "") {

				if (this.daoRegistrierung.userBereitsRegistriert(username, emailadresse)) {

					BeanRegister showNutzer = this.daoRegistrierung.showNutzerDaten(username, emailadresse);
					RequestDispatcher dispatch = request.getRequestDispatcher("/registrierunguser.jsp");
					request.setAttribute("datenNutzer", showNutzer);
					dispatch.forward(request, response);

				} else {
					this.daoRegistrierung.neuerNutzerErstellen(username, emailadresse);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
					request.setAttribute("warnungAnNutzer", "username and mail saved");
					dispatcher.forward(request, response);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

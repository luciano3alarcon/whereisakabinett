package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanRegister;
import dao.DaoRegistrierterNutzer;

@WebServlet("/EditRegisterServlet")
public class EditRegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private DaoRegistrierterNutzer nutzerRegistriert = new DaoRegistrierterNutzer();

	public EditRegisterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String aktion = request.getParameter("aktion");
		String nutzerDatenId = request.getParameter("datenNutzer");

		try {
			if (aktion.equalsIgnoreCase("save")) {
				BeanRegister nutzerDatenSave = this.nutzerRegistriert.showNutzer(nutzerDatenId);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/registrierunguser.jsp");
				request.setAttribute("datenNutzer", nutzerDatenSave);
				dispatcher.forward(request, response);

				this.nutzerRegistriert.updatenDatenNutzer(nutzerDatenSave);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
//		try {
//			String aktion = request.getParameter("aktion");
//			String nutzerDatenId = request.getParameter("datenNutzer");
//
//			BeanRegister nutzerDaten = this.nutzerErstellen(request);
//
//			if (aktion.equalsIgnoreCase("save") && nutzerDatenId != null) {
//				// werden die Daten gespeichert
//				BeanRegister showRegistrierterNutzer = this.nutzerRegistriert.showNutzer(nutzerDatenId);
//				this.nutzerRegistriert.updatenDatenNutzer(showRegistrierterNutzer);
//
//			} else if (aktion == "edit") {
//				// werden die eingetragenen Daten in die DB upgedatet
//			} else if (aktion == "delete") {
//				// Nutzer wird nach der ID gelöscht.
//			}
//
//			RequestDispatcher view = request.getRequestDispatcher("/registrierunguser.jsp");
//			request.setAttribute("nutzerDaten", this.nutzerRegistriert.showNutzer(nutzerDatenId));
//			view.forward(request, response);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	public static BeanRegister nutzerErstellen(HttpServletRequest request) {

		String username = request.getParameter("username");
		String name = request.getParameter("name");
		String vorname = request.getParameter("vorname");
		String stadt = request.getParameter("stadt");
		String geschlecht = request.getParameter("geschlecht");
		String beautifull = request.getParameter("beautifull");
		String newsletter = request.getParameter("newsletter");
		String email = request.getParameter("email");
		String id = request.getParameter("id");

		BeanRegister nutzerDaten = new BeanRegister();
		if (id != null && !id.isEmpty()) {
			nutzerDaten.setId(Integer.parseInt(id));
		}
				
		nutzerDaten.setUsername(username);
		nutzerDaten.setName(name);
		nutzerDaten.setVorname(vorname);
		nutzerDaten.setStadt(stadt);
		nutzerDaten.setGeschlecht(geschlecht);
		nutzerDaten.setBeautifull(beautifull);
		nutzerDaten.setNewsletter(newsletter);
		nutzerDaten.setEmailadresse(email);

		return nutzerDaten;
	}

}

package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditRegisterServlet")
public class EditRegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;


	public EditRegisterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String aktion = request.getParameter("aktion");
		String id = request.getParameter("datenNutzer");
		
		if (aktion == "save") {
			// werden die Daten gespeichert


		} else if (aktion == "edit") {
			// werden die eingetragenen Daten in die DB upgedatet
		} else if (aktion == "delete") {
			// Nutzer wird nach der ID gelöscht.
		}
		
	}

}

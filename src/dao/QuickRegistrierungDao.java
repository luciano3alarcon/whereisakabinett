package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.BeanRegister;
import connection.SingleConnection;

public class QuickRegistrierungDao {

	private static Connection connection;

	public QuickRegistrierungDao() {
		connection = SingleConnection.getConnection();
	}

	public void neuerNutzerErstellen(String username, String emailadresse) throws Exception {

		try {

			String quickInsertNutzer = "INSERT INTO registrierung(username, name, vorname, stadt, geschlecht, beautifull, newsletter, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement insertNewUser = connection.prepareStatement(quickInsertNutzer);
			insertNewUser.setString(1, username);
			insertNewUser.setString(2, "");
			insertNewUser.setString(3, "");
			insertNewUser.setString(4, "");
			insertNewUser.setString(5, "");
			insertNewUser.setString(6, "");
			insertNewUser.setString(7, "");
			insertNewUser.setString(8, emailadresse);
			insertNewUser.execute();

			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (Exception e2) {
				System.out.println("Error to create a new user. Dao Registrierung");
				e2.printStackTrace();
			}
		}
	}

	public boolean userBereitsRegistriert(String username, String emailadresse) throws Exception {

		String sql = "SELECT COUNT (1) as anzahlEintraege FROM registrierung WHERE username = '" + username
				+ "' AND email ='" + emailadresse + "'; ";

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet result = statement.executeQuery();

		if (result.next()) {
			return result.getInt("anzahlEintraege") == 1; // Hier wird true erwartet.
		}
		return false;
	}

	public BeanRegister showNutzerDaten(String username, String emailadresse) throws Exception {

		String searchNutzer = "SELECT * FROM registrierung WHERE username = '" + username + "' AND email = '"
				+ emailadresse + "' ;  ";

		PreparedStatement queryListe = connection.prepareStatement(searchNutzer);
		ResultSet result = queryListe.executeQuery();

		if (result.next()) {

			BeanRegister nutzerDaten = new BeanRegister();
			nutzerDaten.setUsername(result.getString("username"));
			nutzerDaten.setName(result.getString("name"));
			nutzerDaten.setVorname(result.getString("vorname"));
			nutzerDaten.setStadt(result.getString("stadt"));
			nutzerDaten.setGeschlecht(result.getString("geschlecht"));
			nutzerDaten.setBeautifull(result.getString("beautifull"));
			nutzerDaten.setNewsletter(result.getString("newsletter"));
			nutzerDaten.setEmailadresse(result.getString("email"));
			nutzerDaten.setId(result.getInt("id"));

			return nutzerDaten;
		}
		return null;
	}

}

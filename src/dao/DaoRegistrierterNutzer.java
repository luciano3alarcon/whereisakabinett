package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BeanRegister;
import connection.SingleConnection;

public class DaoRegistrierterNutzer {

	private static Connection connection;
	BeanRegister nutzer = new BeanRegister();

	public DaoRegistrierterNutzer() {
		connection = SingleConnection.getConnection();
	}

	public BeanRegister showNutzer(String id) throws Exception {

		String searchNutzerById = "SELECT * FROM registrierung WHERE id = '" + id + "';";

		PreparedStatement queryListe = connection.prepareStatement(searchNutzerById);
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

	public void updatenDatenNutzer(BeanRegister nutzerDaten) throws Exception {

		String queryNutzerUpdaten = "UPDATE registrierung SET username=?, name=?, vorname=?, stadt=?, geschlecht=?, beautifull=?, newsletter=?, email=?, id=? WHERE id= '"
				+ nutzerDaten.getId() + "';";

		try {
			PreparedStatement statementPrepared = this.connection.prepareStatement(queryNutzerUpdaten);
			statementPrepared.setString(1, nutzerDaten.getUsername());
			statementPrepared.setString(2, nutzerDaten.getName());
			statementPrepared.setString(3, nutzerDaten.getVorname());
			statementPrepared.setString(4, nutzerDaten.getStadt());
			statementPrepared.setString(5, nutzerDaten.getGeschlecht());
			statementPrepared.setString(6, nutzerDaten.getBeautifull());
			statementPrepared.setString(7, nutzerDaten.getNewsletter());
			statementPrepared.setString(8, nutzerDaten.getEmailadresse());
			statementPrepared.setInt(9, nutzerDaten.getId());

			statementPrepared.executeUpdate();
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();

			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	}

	public List<BeanRegister> nutzerInderDBSpeichern() throws Exception {

		List<BeanRegister> user = new ArrayList<BeanRegister>();
		String sqlQuery = "SELECT * FROM registrierung;";

		PreparedStatement queryListe = this.connection.prepareStatement(sqlQuery);
		ResultSet resultSet = queryListe.executeQuery();

		while (resultSet.next()) {
			BeanRegister beanRegister = new BeanRegister();
			beanRegister.setEmailadresse(resultSet.getString("username"));

			user.add(beanRegister);
		}
		return user;
	}

	public void setNutzer(BeanRegister nutzerDaten) {

		try {
			String insertNutzer = "INSERT INTO registrierung(\r\n"
					+ "	username, name, vorname, stadt, geschlecht, beautifull, newsletter, email)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement insertDaten = connection.prepareStatement(insertNutzer);
			insertDaten.setString(1, nutzerDaten.getUsername());
			insertDaten.setString(2, nutzerDaten.getName());

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<BeanRegister> erstellenNutzer() throws Exception {

		List<BeanRegister> datenNutzer = new ArrayList<BeanRegister>();
		String sqlQuery = "SELECT * FROM registerunguser;";

		PreparedStatement statement = this.connection.prepareStatement(sqlQuery);
		ResultSet result = statement.executeQuery();

		while (result.next()) {

			BeanRegister beanRegister = new BeanRegister();
			beanRegister.setUsername(result.getString("username"));
			beanRegister.setVorname(result.getString("vorname"));

			datenNutzer.add(beanRegister);
		}

		return datenNutzer;
	}

}

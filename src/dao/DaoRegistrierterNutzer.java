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

	public List zeigNutzer(BeanRegister Nutzer) throws Exception {

		List<BeanRegister> zeigNutzer = new ArrayList<BeanRegister>();
		String sqlQuery = "SELECT * FROM registrierung;";

		PreparedStatement queryListe = this.connection.prepareStatement(sqlQuery);
		ResultSet resultSet = queryListe.executeQuery();

		while (resultSet.next()) {

			BeanRegister beanRegister = new BeanRegister();

		}

		return zeigNutzer;
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

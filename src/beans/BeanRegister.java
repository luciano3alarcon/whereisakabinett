package beans;

public class BeanRegister {

	private int id;
	private String username;
	private String emailadresse;
	private String name;
	private String vorname;
	private String stadt;
	private String geschlecht;
	private String beautifull;
	private String newsletter; // Newsletter


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBeautifull() {
		return beautifull;
	}

	public void setBeautifull(String beautifull) {
		this.beautifull = beautifull;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailadresse() {
		return this.emailadresse;
	}

	public void setEmailadresse(String emailadresse) {
		this.emailadresse = emailadresse;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return this.vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getStadt() {
		return this.stadt;
	}

	public void setStadt(String stadt) {
		this.stadt = stadt;
	}

	public String getNewsletter() {
		return this.newsletter;
	}

	public void setNewsletter(String newsletter) {
		this.newsletter = newsletter;
	}

	public String getGeschlecht() {
		return this.geschlecht;
	}

	public void setGeschlecht(String geschlecht) {
		this.geschlecht = geschlecht;
	}

}

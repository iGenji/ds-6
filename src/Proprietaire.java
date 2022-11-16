public class Proprietaire {
	
	private String nom;
	private String prenom;
	private String numeroGSM;
	private String email;

	public Proprietaire(String nom, String prenom, String numerroGSM, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.numeroGSM = numerroGSM;
		this.email = email;
	}
	
	public Proprietaire(String nom) {
		super();
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public String toString() {
		return "Proprietaire [nom=" + nom + ", prenom=" + prenom + ", numeroGSM=" + numeroGSM + ", email=" + email + "]";
	}

	public String getPrenom() {
		return prenom;
	}

	public String getNumeroGSM() {
		return numeroGSM;
	}


	public String getEmail() {
		return email;
	}
	
}

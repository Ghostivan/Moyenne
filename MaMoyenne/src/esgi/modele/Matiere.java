package esgi.modele;

public class Matiere {
	
	private String idMatiere;
	private String nomMatiere;
	private String coefMatiere;
	
	public Matiere(String idMatiere, String nomMatiere, String coefMatiere) {
		super();
		this.idMatiere = idMatiere;
		this.nomMatiere = nomMatiere;
		this.coefMatiere = coefMatiere;
	}

	public String getIdMatiere() {
		return idMatiere;
	}
	
	public void setIdMatiere(String idMatiere) {
		this.idMatiere = idMatiere;
	}

	public String getNomMatiere() {
		return nomMatiere;
	}

	public void setNomMatiere(String nomMatiere) {
		this.nomMatiere = nomMatiere;
	}

	public String getCoefMatiere() {
		return coefMatiere;
	}

	public void setCoefMatiere(String coefMatiere) {
		this.coefMatiere = coefMatiere;
	}
	
	
}

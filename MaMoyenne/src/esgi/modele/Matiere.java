package esgi.modele;

public class Matiere {
	
	private long id;
	private String nom;
	private int coef;
	
	public Matiere(long idMatiere, String nomMatiere, int coefMatiere) {
		super();
		this.id = idMatiere;
		this.nom = nomMatiere;
		this.coef= coefMatiere;
	}
	public Matiere(String nomMatiere, int coefMatiere) {
		super();
		this.nom = nomMatiere;
		this.coef= coefMatiere;
	}
	public Matiere(){
		
	}
	public long getId() {
		return id;
	}
	
	public void setId(long idMatiere) {
		this.id = idMatiere;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nomMatiere) {
		this.nom = nomMatiere;
	}

	public int getCoef() {
		return coef;
	}

	public void setCoef(int coefMatiere) {
		this.coef = coefMatiere;
	}
	
	
}

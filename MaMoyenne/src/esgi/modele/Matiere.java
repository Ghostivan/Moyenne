package esgi.modele;

import java.util.ArrayList;

public class Matiere {
	
	private long id;
	private String nom;
	private int coef;
	private ArrayList<Note> notes;
	
	public Matiere(long idMatiere, String nomMatiere, int coefMatiere) {
		super();
		this.id = idMatiere;
		this.nom = nomMatiere;
		this.coef= coefMatiere;
		this.notes = new ArrayList<Note>();
	}
	
	public Matiere(long idMatiere, String nomMatiere, int coefMatiere, ArrayList<Note> MesNotes) {
		super();
		this.id = idMatiere;
		this.nom = nomMatiere;
		this.coef= coefMatiere;
		this.notes = MesNotes;
	}
	
	public Matiere(String nomMatiere, int coefMatiere) {
		super();
		this.nom = nomMatiere;
		this.coef= coefMatiere;
		this.notes = new ArrayList<Note>();
	}
	
	public Matiere(){
		this.notes = new ArrayList<Note>();
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long idMatiere) {
		this.id = idMatiere;
	}

	public ArrayList<Note> getNotes() {
		return notes;
	}

	public void setNotes(ArrayList<Note> notes) {
		this.notes = notes;
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
	
	//TODO calcul la moyenne
	//Calcul de la moyenne
	public int getMoyenne(){
		return 0;
	}
	
	//Renvoi chaine de caractere avec toute les notes séparé pas une virgule
	public String getMesNotes(){
		return "lol";	
	}
	
	
}

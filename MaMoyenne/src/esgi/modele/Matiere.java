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
	
	/**
	 * Calcul de la moyenne par matière
	 * @return uneNote
	 */
	public float getMoyenne(){
		
		float uneNote = notes.get(0).getValue();
		for (int i=1; i<notes.size(); i++){
			uneNote = uneNote + notes.get(i).getValue();
		}
		uneNote = uneNote/notes.size();
		
		return uneNote;
	}
	
	/**
	 * Renvoi chaine de caractere avec toute les notes séparé pas une virgule
	 * @return uneNote
	 */
	public String getMesNotes(){
		
		String uneNote = "";
		
		for (int i=0; i<notes.size(); i++){
			uneNote = uneNote + notes.get(i).getValue() + ", ";
		}
		
		return uneNote;	
	}
	
	public String getMoyenneGenerale(){
		return "Coucou";
	}
	
}

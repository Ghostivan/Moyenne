package esgi.modele;

import java.text.DecimalFormat;
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
	public String getMoyenne(){
		float uneNote = 0.0f;
		for (int i=0; i<notes.size(); i++){
			uneNote += notes.get(i).getValue();
		}
		if(notes.size() != 0){
			return Float.toString(uneNote/notes.size());
		}else{
			return " ";
		}
	}
	
	/**
	 * Renvoi chaine de caractere avec toute les notes séparé pas une virgule
	 * @return uneNote
	 */
	public String getMesNotes(){
		
		String uneNote = "";
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(1);
		for (int i=0; i<notes.size(); i++){
			uneNote += df.format(notes.get(i).getValue()) + " ";
		}
		
		return uneNote;	
	}
	
}

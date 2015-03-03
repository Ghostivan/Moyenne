package esgi.modele;

public class Note {

	private long id;
	private long id_mat;
	private float value;
	
	/**
	 * Constructeur de Note
	 * @param idNote
	 * @param idMatière
	 * @param note
	 */
	public Note(long idNote, long idMatière, float note) {
		super();
		this.id = idNote;
		this.id_mat = idMatière;
		this.value = note;
	}
	
	public Note(long idMatière, float note) {
		super();
		this.id_mat = idMatière;
		this.value = note;
	}
	
	public Note(){
		
	}
	
	public long getId() {
		return id;
	}

	public void setId(long idNote) {
		this.id = idNote;
	}

	public long getIdMat() {
		return id_mat;
	}

	public void setIdMat(long idMatière) {
		this.id_mat = idMatière;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float note) {
		this.value = note;
	}
	
}

package esgi.modele;

public class Notes {

	private String idNote;
	private String idMatière;
	private String note;
	
	public Notes(String idNote, String idMatière, String note) {
		super();
		this.idNote = idNote;
		this.idMatière = idMatière;
		this.note = note;
	}

	public String getIdNote() {
		return idNote;
	}

	public void setIdNote(String idNote) {
		this.idNote = idNote;
	}

	public String getIdMatière() {
		return idMatière;
	}

	public void setIdMatière(String idMatière) {
		this.idMatière = idMatière;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
}

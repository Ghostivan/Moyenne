package esgi.modele;

public class Notes {

	private String idNote;
	private String idMati�re;
	private String note;
	
	public Notes(String idNote, String idMati�re, String note) {
		super();
		this.idNote = idNote;
		this.idMati�re = idMati�re;
		this.note = note;
	}

	public String getIdNote() {
		return idNote;
	}

	public void setIdNote(String idNote) {
		this.idNote = idNote;
	}

	public String getIdMati�re() {
		return idMati�re;
	}

	public void setIdMati�re(String idMati�re) {
		this.idMati�re = idMati�re;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
}

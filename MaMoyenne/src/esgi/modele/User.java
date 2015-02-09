package esgi.modele;

import java.util.HashMap;

public class User {

	private String idUser;
	private String nomUser;
	private String prenomUser;
	private String loginUser;
	private String passwordUser;
	private HashMap<String, String> notesUser;
	private String typeUser;

	public User(String idUser, String nomUser, String prenomUser,
			String loginUser, String passwordUser,
			HashMap<String, String> notesUser, String typeUser) {
		super();
		this.idUser = idUser;
		this.nomUser = nomUser;
		this.prenomUser = prenomUser;
		this.loginUser = loginUser;
		this.passwordUser = passwordUser;
		this.notesUser = notesUser;
		this.typeUser = typeUser;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getNomUser() {
		return nomUser;
	}

	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}

	public String getPrenomUser() {
		return prenomUser;
	}

	public void setPrenomUser(String prenomUser) {
		this.prenomUser = prenomUser;
	}

	public String getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	public String getPasswordUser() {
		return passwordUser;
	}

	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}

	public HashMap<String, String> getNotesUser() {
		return notesUser;
	}

	public void setNotesUser(HashMap<String, String> notesUser) {
		this.notesUser = notesUser;
	}

	public String getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}

}
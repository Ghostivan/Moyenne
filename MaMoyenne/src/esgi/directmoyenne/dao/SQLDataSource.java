package esgi.directmoyenne.dao;

import java.util.ArrayList;
import java.util.List;
import esgi.modele.Connection;
import esgi.modele.Matiere;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class SQLDataSource {
	// Database fields
	  private SQLiteDatabase database;
	  private Connection dbHelper;
	  private String[] matiereColumns = { 
			  Connection.COLUMN_MT_ID,
			  Connection.COLUMN_MT_NOM,
			  Connection.COLUMN_MT_COEF
	 };
	 private String[] adminColumns = { 
			  Connection.COLUMN_NT_ID,
			  Connection.COLUMN_NT_IDMAT,
			  Connection.COLUMN_NT_VALUE
	 };
	  public SQLDataSource(Context context) {
		context.deleteDatabase(Connection.DBNAME);
	    dbHelper = new Connection(context);
	  }
	  public void open() throws SQLException {
	    database = dbHelper.getWritableDatabase();
	  }
	  public void close() {
	    dbHelper.close();
	  }
	  /**
	   * Treatment Matiere
	   */
	  public Matiere createMatiere(Matiere mt) {
	    ContentValues values = new ContentValues();
	    values.put(Connection.COLUMN_MT_NOM, mt.getNom());
	    values.put(Connection.COLUMN_MT_COEF, mt.getCoef());
	    // Creation d'un utilisateur avec un id a null
	    long insertId = database.insert(Connection.TABLE_MATIERE, null,
	        values);
	    Cursor cursor = database.query(Connection.TABLE_MATIERE,
	    		matiereColumns, Connection.COLUMN_MT_ID + " = " + insertId, null,
	        null, null, null);
	    cursor.moveToFirst();
	    Matiere newMatiere = cursorToMatiere(cursor);
	    cursor.close();
	    return newMatiere;
	  }
	  public void deleteMatiere(Matiere mat) {
	    long id = mat.getId();
	    System.out.println("Matiere deleted with id: " + id);
	    database.delete(Connection.TABLE_MATIERE, Connection.COLUMN_MT_ID
	        + " = " + id, null);
	  }
	  public List<Matiere> getAllMatieres() {
	    List<Matiere> Matieres = new ArrayList<Matiere>();
	    Cursor cursor = database.query(Connection.TABLE_MATIERE,
	    		matiereColumns, null, null, null, null, null);
	    cursor.moveToFirst();
	    while (!cursor.isAfterLast()) {
	      Matiere Matiere = cursorToMatiere(cursor);
	      Matieres.add(Matiere);
	      cursor.moveToNext();
	    }
	    cursor.close();
	    return Matieres;
	  }
	  private Matiere cursorToMatiere(Cursor cursor) {
	    Matiere Matiere = new Matiere();
	    Matiere.setId(cursor.getLong(0));
	    Matiere.setNom(cursor.getString(1));
	    return Matiere;
	  }
	  
	  
	  /**
	   * Treatment ADMINISTRATOR
	   
	  public Admin createAdmin(Admin ad){
		  ContentValues values = new ContentValues();
		  values.put(Connection.COLUMN_AD_PSEUDO, ad.getPseudo());
		  values.put(Connection.COLUMN_AD_PASSWORD, ad.getPass());
		  // Creation d'un utilisateur avec un id a null
		  long insertId = database.insert(Connection.TABLE_ADMIN, null,values);
		    Cursor cursor = database.query(Connection.TABLE_ADMIN,
		    	adminColumns, Connection.COLUMN_AD_ID + " = " + insertId, null,
		        null, null, null);
		    cursor.moveToFirst();
		    Admin newAdmin = cursorToAdmin(cursor);
		    cursor.close();
		    return newAdmin;
	  }
	  public void deleteAdmin(Admin ad) {
		    long id = ad.getId();
		    System.out.println("Matiere deleted with id: " + id);
		    database.delete(Connection.TABLE_ADMIN, Connection.COLUMN_AD_ID
		        + " = " + id, null);
		  }
	  public List<Admin> getAllAdmin() {
		  List<Admin> admins = new ArrayList<Admin>();
		  Cursor cursor = database.query(Connection.TABLE_ADMIN,adminColumns, null, null, null, null, null);
		  cursor.moveToFirst();
		  while (!cursor.isAfterLast()) {
			  Admin admin = cursorToAdmin(cursor);
			  admins.add(admin);
			  cursor.moveToNext();
		  }
		  cursor.close();
		  return admins;
	  }
	  private Admin cursorToAdmin(Cursor cursor) {
		  Admin admin = new Admin();
		  admin.setId(cursor.getLong(0));
		  admin.setPseudo(cursor.getString(1));
		  return admin;
	  }
	  */
}

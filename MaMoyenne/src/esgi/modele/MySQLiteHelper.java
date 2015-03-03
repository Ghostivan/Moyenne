package esgi.modele;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {
	
	// Database Version
    public static final int DATABASE_VERSION = 4;
    // Database Name
    private static final String DATABASE_NAME = "moyennedb";
   
	public MySQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);	
	}

	/**
	 * Création de la base de données
	 */
	public void onCreate(SQLiteDatabase db) {
		// SQL statement to create book table
		String CREATE_MATIERE_TABLE = "CREATE TABLE Matiere ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " + 
				"name TEXT, "+
				"coef TEXT )";
		String CREATE_NOTE_TABLE = "CREATE TABLE Note ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " + 
				"id_mat INTEGER, "+
				"value REAL, "+
				"FOREIGN KEY(id_mat) REFERENCES Matiere(id) )";
		// create books table
		db.execSQL(CREATE_MATIERE_TABLE);
		db.execSQL(CREATE_NOTE_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older books table if existed
        db.execSQL("DROP TABLE IF EXISTS Matiere");
        db.execSQL("DROP TABLE IF EXISTS Note");
        // create fresh books table
        this.onCreate(db);
	}
	
	//---------------------------------------------------------------------
   
	/**
     * CRUD MATIERE (create "add", read "get", update, delete)
     */
	
	// Books table name
    private static final String TABLE_MATIERE = "Matiere";
    
    // Books Table Columns names
    private static final String KEY_MAT_ID = "id";
    private static final String KEY_MAT_NAME = "name";
    private static final String KEY_MAT_COEF = "coef";
    
    private static final String[] COLUMNS_MAT = {KEY_MAT_ID,KEY_MAT_NAME,KEY_MAT_COEF};
    
    /**
     * Ajout d'une matière dans la BDD
     * @param mat
     */
	public void addMatiere(Matiere mat){
		Log.d("addMatiere", mat.toString());
		// 1. get reference to writable DB
		SQLiteDatabase db = this.getWritableDatabase();
		 
		// 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_MAT_NAME, mat.getNom()); 
        values.put(KEY_MAT_COEF, mat.getCoef());
 
        // 3. insert
        db.insert(TABLE_MATIERE, // table
        		null, //nullColumnHack
        		values); // key/value -> keys = column names/ values = column values
        
        // 4. close
        db.close(); 
	}
	
	/**
	 * Renvoie les info d'une matière avec son id en paramètre
	 * @param id
	 * @return mat
	 */
	public Matiere getMatiere(int id){

		// 1. get reference to readable DB
		SQLiteDatabase db = this.getReadableDatabase();
		 
		// 2. build query
        Cursor cursor = 
        		db.query(TABLE_MATIERE, // a. table
        		COLUMNS_MAT, // b. column names
        		" id = ?", // c. selections 
                new String[] { String.valueOf(id) }, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
        
        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();
 
        // 4. build matiere object
        Matiere mat = new Matiere();
        mat.setId(Integer.parseInt(cursor.getString(0)));
        mat.setNom(cursor.getString(1));
        mat.setCoef(Integer.parseInt(cursor.getString(2)));

		Log.d("getMatiere("+id+")", mat.toString());

        // 5. return matiere
        return mat;
	}
	
	/**
	 * Renvoie les info d'une matière avec son nom en paramètre
	 * @param name
	 * @return mat
	 */
	public Matiere getMatiereByName(String name){

		// 1. get reference to readable DB
		SQLiteDatabase db = this.getReadableDatabase();
		 
		// 2. build query
        Cursor cursor = 
        		db.query(TABLE_MATIERE, // a. table
        		COLUMNS_MAT, // b. column names
        		" name = ?", // c. selections 
                new String[] { name }, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
        
        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();
 
        // 4. build matiere object
        Matiere mat = new Matiere();
        mat.setId(Integer.parseInt(cursor.getString(0)));
        mat.setNom(cursor.getString(1));
        mat.setCoef(Integer.parseInt(cursor.getString(2)));

		Log.d("getMatiereByName("+name+")", mat.toString());

        // 5. return matiere
        return mat;
	}
	
	/**
	 * Renvoie la liste des matières
	 * @return listMat
	 */
    public List<Matiere> getAllMatieres() {
        List<Matiere> listMat = new LinkedList<Matiere>();

        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_MATIERE;
 
    	// 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
 
        // 3. go over each row, build book and add it to list
        Matiere mat = null;
        if (cursor.moveToFirst()) {
            do {
            	mat = new Matiere();
            	mat.setId(Integer.parseInt(cursor.getString(0)));
            	mat.setNom(cursor.getString(1));
            	mat.setCoef(Integer.parseInt(cursor.getString(2)));

                // Add book to books
            	listMat.add(mat);
            } while (cursor.moveToNext());
        }
        
		Log.d("getAllMatiere()", listMat.toString());

        // return books
        return listMat;
    }
	
	/**
	 * Update la matière passé en parametre
	 * @param mat
	 * @return i
	 */
    public int updateMatiere(Matiere mat) {

    	// 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
 
		// 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put("id_mat", mat.getNom()); 
        values.put("value", mat.getCoef()); 
 
        // 3. updating row
        int i = db.update(TABLE_MATIERE, //table
        		values, // column/value
        		KEY_MAT_ID+" = ?", // selections
                new String[] { String.valueOf(mat.getId()) }); //selection args
        
        // 4. close
        db.close();
        
        return i;
        
    }

    /**
     * Supprime la matière envoyer en paramètre
     * @param mat
     */
    public void deleteMatiere(Matiere mat) {

    	// 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        
        // 2. delete
        db.delete(TABLE_MATIERE,
        		KEY_MAT_ID+" = ?",
                new String[] { String.valueOf(mat.getId()) });
        
        // 3. close
        db.close();
        
		Log.d("deleteMatiere", mat.toString());

    }
    
	/**
     * CRUD NOTE (create "add", read "get", update, delete)
     */
    private static final String TABLE_NOTE = "Note";
    
    // Books Table Columns names
    private static final String KEY_NT_ID = "id";
    private static final String KEY_NT_ID_MAT = "id_mat";
    private static final String KEY_NT_VALUE = "value";
    
    private static final String[] COLUMNS_NT = {KEY_NT_ID,KEY_NT_ID_MAT,KEY_NT_VALUE};
    
	public void addNote(Note nt){
		Log.d("addNote", nt.toString());
		// 1. get reference to writable DB
		SQLiteDatabase db = this.getWritableDatabase();
		 
		// 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_NT_ID_MAT, nt.getIdMat()); 
        values.put(KEY_NT_VALUE, nt.getValue());
 
        // 3. insert
        db.insert(TABLE_NOTE, // table
        		null, //nullColumnHack
        		values); // key/value -> keys = column names/ values = column values
        
        // 4. close
        db.close(); 
	}
	
	public Note getNote(int id){

		// 1. get reference to readable DB
		SQLiteDatabase db = this.getReadableDatabase();
		 
		// 2. build query
        Cursor cursor = 
        		db.query(TABLE_NOTE, // a. table
        		COLUMNS_NT, // b. column names
        		" id = ?", // c. selections 
                new String[] { String.valueOf(id) }, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
        
        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();
 
        // 4. build note object
        Note nt = new Note();
        nt.setId(Integer.parseInt(cursor.getString(0)));
        nt.setIdMat(Integer.parseInt(cursor.getString(1)));
        nt.setValue(Float.parseFloat(cursor.getString(2)));

		Log.d("getNote("+id+")", nt.toString());

        // 5. return note
        return nt;
	}
	
	/**
	 * Retourne la liste de notes par matière
	 * @param l
	 * @return listNt
	 */
	public ArrayList<Note> getNoteByIdMatiere(long l){
		
		ArrayList<Note> listNt = new ArrayList<Note>();
		
		// 1. get reference to readable DB
		SQLiteDatabase db = this.getReadableDatabase();
		 
		// 2. build query
        Cursor cursor = 
        		db.query(TABLE_NOTE, // a. table
        		COLUMNS_NT, // b. column names
        		" id_mat = ?", // c. selections 
                new String[] { String.valueOf(l) }, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
        
        // 3. if we got results get the first one
        Note nt = null;
        if (cursor.moveToFirst()) {
            do {
            	nt = new Note();
            	nt.setId(Integer.parseInt(cursor.getString(0)));
            	nt.setIdMat(Integer.parseInt(cursor.getString(1)));
            	nt.setValue(Float.parseFloat(cursor.getString(2)));

                // Add book to books
            	listNt.add(nt);
            } while (cursor.moveToNext());
        }
        
		Log.d("getAllNote()", listNt.toString());

        // return books
        return listNt;
	}
	
	/**
	 * Retourne une liste de toutes les notes en BDD.
	 * @return listNt
	 */
    public List<Note> getAllNotes() {
        List<Note> listNt = new LinkedList<Note>();

        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_NOTE;
 
    	// 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
 
        // 3. go over each row, build note and add it to list
        Note nt = null;
        if (cursor.moveToFirst()) {
            do {
            	nt = new Note();
            	nt.setId(Integer.parseInt(cursor.getString(0)));
            	nt.setIdMat(Integer.parseInt(cursor.getString(1)));
            	nt.setValue(Float.parseFloat(cursor.getString(2)));

                // Add book to books
            	listNt.add(nt);
            } while (cursor.moveToNext());
        }
        
		Log.d("getAllNote()", listNt.toString());

        // return books
        return listNt;
    }
	
	/**
	 * Update les noate passé en paramètre
	 * @param nt
	 * @return i
	 */
    public int updateNote(Note nt) {

    	// 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
 
		// 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put("id_mat", nt.getIdMat());  
        values.put("value", nt.getValue()); 
 
        // 3. updating row
        int i = db.update(TABLE_MATIERE, //table
        		values, // column/value
        		KEY_NT_ID+" = ?", // selections
                new String[] { String.valueOf(nt.getId()) }); //selection args
        
        // 4. close
        db.close();
        
        return i;
        
    }

   /**
    * Supprime la note passé en paramètre
    * @param nt
    */
    public void deleteNote(Note nt) {

    	// 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        
        // 2. delete
        db.delete(TABLE_MATIERE, KEY_NT_ID+" = ?", new String[] { String.valueOf(nt.getId()) });
        
        // 3. close
        db.close();
        
		Log.d("deleteNote", nt.toString());

    }
}

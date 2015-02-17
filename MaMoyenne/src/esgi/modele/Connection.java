package esgi.modele;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Connection extends SQLiteOpenHelper{
	//DATABASE
	public final static String DBNAME = "directmoyenne";
	public final static int DBVERSION = 2;
	
	/*
	 * STUDENT 
	 */
	public static final String TABLE_MATIERE = "Matiere";
	public static final String COLUMN_MT_ID = "id";
	public static final String COLUMN_MT_NOM = "nom";
	public static final String COLUMN_MT_COEF = "coef";
	/*
	 * ADMINISTRATOR 
	 */
	public static final String TABLE_NOTE = "Note";
	public static final String COLUMN_NT_ID = "id";
	public static final String COLUMN_NT_IDMAT = "id_mat";
	public static final String COLUMN_NT_VALUE = "value";
	/*
	 * 
	 */
	// CREATION DATABASE
	private static final String CREATE_TABLE_USER = "create table "
		      + TABLE_MATIERE + "(" + COLUMN_MT_ID
		      + " integer primary key autoincrement, " + COLUMN_MT_NOM
		      + " varchar (40) not null, "+ COLUMN_MT_COEF 
		      + " integer (2) not null )";
	private static final String CREATE_TABLE_ADMIN = "create table "
		      + TABLE_NOTE + "(" + COLUMN_NT_ID
		      + " integer primary key autoincrement, " + COLUMN_NT_IDMAT
		      + " integer (5) not null, "+ COLUMN_NT_VALUE
		      + " integer (2) not null, "
		      + " foreign key("+COLUMN_NT_IDMAT +") references "+ TABLE_MATIERE+"("+COLUMN_MT_ID+") )";
	public Connection(Context context) {
		super(context, DBNAME, null, DBVERSION);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		 db.execSQL(CREATE_TABLE_USER);
		 db.execSQL(CREATE_TABLE_ADMIN);
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(Connection.class.getName(),
		        "Upgrading database from version " + oldVersion + " to "
		            + newVersion + ", which will destroy all old data");
		    db.execSQL("DROP TABLE IF EXISTS " + TABLE_MATIERE);
		    db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTE);
		    onCreate(db);
	}

}

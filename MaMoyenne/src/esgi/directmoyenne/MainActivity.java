package esgi.directmoyenne;

import java.util.ArrayList;
import java.util.List;

import com.example.mamoyenne.R;

import esgi.modele.Matiere;
import esgi.modele.MySQLiteHelper;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/*initDB();
		List<Matiere> lu = datasource.getAllMatieres();
		TextView text = (TextView) findViewById(R.id.titleHomePage);
		String tmp = " ";
		text.setText(" "); 
		for(Matiere st : lu){
			tmp+="******** ID : "+st.getId()+" | NAME : "+st.getNom()+" *********\n";
		}
		text.setText(tmp);*/
		MySQLiteHelper db = new MySQLiteHelper(this);
        
        /**
         * CRUD Operations
         * */
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public void initNewMatiere(View view){
		Button bt = (Button)findViewById(R.id.bt_newMatiere);
		bt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent in = new Intent(MainActivity.this,AddMatiereActivity.class);
				startActivity(in);
			}
		});
	}
	public void initNewNotes(View view){
		Button bt = (Button)findViewById(R.id.bt_newNote);
		bt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent in = new Intent(MainActivity.this,AddNotesActivity.class);
				startActivity(in);
			}
		});
	}
	public void initDashBoard(View view){
		Button bt = (Button)findViewById(R.id.bt_calculate);
		bt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent in = new Intent(MainActivity.this,DashBoardActivity.class);
				//in.putExtra(KEY_DB, datasource.getDataSource());
				startActivity(in);
			}
		});
	}
	/*public void sendFormStudent(View view) {
		System.out.println("Student Clicked !");
		Button btListe = (Button) findViewById(R.id.bt_student);
		//String txtStudent = (String) findViewById(R.id);
		btListe.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, ListEleve.class);
				startActivity(intent);
				finish();
			}
		});
	}*/
	public void initDB(){
	    //datasource.open();
	    /**
	     * TEST DE CREATION USER
	     * TEST DE SUPPRESSION USER
	     * TEST MODIFICATION MOT DE PASSE
	     */
		List<Matiere> list = new ArrayList<Matiere>();
		Matiere temp;
		String[][] tab = {
							{"Maths","5"},
							{"Anglais","3"},
							{"Langage C++","3"},
							{"Android","3"},
							{"IOS","2"}
						};
		int cpt = 0;
		while(cpt < tab.length){
				temp = new Matiere();
				temp.setNom(tab[cpt][0]);
				temp.setCoef(Integer.parseInt(tab[cpt][1]));
				list.add(temp);
				cpt++;
		}
		for(Matiere ts : list){
			//datasource.createMatiere(ts);
		}
		
	}
	public Context getCurrentContext(){
		return this;
	}
	
}

package esgi.directmoyenne;

import java.text.DecimalFormat;
import java.util.ArrayList;

import com.example.mamoyenne.R;

import esgi.modele.Matiere;
import esgi.modele.MySQLiteHelper;
import esgi.modele.Note;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

public class DashBoardActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);
		MySQLiteHelper db = new MySQLiteHelper(this);
		
		ArrayList<Matiere> matiere = new ArrayList<Matiere>(db.getAllMatieres());
		ArrayList<Note> ln;
		
		for (Matiere m:matiere){
			ln = new ArrayList<Note>(db.getNoteByIdMatiere(m.getId()));
			m.setNotes(ln);
			
		}
		
		ArrayAdapterMatiere monAdapter = new ArrayAdapterMatiere(this, R.layout.matiere_item , matiere);
		ListView lv = (ListView) findViewById(R.id.tb_layout);
		lv.setAdapter(monAdapter);
		
		TextView moyenneGene = (TextView) findViewById(R.id.moyenneGeneraleNote);
		moyenneGene.setText(getMoyenneGenerale(matiere));
		setupActionBar();
		
	}
	
	private void setupActionBar() {
		   getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dashboard, menu);
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
	
	/**
	 * Retourne la moyenne générale
	 * @param lm
	 * @return moyenne général format String
	 */
	public String getMoyenneGenerale( ArrayList<Matiere> lm){
		float total = 0;
		int cptCoef = 0;
		for(Matiere m : lm) {
			if(m.getMoyenne() != " "){
				cptCoef += m.getCoef();
				total +=  Float.parseFloat(m.getMoyenne()) * m.getCoef();
			}
		}
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(1);
		return df.format(total/cptCoef);
	}
	
}

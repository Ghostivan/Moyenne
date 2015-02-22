package esgi.directmoyenne;

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

public class DashBoardActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);
		MySQLiteHelper db = new MySQLiteHelper(this);
		
		ArrayList<Matiere> matiere = new ArrayList<Matiere>(db.getAllMatieres());
		
		for (Matiere m:matiere){
			m.setNotes(new ArrayList<Note>(db.getNoteByIdMatiere(m.getId())));
		}
		
		ArrayAdapterMatiere monAdapter = new ArrayAdapterMatiere(this, R.layout.matiere_item , matiere);
		ListView lv = (ListView) findViewById(R.id.tb_layout);
		lv.setAdapter(monAdapter);        
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

}

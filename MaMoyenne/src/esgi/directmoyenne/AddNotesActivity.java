package esgi.directmoyenne;

import java.util.List;

import com.example.mamoyenne.R;

import esgi.modele.Matiere;
import esgi.modele.MySQLiteHelper;
import esgi.modele.Note;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddNotesActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_notes);
		Spinner listMat = (Spinner) findViewById(R.id.listMatiere);
        ArrayAdapter<String> adapterMatiere = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, getValueMat());
        listMat.setAdapter(adapterMatiere);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_notes, menu);
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
	 * Validation de la note
	 * @param view
	 */
	public void validNotes(View view){
        final MySQLiteHelper db = new MySQLiteHelper(this);
		Button bt = (Button)findViewById(R.id.validNotes);
		final Spinner sp = (Spinner)findViewById(R.id.listMatiere);
		bt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				EditText note = (EditText)findViewById(R.id.edtNote);
				float currNote = Float.parseFloat(note.getText().toString());
				boolean flag = verifyNote(currNote);
				System.out.println("Note = "+note.getText().toString()+" ");
				System.out.println("Boolean = "+flag+" ");
				if( flag == false){
					Toast.makeText(AddNotesActivity.this, "La note est incorrect !", Toast.LENGTH_LONG).show();
				}else{
					Toast.makeText(AddNotesActivity.this, "La note est correct !", Toast.LENGTH_LONG).show();
					Matiere mt = db.getMatiereByName(sp.getSelectedItem().toString());
					Note nt = new Note(mt.getId(),currNote);
					db.addNote(nt);
				}
			}
		});
	}
	
	/**
	 * Retourne la valeur de la matière
	 * @return
	 */
	public String[] getValueMat(){
		MySQLiteHelper db = new MySQLiteHelper(this);
		List<Matiere> list = db.getAllMatieres();
		String[] tmp = new String[list.size()];
		for(int i=0;i<list.size();i++){

			tmp[i] = list.get(i).getNom();
		}
		return tmp;
	}
	
	/**
	 * Vérification de la note
	 * @param currNote
	 * @return true or false
	 */
	public boolean verifyNote(float currNote){
		if(currNote > 20){
			return false;
		}else if(currNote < 0){
			return false;
		}else{
			return true;
		}
	}
	
	
	/**
	 * Retour au menu
	 * @param view
	 */
	public void retourMenuNote(View view){
		Button bt = (Button)findViewById(R.id.retourNote);
		bt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent in = new Intent(AddNotesActivity.this,MainActivity.class);
				startActivity(in);
			}
		});
	}
}

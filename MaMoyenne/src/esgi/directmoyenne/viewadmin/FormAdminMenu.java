package esgi.directmoyenne.viewadmin;

import com.example.mamoyenne.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FormAdminMenu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_form_admin_menu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.form_admin_menu, menu);
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
	
	public void sendFormAdminSaisirEleve(View view) {
		System.out.println("Administrator Saisir Eleve Clicked !");
		Button btListe = (Button) findViewById(R.id.newStudent);
		btListe.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				
				//Test Login/Mdp pour connexion
				
				
				Intent intent = new Intent(FormAdminMenu.this, FormAdminSaisirEleve.class);
				startActivity(intent);
				finish();
			}
		});
	}
	
	public void sendFormAdminSaisirNote(View view) {
		System.out.println("Administrator Saisir Note Clicked !");
		Button btListe = (Button) findViewById(R.id.newNote);
		btListe.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(FormAdminMenu.this, FormAdminSaisirNote.class);
				startActivity(intent);
				finish();
			}
		});
	}
	
	public void sendFormAdminSaisirMatiere(View view) {
		System.out.println("Administrator Saisir Matiere Clicked !");
		Button btListe = (Button) findViewById(R.id.newMatiere);
		btListe.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(FormAdminMenu.this, FromAdminSaisirMatiere.class);
				startActivity(intent);
				finish();
			}
		});
	}
	
	public void sendFormAdminModifNote(View view) {
		System.out.println("Administrator Modifier Note Clicked !");
		Button btListe = (Button) findViewById(R.id.modifNote);
		btListe.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(FormAdminMenu.this, FormAdminModifierNote.class);
				startActivity(intent);
				finish();
			}
		});
	}


}

package esgi.directmoyenne;

import com.example.mamoyenne.R;
import esgi.modele.Matiere;
import esgi.modele.MySQLiteHelper;
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

public class AddMatiereActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_matiere);
		Spinner s = (Spinner) findViewById(R.id.coefMatiere);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, getValueCoef());
        s.setAdapter(adapter);
        setupActionBar();
	}
        
    private void setupActionBar() {
 		   getActionBar().setDisplayHomeAsUpEnabled(true);
    }
 

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_matiere, menu);
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

	public void validMatiere(View view){
        final MySQLiteHelper db = new MySQLiteHelper(this);
		Button bt = (Button)findViewById(R.id.validMatiere);
		final Spinner sp = (Spinner)findViewById(R.id.coefMatiere);
		final EditText nameMat = (EditText)findViewById(R.id.nomMatiere);	
		bt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(nameMat.getText().toString().length() > 0){
					Matiere ma = new Matiere(nameMat.getText().toString(),Integer.parseInt(sp.getSelectedItem().toString()));
					db.addMatiere(ma);
						Toast.makeText(AddMatiereActivity.this, "Matière "+nameMat.getText().toString()+" avec le coefficient "+sp.getSelectedItem().toString()+"est enregistrée", Toast.LENGTH_LONG).show();
						startActivity(new Intent(AddMatiereActivity.this,MainActivity.class));
					
				}else{
					Toast.makeText(AddMatiereActivity.this, "Le nom de la matière est incorrecte", Toast.LENGTH_LONG).show();
				}
			}
		});
	}
	public String[] getValueCoef(){
		String[] values = new String[13];
		for(int i=0;i<=12;i++){
			if(i == 0){
				values[i] = "Choisir un coefficient";
			}else{
				values[i] = Integer.toString(i);
			}
		}
		return values;
	}
}

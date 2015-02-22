package esgi.directmoyenne;

import com.example.mamoyenne.R;

import esgi.modele.MySQLiteHelper;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		MySQLiteHelper db = new MySQLiteHelper(this);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
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
	
	public void deleteAll(View view){
		
		Button bt = (Button)findViewById(R.id.bt_deleteAll);
		final MySQLiteHelper db = new MySQLiteHelper(this);
		bt.setOnClickListener(new View.OnClickListener() 
		{
			@Override
			public void onClick(View v) {
				
				db.onUpgrade(db.getReadableDatabase(),MySQLiteHelper.DATABASE_VERSION, MySQLiteHelper.DATABASE_VERSION+1);
				Toast.makeText(MainActivity.this, "Toutes les données ont étaient supprimés", Toast.LENGTH_LONG).show();
			}
		});
	}

//	public Context getCurrentContext(){
//		return this;
//	}
	
}

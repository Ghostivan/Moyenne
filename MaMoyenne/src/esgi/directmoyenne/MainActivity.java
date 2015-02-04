package esgi.directmoyenne;

import com.example.mamoyenne.R;

import esgi.directmoyenne.forms.FormAdministrator;
import esgi.directmoyenne.forms.FormStudent;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
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

	public void sendFormAdmin(View view) {
		System.out.println("Administrator Clicked !");
		Button btListe = (Button) findViewById(R.id.bt_admin);
		btListe.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,
						FormAdministrator.class);
				startActivity(intent);
				finish();
			}
		});
	}

	public void sendFormStudent(View view) {
		System.out.println("Student Clicked !");
		Button btListe = (Button) findViewById(R.id.bt_student);
		btListe.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, FormStudent.class);
				startActivity(intent);
				finish();
			}
		});
	}
}

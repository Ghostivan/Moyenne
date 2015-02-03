package esgi.directmoyenne.forms;

import esgi.directmoyenne.R;
import esgi.directmoyenne.R.id;
import esgi.directmoyenne.R.layout;
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

public class FormAdministrator extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_form_administrator);
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

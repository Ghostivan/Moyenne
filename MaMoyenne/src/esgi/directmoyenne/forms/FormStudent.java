package esgi.directmoyenne.forms;

import com.example.mamoyenne.R;

import esgi.directmoyenne.MainActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class FormStudent extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_form_student);
	}
	public void confirmStudent(View view) {
		System.out.println("Confirm Student Clicked !");
		Button btConfirm = (Button) findViewById(R.id.btConfirm);
		btConfirm.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				EditText name = (EditText) findViewById(R.id.txtStudentInput);
				System.out.println(name.getText());
			}
		});
	}
	
}

package esgi.directmoyenne;

import com.example.mamoyenne.R;
import com.example.mamoyenne.R.id;
import com.example.mamoyenne.R.layout;
import com.example.mamoyenne.R.menu;

import esgi.modele.Matiere;
import esgi.modele.MySQLiteHelper;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class DashBoardActivity extends Activity {
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);
		MySQLiteHelper db = new MySQLiteHelper(this);
		if(db.getAllMatieres().size() > 0){
			TableLayout tl =(TableLayout)findViewById(R.id.tb_layout);    
			TableRow tr;
			int sizeMat = db.getAllMatieres().size();
			int sizeCoef = db.getAllMatieres().size();
			int sizeNotes = db.getAllNotes().size();
			String[] column = {"   Coefficient   ","   Notes   ","   Moyenne   "};
			String[] matiere = new String[sizeMat];
			String[] coef = new String[sizeCoef];
			String[] notes = new String[sizeNotes];
			for(int i=0;i<matiere.length;i++){
				matiere[i] = db.getAllMatieres().get(i).getNom();
				coef[i] = Integer.toString(db.getAllMatieres().get(i).getCoef());
			/* tr = new TableRow(this);
				 TextView textview = (TextView)findViewById(R.id.colNameMatiere);
				 textview.setText(m.getNom());
				 tr.addView(textview);
				 tr.setLayoutParams(new LayoutParams( LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
				 tl.addView(tl, new TableLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			*/
			}
			ScrollView sv = new ScrollView(this);
		     TableLayout tableLayout = createTableLayout(matiere, column ,coef,sizeMat+1,sizeNotes+1, column.length+1);
		     HorizontalScrollView hsv = new HorizontalScrollView(this);
		     
		     hsv.addView(tableLayout);
		     sv.addView(hsv);
		     setContentView(sv);
		}
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
	 private TableLayout createTableLayout(String [] rv, String [] cv,String[] coef,int rowCount, int noteCount,int matCount) {
	     // 1) Create a tableLayout and its params
		 MySQLiteHelper db = new MySQLiteHelper(this);
		 TableLayout.LayoutParams tableLayoutParams = new TableLayout.LayoutParams();
	     TableLayout tableLayout = new TableLayout(this);
	     tableLayout.setBackgroundColor(Color.BLACK);

	     // 2) create tableRow params
	     TableRow.LayoutParams tableRowParams = new TableRow.LayoutParams();
	     tableRowParams.setMargins(2, 2, 2, 2);
	     tableRowParams.weight = 1;

	     for (int i = 0; i < rowCount; i++) {
	         // 3) create tableRow
	         TableRow tableRow = new TableRow(this);
	         tableRow.setBackgroundColor(Color.BLACK);
	         
		         for (int j= 0; j < matCount; j++) {
		             // 4) create textView
		             TextView textView = new TextView(this);
		           //  textView.setText(String.valueOf(j));
		             textView.setBackgroundColor(Color.WHITE);
		             textView.setGravity(Gravity.CENTER);
		             
		             String s1 = Integer.toString(i);
		    String s2 = Integer.toString(j);
		    String s3 = s1 + s2;
		    int id = Integer.parseInt(s3);
		    Log.d("TAG", "-___>"+id);
		    long idNoteMat = 0;
		              if (i ==0 && j==0){
		               textView.setText("     Matieres    ");
		               textView.setBackgroundColor(Color.CYAN);
		              } else if(i==0){
		               Log.d("TAAG", "set Column Headers");
		               textView.setBackgroundColor(Color.CYAN);
		               textView.setText(cv[j-1]);
		              }else if(j == 1 && j == i){
		            	  textView.setText(coef[i-1]);
		              }else if( j==1){
		            	 
		            	  textView.setText(coef[i-1]);
		              }else if( j==0){
		               Log.d("TAAG", "Set Row Headers");
		               textView.setText(rv[i-1]);
		              }else if(j == 2){
		            	  idNoteMat = db.getMatiereByName(rv[i-1]).getId();
		            	  textView.setText(String.valueOf(db.getNoteByIdMatiere((int)idNoteMat).getValue()));
		              // check id=23
		              /*if(id==23){
		                textView.setText("ID=23");
		                
		               }*/
		              }else{
		            	  textView.setText("   CN  ");
		              }
	
		             // 5) add textView to tableRow
		             tableRow.addView(textView, tableRowParams);
		         }

	         // 6) add tableRow to tableLayout
	         tableLayout.addView(tableRow, tableLayoutParams);
	     }

	     return tableLayout;
	 }
}

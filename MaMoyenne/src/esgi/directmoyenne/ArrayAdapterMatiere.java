package esgi.directmoyenne;

import java.util.ArrayList;

import com.example.mamoyenne.R;

import esgi.modele.Matiere;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class ArrayAdapterMatiere extends ArrayAdapter<Matiere> {

	Context mContext;
	int layoutResourceId;
	ArrayList<Matiere> data = new ArrayList<Matiere>();
	
	public ArrayAdapterMatiere(Context mContext, int layoutResourceId,
			ArrayList<Matiere> data) {

		super(mContext, layoutResourceId, data);
		this.layoutResourceId = layoutResourceId;
		this.mContext = mContext;
		this.data = data;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		//Crée la vue si jamais exister
		if (convertView == null) {
			LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
			convertView = inflater.inflate(layoutResourceId, parent, false);
		}

		// Récuparation de la matiere
		Matiere matiere = data.get(position);

		// get the TextView and then set the text (item name) and tag (item ID)
		TextView textViewMatiere = (TextView) convertView.findViewById(R.id.matiere);
		textViewMatiere.setText(matiere.getNom());
		
		TextView textViewCoef = (TextView) convertView.findViewById(R.id.coef);
		textViewCoef.setText(matiere.getCoef());
		
		TextView textViewNotes = (TextView) convertView.findViewById(R.id.notes);
		textViewNotes.setText(matiere.getMesNotes());
		
		TextView textViewMoyenne = (TextView) convertView.findViewById(R.id.moyenne);
		textViewMoyenne.setText(matiere.getMoyenne());

		return convertView;

	}

}

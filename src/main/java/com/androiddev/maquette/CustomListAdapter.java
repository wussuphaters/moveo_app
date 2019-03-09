package com.androiddev.maquette;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter {

    private final Activity context;
    //private final Integer[] imageIDArray;
   // private final String[] nameArray;
    private ArrayList<Sportif> sportifs;

    public CustomListAdapter(Activity context, ArrayList<Sportif> sportifs) {
        super(context,R.layout.listview_roll,sportifs);
        this.context=context;
        this.sportifs=sportifs;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listview_roll, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView nameTextField = (TextView) rowView.findViewById(R.id.prenom);
        TextView ageTextField = (TextView) rowView.findViewById(R.id.age);
        TextView distanceTextField = (TextView) rowView.findViewById(R.id.distance);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        RatingBar noteBar = (RatingBar) rowView.findViewById(R.id.note);

        //this code sets the values of the objects to values from the arrays
        nameTextField.setText(String.valueOf(sportifs.get(position).getPrenom())+",");
        distanceTextField.setText(String.valueOf(sportifs.get(position).getDistance())+" Km");
        ageTextField.setText(String.valueOf(sportifs.get(position).getAge()));
        imageView.setImageResource(sportifs.get(position).getImage());
        noteBar.setRating(sportifs.get(position).getNote());

        return rowView;

    }
}

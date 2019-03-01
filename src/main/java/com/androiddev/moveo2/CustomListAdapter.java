package com.androiddev.moveo2;

import android.app.Activity;
import android.media.Rating;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter {

    private final Activity context;
    private final Integer[] imageIDArray;
    private final String[] nameArray;
    private final Integer[] ageArray;
    private final Integer[] levelArray;
    private final String[] distanceArray;
    private final String[] sportArray;
    private final Integer[] noteArray;

    public CustomListAdapter(Activity context,Integer[] imageIDArray,String[] nameArray,Integer[] ageArray,Integer[] levelArray,String[] distanceArray,String[] sportArray,Integer[] noteArray) {
        super(context,R.layout.listview_roll,nameArray);

        this.context=context;
        this.ageArray=ageArray;
        this.distanceArray=distanceArray;
        this.levelArray=levelArray;
        this.imageIDArray=imageIDArray;
        this.sportArray=sportArray;
        this.nameArray=nameArray;
        this.noteArray=noteArray;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listview_roll, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView nameTextField = (TextView) rowView.findViewById(R.id.prenom);
        TextView ageTextField = (TextView) rowView.findViewById(R.id.prenom);
        TextView levelTextField = (TextView) rowView.findViewById(R.id.prenom);
        TextView distanceTextField = (TextView) rowView.findViewById(R.id.prenom);
        TextView sportTextField = (TextView) rowView.findViewById(R.id.prenom);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        RatingBar noteBar = (RatingBar) rowView.findViewById(R.id.note);

        //this code sets the values of the objects to values from the arrays
        nameTextField.setText(nameArray[position]);
        ageTextField.setText(ageArray[position]);
        levelTextField.setText(levelArray[position]);
        distanceTextField.setText(distanceArray[position]);
        sportTextField.setText(sportArray[position]);
        imageView.setImageResource(imageIDArray[position]);
        noteBar.setRating(noteArray[position]);

        return rowView;

    };
}

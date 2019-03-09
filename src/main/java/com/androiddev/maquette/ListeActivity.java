package com.androiddev.maquette;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListeActivity extends AppCompatActivity {
    private ArrayList<Sportif> sportifs;
    ArrayList<Sportif>sportSelection;
    Spinner spinnerSport;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_resultats);
       final Intent detail=new Intent(this,DetailActivity.class);
        ListView liste=(ListView)findViewById(R.id.liste);
        sportifs = Sportif.initialisation();
        sportSelection = new ArrayList<>();
        Bundle extras = getIntent().getExtras();

        String sportSelectionner = extras.getString("sportSelectionner");
        int distanceMax=extras.getInt("distanceMax");

       for (Sportif sportif:sportifs) {
           for(String sport:sportif.getSport()) {
               if(sport.equals(sportSelectionner) && sportif.getDistance()<=distanceMax){
                   sportSelection.add(sportif);
               }
           }
       }
       if(!sportSelection.isEmpty()){

           CustomListAdapter adapter=new CustomListAdapter(this,/*,images,*/sportSelection);
           liste.setAdapter(adapter);
       }
       else
       {
           Toast.makeText(this, "Aucun résultat", Toast.LENGTH_SHORT).show();
       }

       liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               detail.putExtra("sportif",sportSelection.get(position));
               startActivity(detail);
           }
       });
    }
}

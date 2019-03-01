package com.androiddev.moveo2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListeActivity extends AppCompatActivity {
    private ArrayList<Sportif> sportifs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_resultats);

        ListView liste=(ListView)findViewById(R.id.liste);

    }
}

package com.example.brandon.app1.View;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.brandon.app1.MainActivity;
import com.example.brandon.app1.Model.MovieAdapter;
import com.example.brandon.app1.Model.Movies;
import com.example.brandon.app1.R;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    MovieAdapter oMovieAdapter;
    ListView oListView;
    ArrayList<Movies> movieDataArray;
    int counter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        Toast.makeText(this, "Click movie to delete", Toast.LENGTH_LONG).show();

        oListView= (ListView) findViewById(R.id.moviesListView);
        oMovieAdapter = new MovieAdapter(this);
        oListView.setAdapter(oMovieAdapter);

        //ArrayList<Movies> movieDataArray  = (ArrayList<Movies>) getIntent().getSerializableExtra("data");
        movieDataArray  = getIntent().getParcelableArrayListExtra("data");

        fillMovieData(movieDataArray);

        oListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                oMovieAdapter.remove(movieDataArray.get(i));
                movieDataArray.remove(i);
                oMovieAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onBackPressed() {
        returnStuff(movieDataArray);
    }

    private void fillMovieData(ArrayList<Movies> lMovies)
    {
        oMovieAdapter.clear();

        for (Movies oMovie : lMovies){
            oMovieAdapter.add(oMovie);
        }
        oMovieAdapter.notifyDataSetChanged();
    }

    public void returnStuff(ArrayList<Movies> currentList){
        Intent myIntent = new Intent();
        myIntent.putExtra("arrayListUpdt", currentList);
        setResult(Activity.RESULT_OK, myIntent);
        finish();
    }
}


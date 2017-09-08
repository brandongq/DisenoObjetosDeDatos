package com.example.brandon.app1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.brandon.app1.Model.Movies;
import com.example.brandon.app1.View.ListViewActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Movies> movieDataArray = new ArrayList<Movies>();
    public static final int RETURN_CODE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMoviesAct = (Button) findViewById(R.id.btnMoviesAct);
        Button btnAddMovie = (Button) findViewById(R.id.btnAddMovie);
        Button btnDeleteMovies = (Button) findViewById(R.id.btnDeleteMovies);

        btnAddMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tvName = (TextView) findViewById(R.id.tbName);
                TextView tvDuration = (TextView) findViewById(R.id.tbDuration);
                TextView tvGenre = (TextView) findViewById(R.id.tbGenre);
                TextView tvDirector = (TextView) findViewById(R.id.tbDirector);
                TextView tvYear = (TextView) findViewById(R.id.tbYear);

                String name = tvName.getText().toString();
                int duration = Integer.parseInt(tvDuration.getText().toString());
                String genre  = tvGenre.getText().toString();
                String director= tvDirector.getText().toString();
                int year = Integer.parseInt(tvYear.getText().toString());

                movieDataArray.add(new Movies(name, duration, director, genre, year));

                tvName.setText("");
                tvDuration.setText("");
                tvGenre.setText("");
                tvDirector.setText("");
                tvYear.setText("");
                tvName.requestFocus();

            }
        });

        btnMoviesAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListViewActivity.class);
                intent.putExtra("data", movieDataArray);
                //startActivity(intent);
                startActivityForResult(intent, RETURN_CODE);
            }
        });

        btnDeleteMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movieDataArray.clear();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == RETURN_CODE && data != null){
            movieDataArray = data.getParcelableArrayListExtra("arrayListUpdt");
        }
    }


}

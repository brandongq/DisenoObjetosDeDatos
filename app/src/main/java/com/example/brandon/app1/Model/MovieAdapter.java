package com.example.brandon.app1.Model;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.brandon.app1.R;

import java.util.ArrayList;

/**
 * Created by Brandon on 25-Aug-17.
 */

public class MovieAdapter extends ArrayAdapter<Movies> {

    public MovieAdapter(Context context) {
        super(context, R.layout.movie_row, R.id.txtViewName);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull final ViewGroup parent) {
        final View oView = super.getView(position, convertView, parent);

        TextView txtViewName = (TextView) oView.findViewById(R.id.txtViewName);
        TextView txtViewDuration = (TextView) oView.findViewById(R.id.txtViewDuration);
        TextView txtViewDirector = (TextView) oView.findViewById(R.id.txtViewDirector);
        TextView txtViewGenre = (TextView) oView.findViewById(R.id.txtViewGenre);
        TextView txtViewYear = (TextView) oView.findViewById(R.id.txtViewYear);

        Movies oMovie = this.getItem(position);

        txtViewName.setText(oMovie.getNombre());
        txtViewDirector.setText(oMovie.getDirector());
        txtViewDuration.setText(oMovie.getDuracion() + "");
        txtViewGenre.setText(oMovie.getGenero());
        txtViewYear.setText(oMovie.getYear() + "");

        return oView;
    }
}

package com.jiadibo.digitalentsandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Movie> movies;

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public MovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false);
        }

        ViewHolder viewholder = new ViewHolder(convertView);
        Movie movie = (Movie) getItem(position);
        viewholder.bind(movie);

        return convertView;
    }

    private class ViewHolder {
        private TextView tvName, tvDesc;
        private ImageView imgMovie;

        ViewHolder(View view) {
            tvName = view.findViewById(R.id.tv_name);
            tvDesc = view.findViewById(R.id.tv_desc);
            imgMovie = view.findViewById(R.id.img_movie);
        }

        void bind(Movie movie) {
            tvName.setText(movie.getName());
            tvDesc.setText(movie.getDescription());
            imgMovie.setImageResource(movie.getPhoto());
        }
    }


}

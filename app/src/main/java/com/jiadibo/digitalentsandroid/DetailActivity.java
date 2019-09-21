package com.jiadibo.digitalentsandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView tvName, tvDesc;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvName = findViewById(R.id.tvName);
        tvDesc = findViewById(R.id.tvDesc);
        imageView = findViewById(R.id.imgMovie);

        Intent intent = getIntent();
        Movie movie = intent.getExtras().getParcelable("moview");

        Log.e("MESEGE MOVIE", "DATA :" + movie.getName());

        String name = movie.getName();
        String desc = movie.getDescription();
        Integer photo = movie.getPhoto();

        tvName.setText(name);
        tvDesc.setText(desc);
        imageView.setImageResource(photo);

    }
}

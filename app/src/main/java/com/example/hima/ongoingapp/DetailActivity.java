package com.example.hima.ongoingapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {


    Toolbar mToolbar5 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mToolbar5 = (Toolbar) findViewById(R.id.toolbar4);

        setSupportActionBar(mToolbar5);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        TextView mTitle = (TextView) mToolbar5.findViewById(R.id.text5);
        Typeface tf =  Typeface.createFromAsset(getAssets(),"Pokemon Solid.ttf");
        mTitle.setTypeface(tf);

        TextView v = (TextView)findViewById(R.id.textDetail);
        v.setTypeface(tf);

        ImageView im = (ImageView)findViewById(R.id.profilePokemonImage);

       Intent intent = getIntent();
        String value = intent.getStringExtra("someKey");

        int image = intent.getIntExtra("intKey",0);

        mTitle.setText(value);
        im.setImageResource(image);

        if(value.equals("Totodile")){
            Toast.makeText(this, "Totodile", Toast.LENGTH_SHORT).show();
            v.setText("thiiiiiiiiiiiiiiiiiiiiiiis\niiiiiiiiiiiiiiiiiiiiiiiiiiiiis \nToooooooooooooooooooootodile\n ");
            //
        }
        if(value.equals("Cyndaquil")){

            v.setText("thiiiiiiiiiiiiiiiiiiiiiiis\niiiiiiiiiiiiiiiiiiiiiiis \nCyndaaaaaaaaaaaaaaaaaaaaaaaauiilt\n ");
        }
        if(value.equals("Chickorita")){
            Toast.makeText(this, "Totodile", Toast.LENGTH_SHORT).show();
            v.setText("thiiiiiiiiiiiiiiiiiiiiiiis\niiiiiiiiiiiiiiiiiiiiiiiiiiiiis \nchickoriiiiiiiiiiiiiiiiitaaa\n ");
            //
        }
        if(value.equals("Squirtle")){

            v.setText("thiiiiiiiiiiiiiiiiiiiiiiis\niiiiiiiiiiiiiiiiiiiiiiis \nSquirtleeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee\n ");
        }

        if(value.equals("Treeko")){

            v.setText("thiiiiiiiiiiiiiiiiiiiiiiis\niiiiiiiiiiiiiiiiiiiiiiis \nTreeeeeeeeeeeeeeeekoooooo\n ");
        }








    }
}

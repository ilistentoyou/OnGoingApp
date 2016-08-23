package com.example.hima.ongoingapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class Profile extends AppCompatActivity {


    final int PICK_IMAGE_REQUEST = 0;

    Toolbar mToolbarProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mToolbarProfile = (Toolbar) findViewById(R.id.toolbarProfile);

        setSupportActionBar(mToolbarProfile);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        TextView mTitle = (TextView) mToolbarProfile.findViewById(R.id.textProfile);
        Typeface tf = Typeface.createFromAsset(getAssets(), "Pokemon Solid.ttf");
        mTitle.setTypeface(tf);

        TextView v = (TextView) findViewById(R.id.nameProfile);
        v.setTypeface(tf);

        TextView v2 = (TextView) findViewById(R.id.emailProfile);
        v2.setTypeface(tf);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();

        if (i == R.id.changePicture) {

            Intent intent = new Intent();
// Show only images, no videos or anything else
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
// Always show the chooser (if there are multiple options available)
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);


        }

        if (i == R.id.pokemons) {
            Intent cn = new Intent(getApplicationContext(), Pokemons.class);
            startActivity(cn);
        }

        if (i == R.id.log_outt) {
            Intent n = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(n);
        }


        return true;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri uri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                // Log.d(TAG, String.valueOf(bitmap));

                ImageView imageView = (ImageView) findViewById(R.id.imageProfile);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}




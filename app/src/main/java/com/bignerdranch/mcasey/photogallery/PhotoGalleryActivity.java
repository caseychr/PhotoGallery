package com.bignerdranch.mcasey.photogallery;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PhotoGalleryActivity extends AppCompatActivity {

    public static Intent newIntent(Context context)
    {
        return new Intent(context, PhotoGalleryActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_gallery);

        // FragmentManager is where we link fragments to activities
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if(fragment == null)
        {
            //We call what fragment we want to use with this activity
            fragment = PhotoGalleryFragment.newInstance();
            // fragment_container is the id of the layout xml for this activity
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }
}

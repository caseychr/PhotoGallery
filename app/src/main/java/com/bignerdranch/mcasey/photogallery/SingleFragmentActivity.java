package com.bignerdranch.mcasey.photogallery;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public abstract class SingleFragmentActivity extends AppCompatActivity
{
    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        // FragmentManager is where we link fragments to activities
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if(fragment == null)
        {
            //We call what fragment we want to use with this activity
            fragment = createFragment();
            // fragment_container is the id of the layout xml for this activity
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }
}

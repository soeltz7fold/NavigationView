package com.example.droid.navigationview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by X7A on 10/04/2016.
 */
public class ProfilePage extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle SavedInstanceState){
        return inflater.inflate(R.layout.content_profile, container, false);
//        judul.setText("Halaman: " + A.getStringExtra("info"));
//        Toast.makeText(ProfilePage.this, "Here", Toast.LENGTH_LONG);
    }

}

package com.example.droid.navigationview;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Intent A, B, C, D;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.kick_me){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();
        if (id == R.id.home){
//            switch (item.getItemId()){}
//            A = new Intent(this, HomePage.class);
//            startActivity(A);
            Fragment FG = new HomePage();
            FragmentManager FM = getSupportFragmentManager();
            FragmentTransaction FT = FM.beginTransaction();
            Bundle bundle= new Bundle();
            FG.setArguments(bundle);
            FT.replace(R.id.fragment_place, FG);
            FT.commit();
            Toast.makeText(getApplicationContext(), "Anda Berada di halaman HomePage", Toast.LENGTH_SHORT)
                    .show();
            TextView hello = (TextView)findViewById(R.id.txtHome);


        } else if (id == R.id.profile) {
            Fragment FG = new ProfilePage();
            FragmentManager FM = getSupportFragmentManager();
            FragmentTransaction FT = FM.beginTransaction();
            Bundle bundle = new Bundle();
            FG.setArguments(bundle);
            FT.replace(R.id.fragment_place, FG);
            FT.commit();
            Toast.makeText(MainActivity.this, "Anda Berada di halaman Profile", Toast.LENGTH_SHORT)
            .show();

        } else if (id == R.id.contact) {
            Fragment FG = new ContactPage();
            FragmentManager FM = getSupportFragmentManager();
            FragmentTransaction FT =FM.beginTransaction();
            Bundle bundle = new Bundle();
            FG.setArguments(bundle);
            FT.replace(R.id.fragment_place, FG);
            FT.commit();
            Toast.makeText(MainActivity.this, "Anda Berada di halaman Contact", Toast.LENGTH_SHORT)
            .show();

        } else if (id == R.id.exit) {
//            Toast.makeText(MainActivity.this, "Apakah Anda Yakin Keluar Aplikasi?", Toast.LENGTH_LONG)
//                    .show();
            finish();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

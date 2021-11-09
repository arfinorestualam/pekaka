package com.example.peluangkerja;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigation = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment fragment;
            switch (menuItem.getItemId()) {
                case R.id.navigation_home:
                    fragment = new FilmFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.nav_host_fragment,fragment,fragment.getClass().getSimpleName())
                            .commit();
                    return true;

                case R.id.navigation_notifications:
                    fragment = new FavoriteFragment();

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.nav_host_fragment,fragment,fragment.getClass().getSimpleName())
                            .commit();
                    return true;

                case R.id.navigation_dashboard:
                    fragment = new TvShowFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.nav_host_fragment,fragment,fragment.getClass().getSimpleName())
                            .commit();

                case R.id.navigation_profile:
                    fragment = new TvShowFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.nav_host_fragment,fragment,fragment.getClass().getSimpleName())
                            .commit();
                    return true;


            }
            return false;
        }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        navView.setOnNavigationItemSelectedListener( onNavigation);
        if (savedInstanceState == null) {
            navView.setSelectedItemId(R.id.navigation_home);
        }}

}
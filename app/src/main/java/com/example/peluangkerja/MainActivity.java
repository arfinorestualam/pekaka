package com.example.peluangkerja;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.peluangkerja.Fragment.homeFragment;
import com.example.peluangkerja.Fragment.listJobFragment;
import com.example.peluangkerja.Fragment.notificationFragment;
import com.example.peluangkerja.Fragment.profileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigation = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment fragment;
            switch (menuItem.getItemId()) {
                case R.id.navigation_home:
                    fragment = new homeFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.nav_host_fragment,fragment,fragment.getClass().getSimpleName())
                            .commit();

                    return true;

                case R.id.navigation_notifications:
                    fragment = new listJobFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.nav_host_fragment,fragment,fragment.getClass().getSimpleName())
                            .commit();
                    return true;

                case R.id.navigation_dashboard:
                    fragment = new notificationFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.nav_host_fragment,fragment,fragment.getClass().getSimpleName())
                            .commit();
                    return true;

                case R.id.navigation_profile:
                    fragment = new profileFragment();
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

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.notification, menu);
//        Fragment whichFragment = getVisibleFragment();//getVisible method return current visible fragment
//        String shareVisible=whichFragment.getClass().toString();
//        if(shareVisible.equals(notificationFragment.class.toString())
//                ||shareVisible.equals(profileFragment.class.toString())
//                )
//        {
//            MenuItem item=menu.findItem(R.id.notification);
//            item.setVisible(false);
//        }
//        return super.onCreateOptionsMenu(menu);
//    }
//    public Fragment getVisibleFragment(){
//        FragmentManager fragmentManager = MainActivity.this.getSupportFragmentManager();
//        List<Fragment> fragments = fragmentManager.getFragments();
//        if(fragments != null){
//            for(Fragment fragment : fragments){
//                if(fragment != null && fragment.isVisible())
//                    return fragment;
//            }
//        }
//        return null;
//    }
}
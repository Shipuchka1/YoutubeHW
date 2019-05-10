package com.example.youtubehw;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements Mainfragment.OnFragmentInteractionListener,
        TrendsFragment.OnFragmentInteractionListener,
        FollowsFragment.OnFragmentInteractionListener,
        LibraryFragment.OnFragmentInteractionListener,
        InputFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.main:
                    loadFragment(Mainfragment.newInstance());
                    return true;
                case R.id.trend:
                    loadFragment(TrendsFragment.newInstance());
                    return true;
                case R.id.follows:
                    loadFragment(FollowsFragment.newInstance());
                    return true;
                case R.id.input:
                    loadFragment(InputFragment.newInstance());
                    return true;
                case R.id.library:
                    loadFragment(LibraryFragment.newInstance());
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fl_content, fragment);
        ft.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

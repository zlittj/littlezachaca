package com.zachlittle.android.aca.filmsearch;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                Fragment fragment = new SearchDialogFragment();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragHolder, fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment = new MainFragment();
        fragmentManager.beginTransaction()
                .replace(R.id.fragHolder, fragment)
                .addToBackStack(null)
                .commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_reset) {
            FragmentManager fragmentManager = getFragmentManager();
            Fragment fragment = new MainFragment();
            Bundle bundle = new Bundle();
            bundle.putString("search", "");
            fragment.setArguments(bundle);
            fragmentManager.beginTransaction()
                    .replace(R.id.fragHolder, fragment)
                    .addToBackStack(null)
                    .commit();

            return true;

        }

        return super.onOptionsItemSelected(item);
    }
}
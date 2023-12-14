package com.example.our_graduationproject.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.our_graduationproject.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navBar = (BottomNavigationView) findViewById(R.id.bottomNavigationView);


        // Initialize and assign variable

        // Set Home selected
        navBar.setSelectedItemId(R.id.placeholder);

        // Perform item selected listener
        navBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.gallary:
                        startActivity(new Intent(getApplicationContext(),firstt.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });

    }
}


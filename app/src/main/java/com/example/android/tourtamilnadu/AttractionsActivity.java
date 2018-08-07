package com.example.android.tourtamilnadu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Meenakshi on 8/6/2018.
 */

public class AttractionsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new AttractionsFragment())
                .commit();
    }
}




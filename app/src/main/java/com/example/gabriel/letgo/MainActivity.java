package com.example.gabriel.letgo;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager slider = findViewById(R.id.container);
        CustPageAdapter adapter = new CustPageAdapter(getSupportFragmentManager());
        slider.setAdapter(adapter);
        slider.setCurrentItem(1);


    }
}

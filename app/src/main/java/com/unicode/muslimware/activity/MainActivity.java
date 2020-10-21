package com.unicode.muslimware.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.unicode.muslimware.R;
import com.unicode.muslimware.fragment.FragmentMain1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // start fragment main (default theme)
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fl_main, new FragmentMain1());
        ft.commit();


        Intent intentSettingActivity = new Intent(MainActivity.this,SettingActivity.class);
        startActivity(intentSettingActivity);
    }
}
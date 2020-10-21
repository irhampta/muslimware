package com.unicode.muslimware.activity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.unicode.muslimware.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Intent intentMainActivity = new Intent(SplashActivity.this,MainActivity.class);
        startActivity(intentMainActivity);

    }
}
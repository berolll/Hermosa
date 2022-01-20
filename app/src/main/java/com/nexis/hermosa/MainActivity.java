package com.nexis.hermosa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread logoAnimation=new Thread() {
            @Override
            public void run() {
                ImageView logo = findViewById(R.id.hermosa);
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animasyon);
                logo.startAnimation(animation);
            }
        };
        logoAnimation.start();

        Thread heps=new Thread() {
            public void run() {
                try {
                    sleep(3500);
                    Intent i=new Intent(MainActivity.this, MapsActivity.class);
                    startActivity(i);
                    finish();
                    super.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        heps.start();

    }

}
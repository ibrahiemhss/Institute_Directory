package com.directory.institute.institute_directory;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.io.IOException;

import pl.droidsonroids.gif.AnimationListener;
import pl.droidsonroids.gif.GifDrawable;

public class SplashActivity extends AppCompatActivity {
   private ImageView splash;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final RotateAnimation rotate = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(1000);
        rotate.setInterpolator(new LinearInterpolator());
        splash = (ImageView) findViewById(R.id.imgLogo);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                splash.animate().rotationBy(360).withEndAction(this).setDuration(3000).setInterpolator(new LinearInterpolator()).start();
            }
        };

        splash.animate().rotationBy(360).withEndAction(runnable).setDuration(3000).setInterpolator(new LinearInterpolator()).start();


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {

                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                handler.postDelayed(this, 120000); //now is every 2 minutes
            }
        }, 6000); //Every 120000 ms (2 minutes)    }

    }

}
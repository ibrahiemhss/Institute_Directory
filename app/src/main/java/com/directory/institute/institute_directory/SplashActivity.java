package com.directory.institute.institute_directory;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
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
import android.widget.TextView;

import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;
import pl.droidsonroids.gif.AnimationListener;
import pl.droidsonroids.gif.GifDrawable;

public class SplashActivity extends AppCompatActivity {
   private CircleImageView splash;
   private TextView mTextView;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splash = findViewById(R.id.imgLogo);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                splash.animate().rotationBy(360).withEndAction(this).setDuration(3000).setInterpolator(new LinearInterpolator()).start();
            }
        };
        Slide slide1 = (Slide) findViewById(R.id.slide);
        slide1.setText(getResources().getString(R.string.app_name));

        Slide slide2 = (Slide) findViewById(R.id.slide2);
        slide2.setBackgroundColor(getResources().getColor(R.color.white));
        slide2.setTextColor(getResources().getColor(R.color.black));
        slide2.setText(getResources().getString(R.string.app_name));

        splash.animate().rotationBy(360).withEndAction(runnable).setDuration(3000).setInterpolator(new LinearInterpolator()).start();


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {

                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                onBackPressed();

                handler.postDelayed(this, 120000); //now is every 2 minutes
            }
        }, 6000); //Every 120000 ms (2 minutes)    }



    }

}
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

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import pl.droidsonroids.gif.AnimationListener;
import pl.droidsonroids.gif.GifDrawable;

import static com.directory.institute.institute_directory.DetailsActivity.EXRA_PDF_VALUES;

public class SplashActivity extends AppCompatActivity {

    @SuppressWarnings("WeakerAccess")
    @BindView(R.id.imgLogo)
   protected CircleImageView splash;
   private TextView mTextView;
    public final static String EXRA_OPEN_VALUES = "extra_open";
    public   Runnable runnable;
    public  Handler handler;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);



    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)

    @Override
    protected void onResume() {
        super.onResume();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            if(extras.getInt(EXRA_OPEN_VALUES)==1) {
                extras.putInt(EXRA_OPEN_VALUES,0);
                finish();
            }
            else {
                initAnimation();
            }

        }else {
            initAnimation();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (handler != null&&runnable!=null) {
            handler.removeCallbacks(runnable);

        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (handler != null&&runnable!=null) {
            handler.removeCallbacks(runnable);

        }

    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)

    public void initAnimation(){
        runnable = new Runnable() {
            @Override
            public void run() {
                splash.animate().rotationBy(360).withEndAction(this).setDuration(3000).setInterpolator(new LinearInterpolator()).start();
            }
        };

        splash.animate().rotationBy(360).withEndAction(runnable).setDuration(3000).setInterpolator(new LinearInterpolator()).start();


        handler = new Handler();
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
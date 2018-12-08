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
import android.widget.Toast;

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
    public Runnable runnable;
    public Handler handler;
    private boolean isOpen = false;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);


        isOpen = SharedPrefManager.getInstance(this).isOpen();
        if (isOpen) {
            SplashActivity.this.finish();
        } else {
            initAnimation();
        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPrefManager.getInstance(SplashActivity.this).setOpen(false);

    }


    @Override
    protected void onPause() {
        super.onPause();
        SharedPrefManager.getInstance(SplashActivity.this).setOpen(true);

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPrefManager.getInstance(SplashActivity.this).setOpen(false);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        SharedPrefManager.getInstance(SplashActivity.this).setOpen(true);

    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPrefManager.getInstance(SplashActivity.this).setOpen(false);

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void initAnimation() {

        splash.animate().rotationBy(360).setDuration(3000).setInterpolator(new LinearInterpolator()).withEndAction(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
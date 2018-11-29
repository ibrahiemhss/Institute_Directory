package com.directory.institute.institute_directory;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private final static String TAG = MainActivity.class.getSimpleName();

    @SuppressWarnings("WeakerAccess")
    @BindView(R.id.drawer_layout)
    protected DrawerLayout mDrawerLayout;
    @SuppressWarnings("WeakerAccess")
    @BindView(R.id.maintoolbar)
    protected Toolbar mToolbar;
    @SuppressWarnings("WeakerAccess")
    @BindView(R.id.nav_view)
    protected NavigationView mNavigationView;
    private Boolean isOpen1=false,isOpen2=false;
    private Intent intent;
    private Bundle extras;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        isOpen1=false;
        isOpen2=false;
        setUpToolbar();


    }



    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void setUpToolbar() {

        setSupportActionBar(mToolbar);
        mToolbar.setLogoDescription(getResources().getString(R.string.app_name));//to show title inside  toolbar
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                //to make animation with action with close and open NavigationView with DrawerLayout
                this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        mNavigationView.setNavigationItemSelectedListener(this);
       // initNavigationDrawer(this,mNavigationView);

    }

    @Override
    public void onBackPressed() {//to make arrow back icon in toolbar to open and close DrawerLayout

        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            onBackPressed();

            finish();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {
            case R.id.txt_Institute:
                 intent = new Intent(MainActivity.this, DetailsActivity.class);
                 extras = new Bundle();

                extras.putInt(DetailsActivity.EXRA_PDF_VALUES,1);
                intent.putExtras(extras);
                startActivity(intent);

                break;



            case R.id.txt_Directors:
                intent = new Intent(MainActivity.this, DetailsActivity.class);
                extras = new Bundle();

                extras.putInt(DetailsActivity.EXRA_PDF_VALUES,2);
                intent.putExtras(extras);
                startActivity(intent);
                break;

            case R.id.txt_Certifications_Section:
                intent = new Intent(MainActivity.this, DetailsActivity.class);
                extras = new Bundle();

                extras.putInt(DetailsActivity.EXRA_PDF_VALUES,3);
                intent.putExtras(extras);
            //    startActivity(intent);
                break;

            case R.id.txt_library:
                intent = new Intent(MainActivity.this, DetailsActivity.class);
                extras = new Bundle();

                extras.putInt(DetailsActivity.EXRA_PDF_VALUES,4);
                intent.putExtras(extras);
             //   startActivity(intent);
                break;

            case R.id.txt_General_Registrar:
                intent = new Intent(MainActivity.this, DetailsActivity.class);
                extras = new Bundle();

                extras.putInt(DetailsActivity.EXRA_PDF_VALUES,5);
                intent.putExtras(extras);
            //    startActivity(intent);
                break;

            case R.id.txt_Study_and_Examinations:
                intent = new Intent(MainActivity.this, DetailsActivity.class);
                extras = new Bundle();

                extras.putInt(DetailsActivity.EXRA_PDF_VALUES,6);
                intent.putExtras(extras);
               // startActivity(intent);
                break;

            case R.id.txt_Admission_Section:
                intent = new Intent(MainActivity.this, DetailsActivity.class);
                extras = new Bundle();

                extras.putInt(DetailsActivity.EXRA_PDF_VALUES,7);
                intent.putExtras(extras);
                startActivity(intent);
                break;

            case R.id.txt_Graduates:
                intent = new Intent(MainActivity.this, DetailsActivity.class);
                extras = new Bundle();

                extras.putInt(DetailsActivity.EXRA_PDF_VALUES,8);
                intent.putExtras(extras);
                startActivity(intent);
                break;

            case R.id.txt_Student_Affairs:
                intent = new Intent(MainActivity.this, DetailsActivity.class);
                extras = new Bundle();

                extras.putInt(DetailsActivity.EXRA_PDF_VALUES,9);
                intent.putExtras(extras);
                startActivity(intent);
                break;

            case R.id.txt_about_app:
                intent = new Intent(MainActivity.this, DetailsActivity.class);
                extras = new Bundle();

                extras.putInt(DetailsActivity.EXRA_PDF_VALUES,10);
                intent.putExtras(extras);
                startActivity(intent);

                break;




        }
        //close navigation drawer
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }



}

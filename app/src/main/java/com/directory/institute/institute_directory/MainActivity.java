package com.directory.institute.institute_directory;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @SuppressWarnings("WeakerAccess")
    @BindView(R.id.drawer_layout)
    protected DrawerLayout mDrawerLayout;
    @SuppressWarnings("WeakerAccess")
    @BindView(R.id.maintoolbar)
    protected Toolbar mToolbar;
    @SuppressWarnings("WeakerAccess")
    @BindView(R.id.nav_view)
    protected NavigationView mNavigationView;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

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

    }

    @Override
    public void onBackPressed() {//to make arrow back icon in toolbar to open and close DrawerLayout

        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}

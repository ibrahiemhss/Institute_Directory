package com.directory.institute.institute_directory;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity{
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
    String[] res1,res2;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        isOpen1=false;
        isOpen2=false;
        setUpToolbar();

        res1=getResources().getStringArray(R.array.Scientific_Affairs);

        res2=getResources().getStringArray(R.array.General_Registrar);

        initNavigationDrawer(this,mNavigationView);



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
         //   SharedPrefManager.getInstance(this).setOpen(false);

            finish();

        }
    }



    public void initNavigationDrawer(final Context context, final NavigationView navigationView) {

        Configuration configuration = context.getResources().getConfiguration();
        final int screenWidthDp = configuration.screenWidthDp; //The current width of the available screen space, in dp units, corresponding to screen width resource qualifier.

        Log.d(TAG, "allWidthOfScreen =" + String.valueOf(screenWidthDp) + "\n with after div =" + String.valueOf((int) (screenWidthDp * 0.83)));

        TextView txt_Institute = navigationView.findViewById(R.id.txt_Institute);
        TextView txt_Directors = navigationView.findViewById(R.id.txt_Directors);
        Spinner spinner_Affairs= navigationView.findViewById(R.id.sp_Affairs);
        Spinner spinner_General_Registrar= navigationView.findViewById(R.id.sp_General_Registrar);
        TextView txt_about_app= navigationView.findViewById(R.id.txt_about_app);


        txt_Institute.setOnClickListener(view -> {
            intent = new Intent(MainActivity.this, DetailsActivity.class);
            extras = new Bundle();

            extras.putInt(DetailsActivity.EXRA_PDF_VALUES,1);
            intent.putExtras(extras);
            startActivity(intent);
        });
        txt_Directors.setOnClickListener(view -> {
            intent = new Intent(MainActivity.this, DetailsActivity.class);
            extras = new Bundle();

            extras.putInt(DetailsActivity.EXRA_PDF_VALUES,2);
            intent.putExtras(extras);
            startActivity(intent);
        });



        txt_about_app.setOnClickListener(view -> {
            intent = new Intent(MainActivity.this, DetailsActivity.class);
            extras = new Bundle();

            extras.putInt(DetailsActivity.EXRA_PDF_VALUES,11);
            intent.putExtras(extras);
            startActivity(intent);

        });



        spinner_Affairs.setAdapter(new ArrayAdapter<String>(this,R.layout.spinner_item,res1));
        spinner_Affairs.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ((TextView) parent.getChildAt(0)).setTypeface(Typeface.DEFAULT_BOLD);

                ((TextView) parent.getChildAt(0)).setTextSize(18);
                ((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(R.color.colorPrimaryDark));


                switch (position){
                    case 1:

                        intent = new Intent(MainActivity.this, DetailsActivity.class);
                        extras = new Bundle();

                        extras.putInt(DetailsActivity.EXRA_PDF_VALUES,3);
                        intent.putExtras(extras);
                        startActivity(intent);
                        break;
                    case 2:

                        intent = new Intent(MainActivity.this, DetailsActivity.class);
                        extras = new Bundle();

                        extras.putInt(DetailsActivity.EXRA_PDF_VALUES,4);
                        intent.putExtras(extras);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(MainActivity.this, DetailsActivity.class);
                        extras = new Bundle();

                        extras.putInt(DetailsActivity.EXRA_PDF_VALUES,5);
                        intent.putExtras(extras);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(MainActivity.this, DetailsActivity.class);
                        extras = new Bundle();

                        extras.putInt(DetailsActivity.EXRA_PDF_VALUES,6);
                        intent.putExtras(extras);
                        startActivity(intent);
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinner_General_Registrar.setAdapter(new ArrayAdapter<String>(this,R.layout.spinner_item,res2));
        spinner_General_Registrar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ((TextView) parent.getChildAt(0)).setTypeface(Typeface.DEFAULT_BOLD);

                ((TextView) parent.getChildAt(0)).setTextSize(18);
                ((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(R.color.colorPrimaryDark));


                switch (position){

                    case 1:
                        intent = new Intent(MainActivity.this, DetailsActivity.class);
                        extras = new Bundle();

                        extras.putInt(DetailsActivity.EXRA_PDF_VALUES,7);
                        intent.putExtras(extras);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, DetailsActivity.class);
                        extras = new Bundle();

                        extras.putInt(DetailsActivity.EXRA_PDF_VALUES,8);
                        intent.putExtras(extras);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(MainActivity.this, DetailsActivity.class);
                        extras = new Bundle();

                        extras.putInt(DetailsActivity.EXRA_PDF_VALUES,9);
                        intent.putExtras(extras);
                        startActivity(intent);
                        break;

                    case 4:
                        intent = new Intent(MainActivity.this, DetailsActivity.class);
                        extras = new Bundle();

                        extras.putInt(DetailsActivity.EXRA_PDF_VALUES,10);
                        intent.putExtras(extras);
                        startActivity(intent);
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }


}

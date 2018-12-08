package com.directory.institute.institute_directory;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    private static final String STATE_ASSET = "asset";
    private static final String STATE_PICKED = "picked";
    private String chosenAsset = null;
    private Uri pickedDocument = null;

    public final static String EXRA_PDF_VALUES = "extra_pdf";

    @SuppressWarnings("WeakerAccess")
    @BindView(R.id.detailstoolbar)
    protected Toolbar mToolbar;

    @SuppressWarnings("WeakerAccess")
    @BindView(R.id.viewer)
    protected PDFView viewer;

    private String mAsset_pdf = "profile_of_institute.pdf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            mToolbar.setTitle(getResources().getString(R.string.app_name));
        }
        Bundle extras = getIntent().getExtras();
        assert extras != null;

        if (extras.containsKey(EXRA_PDF_VALUES)) {


            switch (extras.getInt(EXRA_PDF_VALUES)) {
                case 1:
                    mAsset_pdf = "profile_of_institute.pdf";

                    break;

                case 2:
                    mAsset_pdf = "series_manager_of_the_institute.pdf";

                    break;
                case 3:

                    mAsset_pdf = "scientific_department.pdf";

                    break;

                case 4:
                    mAsset_pdf = "reseach_department.pdf";


                    break;

                case 5:
                    mAsset_pdf = "workshps.pdf";

                    break;

                case 6:
                    mAsset_pdf = "Librang.pdf";

                    break;

                case 7:
                    mAsset_pdf = "studying_and_exam_department.pdf";

                    break;

                case 8:
                    mAsset_pdf = "Registry_and_acceptancy_department.pdf";

                    break;

                case 9:
                    mAsset_pdf = "Graduated_depurtment.pdf";

                    break;

                case 10:
                    mAsset_pdf = "activity_and_student_departmant_affairs.pdf";

                    break;

                case 11:
                    mAsset_pdf = "around_application.pdf";

                    break;


            }

            loadPdf(mAsset_pdf);

        }

    }


    @SuppressWarnings("SameReturnValue")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                Intent intent = new Intent(DetailsActivity.this, MainActivity.class);

                startActivity(intent);
                return true;

        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(STATE_ASSET, chosenAsset);
        outState.putParcelable(STATE_PICKED, pickedDocument);
    }


    private void loadPdf(String name) {
        chosenAsset = name;
        pickedDocument = null;
        configureViewer(viewer.fromAsset(name));
    }

    private void configureViewer(PDFView.Configurator configurator) {
        configurator
                .enableSwipe(true)
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .scrollHandle(new DefaultScrollHandle(this))
                .load();
    }


}


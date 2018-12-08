package com.directory.institute.institute_directory;

import android.content.Context;
import android.content.SharedPreferences;

@SuppressWarnings({"ALL", "UnusedReturnValue"})
public class SharedPrefManager {

    private static final String SHARED_PREF_NAME = "save_contents";//key main key of  of sharedpreferences
    private static final String KEY_IS_OPEN = "is_open";
    private static SharedPrefManager mInstance;
    private static Context mCtx;
    SharedPreferences pref;
    SharedPreferences.Editor editor;


    public SharedPrefManager(Context context) {
        mCtx = context;
        pref = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);

        }
        return mInstance;
    }


    public void setOpen(boolean isLoggedIn) {
        editor = pref.edit();
        editor.putBoolean(KEY_IS_OPEN, isLoggedIn);
        editor.apply();
        editor.commit();

    }


    public boolean isOpen() {
        return pref.getBoolean(KEY_IS_OPEN, false);

    }


}

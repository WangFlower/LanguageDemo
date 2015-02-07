package com.example.sam.myapplication;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.Log;

import java.util.Locale;

/**
 * Created by Sam on 2015/2/5.
 */
public class LanguageApplication extends Application {

    private Locale mlocale = null;

    public LanguageApplication(){

    }

    @Override
    public void onCreate() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String localconfig = sp.getString("local","");
        Configuration config = getResources().getConfiguration();
        DisplayMetrics metrics = getResources().getDisplayMetrics();

        if(null!=localconfig&&!"".equals(localconfig)){
            mlocale = new Locale(localconfig);
        }else{
            mlocale = Locale.getDefault();
        }
        config.locale = mlocale;
        getResources().updateConfiguration(config, metrics);


    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {

        super.onConfigurationChanged(newConfig);


    }
}

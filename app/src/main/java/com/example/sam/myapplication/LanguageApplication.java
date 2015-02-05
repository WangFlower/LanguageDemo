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

    public LanguageApplication(){

    }

    @Override
    public void onCreate() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String localconfig = sp.getString("local","");
        Log.d("LanguageApplication","onConfigurationChanged-->"+localconfig);
        Configuration config = getResources().getConfiguration();
        DisplayMetrics metrics = getResources().getDisplayMetrics();

        if(null!=localconfig&&!"".equals(localconfig)){
            config.locale = new Locale(localconfig);
        }else{
            config.locale = Locale.getDefault();
        }
        getResources().updateConfiguration(config, metrics);


    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {

        super.onConfigurationChanged(newConfig);


    }
}

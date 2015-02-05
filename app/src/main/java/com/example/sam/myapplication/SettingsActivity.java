package com.example.sam.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Logger;


public class SettingsActivity extends Activity {

    private ListView mLanguagelist ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_expandable_list_item_1,
                getLanguagesValues());
        mLanguagelist = (ListView) this.findViewById(R.id.languagelist);
        mLanguagelist.setAdapter(adapter);
        mLanguagelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setLanguage((int)id);

            }
        });
    }



    private ArrayList<String> getLanguagesValues(){
        ArrayList<String> data = new ArrayList<String>();
        data.add("跟随系统");
        data.add("简体中文");
        data.add("English");
        data.add("Deutsch");
        data.add("Français");
        data.add("其他");
        return data;
    }

    /**
     * 设置语言
     */
    private void setLanguage(int index){
        Log.d("setLanguage",""+index);
        Resources resources = getResources();
        Configuration config = resources.getConfiguration();
        DisplayMetrics dm = resources .getDisplayMetrics();
        String temp ;
        switch (index){
            case 0:
                //跟随系统
                config.locale = Locale.getDefault();
                break;
            case 1:
                //简体中文
                config.locale = Locale.SIMPLIFIED_CHINESE;
                break;
            case 2:
                //英文
                config.locale = Locale.ENGLISH;
                break;
            case 3:
                //德文
                config.locale = Locale.GERMAN;
                break;
            case 4:
                //法文
                config.locale = Locale.FRENCH;
                break;
            case 5:
                //其他语言 本地语言
                config.locale = new Locale("sam");
                break;

        }
        resources.updateConfiguration(config, dm);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        sp.edit().putString("local",config.locale.getLanguage()).commit();
        startActivity(new Intent(this,MainActivity.class));
    }


}

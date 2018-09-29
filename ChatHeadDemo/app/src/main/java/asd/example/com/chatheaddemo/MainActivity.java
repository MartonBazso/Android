package com.mollyiv.chatheaddemo;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.mollyiv.chatheaddemo.SettingsFragment settingsFragment = new com.mollyiv.chatheaddemo.SettingsFragment();
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, settingsFragment)
                .commit();
    }
}

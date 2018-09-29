package com.example.marci.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Marci on 2018. 03. 12..
 */

public class MyReceiver extends BroadcastReceiver {




    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Intent Detected.",
                Toast.LENGTH_LONG).show();


        System.out.println("test");
    }




}

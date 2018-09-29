package com.example.marci.intenttest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button startBrowser = (Button) findViewById(R.id.start_browser);
        startBrowser.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(com.example.marci.intenttest.LAUNCH,
                        Uri.parse("http://www.example.com"));
                startActivity(i);
            }
        });



        Button startPhone = (Button) findViewById(R.id.start_phone);
        startPhone.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("tel:9510300000"));
                startActivity(i);
            }
        });
    }
}

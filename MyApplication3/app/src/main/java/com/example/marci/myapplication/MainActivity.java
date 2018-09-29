package com.example.marci.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {


    Bundle asd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        asd = savedInstanceState;




    }

    @Override
    protected void onStart() {

        super.onStart();

        System.out.println("Test-----------------------------------------------------------------------");


    }



    protected void onResume(){
        super.onResume();
        System.out.println("Resume");


    }



    @Override
    protected void onPause() {

        super.onPause();
        this.onStart();
        System.out.println("Pause");
    }



    @Override
    protected void onStop() {

        super.onStop();
        System.out.println("STOP");
    }


    @Override
    protected void onRestart() {

        super.onRestart();
        System.out.println("I have re-started!");
    }



    @Override
    protected void onDestroy() {

        super.onDestroy();

        super.onStart();
        System.out.println("I have been DESTROYED!!!!!!!!!!");
    }





    // Method to start the service
    public void startService(View view) {
        startService(new Intent(getBaseContext(), MyService.class));
    }
    // Method to stop the service
    public void stopService(View view) {
        stopService(new Intent(getBaseContext(), MyService.class));
    }

    public void broadcastIntent(View view)
    {
        Intent intent = new Intent();
        intent.setAction("com.example.marciegyfagóta.myapplication.CUSTOM_INTENT");
        sendBroadcast(intent);

        System.out.println(intent.getAction());

    }

}

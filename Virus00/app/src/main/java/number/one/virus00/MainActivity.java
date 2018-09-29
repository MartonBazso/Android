package number.one.virus00;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
    @Override
    protected void onPause(){
        super.onPause();
        startActivity(new Intent(getBaseContext(),MainActivity.class));
    }

    @Override
    protected void onStop(){
        super.onStop();
        startActivity(new Intent(getBaseContext(),MainActivity.class));
    }

    @Override
    protected void onStart(){
        super.onStart();
        startActivity(new Intent(getBaseContext(),MainActivity.class));
    }
    //Here starts the encoder part

    public void EncodeButton(View view) {
        //setContentView(R.layout.activity_encode);
        startActivity(new Intent(getBaseContext(),Encode.class));
    }

    public void DecodeButton(View view){

        startActivity(new Intent(getBaseContext(),Decode.class));

    }


}

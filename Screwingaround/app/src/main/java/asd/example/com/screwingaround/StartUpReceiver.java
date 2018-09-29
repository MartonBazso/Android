package asd.example.com.screwingaround;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class StartUpReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context,"Üdvözlöm Uram! Miben lehetek a szolglatára?", Toast.LENGTH_LONG).show();

        //Intent app = new Intent(context, MainActivity.class);
        //context.startActivity(app);
    }
}

package asd.example.com.screwingaround;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainService extends Service {

    private final static int FOREGROUND_ID = 999;

    private GirlLayout mHeadLayer;
    public MainActivity mainActivity;


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        logServiceStarted();

        initHeadLayer();

        //PendingIntent pendingIntent = createPendingIntent();




        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        destroyHeadLayer();
        stopForeground(true);

        logServiceEnded();
    }

    private void initHeadLayer() {
        mHeadLayer = new GirlLayout(this);
    }

    private void destroyHeadLayer() {
        mHeadLayer.destroy();
        mHeadLayer = null;
    }

    private PendingIntent createPendingIntent() {
        Intent intent = new Intent(this, MainActivity.class);
        return PendingIntent.getActivity(this, 0, intent, 0);
    }



    private void logServiceStarted() {
        Toast.makeText(this, "Service started", Toast.LENGTH_SHORT).show();
    }

    private void logServiceEnded() {
        Toast.makeText(this, "Service ended", Toast.LENGTH_SHORT).show();
    }





}

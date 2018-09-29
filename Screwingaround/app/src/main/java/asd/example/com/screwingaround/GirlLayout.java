package asd.example.com.screwingaround;

import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class GirlLayout extends View {


    double timer = 0;
    private Context mContext;
    private FrameLayout mFrameLayout;
    private WindowManager mWindowManager;
    public static MainActivity mainActivity;
    Commands commands = new Commands(mainActivity , mContext);
    public GirlLayout(Context context) {
        super(context);

        mContext = context;
        mFrameLayout = new FrameLayout(mContext);

        addToWindowManager();
    }

    private void addToWindowManager() {



        final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,
                PixelFormat.TRANSLUCENT);
        params.gravity = Gravity.LEFT;

        mWindowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        mWindowManager.addView(mFrameLayout, params);

        final LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // Here is the place where you can inject whatever layout you want.
        layoutInflater.inflate(R.layout.head, mFrameLayout);
        layoutInflater.inflate(R.layout.command_input, mFrameLayout);
        // Support dragging the image view
        final ImageView imageView = (ImageView) mFrameLayout.findViewById(R.id.imageView);
       imageView.setOnTouchListener(new OnTouchListener() {
            private int initX, initY;
            private int initTouchX, initTouchY;

            @Override public boolean onTouch(View v, MotionEvent event) {
                timer += 0.1;

                int x = (int)event.getRawX();
                int y = (int)event.getRawY();

                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:
                        initX = params.x;
                        initY = params.y;
                        initTouchX = x;
                        initTouchY = y;

                        return true;

                    case MotionEvent.ACTION_UP:
                        if(timer > 1.5){
                            mContext.stopService(new Intent(mContext,MainService.class));
                            timer = 0;
                        } else {timer = 0;}
                        return true;

                    case MotionEvent.ACTION_MOVE:
                        params.x = initX + (x - initTouchX);
                        params.y = initY + (y - initTouchY);

                        // Invalidate layout
                        mWindowManager.updateViewLayout(mFrameLayout, params);
                        return true;


                }
                return false;
            }





        });

       final Button command_button = (Button) mFrameLayout.findViewById(R.id.button);
       command_button.setOnClickListener(new OnClickListener() {
           @Override
           public void onClick(View v) {
                commands.process(((EditText)mFrameLayout.findViewById(R.id.command_text)).getText().toString());
               ((EditText)mFrameLayout.findViewById(R.id.command_text)).setText(null);

           }
       });







    }

    /**
     * Removes the view from window manager.
     */
    public void destroy() {
        mWindowManager.removeView(mFrameLayout);
    }
}

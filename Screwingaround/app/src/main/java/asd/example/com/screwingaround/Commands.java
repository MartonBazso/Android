package asd.example.com.screwingaround;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.inputmethodservice.Keyboard;
import android.os.Environment;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Commands {

    //Szótár

    String[] greetings = {"hello", "helo", "szia", "üdv", "hi", "ahoy", "hoi", "hali"};
    String[] starts = {"indítsd", "start", "indít", "indul", "nyisd", "run", "futtat"};


    String[] keywords = {

            "messenger",//1
            "gmail", //2
            "böngésző", "browser",//3
            "youtube"//4

    };


    String[] launchintents = {

            "com.facebook.orca",//1
            "com.google.android.gm",//2
            "com.android.browser", "com.android.browser",//3
            "com.google.android.youtube"//4

    };


    String[] scr = {"screenshot" , "screen" , "printscreen" , "scr"};

    MainActivity mainActivity;
    Random rand = new Random();

    Context mContext;
    public Commands(MainActivity main , Context context) {

        mContext = context;
        mainActivity = main;

    }


 /*   private static String[] toWordArray(String commands){
        if(commands != null){
            String[] words = new String[commands.length()];
            String newcommand = commands;
            int j = 0;

            for(int i = 0; i < newcommand.length() ; i++) {

                if(newcommand.charAt(i) == ' ') {

                    words[j] = newcommand.substring(0, i);

                    newcommand = newcommand.substring(i+1);
                    i = 0;
                    j++;

                }

            }

            words[j] = newcommand;
            return words;

        } else return null;



    }*/


    public void process(String command) {

        if (command != null) {

            for (int i = 0; i < greetings.length; i++) {

                if (command.contains(greetings[i])) {
                    int time = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

                    if( 5 < time && time < 12){
                        Toast.makeText(mainActivity.getApplicationContext(), "Jó reggelt Uram!", Toast.LENGTH_SHORT).show();
                    }

                    if( 13 < time && time < 18){
                        Toast.makeText(mainActivity.getApplicationContext(), "Jó napot Uram!", Toast.LENGTH_SHORT).show();
                    }

                    if( 18 < time && time < 24 || time < 5){
                        Toast.makeText(mainActivity.getApplicationContext(), "Szép estét!", Toast.LENGTH_SHORT).show();
                    }


                }
            }

            for (int i = 0; i < starts.length; i++) {

                if (command.contains(starts[i])) {


                    for (int j = 0; j < keywords.length; j++) {
                        if (command.contains(keywords[j])) {
                            startActivity(command, keywords[j], launchintents[j]);
                        }

                    }


                }
            }




            for (int i = 0; i < scr.length; i++) {
                Toast.makeText(mContext,"Sajnálom, de nem vagyok rá képes :(" , Toast.LENGTH_SHORT).show();
                /*if (command.contains(scr[i])) {







                    Bitmap screenshot = screenShot(mainActivity.getWindow().getDecorView().getRootView());
                    createImage(screenshot);


                }*/
            }



            if(command.contains("asd")){



            }


        }


    }


    private void startActivity(String command, String keyword, String intent) {


        Intent launchIntent = mainActivity.getPackageManager().getLaunchIntentForPackage(intent);
        if (launchIntent != null) {

            launchIntent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
            mainActivity.startActivity(launchIntent);
        }


    }



    public Bitmap screenShot(View view) {
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(),
                view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);
        return bitmap;
    }


    public void createImage(Bitmap bmp) {
        Date now = new Date();
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 40, bytes);

        File file = new File( "/storage/sdcard1/screenshots" + "/" +  now.getTime() +".jpg"
                  );
        try {
            file.createNewFile();
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(bytes.toByteArray());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}



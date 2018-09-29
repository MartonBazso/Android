package number.one.virus00;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Marci on 2018. 04. 01..
 */

public class Encode extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encode);



    }

    public void Copy(View view){
        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("label", ((EditText) findViewById(R.id.EncodedCode)).getText().toString());
        clipboard.setPrimaryClip(clip);


        Toast.makeText(this, "The code has been copied to your clipboard",
                Toast.LENGTH_LONG).show();
    }





    public void Encode(View view){


        this.wordToNumber();

        /*int[] asd = {2,3 ,4,2,6};
        char[] kek = new char[asd.length];
        for(int i = 0 ; i < asd.length; i++){
             kek[i] =(char)(asd[i]+48);
        }
            String asdasd = new String(kek);
            System.out.println(asdasd);*/
    }





    private void wordToNumber() {





        EditText basetext1 = (EditText) findViewById(R.id.textToBeEncoded);

        String basetext = basetext1.getText().toString();
        String text = basetext.toLowerCase();
        int[] code = new int[text.length()];
        int[] press = new int[text.length()];



        for(int x = 0; x < text.length() ; x++) {

            char a = text.charAt(x);

            code[x] = returnNum(a);
            press[x] = returnPress(a);

        }

        int i = 0;
        char[] actualword = new char[text.length()*2 + 1];

        for(int y = 0; y < code.length ; y++ ) {

             actualword[i] = (char)(code[y] + 48);

             i++;
        }

        actualword[i] = ':';
        i++;

        for(int y = 0; y < press.length ; y++ ) {

            actualword[i] = (char)(press[y] + 48);

            i++;
        }

        String TextString = new String(actualword);
        EditText solution = (EditText) findViewById(R.id.EncodedCode);
        solution.setText(TextString);



    }





    private static int returnNum(char a) {

        int number = 1;

        if(a == 32) {return 1; }
        //97-122 small abc
        for(int x = 97; x < 123 ; x+=3 )
        {

            number += 1;
            if( x < 115) {


                if(a == x || a == x+1 || a == x+2 )
                {

                    return number;

                } else
                {
                    if( a == 115) {


                        return 7;

                    }

                    if( a == 116 || a == 117 || a == 118) {


                        return 8;

                    }

                    if( a == 119 || a == 120 || a == 121 || a == 122) {


                        return 9;

                    }


                }
            }
        }


        return 0;
    }




    private static int returnPress(char a)
    {
        if(a == 32) {return 2; }

        if( a == 'a' || a == 'd' || a == 'g' || a == 'j' || a == 'm' || a == 'p' || a == 't' || a == 'w') {

            return 1;

        }


        if( a == 'b' || a == 'e' || a == 'h' || a == 'k' || a == 'n' || a == 'q' || a == 'u' || a == 'x') {

            return 2;

        }

        if( a == 'c' || a == 'f' || a == 'i' || a == 'l' || a == 'o' || a == 'r' || a == 'v' || a == 'y') {

            return 3;

        }


        if( a == 's' || a == 'z') {
            return 4;
        }


        return 0;

    }

}



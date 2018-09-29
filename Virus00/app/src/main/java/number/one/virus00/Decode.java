package number.one.virus00;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Marci on 2018. 04. 03..
 */

public class Decode extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decode);



    }
    public void Paste(View view){

        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        ClipData clip = clipboard.getPrimaryClip();
        ((EditText)findViewById(R.id.editText3)).setText(clip.getItemAt(0).getText());


    }


    public void Decode(View view){

        numberToWord();


    }


    private void numberToWord() {

        EditText text = (EditText) findViewById(R.id.editText3);
        String firstline = text.getText().toString();


        char[] array = firstline.toCharArray();
        int size = (array.length-1)/2;
        char[] first = new char[size];
        char[] second = new char[size];
        int i = 0;
        int j = 0;
        boolean containsDD = false;
        for(int x = 0 ; x < array.length ; x++){
            if(firstline.charAt(x) == ':'){
                containsDD = true;
            }
        }
        if(containsDD){
        while(array[i] != ':') {



            //System.out.print( array[i]);
            first[i] = array[i];
            i += 1;

        }


        for(int x = i + 1 ; x < array.length ; x++ ) {

            //System.out.print(array[x]);
            second[j] = array[x];
            j += 1 ;
        }

        //számok 49-57
        System.out.println();
        int firstplace = 50;
        int secondplace = 49;
        char character = 97;
        char[] word = new char[first.length*2+1];


        for( int place = 0 ; place < size ; place++) {

            if(first[place] == '1' && second[place] == '2') {word[place] = ' ';} else

            if(first[place] == '2') {

                switch( second [place]) {

                    case '1': word[place] = ('a'); break;

                    case '2' : word[place] = ('b'); break;

                    case '3' : word[place] = ('c'); break;

                }

            }else



            if(first[place] == '3') {

                switch( second [place]) {

                    case '1': word[place] = ('d'); break;

                    case '2' : word[place] = ('e'); break;

                    case '3' : word[place] = ('f'); break;

                }

            }else


            if(first[place] == '4') {

                switch( second [place]) {

                    case '1': word[place] = ('g'); break;

                    case '2' : word[place] = ('h'); break;

                    case '3' : word[place] = ('i'); break;

                }

            }else


            if(first[place] == '5') {

                switch( second [place]) {

                    case '1': word[place] = ('j'); break;

                    case '2' : word[place] = ('k'); break;

                    case '3' : word[place] = ('l'); break;

                }

            }else


            if(first[place] == '6') {

                switch( second [place]) {

                    case '1': word[place] = ('m'); break;

                    case '2' : word[place] = ('n'); break;

                    case '3' : word[place] = ('o'); break;

                }

            }else

            if(first[place] == '7') {

                switch( second [place]) {

                    case '1': word[place] = ('p'); break;

                    case '2' : word[place] = ('q'); break;

                    case '3' : word[place] = ('r'); break;

                    case '4' : word[place] = ('s'); break;

                }

            }else


            if(first[place] == '8') {

                switch( second [place]) {

                    case '1': word[place] = ('t'); break;

                    case '2' : word[place] = ('u'); break;

                    case '3' : word[place] = ('v'); break;

                }
            }else



            if(first[place] == '9') {

                switch( second [place]) {

                    case '1': word[place] = ('w'); break;

                    case '2' : word[place] = ('x'); break;

                    case '3' : word[place] = ('y'); break;

                    case '4' : word[place] = ('z'); break;
                }
            }else {
                word[place] = ' ';
            }
        }
            String fin = new String(word);
            TextView solution = (TextView) findViewById(R.id.textView);
            solution.setText(fin);
        }
        else {((TextView) findViewById(R.id.textView)).setText("Wrong text format");}




    }





}

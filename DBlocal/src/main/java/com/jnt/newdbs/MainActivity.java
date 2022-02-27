package com.jnt.newdbs;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.jnt.newdbs.Models.DataModel;
import com.jnt.newdbs.Models.PositionModel;
import com.jnt.newdbs.SecureData.MathCalc;
import com.jnt.newdbs.SecureData.RePositionData;
import com.jnt.newdbs.SecureData.EnCodeClass;
import com.jnt.newdbs.SecureData.SecureData;
import com.jnt.newdbs.helper.Enums;
import com.jnt.newdbs.helper.Fonts;

public class MainActivity extends AppCompatActivity {


    private String LOG = "jnth main and master";
    private String string1 = "0123456789";
    private String string2 = "1abcd2efgh3ijkm4nlop5rst";
    private String string4 = "bdhgciufjekam"; // 14
    private String string5 = "1abcd2efgh3ijkm4nlop5ryt"; // 24 = u
    private String string6 = "The Character class wraps a value of the primitive type ch."; //60
    private String string7 = "The Character class wraps a value of the primitive type char in an object. An object of type Character contains a single field whose type is char."; //146

    private RePositionData CD;
    private SecureData SD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        CD = new RePositionData();
        PositionModel[][] Array2D = CD.Make2D(string5);
        PositionModel[][] Array2D_en, Array2D_de;
        Array2D_en = new EnCodeClass().EnCode(Array2D);
        CD.Print2D(Array2D_en);
        Log.i(LOG, "=====================================Decoding");
        Array2D_de = new EnCodeClass().DeCode(Array2D_en);
        CD.Print2D(Array2D_de);
*/

        SD = new SecureData();

        //Log.i(LOG, "[" + +"] => ");


//        SD.MakeHashKey(SD.TargetPairChar(string6),SD.RandomTimeStamp());
//
//        Log.i(LOG," SD.RandomTimeStamp()=> "+SD.RandomTimeStamp());


//        SD.MakeHashKey(SD.TargetPairChar(string6),SD.RandomTimeStamp());
//        Log.i(LOG, " ==>> " +SD.MakeHashKey(SD.TargetPairChar(string6),SD.RandomTimeStamp()));

        String[] result = SD.MakeHashKey(SD.TargetPairChar(string6), SD.RandomTimeStamp());

        Log.i(LOG, "111111 => " + result.length);

        for (int i = 0; i < result.length; i++) {
            Log.i(LOG, i + " => " + result[i]);
        }


        TextView txt1= findViewById(R.id.txt_1);
        TextView txt2= findViewById(R.id.txt_2);
        TextView txt3= findViewById(R.id.txt_3);

        Fonts fn = new Fonts(this);

        txt1.setTypeface(fn.set(Enums.eFont.FONT1));
        txt2.setTypeface(fn.set(Enums.eFont.FONT2));
        txt3.setTypeface(fn.set(Enums.eFont.FONT3));

    }
}
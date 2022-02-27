package com.jnt.newdbs.helper;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.Switch;

public class Fonts {

    private Context context;


    public Fonts(Context context) {
        this.context = context;
    }

    public Typeface set(Enums.eFont font) {

        Typeface face = null;

        switch (font) {

            case FONT1:
                face = Typeface.createFromAsset(context.getAssets(),
                        "fonts/font1.ttf");
                break;

            case FONT2:
                face = Typeface.createFromAsset(context.getAssets(),
                        "fonts/font2.ttf");
                break;

            case FONT3:
                face = Typeface.createFromAsset(context.getAssets(),
                        "fonts/font3.ttf");
                break;

        }

        return face;

    }


}

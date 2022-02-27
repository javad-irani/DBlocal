package com.jnt.newdbs.SecureData;

import com.jnt.newdbs.Models.PositionModel;
import com.jnt.newdbs.helper.Enums;

public class EnCodeClass implements InterfaceCostumeData {

    String LOG = "jnth ";

    // Done.
    @Override
    public PositionModel[][] EnCode(PositionModel[][] Array2D) {

        RePositionData CD = new RePositionData();

        PositionModel[][] temp2D = Array2D;

        int p = 0;
        // encode rows
        for (int i = 0; i < Array2D[0].length; i++) {
            p = (i % 2) + 1;
            temp2D = CD.Shift2D(Enums.eShift2D.ROW, Enums.eShift1D.LEFT, i, p, temp2D);
            //Log.i(LOG, "encode [row Left] = > " + p);
        }

        // encode column
        p = 0;
        for (int i = 0; i < Array2D[0].length; i++) {
            p = (i % 2) + 1;
            temp2D = CD.Shift2D(Enums.eShift2D.COLUMN, Enums.eShift1D.LEFT, i, p, temp2D);
           // Log.i(LOG, "encode [column Left] = > " + p);
        }


        //CD.Print2D(temp2D);
        return temp2D;

    }

    // Done.
    @Override
    public PositionModel[][] DeCode(PositionModel[][] Array2D) {

        RePositionData CD = new RePositionData();

        PositionModel[][] temp2D = Array2D;

        int p = 0;
        // decode column
        for (int i = 0; i < Array2D[0].length; i++) {
            p = (i % 2) + 1;
            temp2D = CD.Shift2D(Enums.eShift2D.COLUMN, Enums.eShift1D.RIGHT, i, p, temp2D);
           // Log.i(LOG, "decode [column Right] = > " + p);
        }

        // decode row
        for (int i = 0; i < Array2D[0].length; i++) {
            p = (i % 2) + 1;
            temp2D = CD.Shift2D(Enums.eShift2D.ROW, Enums.eShift1D.RIGHT, i, p, temp2D);
           // Log.i(LOG, "decode [column Right] = > " + p);
        }

        //CD.Print2D(temp2D);

        return temp2D;
    }
}

package com.jnt.newdbs.SecureData;

import android.util.Log;

import com.jnt.newdbs.Models.PositionModel;
import com.jnt.newdbs.helper.Enums;

public class RePositionData {

    // throws IOException => latter apply this item to some function

    public RePositionData() {
    }

    // Done.
    public PositionModel[] Make1D(String string) {

        String LOG = "jnth Make 1D:";
        Log.i(LOG, "Start Make 1D");

        // Create Array1D , size = string.Length
        PositionModel[] Array1D = new PositionModel[string.length()];

        // Step by Step get chars from string and put in the Array 1D
        for (int i = 0; i < Array1D.length; i++) {
            Array1D[i] = new PositionModel(String.valueOf(string.charAt(i)), true);
        }

        Log.i(LOG, "Finish");

        return Array1D;
    }

    // Done.
    public void Print1D(PositionModel[] Array1D) {

        String LOG = "jnth Print 1D:";
        Log.i(LOG, "Start");

        for (int i = 0; i < Array1D.length; i++) {
            try {
                if (Array1D[i].isActive()) {
                    Log.i(LOG, "[ " + i + " ] =>" + Array1D[i].getData());
                } else {
                    Log.i(LOG, "[ " + i + " ] => is DeActive.");
                }
            } catch (NullPointerException exception) {
                Log.i(LOG, "1D " + "[" + i + "] => Null");
            }

        }

        Log.i(LOG, "Finish");

    }

    // Done.
    public PositionModel[][] Make2D(String string) {

        String LOG = "jnth Make 2D : ";
        Log.i(LOG, "Start");

        // Get Length of string
        int stringLength = string.length();

        // For example string.length = 16 => sqrt(16)=4 OK but
        // if string.length = 12 => sqrt(12)=3 ===> 3X3=9, but need 12 cell, so need +1
        int lengthArray2D
                = MathCalc.FullSquare_(stringLength)
                ? (int) MathCalc.sqrt_(stringLength)
                : ((int) MathCalc.sqrt_(stringLength) + 1);

        // Create a Array 2D. Latter add size of row and column
        PositionModel[][] Array2D = new PositionModel[lengthArray2D][lengthArray2D];

        for (int i = 0; i < Array2D[0].length; i++) {
            for (int j = 0; j < Array2D[0].length; j++) {

                try {

                    if ((((i * Array2D[0].length) + j)) < string.length()) {
                        Array2D[i][j] = new PositionModel(String.valueOf(string.charAt((i * Array2D[0].length) + j)), true);
                    } else {
                        Array2D[i][j] = new PositionModel("", false);
                    }
                } catch (NullPointerException exception) {

                }
            }

        }

        Log.i(LOG, "Finish");

        return Array2D;

    }

    // Done.
    public void Print2D(PositionModel[][] Array2D) {

        String LOG = "jnth Print 2D:";
        Log.i(LOG, "Start");

        for (int i = 0; i < Array2D[0].length; i++) {
            for (int j = 0; j < Array2D[0].length; j++) {

                try {
                    if (Array2D[i][j].isActive()) {
                        Log.i(LOG, "2D " + "[" + i + " " + j + "] = " + Array2D[i][j].getData());
                    } else {
                        Log.i(LOG, "2D " + "[" + i + " " + j + "] = is DeActive.");
                    }
                } catch (NullPointerException exception) {
                    Log.i(LOG, "2D " + "[" + i + " " + j + "] = Null");
                }


            }
        }

        Log.i(LOG, "Finish");
    }

    // Done.
    /*
     * Shift left data in Array 1D.
     * LEFTorRIGHT => Shift to Left or Right
     * @ NO => How Much to shift
     */
    public PositionModel[] Shift1D(Enums.eShift1D LEFTorRIGHT, int NO, PositionModel[] Array1D) {

        String LOG = "jnth Shift 1D";
        //Log.i(LOG, "Start");

        // Check NO, very important Because must NO < Array1D.Length And NO > 0
        //PrintLogArray1D_("", Array1D);
        if ((NO >= Array1D.length) || (NO <= 0)) {
            return Array1D;
        }

        // Check type of shift Array 1D. Left or right. very important
        // if type of shift is left that is OK.
        // But if type of shift is right we need (little)change NO, very important but so easy.
        // If Shift = LEFT , tempArray[size] = Array1D.length - NO.
        if (LEFTorRIGHT == Enums.eShift1D.RIGHT) {
            NO = Array1D.length - NO;
        }

        // This item for keeping the first item from Array 1D for add to last of Array 1D.
        // TempNode for keeping the first item from Array 1D.
        // when finish shift must add Temp Node to last of Array 1D.
        PositionModel tempNode = null;

        // This var for get number of false items in the array 1D.
        // This because in the for loop must this number reduce from counter of loop.
        // for example array1D.Length = 4 ,if all item is true, for loop must same this for(i=0 ; i < 3 ; i++ ),
        // but if one or more cell in tne array was false, must number of false item reduce from for loop
        // Duty of var counterFalseItem in the loop for was this.


        // This item for count false cells in the array ,
        // because if no false item temp replace whit last cell but is have a false replace whit last-1.
        // Notice : do not Change index and countFalseItem, because Different. very important

        for (int i = 0; i < NO; i++) {

            tempNode = Array1D[0];
            for (int j = 0; j < Array1D.length - 1; j++) {
                Array1D[j] = Array1D[j + 1];
            }
            Array1D[Array1D.length - 1] = tempNode;
        }


        return Array1D;
    }

    /*
     * @ ROW_COLUMN => Split row or column
     * @ WHICH => number of row or column.
     */
    public PositionModel[] Split2D(Enums.eShift2D ROW_COLUMN, int WHICH, PositionModel[][] Array2D) {
        String LOG = "Split Array 2D";
        Log.i(LOG, "Start.");

        PositionModel[] Array1D = new PositionModel[Array2D[0].length];

        switch (ROW_COLUMN) {
            case ROW:

                for (int i = 0; i < Array2D[0].length; i++) {
                    Array1D[i] = Array2D[WHICH][i];
                }

                break;
            case COLUMN:

                for (int i = 0; i < Array2D[0].length; i++) {
                    Array1D[i] = Array2D[i][WHICH];
                }

                break;
            default:
                // code block
        }

        /////////////////////////


        return Array1D;
    }

    /*
     * @ ROW_COLUMN => Split row or column
     * @ WHICH => number of row or column.
     * @ Array1D => this array 1D send to array 2D
     */
    public PositionModel[][] Merge1D2D(Enums.eShift2D ROW_COLUMN, int WHICH, PositionModel[] Array1D, PositionModel[][] Array2D) {

        String LOG = "jnth Merge";
        //Log.i(LOG, "Start.");

        switch (ROW_COLUMN) {
            case ROW:

                for (int i = 0; i < Array1D.length; i++) {
                    Array2D[WHICH][i] = Array1D[i];
                }

                break;
            case COLUMN:

                for (int i = 0; i < Array1D.length; i++) {
                    Array2D[i][WHICH] = Array1D[i];
                }

                break;
            default:

        }

        //Log.i(LOG, "Finish");

        return Array2D;
    }

    /*
     *  Shift to left Row in Array 2D
     * @shiftTypeArray2D => ROW or COLUMN
     * @upOrDown => UP or DOWN
     * @NO => which (number) row or column to shift
     * @numberToShift => that row or column How much shift (to up or down)
     * @Array2D => data source
     */
    public PositionModel[][] Shift2D(Enums.eShift2D ROW_COLUMN,
                                     Enums.eShift1D LEFT_RIGHT,
                                     int WHICH,
                                     int NO,
                                     PositionModel[][] Array2D) {


        String LOG = "jnth Shift 2D:";
        //Log.i(LOG, "Start");

        // Check NO, very important Because must NO < Array1D.Length And NO > 0
        if ((NO >= Array2D[0].length) || (NO < 0)) {
            return Array2D;
        }

        // Check WHICH [row or column for shift], very important Because must WHICH < Array1D.Length And WHICH > 0
        if ((WHICH >= Array2D[0].length) || (WHICH < 0)) {
            return Array2D;
        }

        // Create Array 1D for give Row or Column target.
        PositionModel[] tempShift1D = new PositionModel[Array2D[0].length];

        // Create Array 1D for split a row or column from Array 2D.
        // Then send to shift function
        PositionModel[] Split1DFrom2D;

        // Step 1/3 => split a array 1D from Array 2D
        // Give one row or column from Array 2D
        Split1DFrom2D = Split2D(ROW_COLUMN, WHICH, Array2D);
        if (CountFalse1D(Split1DFrom2D) <= 0) {

            // here
            // Step 2/3 => send that Array 1D to shift Function.
            // Send split array 1D to Shift.
            tempShift1D = Shift1D(LEFT_RIGHT, NO, Split1DFrom2D);

        } else {
            tempShift1D = Shift1D_RightDeActive(LEFT_RIGHT, NO, Split1DFrom2D);
        }

        //Log.i(LOG, "Finish");

        // Step 3/3 => Merge Array shifted to main Array 2D
        // What is return ? => Merger
        return Merge1D2D(ROW_COLUMN, WHICH, tempShift1D, Array2D);
    }

    // Get a Array 1D and count items of false.
    public int CountFalse1D(PositionModel[] Array1D) {

        int count = 0;

        for (int i = 0; i < Array1D.length; i++) {
            if (!Array1D[i].isActive()) {
                count++;
            }
        }

        return count;
    }

    public PositionModel[] Shift1D_RightDeActive(Enums.eShift1D LEFTorRIGHT, int NO, PositionModel[] Array1D) {

        String LOG = "jnth ";

        // First take new size of array 1D, new size = old size - count deActive items in the Array 1D.
        int size = (Array1D.length) - CountFalse1D(Array1D);

        // make a Array 1d whit new size.
        PositionModel[] temp1D = new PositionModel[size];
        PositionModel tempNode;

        // Move items from Array 1D to temp 1D, this because need temp 1D without deActive items.
        for (int i = 0; i < temp1D.length; i++) {
            temp1D[i] = Array1D[i];
        }


        switch (LEFTorRIGHT) {
            case LEFT:
                // start shift left from
                for (int i = 0; i < NO; i++) {
                    // tempNode for keeping first item , latter move to last position in the 1D
                    tempNode = temp1D[0];
                    for (int j = 0; j < temp1D.length - 1; j++) {
                        temp1D[j] = temp1D[j + 1];
                    }
                    // Move first item in the Array to last position
                    temp1D[temp1D.length - 1] = tempNode;
                }


                break;
            case RIGHT:
                 // Because dont need write new code, NO = number of Left shift,
                //  NO = But temp1D.length - NO , with this code Right shift simulator with Left shift. very easy
                 NO = temp1D.length - NO;
                Log.i(LOG, "NO = " + NO);

                for (int i = 0; i < NO; i++) {

                    tempNode = temp1D[0];
                    for (int j = 0; j < temp1D.length - 1; j++) {
                        temp1D[j] = temp1D[j + 1];
                    }
                    temp1D[temp1D.length - 1] = tempNode;
                }

                break;
            default:
                // code block
        }


        for (int i = 0; i < temp1D.length; i++) {
            Array1D[i] = temp1D[i];
        }

        return Array1D;

    }

}

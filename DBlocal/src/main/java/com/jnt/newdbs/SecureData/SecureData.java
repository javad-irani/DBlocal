package com.jnt.newdbs.SecureData;

import android.util.Log;

import com.jnt.newdbs.Models.DataModel;

import java.lang.reflect.Array;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;

public class SecureData {

    public SecureData() {

    }

    /*
     * Done.
     * This function give a string and keeping pair characters.
     */
    private DataModel[] PairChar(String string) {
        String LOG = "jnth Pair chars";

        // for this project need remove space character from string. Asci code space=32.
        int SpecialChar = 32;

        // create a array for put string after remove Space character
        ArrayList<Character> strWithoutSpecialChar = new ArrayList<>();

        // return new string without special character. [ without space]
        strWithoutSpecialChar = RemoveSpecialChar(SpecialChar, string);

        // Crate a array for keeping string without space.
        DataModel[] array = new DataModel[strWithoutSpecialChar.size()];

        // This var for change -70 => 70 . remove minus
        int p = 0;
        for (int i = 0; i < strWithoutSpecialChar.size() - 1; i++) {
            p = strWithoutSpecialChar.get(i) - strWithoutSpecialChar.get(i + 1);

            if (p < 0) {
                p = (p - p) - p; // or 0 - p
            }

            array[i] = new DataModel(strWithoutSpecialChar.get(i), strWithoutSpecialChar.get(i + 1), p, true);
        }

        return array;

    }

    /*
     * Done.
     * Give array 1D and print log cat. for test.
     */
    private void Print1D(DataModel[] Array1D) {

        String LOG = "jnth print";
        //Log.i(LOG, "Start");
        for (int i = 0; i < Array1D.length; i++) {
            Log.i(LOG, i + "[" + Array1D[i].getCh1() + " " + Array1D[i].getCh2() + "] => " + Array1D[i].getDistance());
        }

    }

    /*
     * Done.
     * This function give a character and string for remove that character between string, then return new string with Array 1D.
     */
    private ArrayList<Character> RemoveSpecialChar(int ch, String string) {

        String LOG = "jnth";

        ArrayList<Character> tempList = new ArrayList<>();

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != ch) {
                tempList.add(string.charAt(i));
            }

        }

        return tempList;
    }

    /*
     * Done.
     * Give a array 1D and sort by one field.
     */
    private DataModel[] SortArray1D(DataModel[] array1D) {

        String LOG = "jnth Sort";
        Log.i(LOG, "start");

        DataModel temp;
        for (int i = 0; i < array1D.length; i++) {
            for (int j = i; j < array1D.length - 1; j++) {
                if (array1D[i].getDistance() > array1D[j].getDistance()) {

                    temp = array1D[i];
                    array1D[i] = array1D[j];
                    array1D[j] = temp;

                }
            }
        }

        //Log.i(LOG, "End");
        return array1D;
    }

    /*
     * Done.
     * Give a string and convert to array 1D.
     */
    private DataModel[] Make1D(String string) {

        String LOG = "jnth";
        DataModel[] array1D = new DataModel[string.length()];

        for (int i = 0; i < string.length(); i++) {
            array1D[i] = new DataModel(string.charAt(i), string.charAt(i), string.charAt(i), true);

        }

        return array1D;
    }

    /*
     * Give string and return two character for apply encoding string
     */
    public DataModel TargetPairChar(String string) {

        // for keep data after change string to array 1D.
        DataModel[] array1D = new DataModel[string.length()];
        // for keep data after sort.
        DataModel[] SortedArray1D = new DataModel[string.length()];

        array1D = this.PairChar(string);
        SortedArray1D = this.SortArray1D(array1D);

        // first give count of character in the string, then give last digit of count of string.
        // this because we want decode not to be easy.
        int lastDigitCount = string.length() % 10;

        // first calculator middle and plus last digit
        int mid = ((SortedArray1D.length) / 2) + lastDigitCount;

        return SortedArray1D[mid];

    }

    /*
     * Done.
     * get random time stamp.
     */
    public String RandomTimeStamp() {
        long offset = Timestamp.valueOf("2012-01-01 00:00:00").getTime();
        long end = Timestamp.valueOf("2030-01-01 00:00:00").getTime();
        long diff = end - offset + 1;
        Timestamp rand = new Timestamp(offset + (long) (Math.random() * diff));

        //return String.valueOf(rand); // sample: 2021-01-20 11:17:09.085
        return String.valueOf(rand.getTime()); // sample: 1611141429085

    }

    public String[] MakeHashKey(DataModel pairChar, String timeStamp) {

        String LOG = "jnth Make Hash Key";

        // getCh1() return character but we need ASCI code, So convert to int
        int ch1int = pairChar.getCh1();
        // getCh1() return character but we need ASCI code, So convert to int
        int ch2int = pairChar.getCh2();

        // IMPORTANT: when convert digit to string that become reverse, both var
        // but we want reverse only second var.
        // So just need reverse var number one.
        ch1int = new MathCalc().ReverseNumber(ch1int);

        // Convert first var to string
        String ch1Str = String.valueOf(ch1int);
        // Convert second var to string
        String ch2Str = String.valueOf(ch2int);

        // Create a array, size = number of digit one + number of digit two
        String[] strArray = new String[ch1Str.length() + ch2Str.length()];


        // Make a Array size = strArray.length + 13
        // strArray.length = sum of digits of two number.
        // 13 => timeStamp.size()
        String[] resultArray = new String[strArray.length + 13];


        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = "0";
        }

        String[] result = null;
        // timeStamp.size = 13
        // chstr.size = 2 or 3
        // How to decode this result
        // Step 1   : first get size string. size = 17,18 or 19
        // Step 2.1 : if 18 this mean 18-13=5, char1 + char2 = 5, first of array str1 and last of array str2, char1 = 3 and char2 = 2
        //      2.2 : if 17 or 19 . 17-13=4, 19-13=6, char1=2, char2=2 or char1=2, char3=2.
        // IMPORTANT: char2 is reverse
        if (ch1Str.length() > ch2Str.length()) {

            result = insertCharTimestampChar(ch1Str, timeStamp, ch2Str);
        } else {
            result = insertCharTimestampChar(ch2Str, timeStamp, ch1Str);
        }


        return result;
    }

    private void intToString(int number) {
        String LOG = "jnth int to String";


    }

    private String[] insertCharTimestampChar(String char1, String timestamp, String char2) {

        String LOG = "jnth char timestamp";

        // Create Array for keep and return result, size = sum of size chars and timestamp.
        String[] result = new String[char1.length() + timestamp.length() + char2.length()];

        String reverseChar1 = new StringBuilder(char1).reverse().toString();

        // insert ASCI code of char 1
        for (int i = 0; i < char1.length(); i++) {
            result[i] = String.valueOf(reverseChar1.charAt(i));
        }

        // insert ASCI code of timestamp
        for (int i = 0; i < (timestamp.length()); i++) {
            result[i + char1.length()] = String.valueOf(timestamp.charAt(i));
        }

        // insert ASCI code of char 2
        for (int i = 0; i < (char2.length()); i++) {
            result[i + char1.length() + timestamp.length()] = String.valueOf(char2.charAt(i));
        }

        /*********************************/
        /*for (int i = 0; i < result.length; i++) {
            Log.i(LOG, i + " => " + result[i]);
        }*/


        return result;

    }

    private void PrintString(String[] string) {
        String LOG = "jnth Print String";


    }

}

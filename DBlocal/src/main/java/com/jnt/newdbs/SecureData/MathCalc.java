package com.jnt.newdbs.SecureData;

import android.util.Log;

public class MathCalc {

    public MathCalc() {
    }

    // Done.
    // Get Sqrt of number
    public static double sqrt_(int number) {
        return Math.sqrt(number);
    }

    // Done.
    public static Boolean FullSquare_(int number) {
        double temp = sqrt_(number);
        return ((int) temp * (int) temp) == number;
    }

    // Done.
    // get a number and return reverse that.
    public int ReverseNumber(int number) {

        String LOG = "jnth";

        int reverse = 0;
        int result = 1;

        while (number != 0) {

            int a = number % 10;
            reverse = reverse * 10 + a;
            number = number / 10;
        }

        return reverse;

    }

    public static int CountBorder() {

        int index = -2;
        int sqrt = 0;

        int x = 0;

        for (int i = 4; i < 100; i++) {
            // Log.i("jnth", "[" + i + "] = " + sqrt_(i));
            sqrt = (int) sqrt_(i);

            if ((sqrt * sqrt) == i) {
                Log.i("jnth", "sqrt[" + i + "] = " + sqrt + " => [" + ((sqrt + sqrt) + ((sqrt - 2) * 2)) + "]");
                index++;

            }// if


        }// for

        return 0;
    }

}

package edu.kvcc.cis298.cis298assignment2;

import android.content.res.Resources;

/**
 * Created by Robert Peck on 9/30/2015.
 */
public class ConversionCalculations {

    private int mFromTemp;
    private int mToTemp;

    private double mUserInput;
    private double mConvertedTemp = 0;

    private String mConversionType = "";

    public ConversionCalculations(int fromTemp, int toTemp, double userInput) {
        mFromTemp = fromTemp;
        mToTemp = toTemp;
        mUserInput = userInput;
        DetermineTempType();
    }


    public void DetermineTempType() {
        if(mFromTemp == mToTemp) {
            mConvertedTemp = mUserInput;
            mConversionType = "No Conversion";
        }

        if (mFromTemp == 0 && mToTemp == 1) {
            mConvertedTemp = mUserInput * 9/5 + 32;
            mConversionType = "[°F] = ([°C] x 9/5) + 32";
        }

        if (mFromTemp == 0 && mToTemp == 2) {
            mConvertedTemp = mUserInput + 273.15;
            mConversionType = "c_to_k";
        }

        if (mFromTemp == 0 && mToTemp == 3) {
            mConvertedTemp = (mUserInput + 273.15) * 9/5;
            mConversionType = "c_to_r";
        }

        if (mFromTemp == 1 && mToTemp == 0) {
            mConvertedTemp = (mUserInput - 32) * 5/9;
            mConversionType = "f_to_c";
        }

        if (mFromTemp == 1 && mToTemp == 2) {
            mConversionType = "f to k";
        }

        if (mFromTemp == 1 && mToTemp == 3) {
            mConversionType = "f to r";
        }

        if (mFromTemp == 2 && mToTemp == 0) {
            mConversionType = "k to c";
        }

        if (mFromTemp == 2 && mToTemp == 1) {
            mConversionType = "k to f";
        }

        if (mFromTemp == 2 && mToTemp == 3) {
            mConversionType = "k to r";
        }

        if (mFromTemp == 3 && mToTemp == 0) {
            mConversionType = "r to c";
        }

        if(mFromTemp == 3 && mToTemp == 1) {
            mConversionType = "r to f";
        }

        if (mFromTemp == 3 && mToTemp == 2) {
            mConversionType = "r to k";
        }
    }

    public double getmConvertedTemp() {
        return mConvertedTemp;
    }

    public String getmConversionType() {
        return mConversionType;
    }
}

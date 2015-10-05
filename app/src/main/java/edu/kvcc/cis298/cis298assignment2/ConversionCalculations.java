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
            mConversionType = "Hello";
            //Resources.getSystem().getString(R.string.c_to_f);
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

        }

        if (mFromTemp == 1 && mToTemp == 3) {

        }

        if (mFromTemp == 2 && mToTemp == 0) {

        }
    }

    public double getmConvertedTemp() {
        return mConvertedTemp;
    }

    public void setmConvertedTemp(double mConvertedTemp) {
        this.mConvertedTemp = mConvertedTemp;
    }

    public String getmConversionType() {
        return mConversionType;
    }

    public void setmConversionType(String mConversionType) {
        this.mConversionType = mConversionType;
    }
}

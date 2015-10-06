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
            mConversionType = "[K] = ([°C] + 273.15)";
        }

        if (mFromTemp == 0 && mToTemp == 3) {
            mConvertedTemp = (mUserInput + 273.15) * 9/5;
            mConversionType = "[°R] = ([°C] + 273.15) x 9/5";
        }

        if (mFromTemp == 1 && mToTemp == 0) {
            mConvertedTemp = (mUserInput - 32) * 5/9;
            mConversionType = "[°C] = ([°F] - 32) x 5/9";
        }

        if (mFromTemp == 1 && mToTemp == 2) {
            mConvertedTemp = (mUserInput + 459.67) * 5/9;
            mConversionType ="[K] = ([°F] + 459.67) x 5/9";
        }

        if (mFromTemp == 1 && mToTemp == 3) {
            mConvertedTemp = (mUserInput + 459.67);
            mConversionType = "[°R] = ([°F] + 459.67)";
        }

        if (mFromTemp == 2 && mToTemp == 0) {
            mConvertedTemp = (mUserInput - 273.15);
            mConversionType = "[°C] = [K] - 273.15";
        }

        if (mFromTemp == 2 && mToTemp == 1) {
            mConvertedTemp = (mUserInput * 9/5 - 459.67);
            mConversionType = "[°F] = ([K] x 9/5 - 459.67)";
        }

        if (mFromTemp == 2 && mToTemp == 3) {
            mConvertedTemp = (mUserInput * 9/5);
            mConversionType = "[°R] = ([K] x 9/5)";
        }

        if (mFromTemp == 3 && mToTemp == 0) {
            mConvertedTemp = (mUserInput - 491.67) * 5/9;
            mConversionType = "[°C] = ([°R] - 491.67) x 5/9";
        }

        if(mFromTemp == 3 && mToTemp == 1) {
            mConvertedTemp = (mUserInput - 459.67);
            mConversionType = "[°F] = ([°R] - 459.67)";
        }

        if (mFromTemp == 3 && mToTemp == 2) {
            mConvertedTemp = (mUserInput * 5/9);
            mConversionType = "[K] = ([°R] x 5/9)";
        }
    }

    public double getmConvertedTemp() {
        return mConvertedTemp;
    }

    public String getmConversionType() {
        return mConversionType;
    }
}

package edu.kvcc.cis298.cis298assignment2;

/**
 * Created by Robert Peck on 9/30/2015.
 */
public class ConversionCalculations {

    private int mFromTemp;
    private int mToTemp;

    private double mUserInput;
    private double mConvertedTemp = 0;

    public ConversionCalculations(int fromTemp, int toTemp, double userInput) {
        mFromTemp = fromTemp;
        mToTemp = toTemp;
        mUserInput = userInput;
        DetermineTempType();
    }


    private  void DetermineTempType() {
        if (mFromTemp == 0 && mToTemp == 1){
            mConvertedTemp = ((mUserInput) x 9/5 + 32);
        }
    }


}

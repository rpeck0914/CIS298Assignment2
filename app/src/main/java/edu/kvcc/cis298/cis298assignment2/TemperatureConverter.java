package edu.kvcc.cis298.cis298assignment2;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class TemperatureConverter extends AppCompatActivity {

    private EditText mUserInput;
    private double mUserInputVar;

    private int mFromButtonSelected;
    private int mToButtonSelected;
    private String mFromTempSymbol;
    private String mToTempSymbol;

    private String mConvertedTemp;
    private String mEquation;

    private RadioGroup mFromRadioGroup;
    private RadioGroup mToRadioGroup;

    private RadioButton mFromCelsius;
    private RadioButton mFromFahrenheit;
    private RadioButton mFromKelvin;
    private RadioButton mFromRankin;

    private RadioButton mToCelsius;
    private RadioButton mToFahrenheit;
    private RadioButton mToKelvin;
    private RadioButton mToRankin;

    private Button mConvertButton;

    private TextView mConversionText;
    private TextView mEquationText;

    private ConversionCalculations convertTemps;

    private void UpdateSelectedTemps() {

        switch (mFromRadioGroup.getCheckedRadioButtonId()) {
            case R.id.from_celsius:
                mFromButtonSelected = 0;
                mFromTempSymbol = "°C";
                break;

            case R.id.from_fahrenheit:
                mFromButtonSelected = 1;
                mFromTempSymbol = "°F";
                break;

            case R.id.from_kelvin:
                mFromButtonSelected = 2;
                mFromTempSymbol = "K";
                break;

            case R.id.from_rankin:
                mFromButtonSelected = 3;
                mFromTempSymbol = "°R";
                break;
        }

        switch (mToRadioGroup.getCheckedRadioButtonId()) {
            case R.id.to_celsius:
                mToButtonSelected = 0;
                mToTempSymbol = "°C";
                break;

            case R.id.to_fahrenheit:
                mToButtonSelected = 1;
                mToTempSymbol = "°F";
                break;

            case R.id.to_kelvin:
                mToButtonSelected = 2;
                mToTempSymbol = "K";
                break;

            case R.id.to_rankin:
                mToButtonSelected = 3;
                mToTempSymbol = "°R";
                break;
        }

//        if(mFromRadioGroup.getCheckedRadioButtonId() == mFromCelsius.getId()) {
//            mFromButtonSelected = 0;
//            mFromTempSymbol = "°C";
//        }
//
//        if(mFromRadioGroup.getCheckedRadioButtonId() == mFromFahrenheit.getId()) {
//            mFromButtonSelected = 1;
//            mFromTempSymbol = "°F";
//        }
//
//        if(mFromRadioGroup.getCheckedRadioButtonId() == mFromKelvin.getId()) {
//            mFromButtonSelected = 2;
//            mFromTempSymbol = "K";
//        }
//
//        if(mFromRadioGroup.getCheckedRadioButtonId() == mFromRankin.getId()) {
//            mFromButtonSelected = 3;
//            mFromTempSymbol = "°R";
//        }
//
//        if(mToRadioGroup.getCheckedRadioButtonId() == mToCelsius.getId()) {
//            mToButtonSelected = 0;
//            mToTempSymbol = "°C";
//        }
//
//        if(mToRadioGroup.getCheckedRadioButtonId() == mToFahrenheit.getId()) {
//            mToButtonSelected = 1;
//            mToTempSymbol = "°F";
//        }
//
//        if(mToRadioGroup.getCheckedRadioButtonId() == mToKelvin.getId()) {
//            mToButtonSelected = 2;
//            mToTempSymbol = "K";
//        }
//
//        if(mToRadioGroup.getCheckedRadioButtonId() == mToRankin.getId()) {
//            mToButtonSelected = 3;
//            mToTempSymbol = "°R";
//        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_converter);

        mUserInput = (EditText) findViewById(R.id.user_input);

        mFromRadioGroup = (RadioGroup) findViewById(R.id.from_radio_group);
        mToRadioGroup = (RadioGroup) findViewById(R.id.to_radio_group);

        mFromCelsius = (RadioButton) findViewById(R.id.from_celsius);
        mFromFahrenheit = (RadioButton) findViewById(R.id.from_fahrenheit);
        mFromKelvin = (RadioButton) findViewById(R.id.from_kelvin);
        mFromRankin = (RadioButton) findViewById(R.id.from_rankin);

        mToCelsius = (RadioButton) findViewById(R.id.to_celsius);
        mToFahrenheit = (RadioButton) findViewById(R.id.to_fahrenheit);
        mToKelvin = (RadioButton) findViewById(R.id.to_kelvin);
        mToRankin = (RadioButton) findViewById(R.id.to_rankin);

        mEquationText = (TextView) findViewById(R.id.equation_output);
        mConversionText = (TextView) findViewById(R.id.conversion_output);

        mConvertButton = (Button) findViewById(R.id.convert_button);
        mConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateSelectedTemps();

                try {
                    mUserInputVar = Double.parseDouble(mUserInput.getText().toString());
                    convertTemps = new ConversionCalculations(mFromButtonSelected, mToButtonSelected, mUserInputVar);

                    if(mFromTempSymbol == null || mToTempSymbol == null) {
                        throw new MyExceptions();
                    }

                    mEquation = convertTemps.getmConversionType();
                    mConvertedTemp = String.format("%.2f", convertTemps.getmConvertedTemp());

                    mEquationText.setText(mEquation + "");
                    mConversionText.setText(mUserInputVar + "" + mFromTempSymbol + " = " + mConvertedTemp + mToTempSymbol);
                }
                catch (NumberFormatException e) {
                    Toast.makeText(TemperatureConverter.this,"Please Enter A Number",Toast.LENGTH_SHORT).show();
                }

                catch (MyExceptions e) {
                    Toast.makeText(TemperatureConverter.this,"Please Select Temperatures To Be Converted",Toast.LENGTH_SHORT).show();
                }

            }
        });

        if (savedInstanceState != null) {
            mUserInputVar = savedInstanceState.getDouble("User_Input", 0);
            mUserInput.setText(mUserInputVar + "");

            mConvertedTemp = savedInstanceState.getString("Conversion_Text");
            mEquation = savedInstanceState.getString("Equation_Text");

            mFromTempSymbol = savedInstanceState.getString("From_Symbol");
            mToTempSymbol = savedInstanceState.getString("To_Symbol");

            if (mFromTempSymbol != null) {
                mEquationText.setText(mEquation + "");
                mConversionText.setText(mUserInputVar + "" + mFromTempSymbol + " = " + mConvertedTemp + mToTempSymbol);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putDouble("User_Input", mUserInputVar);
        outState.putString("From_Symbol", mFromTempSymbol);
        outState.putString("To_Symbol", mToTempSymbol);
        outState.putString("Conversion_Text", mConvertedTemp);
        outState.putString("Equation_Text", mEquation);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_temperature_converter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

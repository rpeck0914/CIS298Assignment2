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

public class TemperatureConverter extends AppCompatActivity {

    private EditText mUserInput;

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

    private ConversionCalculations[] mConversions = new ConversionCalculations[]{


    };

    private void UpdateSelectedTemps() {


    }

    private void CheckSelectedTemps(int fromSelectedId, int toSelectedId){

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

        mConvertButton = (Button) findViewById(R.id.convert_button);
        mConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedFromId = mFromRadioGroup.getCheckedRadioButtonId();
                int selectedToId = mToRadioGroup.getCheckedRadioButtonId();


            }
        });
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

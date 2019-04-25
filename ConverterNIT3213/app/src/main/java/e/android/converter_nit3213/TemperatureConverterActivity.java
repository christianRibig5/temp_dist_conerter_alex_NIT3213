package e.android.converter_nit3213;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class TemperatureConverterActivity extends AppCompatActivity {

    @BindView(R.id.temperature_fahrenheit) RelativeLayout mFahrenheitScreen;
    @BindView(R.id.temperature_celcius) RelativeLayout mCelciusScreen;

    @BindView(R.id.btnConvertToFahrenheit) Button mBtnConvertToFahrenheit;
    @BindView(R.id.btnConvertToCelcius) Button mBtnConvertToCelcius;

    @BindView(R.id.etCelcius) EditText mCelciusEditText;
    @BindView(R.id.etFahrenheit) EditText mFahrenheitEditText;

    @BindView(R.id.txtAnswer) TextView mAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_converter);
        ButterKnife.bind(this);

        //Make status bar transparent
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        mFahrenheitScreen.setVisibility(View.GONE);
        mCelciusScreen.setVisibility(View.VISIBLE);
    }
    @OnClick(R.id.btnConvertToFahrenheit)
    public void convertFromCelciusToFahrenheit(){
        //hint : T (fahrenheit)= T (celcius) * 9/5 +32
        String caughtValue=mCelciusEditText.getText().toString();
        if(!caughtValue.isEmpty()){
            Double  celVal = Double.valueOf(mCelciusEditText.getText().toString());
            double fahrenheitValue= (celVal*(double)9/5) +32;
            String result=String.valueOf(fahrenheitValue);
            mAnswer.setText(result+" F");
            mFahrenheitScreen.setVisibility(View.VISIBLE);
            mCelciusScreen.setVisibility(View.GONE);
            mCelciusEditText.setText("");
        }else{
            mCelciusEditText.setError("Please enter value in degree celcius");
        }


    }
    @OnClick(R.id.btnConvertToCelcius)
    public void convertFromFahrenheitToCelcius(){
        //hint : T (celcius)= T(fahrenheit)-32)*5/9
        String caughtValue=mFahrenheitEditText.getText().toString();
        if(!caughtValue.isEmpty()){
            Double  fahVal = Double.valueOf(caughtValue);
            double celciusValue = (double)5/9 *(fahVal-32);
            String result=String.valueOf(celciusValue);
            mAnswer.setText(result+" C");
            mFahrenheitScreen.setVisibility(View.GONE);
            mCelciusScreen.setVisibility(View.VISIBLE);
            mFahrenheitEditText.setText("");
        }else{
            mFahrenheitEditText.setError("please enter value in degree fahrenheit");
        }

    }
}

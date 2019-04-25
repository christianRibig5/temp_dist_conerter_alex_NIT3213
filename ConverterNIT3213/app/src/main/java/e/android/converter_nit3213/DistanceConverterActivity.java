package e.android.converter_nit3213;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DistanceConverterActivity extends AppCompatActivity {

    @BindView(R.id.distance_centimeter) RelativeLayout mCentimeterScreen;
    @BindView(R.id.distance_inches) RelativeLayout mInchesScreen;

    @BindView(R.id.btnInches) Button mInchesConvertBtn;
    @BindView(R.id.btnCentimeter) Button mCentimeterConvertBtn;

    @BindView(R.id.edInches) EditText mInchesEditText;
    @BindView(R.id.etCentimeter) EditText mCentimeterEditText;

    @BindView(R.id.txtAnswer) TextView mAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance_converter);
        ButterKnife.bind(this);
        //Make status bar transparent
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        mCentimeterScreen.setVisibility(View.GONE);
        mInchesScreen.setVisibility(View.VISIBLE);
    }
    @OnClick(R.id.btnInches)
    public void convertCentimeterToInches(){
        //hint: 1 cm= 2.5 inches
        String caughtValue= mInchesEditText.getText().toString();
        if(!caughtValue.isEmpty()){
            Double  cmVal = Double.valueOf(caughtValue);
            double InchesValue= cmVal/2.5;
            String result=String.valueOf(InchesValue);
            mAnswer.setText(result+" inches");
            mInchesScreen.setVisibility(View.GONE);
            mCentimeterScreen.setVisibility(View.VISIBLE);
            mInchesEditText.setText("");
        }else{
            mInchesEditText.setError("Please enter distance in centimeter");
        }

    }
    @OnClick(R.id.btnCentimeter)
    public void convertInchesToCentimeter(){
        String caughtValue= mCentimeterEditText.getText().toString();
        if(!caughtValue.isEmpty()){
            Double  inchVal = Double.valueOf(caughtValue);
            double InchesValue= inchVal*2.5;
            String result=String.valueOf(InchesValue);
            mAnswer.setText(result+" cm");
            mCentimeterScreen.setVisibility(View.GONE);
            mInchesScreen.setVisibility(View.VISIBLE);
            mCentimeterEditText.setText("");

        }
        else{
            mCentimeterEditText.setError("Please enter distance in inches");
        }

    }
}

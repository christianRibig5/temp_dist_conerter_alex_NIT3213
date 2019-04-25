package e.android.converter_nit3213;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;


//I used butterknife library to avoid
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tempCalculatorScreen)
    Button mTempCalculatorScreen;

    @BindView(R.id.distanceConverterScreen)
    Button mDistanceConverScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //instantiate the butterknife view binder
        ButterKnife.bind(this);
        //Make status bar transparent
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        //another way of doing samething if not @OnClick() but i prefer a cleaner onCreate constructor
//        mDistanceConverScreen.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                startActivity(new Intent(getApplicationContext(),DistanceConverterActivity.class));
//            }
//        });
//        mTempCalculatorScreen.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getApplicationContext(),TemperatureConverterActivity.class));
//            }
//        });
    }
    @OnClick(R.id.distanceConverterScreen)
    public void gotoDistanceActivity(){
        startActivity(new Intent(getApplicationContext(),DistanceConverterActivity.class));

    }
    @OnClick(R.id.tempCalculatorScreen)
    public void gotoTemperatureActivity(){
        startActivity(new Intent(getApplicationContext(),TemperatureConverterActivity.class));
    }
}

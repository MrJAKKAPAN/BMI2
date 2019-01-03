package com.example.user.bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_cal = (Button)findViewById(R.id.button_cal); /*เรียกให้ปุ่มทำงาน*/
        button_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calBMI();
            }
        });

    }
       /*ตั้งให้ชรู้จักช่องรับเลข*/
        private void calBMI(){
            EditText textw = (EditText)findViewById(R.id.editText_weight);
            EditText texth = (EditText)findViewById(R.id.editText2_high);

            double w = Double.parseDouble(textw.getText().toString());
            double h = Double.parseDouble(texth.getText().toString());

            h = h/100; //cm --> cm

            double bmi = w / (h * h);

            DecimalFormat decFormat = new DecimalFormat("##.##");
            String msg = " ค่า BMI คือ:"+ decFormat.format(bmi)+ "\n";
            msg += "ลักษณะรูปร่างคือ:";

            if (bmi >= 40) msg += "เกินมาตรฐาน";
            else if (bmi >= 35) msg += "เกิน 2";
            else  if (bmi >= 28.5) msg += "เกิน 3";
            else  if (bmi >= 23.5) msg += "เกิน 4";
            else if (bmi >= 18.5) msg += "เกิน 5";
            else msg += "น้ำหนักต่ำกว่าเกณฑ์";
                Toast.makeText(getBaseContext(),msg,Toast.LENGTH_LONG).show();


        }

}

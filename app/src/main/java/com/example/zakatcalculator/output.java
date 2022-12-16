package com.example.zakatcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class output extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        Double tot_value= Double.valueOf(0);
        Double payable= Double.valueOf(0);
        Double tot_zak= Double.valueOf(0);

        TextView weight =(TextView) findViewById(R.id.textView4);
        TextView zakatPayable=(TextView) findViewById(R.id.textView5);
        TextView total=(TextView) findViewById(R.id.textView6);

        Intent intent = getIntent();

         tot_value = getIntent().getDoubleExtra("weight", 0);
         payable = getIntent().getDoubleExtra("payable", 0);
         tot_zak = getIntent().getDoubleExtra("total",0);

         weight.setText("Total value of Gold (RM) :" +tot_value);
         zakatPayable.setText(" Zakat Payable (RM):" +payable);
         total.setText("Total of  Zakat (RM):" +tot_zak);

    }
}
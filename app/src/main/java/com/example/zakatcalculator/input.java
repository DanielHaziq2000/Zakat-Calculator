package com.example.zakatcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class input extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    Spinner sp1;
    ArrayAdapter<CharSequence>adapter;
    EditText ed1;
    EditText ed2;
    Button b1;
    Button b2;
    Double weight;
    Double current;
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }


    public void onNothingSelected(AdapterView<?> parent) {

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        sp1 = (Spinner) findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adapter);
        ed1 = findViewById(R.id.weightinput);
        ed2 = findViewById(R.id.currentinput);
        b1 = findViewById(R.id.calculate);
        b2 = findViewById(R.id.btnreset);


        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        sp1.setOnItemSelectedListener(this);

    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.about:
                Toast.makeText(this, "About", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        try {
            switch (v.getId()){

                case R.id.calculate:
                    calculate();
                    break;

                case R.id.btnreset:
                    ed1.setText("");
                    ed2.setText("");


                    break;
            }
        }catch (java.lang.NumberFormatException nfe) {
            Toast.makeText(this, "This field is required!", Toast.LENGTH_SHORT).show();

        }catch (Exception exp) {
            Toast.makeText(this, "Unknown Exception" + exp.getMessage(), Toast.LENGTH_SHORT).show();

            Log.d("Exception",exp.getMessage());
        }
    }

    private void calculate() {

        String type = sp1.getSelectedItem().toString();
        weight = Double.parseDouble(ed1.getText().toString());
        current = Double.parseDouble(ed2.getText().toString());
        double tot_value,net,payable,tot_zak;

        if (type.equals("Keep")){
            tot_value = weight * current;
            net = weight - 85;

            if (net >=0.0) {
                payable = net * current;
                tot_zak = payable *0.025;
            }

            else{
                payable = 0.0;
                tot_zak = payable * 0.025;
            }


        }

        else{
            tot_value = weight * current;
            net = weight - 200;

            if (net>=0.0) {
                payable = net * current;
                tot_zak = payable *0.025;
            }

            else{
                payable = 0.0;
                tot_zak= payable * 0.025;
            }


        }
        Intent intent= new Intent(getApplicationContext(),output.class);
        intent.putExtra("weight",tot_value);
        intent.putExtra("payable",payable);
        intent.putExtra("total",tot_zak);
        startActivity(intent);
}
}
package com.example.shruti.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;



public class Activity2 extends ActionBarActivity implements OnClickListener {

    Button buttonsin;
    Button buttoncos;
    Button buttontan;
    Button buttoni;
    Button buttonln;
    Button buttonlog;
    Button buttonpie;
    Button buttone;
    Button buttonper;
    Button buttonfact;
    Button buttonsqrt;
    Button buttonres;
    Button buttoneq;
    Button buttonbr1;
    Button buttonbr2;
    Button btnDEL;
    Button Switch;
    private String activity;
    TextView editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        final Intent intent = getIntent();
        activity = intent.getStringExtra("activity2");
        buttonsin = (Button) findViewById(R.id.buttonsin);
        buttoncos = (Button) findViewById(R.id.buttoncos);
        buttontan = (Button) findViewById(R.id.buttontan);
        buttoni = (Button) findViewById(R.id.buttoni);
        buttonln = (Button) findViewById(R.id.buttonln);
        buttonlog = (Button) findViewById(R.id.buttonlog);
        buttone = (Button) findViewById(R.id.buttone);
        buttonpie = (Button) findViewById(R.id.buttonpie);
        buttonper = (Button) findViewById(R.id.buttonper);
        buttonfact = (Button) findViewById(R.id.buttonfact);
        buttonsqrt = (Button) findViewById(R.id.buttonsqrt);
        buttonres = (Button) findViewById(R.id.buttonres);
        buttoneq = (Button) findViewById(R.id.buttoneq);
        buttonbr1 = (Button) findViewById(R.id.buttonbr1);
        buttonbr2 = (Button) findViewById(R.id.buttonbr2);
        btnDEL = (Button) findViewById(R.id.btnDEL);
        editText = (TextView) findViewById(R.id.editText);

        buttoneq.setOnClickListener(this);
        btnDEL.setOnClickListener(this);
        buttonsin.setOnClickListener(this);
        buttoncos.setOnClickListener(this);
        buttontan.setOnClickListener(this);
        buttoni.setOnClickListener(this);
        buttonln.setOnClickListener(this);
        buttonlog.setOnClickListener(this);
        buttone.setOnClickListener(this);
        buttonpie.setOnClickListener(this);
        buttonper.setOnClickListener(this);
        buttonfact.setOnClickListener(this);
        buttonsqrt.setOnClickListener(this);
        buttonres.setOnClickListener(this);
        buttonbr1.setOnClickListener(this);
        buttonbr2.setOnClickListener(this);





        Switch = (Button) findViewById(R.id.buttonfunc);
        Switch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity2.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);

            }
        });
    }

    int clear_flag = 0;
    String sign_flag = " ";
    Double total;
    int last_button = 0;

    public void shownum(String num) {

        String ScrCurrent = editText.getText().toString();
        if (ScrCurrent.equals("0"))
            ScrCurrent = " ";
        ScrCurrent += num;
        editText.setText(ScrCurrent);
    }

    public void showsign() {


    }

    @Override
    public void onClick(View v) {


        if (v.getId() == R.id.btnDEL) {
            editText.setText("0");
       //     total = 0f;
            sign_flag = " ";
        } else if (v.getId() == R.id.buttoneq) {
            Double newNumber = Double.parseDouble(editText.getText().toString());
           // Float total = 0f;
            if (sign_flag == "%") {
                total = (total * newNumber)/100;
                editText.setText(total.toString());
            }
                sign_flag = "=";
        }
        else if(v.getId() == R.id.buttonsqrt){
            Double newNumber = Double.parseDouble(editText.getText().toString());
            total = Math.sqrt(newNumber);
            editText.setText(total.toString());
        }
        else if(v.getId() == R.id.buttonsin){
            Double newNumber = Double.parseDouble(editText.getText().toString());
            total = Math.sin(newNumber);
            editText.setText(total.toString());
        }
        else if(v.getId() == R.id.buttoncos){
            Double newNumber = Double.parseDouble(editText.getText().toString());
            total = Math.cos(newNumber);
            editText.setText(total.toString());
        }
        else if(v.getId() == R.id.buttontan){
            Double newNumber = Double.parseDouble(editText.getText().toString());
            total = Math.tan(newNumber);
            editText.setText(total.toString());
        }
        else if(v.getId() == R.id.buttonln){
            Double newNumber = Double.parseDouble(editText.getText().toString());
            total = Math.log(newNumber);
            editText.setText(total.toString());
        }
        else if(v.getId() == R.id.buttonlog){
            Double newNumber = Double.parseDouble(editText.getText().toString());
            total = Math.log10(newNumber);
            editText.setText(total.toString());
        }
        else if(v.getId() == R.id.buttonpie){
            Double newNumber = Double.parseDouble(editText.getText().toString());
            total = Math.PI;
            editText.setText(total.toString());
        }
        else if (v.getId()==R.id.buttonper){
            sign_flag = "%";
            clear_flag = 1;
            Double newNumber = Double.parseDouble(editText.getText().toString());
            total = newNumber;
        }
        last_button = v.getId();
    }
}

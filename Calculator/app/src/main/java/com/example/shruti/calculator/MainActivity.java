package com.example.shruti.calculator;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements OnClickListener {

    Button button10;
    Button button11;
    Button button12;
    Button button6;
    Button button7;
    Button button8;
    Button button2;
    Button button3;
    Button button4;
    Button button14;
    Button button15;
    Button btnP;
    Button btnM;
    Button btnS;
    Button btnD;
    Button btnE;
    Button btnDEL;
    Button Switch;
    EditText editText;
    private String activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intent = getIntent();
        activity = intent.getStringExtra("activity1");

        button10 = (Button)findViewById(R.id.button10);
       button11 = (Button)findViewById(R.id.button11);
       button12 = (Button)findViewById(R.id.button12);
       button6 = (Button)findViewById(R.id.button6);
       button7 = (Button)findViewById(R.id.button7);
       button8 = (Button)findViewById(R.id.button8);
       button2 = (Button)findViewById(R.id.button2);
       button3 = (Button)findViewById(R.id.button3);
       button4 = (Button)findViewById(R.id.button4);
       button14 = (Button)findViewById(R.id.button14);
       button15 = (Button)findViewById(R.id.button15);
       btnP = (Button)findViewById(R.id.btnP);
       btnS = (Button)findViewById(R.id.btnS);
       btnM = (Button)findViewById(R.id.btnM);
       btnD = (Button)findViewById(R.id.btnD);
       btnE = (Button)findViewById(R.id.btnE);
       btnDEL = (Button)findViewById(R.id.btnDEL);
       editText = (EditText)findViewById(R.id.editText);

        button10.setOnClickListener(this);
        button11.setOnClickListener(this);
        button12.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button14.setOnClickListener(this);
        button15.setOnClickListener(this);
        btnP.setOnClickListener(this);
        btnS.setOnClickListener(this);
        btnM.setOnClickListener(this);
        btnD.setOnClickListener(this);
        btnE.setOnClickListener(this);
        btnDEL.setOnClickListener(this);

        Switch = (Button) findViewById(R.id.buttonfunc);
        Switch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);

            }
        });
        }

        int clear_flag=0;
    String sign_flag = "";
    Double total=0.0;
    int last_button = 0;

    public void shownum(String num){
    if(clear_flag==1)
    {
    editText.setText(" ");
    clear_flag=0;
    }
    else if(editText.getText().equals("0"))
    {
    editText.setText(" ");
    }

    editText.setText(editText.getText()+num);
 }

    public void showsign(String sign) {

        if (last_button == R.id.btnP || last_button == R.id.btnS || last_button == R.id.btnM || last_button == R.id.btnD) {
            //do nothing
        }else{
            clear_flag = 1;//set flag
            Double newNumber = Double.parseDouble(editText.getText().toString());
            if (sign_flag == " " || sign_flag == "=") {
                total = newNumber;
                editText.setText(total.toString());
            }
            else if (sign_flag == "+") {
                total = total + newNumber;
                editText.setText(total.toString());
            }
            else if (sign_flag == "-") {
                total = total - newNumber;
                editText.setText(total.toString());
            }
            else if (sign_flag == "/") {
                total = total / newNumber;
                editText.setText(total.toString());
            }
            else if (sign_flag == "*") {
                total = total * newNumber;
                editText.setText(total.toString());
            }


        }
        sign_flag = sign;
    }
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button15){
            shownum("0");
        }
        else if(v.getId() == R.id.button15){
            shownum("0");
        }
        else if(v.getId() == R.id.button10){
            shownum("1");
        }
        else if(v.getId() == R.id.button11){
            shownum("2");
        }
        else if(v.getId() == R.id.button12){
            shownum("3");
        }
        else if(v.getId() == R.id.button6){
            shownum("4");
        }
        else if(v.getId() == R.id.button7){
            shownum("5");
        }
        else if(v.getId() == R.id.button8){
            shownum("6");
        }
        else if(v.getId() == R.id.button2){
            shownum("7");
        }
        else if(v.getId() == R.id.button3){
            shownum("8");
        }
        else if(v.getId() == R.id.button4){
            shownum("9");
        }
        else if(v.getId() == R.id.btnDEL){
            editText.setText("0");
            total = 0.0;
            sign_flag = " ";
        }
        else if(v.getId() == R.id.button14){
            if(clear_flag == 1){
                editText.setText("");
                clear_flag = 0;
            }
            if(editText.getText().toString().indexOf(".")<0){
                editText.setText(editText.getText() + ".");
            }
        }
        else if(v.getId() == R.id.btnP){
            showsign("+");
        }
        else if(v.getId() == R.id.btnS){
            showsign("-");
        }
        else if(v.getId() == R.id.btnD){
            showsign("/");
        }
        else if(v.getId() == R.id.btnM){
            showsign("*");
        }
        else if(v.getId() == R.id.btnE){
            Double newNumber = Double.parseDouble(editText.getText().toString());
            if(sign_flag == "+"){
                total = total + newNumber;
                editText.setText(total.toString());
            }
            else if (sign_flag == "-") {
                total = total - newNumber;
                editText.setText(total.toString());
            }
            else if (sign_flag == "/") {
                total = total / newNumber;
                editText.setText(total.toString());
            }
            else if (sign_flag == "*") {
                total = total * newNumber;
                editText.setText(total.toString());
            }
            sign_flag = "=";
        }
        last_button = v.getId();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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



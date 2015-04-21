package com.example.shruti.pig;

import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private FrameLayout die1, die2;
    private Button roll, hold;
    TextView rd,p1,p2;
    private int score,roundScore = 0,pscore=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intent = getIntent();
        score = intent.getIntExtra("p1score", 0);

        die1 = (FrameLayout) findViewById(R.id.die1);
        die2 = (FrameLayout) findViewById(R.id.die2);

        rd = (TextView) findViewById(R.id.round);
        p1=(TextView)findViewById(R.id.p1);
        p2=(TextView)findViewById(R.id.p2);

        roll = (Button) findViewById(R.id.button);
        roll.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int virtualScore = rollDice();

                if (virtualScore == 1)
                {
                    Intent intent = new Intent(MainActivity.this, Player2.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
                }
                else
                {
                    roundScore =roundScore+virtualScore;
                    p1.setText("P1:" + roundScore);
                }
            }
        });

        hold = (Button) findViewById(R.id.hold);
        hold.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                score =score+roundScore;

                if (score >= 100) {

                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("Player1!");
                    alertDialog.setMessage("You Won!");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();

                                    score = 0;
                                    roundScore = 0;
                                    startActivity(intent);
                                }
                            });
                    alertDialog.show();
                } else {
                    Intent intent = new Intent(MainActivity.this, Player2.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
                }
            }
        });
    }

    public int rollDice() {

        int num1 = 1 + (int) (6 * Math.random());
        int num2 = 1 + (int) (6 * Math.random());

        setDie(num1, die1);
        setDie(num2, die2);

        pscore=num1+num2;
        rd.setText("Round:" + pscore);

        if(num1==1 && num2==1)
        {
            return 1;
        }
        else if(num1==1||num2==1)
        {
         return 1;
        }
        else
        {
            return pscore;
        }

    }

    public void setDie(int value, FrameLayout die) {
        Drawable pic = null;

        switch (value) {
            case 1:
                pic = getResources().getDrawable(R.drawable.die_face_1);
                break;
            case 2:
                pic = getResources().getDrawable(R.drawable.die_face_2);
                break;
            case 3:
                pic = getResources().getDrawable(R.drawable.die_face_3);
                break;
            case 4:
                pic = getResources().getDrawable(R.drawable.die_face_4);
                break;
            case 5:
                pic = getResources().getDrawable(R.drawable.die_face_5);
                break;
            case 6:
                pic = getResources().getDrawable(R.drawable.die_face_6);
                break;
        }
        die.setBackground(pic);
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

package com.example.cs18rra1.diceroller;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;
public class Dice_Roller extends AppCompatActivity {

    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice__roller);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dice__roller, menu);
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

    public void on_button_click(View view){


        TextView tv = (TextView) this.findViewById(R.id.numberTextView);       //creating relevant text fields for manipulation
        TextView sv = (TextView) this.findViewById(R.id.scoreTextView);
        TextView cv = (TextView) this.findViewById(R.id.congratulationsTextView);
        EditText ev = (EditText) this.findViewById(R.id.enteredvalueTextView);

        int number_entered = Integer.parseInt(ev.getText().toString());

        Random r = new Random();
        int number = r.nextInt(6)+1;                    //random number generator for dice roll (the +1 is to ensure that 0 does not come up as 0 is not on a dice

        if (number_entered == number)                       //successful/unsuccessful guess logic parameters
        {
            cv.setText("Congratulations :)");
            score++;
        } else
        {
            cv.setText("Good luck next time!");
        }

        ev.setText(Integer.toString(number_entered));       //outputs (displayed regardless of correct/incorrect guess
        tv.setText(Integer.toString(number));
        sv.setText(Integer.toString(score));
    }
}

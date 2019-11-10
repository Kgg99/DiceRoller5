package com.example.diceroller;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int count = 0;
    public static ArrayList <String> qList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        addQuestion();

    }
    // from developer site
    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void on_button_click(View view) {

        EditText et = this.findViewById(R.id.editText);

        TextView tv = this.findViewById(R.id.textView2);

        TextView tv2 = this.findViewById(R.id.textView2);
        try {

            int number = randomNumber(7-1)+1;

            tv.setText(Integer.toString(number));

            Integer number2 = Integer.valueOf(et.getText().toString());

            if (number2 == number) {
                tv2.setVisibility(View.VISIBLE);
                counting();
            } else if (number2 > 6) {
                tv.setText("invalid entry");
            } else {
                tv2.setVisibility(View.INVISIBLE);
            }
        }
        catch(Exception ex) {
            Log.e("my Errors", ex.toString());
        }
    }

    public void counting() {
        TextView tv3 = this.findViewById(R.id.textView4);

        count++;

        tv3.setText(Integer.toString(count));
    }
    public void addQuestion(){
        qList.add("If you could go anywhere in the world, where would you go?");
        qList.add("If you were stranded on a desert island, what three things would you want to take with you?");
        qList.add("If you could eat only one food for the rest of your life, what would that be?");
        qList.add("If you won a million dollars, what is the first thing you would buy?");
        qList.add("If you could spaned the day with one fictional character, who would it be?");
        qList.add("If you found a magic lantern and a genie gave you three wishes, what would you wish?");
    }
    public void D_icebreaker(View view){
        TextView textView4 = this.findViewById(R.id.textView4);
        int numberGenerator = randomNumber(qList.size());
        textView4.setText(qList.get(numberGenerator));
    }
    public int randomNumber (int n){
        Random r = new Random();
        int ran = r.nextInt(n);
        return ran;
    }
}
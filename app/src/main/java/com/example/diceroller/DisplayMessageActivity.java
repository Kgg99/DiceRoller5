package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import static com.example.diceroller.MainActivity.qList;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        //TextView tv5 = this.findViewById(R.id.textView5);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Intent intent = getIntent();


    }
    public void on_click_save(View view){
        EditText et2 = this.findViewById(R.id.editText2);
        qList.add(et2.getText().toString());
        finish();

    }
    public void on_click_delete(View view)

    {
        finish();
    }
}
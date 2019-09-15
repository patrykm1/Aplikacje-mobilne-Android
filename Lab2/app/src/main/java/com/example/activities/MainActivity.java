package com.example.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void toSecondActivity(View view){
//        Intent intent = new Intent(this, SecondActivity.class);
//        intent.putExtra("description", "tekst przesłany z main activity ");
//        startActivity(intent);
        EditText messageView = (EditText)findViewById(R.id.editText);
        String messageText = messageView.getText().toString();
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(SecondActivity.EXTRA_MESSAGE, messageText);
        startActivity(intent);
    }
    public void toThirdActivity(View view){
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }
}

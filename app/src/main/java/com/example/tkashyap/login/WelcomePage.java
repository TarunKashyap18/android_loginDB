package com.example.tkashyap.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WelcomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
        TextView tv = (TextView) findViewById(R.id.textView2);
        tv.setText("Welcome "+getIntent().getExtras().getString("user"));
    }
}

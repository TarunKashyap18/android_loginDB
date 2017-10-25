package com.example.tkashyap.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    EditText user,pass;
    dataBase myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        user = (EditText) findViewById(R.id.editText3);
        pass = (EditText) findViewById(R.id.editText4);
        myDB = new dataBase(this);
    }

    public void submit(View view) {
        String username =  user.getText().toString();
        String password = pass.getText().toString();

        if (username.length()==0){
            user.setError("Username reqiured");
        }
        else if (password.length()==0){
            pass.setError("Password reqiured");
        }
        Boolean result = myDB.insertData(username,password);
        if(result == true)
            Toast.makeText(this,"Data Inserted Successfully",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,"Data Insertion Failed",Toast.LENGTH_SHORT).show();
    }
}

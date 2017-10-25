package com.example.tkashyap.login;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText user,pass;
    dataBase myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = (EditText) findViewById(R.id.editText);
        pass = (EditText) findViewById(R.id.editText2);
        myDB = new dataBase(this);
    }

    public void submit(View view) {
        String username =  user.getText().toString();
        String password = pass.getText().toString();
        int flag=0;
        if (username.length()==0){
            user.setError("Username reqiured");
        }
        else if (password.length()==0){
            pass.setError("Password reqiured");
        }
        else {
            Cursor res = myDB.getData();
            if (res != null && res.getCount() > 0) {
                while (res.moveToNext()) {
                    String username1 = res.getString(0).toString();
                    String password1 = res.getString(1).toString();
                    if(username1.length()>0 && password1.length()>0) {
                        if (!username.equals(username1)) {
                            flag = 1;
                        }
                        else if (username.equals(username1)) {
                            flag = 0;
                            if (password.equals(password1)) {
                                Intent i = new Intent(this, WelcomePage.class);
                                i.putExtra("user", username);
                                startActivity(i);
                                return;
                            }
                            else if (!password.equals(password1)) {
                                flag = 2;
                                break;
                            }
                        }
                    }
                }
            }
        }
        if (flag==1)
            Toast.makeText(this, "Incorrect username ", Toast.LENGTH_SHORT).show();
        else if (flag==2)
            Toast.makeText(this, "Incorrect password ", Toast.LENGTH_SHORT).show();

    }

    public void signUp(View view) {
        Intent i = new Intent(this,SignUp.class);
        startActivity(i);
    }
}

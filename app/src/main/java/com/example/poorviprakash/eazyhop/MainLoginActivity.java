package com.example.poorviprakash.eazyhop;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainLoginActivity extends AppCompatActivity {

    EditText email;
    EditText password;
    DatabaseHelper helper=new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_login);
    }
    public void mainActStart(View view) {

        email=(EditText)findViewById(R.id.loginEmail);
        password=(EditText)findViewById(R.id.loginPassword);
        String str=email.getText().toString().trim();

        String check=helper.searchPass(str);
        if(password.getText().toString().trim().equals(check)) {
            Intent in = new Intent(this, MainActivity.class);
            startActivity(in);
        }
        else
        {
            Toast.makeText(MainLoginActivity.this," Email and Password don't match!",Toast.LENGTH_LONG).show();
        }
    }

    public void regStart(View view) {

        Intent in2 = new Intent(this, RegisterActivity.class);
        startActivity(in2);
    }
}

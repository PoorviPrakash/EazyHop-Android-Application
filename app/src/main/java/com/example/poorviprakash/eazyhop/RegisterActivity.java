package com.example.poorviprakash.eazyhop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    EditText password;
    EditText conPassword;
    EditText email;
    EditText name;
    EditText phoneno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void mainAfterRegister(View view) {

        password = (EditText) findViewById(R.id.password);
        conPassword = (EditText) findViewById(R.id.conPassword);
        email = (EditText) findViewById(R.id.email);
        name = (EditText) findViewById(R.id.name);
        phoneno = (EditText) findViewById(R.id.phone);
        if (phoneno.getText().toString().trim().length() == 10) {

            if (password.getText().toString().equals(conPassword.getText().toString())) {
                Contact c = new Contact();
                c.setName(name.getText().toString());
                c.setEmail(email.getText().toString());
                c.setPhoneno(phoneno.getText().toString());
                c.setPassword(password.getText().toString());

                helper.insertContact(c);

                Intent in2 = new Intent(this, MainLoginActivity.class);
                startActivity(in2);
            } else {
                Toast.makeText(this, "Passwords don't match", Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(this, "Incorrect Mobile Number", Toast.LENGTH_LONG).show();
        }
    }
}

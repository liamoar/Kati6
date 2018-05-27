package com.example.welcome.kati6;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button about, signin, login;
    EditText user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user = findViewById(R.id.etusername);
        pass = findViewById(R.id.etpassword);
        about = findViewById(R.id.btnabout);
        signin = findViewById(R.id.btnsignin);
        login = findViewById(R.id.btnlogin);


        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View convertView = LayoutInflater.from(LoginActivity.this).inflate(R.layout.signup, null);
                final EditText name = convertView.findViewById(R.id.etsignupusername);
                final EditText pass = convertView.findViewById(R.id.etsignuppassword);
                Button signin = convertView.findViewById(R.id.btnsignupsignin);


                AlertDialog.Builder alert = new AlertDialog.Builder(LoginActivity.this);
                alert.setView(convertView);
                final AlertDialog dialog = alert.create();
                dialog.show();

                signin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        String passaccess = pass.getText().toString();
                        String useraccess = name.getText().toString();
                        if (useraccess.isEmpty()) {
                            name.setError("username is empty");
                            name.requestFocus();
                            return;
                        }
                        if (passaccess.isEmpty()) {
                            pass.setError("password  is empty");
                            pass.requestFocus();
                            return;
                        }

                        SharedPreferences sp = getSharedPreferences("myfile", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sp.edit();

                        String username = name.getText().toString();
                        String password = pass.getText().toString();
                        editor.putString("user1", username);
                        editor.putString("pass1", password);
                        editor.commit();

                        Toast.makeText(LoginActivity.this, "Sign in successful", Toast.LENGTH_LONG).show();
                        dialog.dismiss();

                    }
                });

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String passaccess = pass.getText().toString();
                String useraccess = user.getText().toString();
                if (useraccess.isEmpty()) {
                    user.setError("username is empty");
                    user.requestFocus();
                    return;
                }

                if (passaccess.isEmpty()) {
                    pass.setError("password  is empty");
                    pass.requestFocus();
                    return;

                }

                String username = user.getText().toString();
                String password = pass.getText().toString();
                SharedPreferences sp = getSharedPreferences("myfile", Context.MODE_PRIVATE);
                String myuser = sp.getString("user1", null);
                String mypass = sp.getString("pass1", null);

                if (myuser.equals(username) && mypass.equals(password)) {
                    Toast.makeText(LoginActivity.this, "login successful", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(LoginActivity.this, MapActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(LoginActivity.this, "Sign in Failed", Toast.LENGTH_LONG).show();

                }

            }
        });
    }
}

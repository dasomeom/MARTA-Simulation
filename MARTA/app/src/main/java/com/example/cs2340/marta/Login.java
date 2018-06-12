package com.example.cs2340.marta;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity implements View.OnClickListener {
    private EditText username;
    private EditText password;
    private Button butLogin;
    private TextView toRegister;
    private TextView toMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.ustext);
        password = (EditText) findViewById(R.id.pstext);
        butLogin = (Button) findViewById(R.id.lgibutton);
        butLogin.setOnClickListener(this);
        toRegister = (TextView) findViewById(R.id.torg);
        toMain = (TextView) findViewById(R.id.backmain);
        toRegister.setOnClickListener(this);
        toMain.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v == butLogin) {
            userLogin(username, password);
        }
        if (v == toRegister) {
            Intent intReg = new Intent (this, Register.class);
            startActivity(intReg);
        }
        if (v == toMain) {
            Intent intMain = new Intent (this, MainActivity.class);
            startActivity(intMain);
        }
    }
    public void userLogin(EditText username, EditText password) {
        if (username.getText().toString().equals("user")
                && password.getText().toString().equals("pass")) {
            Intent loginin = new Intent(this, System.class);
            startActivity(loginin);
        } else {
            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);

            dlgAlert.setMessage("Wrong Password or Username");
            dlgAlert.setTitle("Error!");
            dlgAlert.setPositiveButton("OK", null);
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();
            dlgAlert.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
        }
    }
}

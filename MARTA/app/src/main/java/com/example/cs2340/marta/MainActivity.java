package com.example.cs2340.marta;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonLogin;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonLogin = (Button) findViewById(R.id.mainlogin);
        buttonRegister = (Button) findViewById(R.id.mainregister);
        buttonLogin.setOnClickListener(this);
        buttonRegister.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v == buttonLogin) {
            Intent intLog = new Intent (this, Login.class);
            startActivity(intLog);
        }

        if (v == buttonRegister) {
            Intent intent2 = new Intent (this, Register.class);
            startActivity(intent2);
        }
    }


}
